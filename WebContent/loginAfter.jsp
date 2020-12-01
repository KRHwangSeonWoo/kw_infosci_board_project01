<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="loginPackage.StudentDao" %>
<%
 request.setCharacterEncoding("EUC-KR");
%>

<jsp:useBean id="dto" class="loginPackage.StudentDto"/>
<jsp:setProperty name="dto" property="*"/>
	
<% 
StudentDao dao= StudentDao.getInstance();
int checkIdPwNum=dao.studentIdPwCheck(dto.getId(),dto.getPw());

if(checkIdPwNum==0){
%>

<script>
alert("학생 정보과 올바르지 않습니다. 다시 입력해주세요.");
document.location.href="login_jsp.do";
</script>

<%
}else{
	session.setAttribute("id",dto.getId());
	response.sendRedirect("main.do");
}
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