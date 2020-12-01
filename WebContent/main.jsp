<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="loginPackage.StudentDao" %>
    <jsp:useBean id="dto" class="loginPackage.StudentDto" scope="page"/>
    <jsp:setProperty name="dto" property="*"/>
   	<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
request.setCharacterEncoding("UTF-8"); 
String id=(String)session.getAttribute("id");
StudentDao dao=StudentDao.getInstance();
dto=dao.getStudent(id);
String name=dto.getName();
%>
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR"><title>Insert title here</title>
</head>
<body>

<p><%=name %>님, 광운대학교 정보과학교육원 학생 게시판에 오신 것을 환영합니다.</p>
<table width="770" border="1">


<tr>
	<td>번호</td>
	<td>아이디</td>
	<td>제목</td>
	<td>날짜</td>
	<td>조회수</td>
</tr>



	<c:forEach items="${dtos}" var="dtos">

		<tr>
			<td>${dtos.bId}</td>
			<td>${dtos.id}</td>
			<td><a href="content_view.do?bKey=${dtos.bKey}">${dtos.bTitle }</a></td>
			<td>${dtos.bDate}</td>
			<td>${dtos.bHit}</td>
		</tr>
		</c:forEach>


<tr>
<td colspan="5"><a href="write_page_jsp.do">글작성</a></td>
</tr>
</table>



<form action="logout.jsp" method="post">

<input type="submit" value="로그아웃">&nbsp;&nbsp;&nbsp;
<input type="button" value="회원정보 수정" onclick="javascript:window.location='infoModify_jsp.do'">


</form>

</body>
</html>