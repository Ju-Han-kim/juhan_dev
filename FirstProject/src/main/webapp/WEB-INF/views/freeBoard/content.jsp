<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

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
		<input type="hidden" name="messagePerPage" value="${p.messagePerPage}"/>
		<input type="hidden" name="part" value="${p.part}"/>
		<input type="hidden" name="keyword" value="${p.keyword}"/>
	</form>
	
	<hr>
	<!-- 댓글 -->
	<div>
		<form method="post">
			<input type="hidden" name="currentPage" value="${p.currentPage}"/>
			<input type="hidden" name="messagePerPage" value="${p.messagePerPage}"/>
			<%-- 추후 작성자는 로그인 session으로 처리예정 --%>
			<input type="hidden" name="writer" value="${login.name}"/>
			<table border="1">
				<tr>
					<td colspan="4">
						<strong>댓글</strong>
					</td>					
				</tr>
				<c:forEach var="comment" items="${comments}">
					<tr>
						<td><strong>${comment.writer}</strong></td>
						<td>${comment.content}</td>
						<td width="110"><fmt:formatDate pattern="yyyy-MM-dd" value="${comment.regDate}" /></td>
						<td width="100"> 
							<a href="">수정</a>&nbsp;
							<a href="<c:url value='/comment/del/${comment.commentNo}?boardNo=${article.boardNo}&currentPage=${p.currentPage}&messagePerPage=${p.messagePerPage}&part=${p.part}&keyword=${p.keyword}' />"
							onclick="return confirm('정말 삭제하시겠습니까?')">삭제</a>
						</td>
					</tr>
				</c:forEach>
				<!-- 작성 폼 -->
				<tr>
					<td colspan="4" align="right">
						 <textarea name="content" rows="3" cols="100" placeholder="내용을 작성해주세요"></textarea><br>
						 <input type="submit" value="작성">
				 	</td>
				</tr>
			</table>
		</form>
	
	</div>
<jsp:include page="../include/footer.jsp" />


<script>
	$(function() {
		const btnForm = $("#btnForm");
		//list로 이동
		$("#list-btn").click(function() {
			console.log("리스트이동!");
			location.href="<c:url value='/board/list?currentPage=${p.currentPage}&messagePerPage=${p.messagePerPage}&part=${p.part}&keyword=${p.keyword}'/>";
		});
		
		//게시글 수정페이지로 이동
		$("#update-btn").click(function() {
			console.log("수정페이지이동!");
			btnForm.attr("method", "get");
			btnForm.attr("action","<c:url value='/board/update'/>");
			btnForm.submit();
		});
		
		
	});
	
	const msg = "${msg}";
	if(msg === "commentInsertSuccess"){
		alert("댓글이 등록되었습니다!");
	}else if(msg === "updateSuccess"){
		alert("게시글 수정이 완료되었습니다!");
	}else if(msg === "commentDeleteSuccess"){
		alert("댓글 삭제가 완료되었습니다!");
	}
		
	
</script>    




