/**
 * join validation
 */
$(function() {
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
			$("#inputUserId").css("background-color", "pink");
			$("#idChk").html('<b style="color:green; font-size: 12px;">[중복값을 확인해주세요]</b>');
			chk1 = false;
		}
	});//end idCheck
	
	//아이디 중복값 버튼
	$("#idJoinCheck").click(function(){
		const userId = $("#inputUserId").val();		
		$.ajax({
			type: "POST",
			headers: {
				"Content-Type" : "application/json"
			},
			url: "/user/idchk",
			dataType: "text",
			data: userId,
			success: function(result){
				if(result >= 1){
					$("#inputUserId").css("background-color", "pink");
					$("#idChk").html('<b style="color:red; font-size: 12px;">[중복된 아이디입니다.]</b>');
					$("#inputUserId").focus();
					chk1 = false;
				}else{
					$("#inputUserId").css("background-color", "aqua");
					$("#idChk").html('<b style="color:green; font-size: 12px;">[OK]</b>');
					chk1 = true;
				}
			},
			error: function(){
				console.log("통신오류");
			}
		});
	});
	
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


	$("#join-btn").click(function() {
		
		if(chk1 && chk2 && chk3 && chk4){
			const id = $("#inputUserId").val();
			const pw = $("#inputPw").val();
			const name = $("#inputName").val();
			
			$.ajax({
				type: "POST",
				headers: {
					"Content-Type": "application/json"	
				},
				data: JSON.stringify({
					"userId": id,
					"password": pw,
					"name": name
				}),
				url: "/user/join",
				dataType: "text",
				success: function(result) {
					if(result === "joinSuccess"){
						alert("회원가입을 축하합니다!");
						location.href="/";
					}else{
						alert("회원가입 실패! 다시 시도해주세요");
						location.href="<c:url value='/join' />";
					}
				},
				error: function() {
					console.log("통신실패");
				}
			});
			
		}else{
			alert("입력값을 확인해주세요!");
		}
	});
});
