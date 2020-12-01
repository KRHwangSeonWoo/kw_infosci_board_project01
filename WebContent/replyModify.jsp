<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    

<%
String id=(String)session.getAttribute("id");
String reId=(String)request.getParameter("reId");
String reContent=request.getParameter("reContent");
int reKey=Integer.parseInt(request.getParameter("reKey"));
int bKey=Integer.parseInt(request.getParameter("bKey"));


System.out.println(reKey);

if(reId.equals(id)){

}else{
%>

<script languge="javascript" charset="UTF-8">
	alert("권한이 없습니다");
	history.back(-1);

</script>    

<%
}
%>
    
    
    
<!DOCTYPE html>

<html>
<SCRIPT src="jsCheck.js" charset="utf-8"></SCRIPT>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>


<form name=reply method="post">
	<input type="hidden" value="<%=reKey %>" name="reKey">
	<input type="hidden" value="<%=bKey %>" name="bKey">
<table border="1" width="741">
		
	<tr>
		<td>아이디</td>
		<td><%=id %></td>
	</tr>	
	
	<tr>
		<td>변경할 내용</td>
		<td><input type="text" name="reContent" value="<%=reContent%>" size="100"></td>
	</tr>
	
	<tr>
		<td colspan="2">
				<input type="submit" value="댓글 수정하기" onclick="replay_view(1)">
				<input type="submit" onclick= "replay_view(2)" value="취소">
		</td>
		
	</tr>

</table>

</form>


</body>
</html>

