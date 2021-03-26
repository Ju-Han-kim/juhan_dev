<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp" />

	<h2>글 상세보기</h2>
	<hr>
	# 작성자<br>
	<input name="writer" size="20" value="${article.writer}" readonly/><br>
	# 제목<br>
	<input name="title" size="20" value="${article.title}" readonly/><br>
	# 내용<br>
	<textarea rows="5" cols="20" name="content" readonly>${article.content}</textarea><br>
	
	<form method="post" action="<c:url value='/board/delete'/>" id="btnForm">
		<input type="button" id="list-btn" value="목록"/>
		<input type="button" id="update-btn" value="수정"/>
		<input type="submit" id="delete-btn" onclick="return confirm('정말 삭제하시겠습니까?')" value="삭제"/>
		<input type="hidden" name="boardNo" value="${article.boardNo}"/>
		<input type="hidden" name="currentPage" value="${p.currentPage}"/>
	</form>

<jsp:include page="../include/footer.jsp" />


<script>
	$(function() {
		const btnForm = $("#btnForm");
		
		$("#list-btn").click(function() {
			location.href="<c:url value='/board/list?currentPage=${p.currentPage}'/>";
		});
		
		$("#update-btn").click(function() {
			btnForm.attr("method", "get");
			btnForm.attr("action","<c:url value='/board/update'/>");
			btnForm.submit();
		});
	});
</script>    




