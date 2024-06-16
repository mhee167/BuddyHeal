// 주소록 작성 : 필수 항목 확인
function writeConfirm(){
	if(document.write_frm.ad_id.value.length==0){
		alert("아이디는 필수 항목입니다.");
		write_frm.ad_id.focus();
		return;
	}
	
	if(document.write_frm.ad_name.value.length==0){
		alert("이름은 필수 항목입니다.");
		write_frm.ad_name.focus();
		return;
	}
	
	if(document.write_frm.ad_department.value.length==0){
		alert("부서는 필수 항목입니다.");
		write_frm.ad_department.focus();
		return;
	}
	
	if(document.write_frm.ad_phone.value.length==0){
		alert("전화번호는 필수 항목입니다.");
		write_frm.ad_phone.focus();
		return;
	}
	var phoneRule=/^(010)-[0-9]{3,4}-[0-9]{4}$/;
	if(!phoneRule.test(document.write_frm.ad_phone.value)){
		alert("전화번호는 양식에 맞게 작성해주세요.");
		write_frm.ad_phone.focus();
		return;
	}
	
	if(document.write_frm.ad_email.value.length==0){
		alert("이메일 필수 항목입니다.");
		write_frm.ad_email.focus();
		return;
	}
	var email_regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i;
	if(!email_regex.test(document.write_frm.ad_email.value)){
		alert("이메일 양식에 맞게 작성해주세요.");
		write_frm.ad_email.focus();
		return;
	}
	
	document.write_frm.submit();
}

//주소록 수정 : 필수 항목 확인
function modifyConfirm(){
	if(document.modify_frm.ad_name.value.length==0){
		alert("이름은 필수 항목입니다.");
		modify_frm.ad_name.focus();
		return;
	}
	
	if(document.modify_frm.ad_department.value.length==0){
		alert("부서는 필수 항목입니다.");
		modify_frm.ad_department.focus();
		return;
	}
	
	if(document.modify_frm.ad_phone.value.length==0){
		alert("전화번호는 필수 항목입니다.");
		modify_frm.ad_phone.focus();
		return;
	}
	var phoneRule=/^(010)-[0-9]{3,4}-[0-9]{4}$/;
	if(!phoneRule.test(document.modify_frm.ad_phone.value)){
		alert("전화번호는 양식에 맞게 작성해주세요.");
		modify_frm.ad_phone.focus();
		return;
	}
	
	if(document.modify_frm.ad_email.value.length==0){
		alert("이메일 필수 항목입니다.");
		modify_frm.ad_email.focus();
		return;
	}
	var email_regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i;
	if(!email_regex.test(document.write_frm.ad_email.value)){
		alert("이메일 양식에 맞게 작성해주세요.");
		write_frm.ad_email.focus();
		return;
	}
	
	document.modify_frm.submit();
}