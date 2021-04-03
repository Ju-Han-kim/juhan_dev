<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp" />

	<h2>로그인</h2>
	<hr>
		# 아이디<br>
		<input name="userId" id="inputUserId" size="20" maxlength="20" placeholder="아이디를 입력해주세요" /><br>
		# 비밀번호<br>
		<input type="password" id="inputPw" name="password" size="20" placeholder="비밀번호를 입력해주세요" /><br>
		<input type="checkbox" id="auto-login" name="autoLogin"/> 자동로그인<br>
		<input type="button" id="login-btn" value="로그인">

<jsp:include page="../include/footer.jsp" />

<script src="<c:url value='/js/login-val.js' />"></script>
 
