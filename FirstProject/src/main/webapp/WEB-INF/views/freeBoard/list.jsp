<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
							<a href="<c:url value='/board/content/${article.boardNo}'/>">
								${article.title}
							</a>
						</td>
						<td>${article.writer}</td>
						<td>${article.viewCnt}</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		
		<a href="<c:url value='/board/write'/>">새로운 글 작성</a>
		
		<!-- 페이지처리 -->
		
		
		
		
		
		<!-- 검색처리 -->
	
	</div>
	<script>
		const msg = "${msg}";
		if(msg === "deleteSuccess"){
			alert("게시글이 삭제되었습니다.");
		}
	</script>
	<jsp:include page="../include/footer.jsp" />
	
	
	
	
	
	
	
	
	
	
	
	