<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="loginPackage.*"%>


<%
request.setCharacterEncoding("EUC-KR"); 
%>

<jsp:useBean id="dto" class="loginPackage.StudentDto"/>
<jsp:setProperty name="dto" property="*"/>


<% 
StudentDao dao=StudentDao.getInstance();
if(dao.checkId(dto.getId())==0){
%>

<script language="javascript">
alert("아이디가 이미 존재합니다.")
document.location.href="join.jsp";
</script>

<%
}else{
	int createStudent=dao.createStudent(dto);
	
	if(createStudent==1){
	
	
%>

	<script language="javascript">
				alert("회원가입에 성공했습니다.");
				document.location.href="login_jsp.do";
	</script>
	
<%
	}else{
		
	
%>
	<script language="javascript">
				alert("회원가입에 실패했습니다.");
				document.location.href="login_jsp.do";
			</script>
			
<%
}}
%>






























<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>