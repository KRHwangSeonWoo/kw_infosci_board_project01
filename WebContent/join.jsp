<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


<!DOCTYPE html>
<html>
<script languge="javascript" src="jsCheck.js" charset="UTF-8"></script>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<form action="joinAfter_jsp.do" method="post" name="joinForm">

���̵�: <input type="text" name="id"><br/>
��й�ȣ: <input type="password" name="pw"><br/>
��й�ȣ Ȯ��: <input type="password" name="pw_check"> <br/>
�̸�: <input type="text" name="name"><br/>
����: <input type="email" name="eMail"><br/>
����: <select name="major">
<option value="��ǻ�Ͱ���" selected="selected">��ǻ�Ͱ���</option>
<option value="������Ű���" >������Ű���</option>
<option value="��Ƽ�̵����">��Ƽ�̵����</option>
<option value="������ȣ��">������ȣ��</option>
<option value="�������α׷�����">�������α׷�����</option>
<option value="�濵��">�濵��</option>
<option value="��ȸ������">��ȸ������</option>
<option value="�Ƶ���">�Ƶ���</option>
<option value="�ܽİ濵��">�ܽİ濵��</option>
<option value="ȣ�ڰ濵��">ȣ�ڰ濵��</option>
<option value="�����濵��">�����濵��</option>
<option value="�ǿ�������">�ǿ�������</option>
<option value="ü����">ü����</option>

</select><br/>

�ڵ��� ��ȣ: <input type="tel" name="phoneNum"><br/>

<input type="button" value="ȸ������" onclick="joinJsCheck()">
<input type="button" value="���" onclick="javascript:window.location='login_jsp.do'">

</form>
</body>
</html>