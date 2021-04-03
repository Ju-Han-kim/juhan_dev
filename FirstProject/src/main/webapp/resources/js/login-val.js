$(function() {

	$("#login-btn").click(function() {
		const id = $("#inputUserId").val();
		const pw = $("#inputPw").val();
		
		const autoLogin = $("#auto-login").is(":checked");
		
		if(id === "" || pw === ""){
			alert("정보를 입력해주세요!");
		}else{
			
			$.ajax({
				type: "POST",
				headers: {
					"content-Type": "application/json"
				},
				dataType: "text",
				data: JSON.stringify({
					"userId": id,
					"password": pw,
					"autoLogin": autoLogin
				}),
				url: "/user/login",
				success: function(result) {
					if(result === "idFail"){
						alert("없는 아이디입니다.");
						$("#inputPw").val("");
						$("#inputUserId").focus();
					}else if(result === "pwFail"){
						alert("비밀번호를 확인해주세요.");
						$("#inputPw").val("");
						$("#inputPw").focus();
					}else{
						alert("환영합니다!");
						location.href="/";
					}
				},
				error: function() {
					console.log("통신오류");
				}
			});
		}
	});
	
});//end jquery