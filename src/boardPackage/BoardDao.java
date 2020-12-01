package boardPackage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Timestamp;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


import bCommand.BCommand;
import bCommand.BMainCommand;
import bCommand.BWriteCommand;



public class BoardDao {

// 싱글턴 패턴
public static BoardDao instance= new BoardDao();

private BoardDao() {
	
}

public static BoardDao getInstance() {
	return instance;
}




public ArrayList<BoardDto> login() {
	// TODO Auto-generated method stub
	
	ArrayList<BoardDto> dtos= new ArrayList<BoardDto>();
	Connection connection =null;
	PreparedStatement pstmt=null;
	ResultSet result=null;
	String query="select bKey, bid, id, bTitle, bcontent, bdate, bhit from kw_infosci_board";

	
	
	try {
		connection=getConnection();
		pstmt=connection.prepareStatement(query);
		result=pstmt.executeQuery()	;
		
		while(result.next()) {
			int bKey=result.getInt("bkey");
			int bId=result.getInt("bId"); 
			String id=result.getString("id");
			String bTitle=result.getString("bTitle");
			String bContent=result.getString("bContent");
			Timestamp bDate = result.getTimestamp("bDate");
			int bHit=result.getInt("bhit");
			
			BoardDto dto =new BoardDto(bKey, bId, id, bTitle, bContent, bDate, bHit);
			dtos.add(dto);
		
	
		}}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				try {
					if(result != null) result.close();
					if(pstmt != null) pstmt.close();
					if(connection != null) connection.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		
		
			return dtos;
	
}



public void write( String id, String bTitle, String bContent) {
		// TODO Auto-generated method stub
	 
	Connection connection =null;
	PreparedStatement pstmt=null;
	Statement state=null;
	ResultSet result=null;
	String query1 ="insert into kw_infosci_board (bkey, bid, id, bTitle, bContent, bhit) values (kw_board_seq.nextval,  ?, ?, ?, ?, 0 )";
	String query2="select * from kw_infosci_board";
	int bId=1;
	
	try {
		
		
		connection=getConnection();
		state=connection.createStatement();
		result=state.executeQuery(query2);
		
		while(result.next()) {
		 ++bId;
		}
		
		pstmt=connection.prepareStatement(query1);
		pstmt.setInt(1, bId);
		pstmt.setString(2, id);
		pstmt.setString(3, bTitle);
		pstmt.setString(4, bContent);
		
		pstmt.executeUpdate();
	    
	
	
	}catch(Exception e){
		e.printStackTrace();

		}finally {
			try {
				
				if(pstmt!=null)pstmt.close();
				if(connection!=null) connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	


}

	
	
	

   
   
public ArrayList<BoardDto> main() {
	// TODO Auto-generated method stub
	
	ArrayList<BoardDto> dtos= new ArrayList<BoardDto>();
	Connection connection =null;
	PreparedStatement pstmt=null;
	ResultSet result=null;
	String query="select bKey, bid, id, bTitle, bcontent, bdate, bhit from kw_infosci_board  order by bKey asc";


	
	
	try {
		connection=getConnection();
		pstmt=connection.prepareStatement(query);
		result=pstmt.executeQuery()	;
		
		while(result.next()) {
			int bKey=result.getInt("bkey");
			int bId=result.getInt("bId"); 
			String id=result.getString("id");
			String bTitle=result.getString("bTitle");
			String bContent=result.getString("bContent");
			Timestamp bDate = result.getTimestamp("bDate");
			int bHit=result.getInt("bhit");
			
			BoardDto dto =new BoardDto(bKey, bId, id, bTitle, bContent, bDate, bHit);
			dtos.add(dto);
		
	
		}}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				try {
					if(result != null) result.close();
					if(pstmt != null) pstmt.close();
					if(connection != null) connection.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		
		
			return dtos;
	
}





public BoardDto content_view(int bKey) {
	// TODO Auto-generated method stub
	
	Connection connection=null;
	PreparedStatement pstmt=null;
	ResultSet result=null;
	String query="select * from kw_infosci_board where bKey = ?";
	BoardDto dto=null;
	
	try {
		connection=getConnection();
		pstmt=connection.prepareStatement(query);
		pstmt.setInt(1,bKey);
		result=pstmt.executeQuery();
		
		while(result.next()) {
		int bId=result.getInt("bId");
		String id=result.getString("id");
		String bTitle=result.getString("bTitle");
		String bContent=result.getString("bContent");
		int bHit=result.getInt("bHit");
		Timestamp bDate = result.getTimestamp("bDate");
		dto=new BoardDto( bKey,  bId,  id,  bTitle,  bContent,  bDate,  bHit) ;
		
		}
		
		// 해당 코드 if(result.next()){}은  ~.executeQuery() 메서드를 사용하고 해당 쿼리문의 결과 값 사용하기 위해선  레코드를 특정해야하기에 반드시 필요로 한다. 마찬가기지로 if~를 제외한다면 버그가 발생한다.

	}catch(Exception e){
		e.printStackTrace();
		
	}finally{
		try {
			if(connection!=null)  
			connection.close();
			if(pstmt!=null) 
				pstmt.close();
				if(result!=null)
					result.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	
	return dto;
	}
	
	



public void upHit(int bKey) {
	// TODO Auto-generated method stub
	
	Connection connection=null;
	PreparedStatement pstmt=null;


	String query = "update kw_infosci_board set bHit = bHit + 1 where bKey = ?";


	try {
		
		connection=getConnection();
		pstmt= connection.prepareStatement(query);
		pstmt.setInt(1, bKey);
		pstmt.executeUpdate();
		

	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(connection!=null)  
				connection.close();
				if(pstmt!=null) 
					pstmt.close();

			
		}catch(Exception e2){
			e2.printStackTrace();
		}
	}
	
	
	
	
	
	
}

public void boardModify(int bKey, String bTitle, String bContent) {

	Connection connection=null;
	PreparedStatement pstmt=null;
	String query="update kw_infosci_board set bTitle=?, bContent=? where bKey=?";
	
	try {
		connection=getConnection();
		pstmt= connection.prepareStatement(query);
		pstmt.setString(1, bTitle);
		pstmt.setString(2, bContent);
		pstmt.setInt(3, bKey);
		pstmt.executeUpdate();
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		
		try{
			if(connection!=null)connection.close();
			if(pstmt!=null)pstmt.close();
		}catch(Exception e2) {
			e2.printStackTrace();
		}
		
	}
	
	
	
	
}



public void boardDelete(int bKey) {
	// TODO Auto-generated method stub
	
	Connection connection=null;
	PreparedStatement pstmt1=null;
	PreparedStatement pstmt2=null;
	String query1="delete kw_infosci_board where bKey=?";
	String query2="update kw_infosci_board set bId=bId-1 where bKey>?";
	
	try {
		connection=getConnection();
		pstmt1=connection.prepareStatement(query1);
		pstmt1.setInt(1, bKey);
		pstmt1.executeUpdate();
		
		pstmt2=connection.prepareStatement(query2);
		pstmt2.setInt(1, bKey);
		pstmt2.executeUpdate();
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(connection!=null)connection.close();
			if(pstmt1!=null) pstmt1.close();
			if(pstmt2!=null)pstmt2.close();
			
		}catch(Exception e2) {
			e2.printStackTrace();
		}
		
	}

}



public void writeReply(int bKey, String reId, String reContent) {
	// TODO Auto-generated method stub
	
	Connection connection=null;
	PreparedStatement pstmt=null;
	String query="insert into kw_infosci_reply (bKey, reId, reContent, rekey) values(?,?,?,KW_BOARD_RESEQ.nextval)";
	System.out.println("hi");
	try {
		connection=getConnection();
		pstmt=connection.prepareStatement(query);
		pstmt.setInt(1, bKey);
		pstmt.setString(2, reId);
		pstmt.setString(3,reContent);
		pstmt.executeUpdate();
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(connection!=null) connection.close();
			if(pstmt!=null) pstmt.close();
			
		}catch(Exception e2){
			e2.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
}


public ArrayList<BoardDto> reply_view(int bKey) {
	// TODO Auto-generated method stub
	ArrayList<BoardDto> replys=new ArrayList<BoardDto>();
	Connection connection=null;
	PreparedStatement pstmt=null;
	ResultSet result=null;
	String query="select * from kw_infosci_reply where bKey=? order by reKey asc";
	BoardDto reply=null;
	
	try {
		connection=getConnection();
		pstmt=connection.prepareStatement(query);
		pstmt.setInt(1,bKey);
		result=pstmt.executeQuery();
		
		while(result.next()) {
		int reKey=result.getInt("reKey");
		String reId=result.getString("reId");
		String reContent=result.getString("reContent");
		Timestamp bDate = result.getTimestamp("bDate");
		System.out.println(reKey);
		reply=new BoardDto(reKey, bKey, reId, reContent, bDate) ;
		replys.add(reply);
		}
		

	}catch(Exception e){
		e.printStackTrace();
		
	}finally{
		try {
			if(connection!=null)  
			connection.close();
			if(pstmt!=null) 
				pstmt.close();
				if(result!=null)
					result.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	
	return replys;
	}
	


public void replyModify(int reKey, String reContent) {
	// TODO Auto-generated method stub
	Connection connection=null;
	PreparedStatement pstmt=null;
	String query="update kw_infosci_reply set reContent=? where reKey=?";
	try {
		connection=getConnection();
		pstmt=connection.prepareStatement(query);
		pstmt.setString(1, reContent);
		pstmt.setInt(2, reKey);
		pstmt.executeUpdate();
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(connection!=null)connection.close();
			if(pstmt!=null)pstmt.close();
			
		}catch(Exception e2) {
			e2.printStackTrace();
		}
	}
	
}



public void replyDelete(int reKey) {
	// TODO Auto-generated method stub
	Connection connection=null;
	PreparedStatement pstmt=null;
	String query="delete FROM Kw_infosci_reply where reKey=?";
	try {
		connection=getConnection();
		pstmt=connection.prepareStatement(query);
		pstmt.setInt(1, reKey);
		pstmt.executeUpdate();
	}catch(Exception e) {
		e.printStackTrace();
	}
finally {
	try {
	if(connection!=null)connection.close();
	if(pstmt!=null)pstmt.close();
	
	}catch(Exception e2) {
		e2.printStackTrace();
	}
}


}


private Connection getConnection(){
    	
    	
    	Context context=null;
    	DataSource dataSource=null;
        Connection connection=null;
    	
    	try {
			context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/KRHwangSeonWooDB");
			connection= dataSource.getConnection();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
    	return connection;
	}







   
   
    }
	
