package DaoDto;
//MemberDAO
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	
	public static final int MEMBER_NONEXISTENCE=0;
	public static final int MEMBER_EXISTENCE=1;
	public static final int MEMBER_JOIN_FAIL=0;
	public static final int MEMBER_JOIN_SUCCESS=1;
	public static final int MEMBER_LOGIN_PW_NO_GOOD=0;
	public static final int MEMBER_LOGIN_SUCCESS=1;
	public static final int MEMBER_LOGIN_IS_NOT=-1;
	

	private static MemberDAO instance = new MemberDAO();
	
	public MemberDAO() {
	}
	
	public static MemberDAO getInstance() {
		return instance;
	}

	// 회원 가입 기능
	public int addMember(MemberDTO dto) {
		int ri=0;
		Connection connection=null;
		PreparedStatement pstmt=null;
		String query= "insert into Member2 values(?,?,?,?,?,?)";
		
		try {
			connection=getConnection();
			pstmt=connection.prepareStatement(query);
			pstmt.setString(1,dto.getUser_id());
			pstmt.setString(2,dto.getUser_name());
			pstmt.setString(3,dto.getUser_pw());
			pstmt.setString(4,dto.getUser_pw_re());
			pstmt.setString(5,dto.getUser_phone());
			pstmt.setString(6,dto.getUser_email());
			
			pstmt.executeUpdate();
			ri=MemberDAO.MEMBER_JOIN_SUCCESS;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return ri;
	}
	
	//로그인 아이디 검사 기능
	public int confirmId(String id) {
		int ri=0;
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet set=null;
		
		String query="select user_id from member2 where user_id=?";
		
		try {
			connection=getConnection();
			pstmt=connection.prepareStatement(query);
			pstmt.setString(1,id);
			
			
			set=pstmt.executeQuery();
			
			if(set.next()) {
				ri=MemberDAO.MEMBER_EXISTENCE;
			}else {
				ri=MemberDAO.MEMBER_NONEXISTENCE;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				set.close();
				pstmt.close();
				connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return ri;
	}
	
	//로그인 비밀번호 검사 기능
	public int userCheck(String id,String pw) {
		int ri=0;
		String dbPw;
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet set=null;
		
		String query="select user_pw from member2 where user_id=?";
		
		try {
			connection=getConnection();
			pstmt=connection.prepareStatement(query);
			pstmt.setString(1,id);
			
			
			set=pstmt.executeQuery();
			
			if(set.next()) {
				dbPw=set.getString("user_pw");
				if(dbPw.equals(pw)) {
					ri=MemberDAO.MEMBER_LOGIN_SUCCESS;
				}else {
					ri=MemberDAO.MEMBER_LOGIN_PW_NO_GOOD;
				}
			}else {
					ri=MemberDAO.MEMBER_LOGIN_IS_NOT;
				}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				set.close();
				pstmt.close();
				connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return ri;
	}
	
	//회원 업데이트 기능
	public int updateMember(String id,MemberDTO dto) {
		Connection connection=null;
		PreparedStatement pstmt=null;
		int ri=0;
		
		String query= "update Member2 set user_name=?, user_id=?, user_pw=?,user_pw_re=?, user_phone=?, user_email=? where user_id=?"; 
		String query2= "update Member2 set user_name=?, user_pw=?,user_pw_re=?, user_phone=?, user_email=? where user_id=?"; 
		
		
		try {
			if(!id.equals(dto.getUser_id())) {
			connection=getConnection();
			pstmt=connection.prepareStatement(query);
			pstmt.setString(1,dto.getUser_name());
			pstmt.setString(2,dto.getUser_id());
			pstmt.setString(3,dto.getUser_pw());
			pstmt.setString(4,dto.getUser_pw_re());
			pstmt.setString(5,dto.getUser_phone());
			pstmt.setString(6,dto.getUser_email());
			pstmt.setString(7,id);
			
			}else {
				connection=getConnection();
				pstmt=connection.prepareStatement(query2);
				pstmt.setString(1,dto.getUser_name());
				pstmt.setString(2,dto.getUser_pw());
				pstmt.setString(3,dto.getUser_pw_re());
				pstmt.setString(4,dto.getUser_phone());
				pstmt.setString(5,dto.getUser_email());
				pstmt.setString(6,id);
			}
		
			ri=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return ri;
	}
	
	
	//회원 탈퇴 기능
	public void delMember(String id) {
		Connection connection=null;
		PreparedStatement pstmt=null;
		
		
		String query="delete from Member2 where user_id=?";
		try {
			connection=getConnection();
			pstmt=connection.prepareStatement(query);
			pstmt.setString(1,id);
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//마이 페이지 -> 정보 보여주기 기능
	public MemberDTO getMember(String id) {
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet set=null;
		MemberDTO dto=null;
		
		String query="select * from Member2 where user_id=?";
		try {
			connection=getConnection();
			pstmt=connection.prepareStatement(query);
			pstmt.setString(1,id);
			
			set=pstmt.executeQuery();
			
			if(set.next()) {
				dto=new MemberDTO();
				dto.setUser_id(set.getString("user_id"));
				dto.setUser_name(set.getString("user_name"));
				dto.setUser_pw(set.getString("user_pw"));
				dto.setUser_pw_re(set.getString("user_pw_re"));
				dto.setUser_phone(set.getString("user_phone"));
				dto.setUser_email(set.getString("user_email"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	
	public Connection getConnection() {
		Context context=null;
		DataSource dataSource =null;
		Connection connection=null;
		
		try {
			context= new InitialContext();
			dataSource=(DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			connection = dataSource.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
}