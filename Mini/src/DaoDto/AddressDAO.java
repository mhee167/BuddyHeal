package DaoDto;
import java.io.PrintWriter;
//AddressDAO
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AddressDAO {
	
	public static final int ADDESS_ID_CHECK_SUCCESS = 1;	// memberCheck 성공
	public static final int ADDESS_ID_CHECK_FALSE = 0;		// memberCheck 성공
	public static final int ADDRESS_ADD_SUCCESS = 1; 			// Address에 추가 성공
	public static final int ADDRESS_ADD_FALSE = -1;	 			// Address에 추가 실패
	public static final int ADDRESS_ADD_EXCEPTION = 0;			// Address 예외 발생
	public static final int ADDRESS_MODIFY_SUCCESS = 1; 		// updateAddress()
	public static final int ADDRESS_MODIFY_FALSE = -1;
	public static final int ADDRESS_MODIFY_EXCEPTION = 0;
	
	// 아이디 체크
	public Integer memberCheck(String id) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		List<AddressDTO> dtos = new ArrayList();
		
		String query="SELECT USER_ID FROM MEMBER2";
		int result = ADDESS_ID_CHECK_FALSE;
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			// query 실행 값을 가져오는. "select ad_id from address"와 넣은 값. while로 체크
			set = pstmt.executeQuery();
			
			while (set.next()) {
				// ResultSet에서 ad_id 값을 가져와서 비교
	            String user_id = set.getString("user_id");
	            if (user_id.equals(id)) {
	                result = ADDESS_ID_CHECK_SUCCESS; // 일치할 경우 true로 설정
	                break; // 일치하는 아이디를 찾으면 루프 종료
	            }
	        }
            
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public HashMap<String,Integer> getCount() {
	    Connection connection = null;
	    PreparedStatement pstmt = null;
	    ResultSet set = null;
	    HashMap<String,Integer> dtos = new HashMap();
	    String[] departList= {"PlanningTeam","DesignTeam","FrontEndTeam","BackEndTeam","MarketingTeam"};
	    String query = "SELECT count(*) FROM ADDRESS WHERE AD_DEPARTMENT=?";
	    try {
	        connection = getConnection();
	        pstmt = connection.prepareStatement(query);
	        for(String depart:departList) {
	            pstmt.setString(1, depart);
	            set = pstmt.executeQuery();
	            
	            while (set.next()) {
	                dtos.put(depart,set.getInt(1));
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (set != null) set.close();
	            if (pstmt != null) pstmt.close();
	            if (connection != null) connection.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return dtos;
	}

	public List<AddressDTO> filterAddress(String department) {
	    Connection connection = null;
	    PreparedStatement pstmt = null;
	    ResultSet set = null;
	    List<AddressDTO> dtos = new ArrayList();
	    
	    String query = "SELECT * FROM ADDRESS WHERE AD_department=?";
	    try {
	        connection = getConnection();
	        pstmt = connection.prepareStatement(query);
	        pstmt.setString(1, department);
	        
	        set = pstmt.executeQuery();
	        
	        while (set.next()) {
	            AddressDTO dto = new AddressDTO();
	            dto.setAd_id(set.getString("ad_id"));
	            dto.setAd_name(set.getString("ad_name"));
	            dto.setAd_department(set.getString("ad_department"));
	            dto.setAd_rank(set.getString("ad_rank"));
	            dto.setAd_phone(set.getString("ad_phone"));
	            dto.setAd_email(set.getString("ad_email"));
	            
	            dtos.add(dto);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (set != null) set.close();
	            if (pstmt != null) pstmt.close();
	            if (connection != null) connection.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return dtos;
	}

	// 주소록 추가 기능
	public Integer addAddress(AddressDTO dto) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String checkQuery = "SELECT AD_ID FROM ADDRESS WHERE AD_ID = ?";
		String insertQuery = "INSERT INTO ADDRESS VALUES(?,?,?,?,?,?)";
		
		/* 출력 */
		System.out.println("(addAddress) 컨트롤러에서 받은 객체 id : " + dto.getAd_id());
		
		try {
			if( memberCheck(dto.getAd_id()) == ADDESS_ID_CHECK_SUCCESS ) {
				
				System.out.println("member check TRUE");
				
				connection = getConnection();
				
				// List에 등록된 아이디인지 체크
				pstmt = connection.prepareStatement(checkQuery);
				pstmt.setString(1, dto.getAd_id());
				set = pstmt.executeQuery();
				
				if (set.next()) {
	                return ADDRESS_ADD_EXCEPTION; // 이미 존재할 경우 예외 반환
	            }
				
				pstmt.close();
				
				// 주소록이 이미 있는 아이디인지 체크
				pstmt = connection.prepareStatement(insertQuery);
				pstmt.setString(1,dto.getAd_id());
				pstmt.setString(2,dto.getAd_name());
				pstmt.setString(3,dto.getAd_department());
				pstmt.setString(4,dto.getAd_rank());
				pstmt.setString(5,dto.getAd_phone());
				pstmt.setString(6,dto.getAd_email());
				
				int rowsAffected = pstmt.executeUpdate();
	            
	            // 적용된 행이 있으면 추가 성공 반환
	            if (rowsAffected > 0) {
	                return ADDRESS_ADD_SUCCESS;
	            } else {
	                return ADDRESS_ADD_FALSE;
	            }
				
			} else {// 실패 시
				return ADDRESS_ADD_FALSE;
			}
		} catch(Exception e) {
			e.printStackTrace();
			// 예외 발생
			return null;
			
		} finally {
			try {
				if (set != null) set.close();
	            if (pstmt != null) pstmt.close();
	            if (connection != null) connection.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 주소록 업데이트 기능
	public void updateAddress(String ad_id, AddressDTO dto) {
		Connection connection=null;
		PreparedStatement pstmt=null;
		
		String query= "UPDATE ADDRESS SET AD_NAME=?, AD_DEPARTMENT=?, AD_RANK=?, AD_PHONE=?, AD_EMAIL=? WHERE AD_ID=?";

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1,dto.getAd_name());
			pstmt.setString(2,dto.getAd_department());
			pstmt.setString(3,dto.getAd_rank());
			pstmt.setString(4,dto.getAd_phone());
			pstmt.setString(5,dto.getAd_email());
			pstmt.setString(6,dto.getAd_id());
			
			System.out.println(dto.getAd_id());
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	// 주소록 삭제 기능
	public void delAddress(String id) {
		Connection connection=null;
		PreparedStatement pstmt=null;
		
		String query = "DELETE FROM ADDRESS WHERE AD_ID=?";
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				connection.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	// 이름으로 서칭하는 기능
	public List<AddressDTO> searchAddress(String name) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		List<AddressDTO> dtos = new ArrayList();
		
		String query = "SELECT * FROM ADDRESS WHERE AD_NAME LIKE ?";
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, "%"+name+"%");
			
			set = pstmt.executeQuery();
			
			while (set.next()) {
	            AddressDTO dto = new AddressDTO();
	            dto.setAd_id(set.getString("ad_id"));
	            dto.setAd_name(set.getString("ad_name"));
	            dto.setAd_department(set.getString("ad_department"));
	            dto.setAd_rank(set.getString("ad_rank"));
	            dto.setAd_phone(set.getString("ad_phone"));
	            dto.setAd_email(set.getString("ad_email"));
	            
	            dtos.add(dto);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (pstmt != null) pstmt.close();
	            if (connection != null) connection.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
		return dtos;
	}
	
	// 처음 -> 전체 address 보여주기
	public List<AddressDTO> listAddress() {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		List<AddressDTO> dtos = new ArrayList();
		
		String query="select * from address";
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			set = pstmt.executeQuery();
			
			while (set.next()) {  // ResultSet의 각 행을 순회하면서 리스트에 추가
	            AddressDTO dto = new AddressDTO();
	            dto.setAd_id(set.getString("ad_id"));
	            dto.setAd_name(set.getString("ad_name"));
	            dto.setAd_department(set.getString("ad_department"));
	            dto.setAd_rank(set.getString("ad_rank"));
	            dto.setAd_phone(set.getString("ad_phone"));
	            dto.setAd_email(set.getString("ad_email"));

	            dtos.add(dto);
	        }
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return dtos;
	}
	
	public Connection getConnection() {
		Context context = null;
		DataSource dataSource = null;
		Connection connection = null;
		
		try {
			context = new InitialContext();
			dataSource =(DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			connection = dataSource.getConnection();
			System.out.println("데이터베이스 연결 성공");
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("데이터베이스 연결 실패");
		}
		return connection;
	}
}
