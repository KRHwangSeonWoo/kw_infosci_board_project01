/**
 * 
 */

function joinJsCheck(){
	
	if(document.joinForm.id.value.length<4){
		alert("아이디는 4자리 이상 입력하셔야 합니다.");
		joinForm.id.focus();
		return;
	}
	
	
	if(document.joinForm.pw.value.length==0){
		alert("비밀번호를 입력하셔야 합니다.");
		joinForm.pw.focus();
		return;
	}
	

	
	if(document.joinForm.pw.value!=document.joinForm.pw_check.value){
		alert("비밀번호와 비밀번호 확인의 값이 다릅니다.");
		joinForm.pw_check.focus();
		return;
	}
	if(document.joinForm.name.value.length==0){
		alert("이름을 입력하셔야 합니다");
		joinForm.name.focus();
		return;
	}
	if(document.joinForm.eMail.value.length==0){
		alert("이메일을 입력하셔야 합니다");
		joinForm.eMail.focus();
		return;
	}

	if(document.joinForm.phoneNum.value.length==0){
		alert("핸드폰 번호를 입력하셔야 합니다");
		joinForm.phoneNum.focus();
		return;
	}

document.joinForm.submit();

}







function modifyJsCheck(){
	
	
	if(document.modifyCheck.pw.value.length==0){
		alert("비밀번호를 입력하셔야 합니다");
		modifyCheck.pw.focus();
		return;
	
	}
	

	if(document.modifyCheck.pw.value!=document.modifyCheck.pw_check.value){
		alert("비밀번호와 비밀번호 확인 값이 다릅니다.");
		modifyCheck.pw.focus();
		return;
	}
	
		if(document.modifyCheck.eMail.value.length==0){
		alert("이메일을 입력하셔야 합니다");
		
		joinForm.eMail.focus();
		return;
	}
	
	
		if(document.modifyCheck.phoneNum.value.length==0){
		alert("핸드폰 번호를 입력하셔야 합니다");
		joinForm.phoneNum.focus();
		return;
	}
	
	document.modifyCheck.submit();
	
}




function boardCheck(){
	alert("로그인 후 이용 가능 합니다.");
	

}




function content_view(check){
	if(check==1){
		content.action="boardModify_jsp.do";
		
	}else{
		content.action="boardDelete_jsp.do";
		
	}
	
}

function replay_view(check){
	if(check==1){
		reply.action="replyModify.do";
		
	}else{
	
		reply.action="content_view.do";
		
		
	}
	
}



function boardWritCheck(){
	

	
		if(document.boardWrite.bTitle.value.length==0){
		alert("글 제목을 입력하셔야 합니다");
		joinForm.bTitle.focus();
		return;
	}
	
	
	if(document.boardWrite.bContent.value.length==0){
		alert("글 내용을 입력하셔야 합니다");
		
		boardWrite.bContent.focus();
		return;
	}
	
	document.boardWrite.submit();
	
}

