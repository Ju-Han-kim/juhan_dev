<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
.page-btn{
	border: solid 1px red;
}

</style>
	<jsp:include page="../include/header.jsp" />
	<div align="center">
		<h2>자유게시판</h2>	
		<hr>
		<table border="1">
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
			</tr>
			<c:if test="${articles == null}">
				<td colspan="4">게시글이 존재하지 않습니다.</td>
			</c:if>
			<c:if test="${articles != null}">
				<c:forEach var="article" items="${articles}">
					<tr>
						<td>${article.boardNo}</td>
						<td>
							<a href="<c:url value='/board/content/${article.boardNo}?currentPage=${pm.page.currentPage}'/>">
								${article.title}
							</a>
						</td>
						<td>${article.writer}</td>
						<td>${article.viewCnt}</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<div align="right">
			<input type="button" id="input-btn" value="글 작성"/>
		</div>
		<!-- 페이지처리 -->
		
		<c:if test="${pm.prev}">
			<a href="<c:url value='/board/list?currentPage=1' />"> << </a>&nbsp;
			<a href="<c:url value='/board/list?currentPage=${pm.beginPage - 1}' />"> < </a>&nbsp;
		</c:if>
		
		<c:forEach var="pageNum" begin="${pm.beginPage}" end="${pm.endPage}">
			<a class="${(pageNum == pm.page.currentPage)?'page-btn':''}" 
			href="<c:url value='/board/list?currentPage=${pageNum}'/>"> ${pageNum} </a>&nbsp;
		</c:forEach>
		
		<c:if test="${pm.next}">
			<a href="<c:url value='/board/list?currentPage=${pm.endPage + 1}' />"> > </a>&nbsp;
			<a href="<c:url value='/board/list?currentPage=${pm.totalPage}' />"> >> </a>&nbsp;
		</c:if>
		
		<!-- 검색처리 -->
		<hr>
		<form method="post">
			<select name="part">
				<option value="writer">작성자</option>
				<option value="title">제목</option>
			</select>
			<input name="keyword" size="15"/>
			<input type="submit" value="검색"/>
		</form>
		
	</div>
	<script>
		const msg = "${msg}";
		if(msg === "deleteSuccess"){
			alert("게시글이 삭제되었습니다.");
		}
		
		$(function() {
			$("#input-btn").click(function() {
				location.href="<c:url value='/board/write'/>";
			});
		});
	</script>
	<jsp:include page="../include/footer.jsp" />
	
	
	
	
	
	
	
	
	
	
	
	