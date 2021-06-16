<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>회원가입</title>
</head>

<body>

<h1>회원가입</h1>

<c:url value="/user/addUser" var="addUserUrl" />
<p>${addUserUrl}</p>
<form:form name="frmMember" action="${addUserUrl}" method="POST">
    <p>
        <label for="username">아이디</label>
        <input type="text"  name="username" />
    </p>
    <p>
        <label for="password">비밀번호</label>
        <input type="password" name="password"/>
    </p>
    <button type="submit" class="btn">가입하기</button>
</form:form>
</body>
</html>
