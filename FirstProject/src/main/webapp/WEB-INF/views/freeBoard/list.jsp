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
		<div align="right">
			<input type="button" class="message-page" value="10" />
			<input type="button" class="message-page" value="20" />
			<input type="button" class="message-page" value="30" />
		</div>
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
							<a href="<c:url value='/board/content/${article.boardNo}${(param.currentPage==null)?pm.makeUri(1) : pm.makeUri(param.currentPage)}'/>">
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
			<a href="<c:url value='/board/list${pm.makeUri(1)}' />"> << </a>&nbsp;
			<a href="<c:url value='/board/list${pm.makeUri(pm.beginPage - 1)}' />"> < </a>&nbsp;
		</c:if>
		
		<c:forEach var="pageNum" begin="${pm.beginPage}" end="${pm.endPage}">
			<a class="${(pageNum == pm.page.currentPage)?'page-btn':''}" 
			href="<c:url value='/board/list${pm.makeUri(pageNum)}'/>"> ${pageNum} </a>&nbsp;
		</c:forEach>
		
		<c:if test="${pm.next}">
			<a href="<c:url value='/board/list${pm.makeUri(pm.endPage + 1)}' />"> > </a>&nbsp;
			<a href="<c:url value='/board/list${pm.makeUri(pm.totalPage)}' />"> >> </a>&nbsp;
		</c:if>
		
		<!-- 검색처리 -->
		<hr>
		<select name="part" id="part">
			<option value="writer" ${param.part == 'writer' ? 'selected' : ''}>작성자</option>
			<option value="title" ${param.part == 'title' ? 'selected' : ''}>제목</option>
			<option value="content" ${param.part == 'content' ? "selected" : ''}>내용</option>
			<option value="titleContent" ${param.part == 'titleContent' ? 'selected' : ''}>제목+내용</option>
		</select>
		<input name="keyword" id="keywordInput" size="15" value="${param.keyword}"/>
		<input type="button" id="searchBtn" value="검색"/>
	</div>
	<script>
		const msg = "${param.msg}";
		if(msg === "deleteSuccess"){
			alert("게시글이 삭제되었습니다.");
		}
		
		$(function() {
			$("#input-btn").click(function() {
				location.href="<c:url value='/board/write'/>";
			});
			
			$(".message-page").click(function() {
				let message = $(this).val();
				location.href="<c:url value='/board/list?currentPage=${pm.page.currentPage}&messagePerPage="+message+"'/>";
			});
			
			$("#searchBtn").click(function() {
				const part = $("#part option:selected").val();
				const keyword = $("#keywordInput").val();
				location.href = "<c:url value='/board/list?part="+part+"&keyword="+keyword+"' />";
			});
			
			$("#keywordInput").keydown(function(key) {
				if(key.keyCode == 13){
					$("#searchBtn").click();
				}
			});
			
		});
		
	</script>
	<jsp:include page="../include/footer.jsp" />
	
	
	
	
	
	
	
	
	
	
	
	