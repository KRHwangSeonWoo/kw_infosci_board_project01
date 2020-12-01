package loginPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import loginPackage.StudentDto;

public class StudentDao {

	
	
	
	
	
	//싱글턴 패턴
	public  static StudentDao instance = new StudentDao();
	
	private StudentDao() {
	}
	
	public static StudentDao getInstance(){
		return instance;
	}
	
	

	
	
	
	
	
	//학번 중복 확인 코드
	public  int checkId(String id) {
		int checkId = 0;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet set = null;
		String query = "select id from kw_infosci_student where id = ?";
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();
			if(set.next()){
				checkId = 0 ;
			} else {
				checkId = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				set.close();
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return checkId;
	}
	
	

	
	
	
	
	
	//학생 레코드 생성 코드
	public int createStudent(StudentDto dto) {
		int createStduent = 0;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		String query = "insert into kw_infosci_student values (?,?,?,?,?,?)";
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.geteMail());
			pstmt.setString(5, dto.getMajor());
			pstmt.setString(6, dto.getPhoneNum());
		    pstmt.executeUpdate();
			createStduent=1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return createStduent;
	}
	
	
	
	
	

    //로그인  메서드
	public int studentIdPwCheck(String id, String pw) {
	 
		int idPwCheck=0;
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet result=null;
		String query="select pw from kw_infosci_Student where id=?";
		
	    try {
	    	connection=getConnection();
	    	pstmt= connection.prepareStatement(query);
	    	pstmt.setString(1,id);
	    	result= pstmt.executeQuery();
	    	
	       if(result.next()) {
	    	   
	    	  if(result.getString("pw").equals(pw)) {
	    		  idPwCheck=1;
	    		 
	    	  }else {
	    		  idPwCheck=0;
	    	  }
	       }else {
	    	   idPwCheck=0;
	       }
	       
	    }catch(Exception e) {
	    		e.printStackTrace();

	   }finally {
		try {
			connection.close();
			pstmt.close();
			result.close();
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
	}
	}
	    
	return idPwCheck;    
	
	
	}
	
	
	//학생의 아이디로 해당 아이디의 레코드를 추출해 반환하는 메서드
	public StudentDto getStudent(String id){
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet result = null;
		String query = "select * from kw_infosci_Student where id = ?";
		StudentDto seStudentInfo = null;
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			result = pstmt.executeQuery();
			
			if(result.next()) {
				seStudentInfo = new StudentDto();
				seStudentInfo.setId(result.getNString("id"));
				seStudentInfo.setPw(result.getString("pw"));
				seStudentInfo.setName(result.getString("name"));
				seStudentInfo.seteMail(result.getString("eMail"));
				seStudentInfo.setMajor(result.getString("Major"));
				seStudentInfo.setPhoneNum(result.getString("phoneNum"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				result.close();
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return seStudentInfo;
		
	}
	
	
	
	
	//회원 정보 수정 메서드
	public int updateStudent(StudentDto dto) {
		
		int updateStudent=0;
		
		Connection connection=null;
		PreparedStatement pstmt=null;
	
		
		String query="update kw_infosci_Student set pw=?, eMail=?, Major=?, phoneNum=? where id=?";
		try {
			
			
			connection=getConnection();
			pstmt=connection.prepareStatement(query);
			pstmt.setString(1,dto.getPw());
			pstmt.setString(2,dto.geteMail());
			pstmt.setString(3,dto.getMajor());
			pstmt.setString(4,dto.getPhoneNum());
			pstmt.setString(5,dto.getId());
		    updateStudent=pstmt.executeUpdate();
		    
		    
		}catch(Exception e){
			e.printStackTrace();
			
		}finally {
			try {
				pstmt.close();
				connection.close();
				
				
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		
		return updateStudent;
	}
	
	
	
	
	//커넥션 풀 
	private  Connection getConnection() {
				Context context = null;	
				DataSource dataSource = null;
				Connection connection = null;
		try {
			context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/KRHwangSeonWooDB");			
			connection = dataSource.getConnection();
		} catch (Exception e) {
		e.printStackTrace();
		}
	
	return connection;
}


}
