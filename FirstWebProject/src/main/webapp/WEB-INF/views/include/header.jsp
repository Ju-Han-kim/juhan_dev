<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Juhan-Kim</title>
</head>
<body>

	<div align="center" style="height: 100px; border: 1px solid red;">
		<h2>상단 메뉴 공간입니다.</h2>
		<p>
			<a href="<c:url value='/' />">HOME</a> | <a
				href="<c:url value='/board/list' />">자유게시판</a> | <a href="#">MyPage</a>
			| <a href="#">####</a>

		</p>
	</div>

	<script src="<c:url value='/vendor/jquery/jquery-3.6.0.min.js'/>"></script>