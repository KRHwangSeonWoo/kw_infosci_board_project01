<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  <%
String sId=(String)session.getAttribute("id");
String bId=request.getParameter("id");
int bKey=Integer.parseInt(request.getParameter("bKey"));

if(sId.equals(bId)){

response.sendRedirect("boardDelete.do?bKey="+bKey);

}else{
%>

<Script>
alert("������ �����ϴ�"); 
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

</body>
</html>