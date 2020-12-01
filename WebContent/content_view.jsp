<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String id=(String)session.getAttribute("id");
%>
    
<!DOCTYPE html>

<html>
<script languge="javascript" src="jsCheck.js" charset="UTF-8"></script>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>


<form name="content" method="post">

<input type="hidden" name="bKey" value="${dto.bKey}">
<input type="hidden" name="bId" value="${dto.bId }">
<input type="hidden" name="id" value="${dto.id }">
<input type="hidden" name="bHit" value="${dto.bHit }">

<table width="741" cellpadding="0" cellspacing="0" border="1">
<tr>
	<td width="150">번호</td>
	<td>${dto.bId }</td>
</tr>

<tr>
	<td>아이디</td>
	<td>${dto.id }</td>
</tr>

<tr>
	<td>조회수</td>
	<td>${dto.bHit }</td>
</tr>

<tr>
	<td>제목</td>
	<td>${dto.bTitle }</td>
</tr>

<tr>
	<td>내용</td>
	<td><textarea readonly="readonly" rows="10" >${ dto.bContent }</textarea></td>
</tr>


<tr>
	<td colspan="2"> 
	
	<input type="submit" value="글 수정" onclick="content_view(1)" >
	<input type="submit" value= "글 삭제" onclick="content_view(2)">	
	<a href="main.do" type="button">게시판 돌아가기</a>
	
	</td>

</tr>
</table>
</form>








<form action="writeReply.do" method="post">

<input type="hidden" name="bKey" value="${ dto.bKey }">
<input type="hidden" name="reId" value="${ id }">
<table width="741" cellpadding="0" cellspacing="0" border="1">


<tr>
	<td colspan="2">댓글 쓰기</td>
</tr>


<tr>
	<td >${ id }: </td>
	<td>내용: <input type="text" name="reContent" size="72"><input type="submit" value="글작성"/></td>
</tr>

</table>


</form>



<form>

<table width="741"  border="1">
<tr>
	<td>댓글 보기</td>
</tr>
<c:forEach items="${replys}" var="replys">

	<tr>
		<td>${replys.reId }: ${ replys.reContent } ${ replys.bDate }
			<a href="replyModify_jsp.do?reId=${replys.reId}&reKey=${replys.reKey}&reContent=${replys.reContent}&bKey=${replys.bKey}">댓글 수정</a>
			<a href="replyDelete_jsp.do?reId=${replys.reId}&reKey=${replys.reKey }&bKey=${replys.bKey}">글 삭제</a>		
		</td>	
	</tr>


</c:forEach>
</table>



</form>











</body>
</html>