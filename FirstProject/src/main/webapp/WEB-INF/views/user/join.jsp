<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp" />

	<h2>회원가입</h2>
	<hr>
		# 아이디<br>
		<input name="userId" id="inputUserId" size="20" maxlength="20" placeholder="아이디를 입력해주세요" />&nbsp;&nbsp;<span id="idChk" style="height:20px;"></span><br>
		# 비밀번호<br>
		<input type="password" id="inputPw" name="password" size="20" placeholder="비밀번호를 입력해주세요" />&nbsp;&nbsp;<span id="pwChk" style="height:20px;"></span><br>
		# 비밀번호 확인<br>
		<input type="password" id="inputPwChk" name="passwordChk" size="20" placeholder="비밀번호를 확인해주세요" />&nbsp;&nbsp;<span id="pwChk2" style="height:20px;"></span><br>
		# 이름<br>
		<input name="name" id="inputName" size="20" placeholder="이름을 입력해 주세요"/>&nbsp;&nbsp;<span id="nameChk" style="height:20px;"></span><br>
		<input type="button" id="join-btn" value="회원가입">

<jsp:include page="../include/footer.jsp" />

<script>
	const getIdCheck = RegExp(/^[a-zA-Z0-9]{4,20}$/);
	const getPwCheck= RegExp(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])/);
	const getName= RegExp(/^[가-힣]+$/);
	
	let chk1 = false, chk2 = false, chk3 = false, chk4 = false;
	
	//아이디 검증
	$("#inputUserId").on("keyup", function() {
		if($(this).val() === ""){
			$(this).css("background-color", "pink");
			$("#idChk").html('<b style="color:red; font-size: 12px;">[아이디는 필수 정보입니다!]</b>');
			chk1 = false;
		}else if(!getIdCheck.test($(this).val())){
			$(this).css("background-color", "pink");
			$("#idChk").html('<b style="color:red; font-size: 12px;">[4-20 영문, 숫자 조합으로 작성해주세요!]</b>');
			chk1 = false;
		}else{
			const id = $(this).val();
			
			$.ajax({
				type: "POST",
				headers:{
					"Content-Type": "application/json"
				},
				dataType: "text",
				data: id,
				url: "/user/idchk",
				success: function(result) {
					if(result == 1){
						$("#inputUserId").css("background-color", "pink");
						$("#idChk").html('<b style="color:red; font-size: 12px;">[중복된 아이디입니다!]</b>');
						chk1 = false;
					}else{
						$("#inputUserId").css("background-color", "aqua");
						$("#idChk").html('<b style="color:green; font-size: 12px;">[OK]</b>');
						chk1 = true;
					}
				},
				error: function() {
					console.log("통신 실패");
				}
			});//end ajax
		}
	});//end idCheck
	
	//비밀번호 값 검증
	$("#inputPw").on("keyup", function() {
		if($(this).val() === ""){
			$(this).css("background-color", "pink");
			$("#pwChk").html('<b style="color:red; font-size: 12px;">[비밀번호는 필수 정보입니다!]</b>');
			chk2 = false;
		}else if(!getPwCheck.test($(this).val()) || $(this).val().length < 8){
			$(this).css("background-color", "pink");
			$("#pwChk").html('<b style="color:red; font-size: 12px;">[툭수문자 포함 8자 이상 작성해주세요!]</b>');
			chk2 = false;
		}else{
			$(this).css("background-color", "aqua");
			$("#pwChk").html('<b style="color:green; font-size: 12px;">[OK]</b>');
			chk2 = true;
		}
	});//end pwCheck
	
	//비밀번호 확인 검증
	$("#inputPwChk").on("keyup", function() {
		if($(this).val() === ""){
			$(this).css("background-color", "pink");
			$("#pwChk2").html('<b style="color:red; font-size: 12px;">[비밀번호를 재입력해주세요!]</b>');
			chk3 = false;
		}else if($(this).val() != $("#inputPw").val()){
			$(this).css("background-color", "pink");
			$("#pwChk2").html('<b style="color:red; font-size: 12px;">[비밀번호가 일치하지 않습니다!]</b>');
			chk3 = false;
		}else{
			$(this).css("background-color", "aqua");
			$("#pwChk2").html('<b style="color:green; font-size: 12px;">[OK]</b>');
			chk3 = true;
		}
	});//end pwChk2
	
	//이름 입력값 검증
	$("#inputName").on("keyup", function() {
		if($(this).val() === ""){
			$(this).css("background-color", "pink");
			$("#nameChk").html('<b style="color:red; font-size: 12px;">[이름은 필수 정보입니다!]</b>');
			chk4 = false;
		}else if(!getName.test($(this).val())){
			$(this).css("background-color", "pink");
			$("#nameChk").html('<b style="color:red; font-size: 12px;">[이름은 한글로 입력해주세요!]</b>');
			chk4 = false;
		}else{
			$(this).css("background-color", "aqua");
			$("#nameChk").html('<b style="color:green; font-size: 12px;">[OK]</b>');
			chk4 = true;
		}
	});//end nameCheck
	
	
	
	
	
</script>













