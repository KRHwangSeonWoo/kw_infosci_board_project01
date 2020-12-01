<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<jsp:useBean id="dto" class="boardPackage.BoardDto"/>
<jsp:setProperty name="dto" property="*"/>
<%
String sId=(String)session.getAttribute("id");
String bId=dto.getId();
if(sId.equals(bId)){
%>

<%
}else{
	
%>

<Script>
alert("권한이 없습니다");
history.back(-1);
</Script>

<%
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>


<form action="boardModify.do" method="post">

<input type="hidden" name="bKey" value="<%=dto.getbKey() %>">


<table width="500" cellpadding="0" cellspacing="0" border="1">

<tr>
	<td width="150">번호</td>
	<td><%=dto.getbId()%></td>
</tr>

<tr>
	<td>아이디</td>
	<td><%=dto.getId()%></td>
<tr>
	<td>조회수</td>
	<td><%=dto.getbHit()%></td>
</tr>

<tr>
	<td>제목</td>
	<td><input type="text" name="bTitle"/></td>
</tr>

<tr>
	<td>내용</td>
	<td><textarea rows="10" name="bContent" ></textarea></td>
</tr>

<tr>
	<td colspan="2"> <input type="submit" value="글 수정"><a href="main.do">게시판 돌아가기</a></td>
</tr>

</table>
</form>
</body>
</html>