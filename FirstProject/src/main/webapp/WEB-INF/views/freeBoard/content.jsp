<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp" />

	<h2>글 상세보기</h2>
	<hr>
	# 작성자<br>
	<input name="writer" size="20" value="${article.writer}" /><br>
	# 제목<br>
	<input name="title" size="20" value="${article.title}" /><br>
	# 내용<br>
	<textarea rows="5" cols="20" name="content" readonly>${article.content}</textarea><br>
	
	<form method="post" action="<c:url value='/board/delete'/>" id="btnForm">
		<input type="button" id="list-btn" value="목록"/>
		<input type="button" id="update-btn" value="수정"/>
		<input type="button" id="delete-btn" value="삭제"/>
		<input type="hidden" name="boardNo" value="${article.boardNo}"/>
	</form>

<jsp:include page="../include/footer.jsp" />


<script>
	$(function() {
		const btnForm = $("#btnForm");
		
		$("#list-btn").click(function() {
			location.href="<c:url value='/board/list'/>";
		});
		
		$("#delete-btn").click(function() {
			btnForm.submit();
		});
	});
</script>    




