<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="loginPackage.StudentDao" %>

<% 
request.setCharacterEncoding("EUC-KR");
%>


<jsp:useBean id="dto" class="loginPackage.StudentDto" scope="page"/>
<jsp:setProperty name="dto" property="*"/>

<%

StudentDao dao=StudentDao.getInstance();

String id=(String) session.getAttribute("id");
dto.setId(id);

int updateStudent=dao.updateStudent(dto);

if(updateStudent==1){
	

%>

<script languge="javascript">

alert("�л� ������ �����Ǿ����ϴ�");
javascript:window.location="main.do";


</script>

<%
}else{
	
%>

<script languge="javascript">

alert("�л� ���� ������ �����߽��ϴ�.");
javascript:window.location="infoModify_jsp.do";
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