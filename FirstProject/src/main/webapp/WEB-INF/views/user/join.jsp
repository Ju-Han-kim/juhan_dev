<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp" />

	<h2>회원가입</h2>
	<hr>
		# 아이디<br>
		<input name="userId" id="inputUserId" size="20" maxlength="20" placeholder="아이디를 입력해주세요" />&nbsp;
		<input type="button" id="idJoinCheck" value="중복확인" />
		&nbsp;&nbsp;<span id="idChk" style="height:20px;"></span><br>
		# 비밀번호<br>
		<input type="password" id="inputPw" name="password" size="20" placeholder="비밀번호를 입력해주세요" />&nbsp;&nbsp;<span id="pwChk" style="height:20px;"></span><br>
		# 비밀번호 확인<br>
		<input type="password" id="inputPwChk" name="passwordChk" size="20" placeholder="비밀번호를 확인해주세요" />&nbsp;&nbsp;<span id="pwChk2" style="height:20px;"></span><br>
		# 이름<br>
		<input name="name" id="inputName" size="20" placeholder="이름을 입력해 주세요"/>&nbsp;&nbsp;<span id="nameChk" style="height:20px;"></span><br>
		<input type="button" id="join-btn" value="회원가입">

<jsp:include page="../include/footer.jsp" />
<script src="<c:url value='/js/join-val.js' />"></script>

