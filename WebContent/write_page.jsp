<%@ page language="java" contentType="text/html;charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("EUC_KR"); %>    
    
    <%
    String id=(String)session.getAttribute("id");%>
    
<!DOCTYPE html>

<html>
<script languge="javascript" src="jsCheck.js" charset="UTF-8"></script>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		
		<form action="write.do" method="post" name="boardWrite">
		
			<tr>
				<td>아이디</td>
				<td> <input type="hidden" name="id" value="<%=id%>">  ${id }</td>
			</tr>
			
			<tr>
				<td>제목</td>
				<td> <input type="text" name="bTitle"></input>  </td>
			</tr>
			
			<tr>
				<td> 내용 </td>
				<td> <textarea name="bContent" rows="10"></textarea> </td>
				
			</tr>
			
			
			<tr >
				<td colspan="2"> <input type="button" value="글작성" onclick="boardWritCheck()"> &nbsp;&nbsp; <a href="main.do">게시판 돌아가기</a> </td>
			</tr>
			
			
		</form>
	</table>
	
</body>
</html>