<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="include/header.jsp" />
<img src="<c:url value='/img/home/welcome.jpg'/>" alt="" style="width:100%; height:60%;" />
<jsp:include page="include/footer.jsp" />
<script>
	const msg = "${param.msg}";
	
	if(msg === "login"){
		alert("로그인 후 이용 가능합니다!");
	}
</script>