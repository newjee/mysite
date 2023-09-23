<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="header">
    <h1>${updated.title }</h1>
    <ul>
        <c:choose>
            <c:when test="${empty authUser}">
                <li><a href="${pageContext.request.contextPath}/user/login">로그인</a>
                <li/>
                <li><a href="${pageContext.request.contextPath}/user/join">회원가입</a>
                <li>
            </c:when>

            <c:otherwise>
                <li><a href="${pageContext.request.contextPath}/user/update">회원정보수정</a>
                <li>
                <li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a>
                <li>
                <li>${authUser.name }님 안녕하세요 >_-</li>
            </c:otherwise>

        </c:choose>
    </ul>
</div>
