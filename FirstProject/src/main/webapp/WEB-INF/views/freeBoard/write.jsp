<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../include/header.jsp" />

	<h2>글 작성</h2>
	<hr>
	<form method="post" id="writeForm">
		# 작성자<br>
		<input name="writer" size="20" value="${login.name}" readonly/><br>
		# 제목<br>
		<input name="title" size="20" placeholder="제목을 작성해주세요" /><br>
		# 내용<br>
		<textarea rows="5" cols="20" name="content"></textarea><br>
		<input type="button" id="write-btn" value="글등록">
	</form>

<jsp:include page="../include/footer.jsp" />

<%-- JQuery practice --%>
<%-- submit button --%>
<script>
	$(function() {
		const writeForm = $("#writeForm");
		
		$("#write-btn").click(function() {
			writeForm.submit();
		});
	});
</script>    