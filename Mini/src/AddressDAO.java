//AddressDAO
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AddressDAO {

public AddressDAO() {
	
}

// 주소록 추가 기능
public void addAddress(AddressDTO dto) {
	Connection connection=null;
	PreparedStatement pstmt=null;
	String query= "insert into address values(?,?,?,?,?,?)";
	
	try {
		connection=getConnection();
		pstmt=connection.prepareStatement(query);
		pstmt.setString(1,dto.getId());
		pstmt.setString(2,dto.getName());
		pstmt.setString(3,dto.getDepartment());
		pstmt.setString(4,dto.getRank());
		pstmt.setString(5,dto.getPhone());
		pstmt.setString(6,dto.getEmail());
		
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


//주소록 업데이트 기능

public void updateAddress(AddressDTO dto,String id) {
	Connection connection=null;
	PreparedStatement pstmt=null;
	
	//커리문을 2번 실행 가능한가?
	
	String query= "update address set id=?, name=?, department=?, rank=?, phone=?, email=?";
	
	
	try {
		connection=getConnection();
		pstmt=connection.prepareStatement(query);
		pstmt.setString(1,dto.getId());
		pstmt.setString(2,dto.getName());
		pstmt.setString(3,dto.getDepartment());
		pstmt.setString(4,dto.getRank());
		pstmt.setString(5,dto.getPhone());
		pstmt.setString(6,dto.getEmail());
		
		
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

//주소록 삭제 기능

public void delAddress(String id) {
	Connection connection=null;
	PreparedStatement pstmt=null;
	
	
	String query="delete from address where id=?";
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

//이름으로 서칭하는 기능
public List<AddressDTO> searchAddress(String name) {
	Connection connection=null;
	PreparedStatement pstmt=null;
	ResultSet set=null;
	List<AddressDTO> dtos=new ArrayList();
	
	String query="select * from address where ad_name=?";
	try {
		connection=getConnection();
		pstmt=connection.prepareStatement(query);
		pstmt.setString(1,name);
		
		set=pstmt.executeQuery();
		
		if(set.next()) {
			for(AddressDTO dto : dtos) {
			dto=new AddressDTO();
			dto.setId(set.getString("ad_id"));
			dto.setName(set.getString("ad_name"));
			dto.setDepartment(set.getString("ad_department"));
			dto.setRank(set.getString("ad_rank"));
			dto.setPhone(set.getString("ad_phone"));
			dto.setEmail(set.getString("ad_email"));
			
			
			dtos.add(dto);
			}
			
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
	return dtos;
}

//처음 -> 전체 address 보여주기
public List<AddressDTO> listAddress() {
	Connection connection=null;
	PreparedStatement pstmt=null;
	ResultSet set=null;
	List<AddressDTO> dtos=new ArrayList();
	
	String query="select * from address";
	try {
		connection=getConnection();
		pstmt=connection.prepareStatement(query);
		
		
		set=pstmt.executeQuery();
		
		if(set.next()) {
			for(AddressDTO dto : dtos) {
			dto=new AddressDTO();
			dto.setId(set.getString("ad_id"));
			dto.setName(set.getString("ad_name"));
			dto.setDepartment(set.getString("ad_department"));
			dto.setRank(set.getString("ad_rank"));
			dto.setPhone(set.getString("ad_phone"));
			dto.setEmail(set.getString("ad_email"));
			
			dtos.add(dto);
			}
			
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
	return dtos;
}

public Connection getConnection() {
	Context context=null;
	DataSource dataSource =null;
	Connection connection=null;
	
	try {
		context= new InitialContext();
		dataSource=(DataSource)context.lookup("java:comp/env/jdbc.Oracle11g");
		connection = dataSource.getConnection();
	}catch(Exception e) {
		e.printStackTrace();
	}
	return connection;
}
}
