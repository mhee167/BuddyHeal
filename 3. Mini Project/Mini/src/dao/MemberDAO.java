package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;


import javax.naming.*;
import javax.servlet.http.HttpSession;

import dto.MemberDTO;

public class MemberDAO {
	
	public static final int MEMBER_NONEXIST=0;
	public static final int MEMBER_EXIST=1;
	public static final int MEMBER_JOIN_FAIL=0;
	public static final int MEMBER_JOIN_SUCCESS=1;
	public static final int MEMBER_LOGIN_NOGOOD=0;
	public static final int MEMBER_LOGIN_SUCCESS=1;
	public static final int MEMBER_LOGIN_FAIL=-1;
	public static MemberDAO instance=new MemberDAO();
	
    private Connection con;
    private PreparedStatement pstmt;
    private DataSource dataFactory;

    public MemberDAO() {
        try {
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup("java:/comp/env");
            dataFactory = (DataSource) envContext.lookup("jdbc/Oracle11g");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static MemberDAO getInstance() {
    	return instance;
    }
    
    //전체 회원 조회
    public List<MemberDTO> selectMember(String inputid) {
        List<MemberDTO> list = new ArrayList<>();
        ResultSet rs=null;
        try {
            con = dataFactory.getConnection();

            String query = "SELECT ";
            if (inputid.equals("*")) {
                query += "* ";
            } else {
                query += inputid + " ";
            }
            query += "FROM member";


            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                MemberDTO dto = new MemberDTO(); 

                String id = rs.getString("id");
                String pwd = rs.getString("pwd");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                Date joinDate = rs.getDate("joinDate");

                dto.setId(id);
                dto.setPwd(pwd);
                dto.setName(name);
                dto.setAddress(address);
                dto.setPhone(phone);
                dto.setEmail(email);
                dto.setJoinDate(joinDate);

                list.add(dto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

   
    //회원 추가
    public void insertMember(MemberDTO dto) {
        try {
            con = dataFactory.getConnection();
            String id = dto.getId();
            String pwd = dto.getPwd();
            String name = dto.getName();
            String address = dto.getAddress();
            String phone= dto.getPhone();
            String email = dto.getEmail();
            
            String query = "insert into member";
            query += "(id,pwd,name,address,phone,email)";
            query += "values(?,?,?,?,?,?)";

            System.out.println(query);
            
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            pstmt.setString(3, name);
            pstmt.setString(4, address);
            pstmt.setString(5, phone);
            pstmt.setString(6, email);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    //회원 삭제
    public void delMember(String id) {
        try {
            con = dataFactory.getConnection();
            String query = "delete from member where id=?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            pstmt.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    //회원 정보 update
    public void updateMember(MemberDTO member) {
        try (Connection con = dataFactory.getConnection();
             PreparedStatement pstmt = con.prepareStatement(
                     "UPDATE MEMBER SET pwd=?, name=?, address=?, phone=?, email=? WHERE id=?")) {
            pstmt.setString(1, member.getPwd());
            pstmt.setString(2, member.getName());
            pstmt.setString(3, member.getAddress());
            pstmt.setString(4, member.getPhone());
            pstmt.setString(5, member.getEmail());
            pstmt.setString(6, member.getId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // 실제로는 로깅 등의 처리를 추천합니다.
        }
    }

    
    // 아이디 유효성 검사
    public int userCheck(String id,String pwd) throws Exception {
    	int ri=0;
    	ResultSet rs=null;
    	String dbPwd;
        String query = "SELECT pwd FROM member where id=?";
        System.out.println(query);


       
        try {
            con = dataFactory.getConnection();        
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                dbPwd = rs.getString("pwd");
                if (dbPwd != null && !dbPwd.isEmpty()) { 
                    if (pwd.equals(dbPwd)) {
                        ri = MemberDAO.MEMBER_LOGIN_SUCCESS;
                        
                    
                    } else {
                        ri = MemberDAO.MEMBER_LOGIN_FAIL;
                        System.out.println("비밀번호가 일치하지 않음");
                    }
                } else {
                    ri = MemberDAO.MEMBER_LOGIN_FAIL;
                    System.out.println("데이터베이스에서 비밀번호를 가져오지 못함");
                }
            } else {
                ri = MemberDAO.MEMBER_LOGIN_NOGOOD;
                System.out.println("정보가 없음");
            }
        } catch (SQLException e) {
            System.out.println("SQL 예외 발생: " + e.getMessage());
        }
    	catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
			  rs.close();
	           pstmt.close();
	           con.close();}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return ri;
    }
    
}
