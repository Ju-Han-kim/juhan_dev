<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp" />

	<h2>글 수정하기</h2>
	<hr>
	<form method="post" id="btnForm">
		# 작성자<br>
		<input name="writer" size="20" value="${article.writer}" readonly/><br>
		# 제목<br>
		<input name="title" size="20" value="${article.title}" /><br>
		# 내용<br>
		<textarea rows="5" cols="20" name="content">${article.content}</textarea><br>
	
		<input type="submit" id="update-btn" value="수정"/>
		<input type="button" id="list-btn" value="목록"/>
		<input type="hidden" name="boardNo" value="${article.boardNo}"/>
	</form>

<jsp:include page="../include/footer.jsp" />


<script>
	$(function() {
		$("#list-btn").click(function() {
			location.href="<c:url value='/board/list?currentPage=${p.currentPage}&messagePerPage=${p.messagePerPage}&part=${p.part}&keyword=${p.keyword}'/>";
		});
	});
</script>    




