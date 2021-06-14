<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
   <title>메인페이지</title>
</head>

<body>

<h1>메인페이지</h1>

<!-- jstl 에서 시큐리티 관련해서 제공하는 태그 (http://www.springframework.org/security/tags) -->
<sec:authorize access="isAnonymous()"> <!-- isAnonymous() = permitAll -->
   <p><a href="<c:url value="/login/loginForm" />">로그인</a></p>
</sec:authorize>

<sec:authorize access="isAuthenticated()"> <!-- isAuthenticated() = 로그인된 유저와 로그인 안된 유저를 구분함 -->
   <form:form action="${pageContext.request.contextPath}/logout" method="POST">
       <input type="submit" value="로그아웃" />
   </form:form>
   <p><a href="<c:url value="/loginInfo" />">로그인 정보 확인 방법5 가지(상속관계만 잘 이해하면 된다.)</a></p>
</sec:authorize>

<h3>
    [<a href="<c:url value="/user/userForm" />">회원가입</a>]
    [<a href="<c:url value="/user/userHome" />">유저 홈</a>] <!-- c:url = 절대 경로로 만들어줌 (컨텍스트 패스를 달아준다) -->
    [<a href="<c:url value="/admin/adminHome" />">관리자 홈</a>]
<%--     [<a href="<c:url value="/restful/" />">게시판</a>] --%>
</h3>
</body>
</html>