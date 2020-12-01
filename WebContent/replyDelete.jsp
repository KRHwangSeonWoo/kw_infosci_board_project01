<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%
String id=(String)session.getAttribute("id");
String reId=(String)request.getParameter("reId");
int reKey=Integer.parseInt(request.getParameter("reKey"));
int bKey=Integer.parseInt(request.getParameter("bKey"));


System.out.println(reKey);

if(reId.equals(id)){
response.sendRedirect("replyDelete.do?reKey="+reKey+"&bKey="+ bKey);
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
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>