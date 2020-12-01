<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="boardPackage.*" %>
<%@ page import="java.util.ArrayList"%>
<%
BoardDao dao=BoardDao.getInstance();
ArrayList<BoardDto> dtos=dao.main();


%>

<!DOCTYPE html>
<script languge="javascript" src="jsCheck.js" charset="UTF-8"></script>

<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>




<p>광운대학교 정보과학교육원 학생 게시판</p>

<form action="loginAfter_jsp.do" method="post">
아이디: <input type="text" name="id">
비밀번호: <input type="password" name="pw">
<input type="submit" value="로그인">&nbsp; <input type="button" value="회원가입" onclick="javascript:window.location='login_jsp.do'"><br/>
<br/>
</form>
<table width="770" border="1">
<tr>
		<td>번호</td>
		<td>아이디</td>
		<td>제목</td>
		<td>날짜</td>
		<td>조회수</td>
</tr>

<%
for(int i=0; i<dtos.size(); i++){
%>


<tr>
    <td><%= dtos.get(i).getbId() %></td>
	<td><%= dtos.get(i).getId() %></td>
	<td><a href="login.jsp" onclick="boardCheck()"><%=dtos.get(i).getbTitle() %></a></td>
	<td><%= dtos.get(i).getId() %></td>
	<td><%=dtos.get(i).getbHit() %></td>
	
</tr>



<%} %>

<td colspan="5"><button onclick="boardCheck()">글작성</button></td>
</table>

</body>
</html>