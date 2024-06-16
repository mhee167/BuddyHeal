// 회원가입: 필수 항목 확인
function joinConfirm(){
	if(document.join_frm.user_id.value.length==0){
		alert("아이디는 필수 항목입니다.");
		join_frm.user_id.focus();
		return;
	}
	
	if(document.join_frm.user_name.value.length==0){
		alert("이름은 필수 항목입니다.");
		join_frm.user_name.focus();
		return;
	}
	
	if(document.join_frm.user_pw.value.length==0){
		alert("비밀번호는 필수 항목입니다.");
		join_frm.user_pw.focus();
		return;
	}
	
	if(document.join_frm.user_pw.value.length<5){
		alert("비밀번호는 5자 이상입니다.");
		join_frm.user_pw.focus();
		return;
	}
	
	if(document.join_frm.user_pw_re.value.length==0){
		alert("비밀번호 확인은 필수 항목입니다.");
		join_frm.user_pw_re.focus();
		return;
	}
	
	if(document.join_frm.user_pw_re.value!=document.join_frm.user_pw.value){ //왜 equals로 하면 틀리지/
		alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
		join_frm.pw.focus();
		return;
	}
	
	if(document.join_frm.user_phone.value.length==0){
		alert("전화번호는 필수 항목입니다.");
		join_frm.user_phone.focus();
		return;
	}

	var phoneRule=/^(010)-[0-9]{3,4}-[0-9]{4}$/;
	if(!phoneRule.test(document.join_frm.user_phone.value)){
		alert("전화번호는 양식에 맞게 작성해주세요.");
		join_frm.user_phone.focus();
		return;
	}

	var email_regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i;
	if(!email_regex.test(document.join_frm.user_email.value)){
		alert("이메일 양식에 맞게 작성해주세요.");
		join_frm.email.focus();
		return;
	}
	
	//value는 체크 박스의 값을 나타냄.
	if(!document.join_frm.agree_terms.checked){
		alert("이용 약관에 동의해야 회원 가입이 가능합니다.");
		join_frm.agree_terms.focus();
		return;
	}
	
	if(!document.join_frm.agree_privacy.checked){
		alert("개인정보 수집에 동의해야 회원 가입이 가능합니다.");
		join_frm.agree_privacy.focus();
		return;
	}
	
	document.join_frm.submit();
}

//회원 정보 수정: 필수 항목 확인
function updateConfirm(){
	if(document.m_modify.user_id.length==0){
		alert("아이디를 입력하세요.");
		m_modify.user_id.focus();
		return;
	}
	
	if(document.m_modify.user_name.length==0){
		alert("이름을 입력하세요.");
		m_modify.user_name.focus();
		return;
	}
	
	if(document.m_modify.user_pw.length==0){
		alert("비밀번호를 입력하세요.");
		m_modify.user_pw.focus();
		return;
	}
	
	if(document.m_modify.user_pw.length<5){
		alert("비밀번호는 5자 이상입니다.");
		m_modify.user_pw.focus();
		return;
	}
	
	if(document.m_modify.user_pw_re.length==0){
		alert("비밀번호 확인을 입력하세요.");
		m_modify.user_pw_re.focus();
		return;
	}
	
	if(!document.m_modify.user_pw_re.equals(document.m_modify.user_pw)){
		alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
		m_modify.pw.focus();
		return;
	}
	
	if(document.m_modify.user_phone.length==0){
		alert("전화번호를 입력하세요.");
		join_frm.user_phone.focus();
		return;
	}

	
	if(document.m_modify.user_email.length==0){
		alert("이메일을 입력하세요.");
		join_frm.email.focus();
		return;
	}
	
	document.m_modify.submit();
}