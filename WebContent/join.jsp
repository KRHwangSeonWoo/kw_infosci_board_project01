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

아이디: <input type="text" name="id"><br/>
비밀번호: <input type="password" name="pw"><br/>
비밀번호 확인: <input type="password" name="pw_check"> <br/>
이름: <input type="text" name="name"><br/>
메일: <input type="email" name="eMail"><br/>
전공: <select name="major">
<option value="컴퓨터공학" selected="selected">컴퓨터공학</option>
<option value="정보통신공학" >정보통신공학</option>
<option value="멀티미디어학">멀티미디어학</option>
<option value="정보보호학">정보보호학</option>
<option value="게임프로그래밍학">게임프로그래밍학</option>
<option value="경영학">경영학</option>
<option value="사회복지합">사회복지합</option>
<option value="아동학">아동학</option>
<option value="외식경영학">외식경영학</option>
<option value="호텔경영학">호텔경영학</option>
<option value="관광경영학">관광경영학</option>
<option value="실용음악학">실용음악학</option>
<option value="체육학">체육학</option>

</select><br/>

핸드폰 번호: <input type="tel" name="phoneNum"><br/>

<input type="button" value="회원가입" onclick="joinJsCheck()">
<input type="button" value="취소" onclick="javascript:window.location='login_jsp.do'">

</form>
</body>
</html>