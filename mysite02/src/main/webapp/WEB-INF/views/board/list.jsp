<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html>
<head>
    <title>mysite02</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <link href="${pageContext.request.contextPath }/assets/css/board.css" rel="stylesheet"
          type="text/css">
</head>

<body>
<div id="container">
    <c:import url="/WEB-INF/views/includes/header.jsp"/>
    <div id="content">
        <div id="board">
            <form id="search_form" action="" method="post" action="${pageContext.request.contextPath }/board">
                <input type="hidden" name="a" value="list">
                <input type="text" id="kwd" name="kwd" value="">

                <input type="submit" value="찾기">
            </form>

            <table class="tbl-ex">
                <c:set var="count" value="${fn:length(list)}"/>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>글쓴이</th>
                    <th>조회수</th>
                    <th>작성일</th>
                    <th>&nbsp;</th>
                </tr>
                <c:forEach items="${list}" var="vo" varStatus="status">
                    <tr>
                        <c:set var="rowNumber" value="${pageCnt- ((selectedPage - 1) * 5 + status.index )}" />
                        <td>[${rowNumber}]</td>
<%--                        <td>[${count - status.index}]</td>--%>
                        <c:choose>
                            <c:when test="${vo.depth ne '1'}">
                                <td style="padding-left: ${(vo.depth-1)*20}px">
                                    <img src="${pageContext.request.contextPath}/assets/images/reply.png">
                                    <a href="${pageContext.request.contextPath}/board?a=view&no=${vo.no}">${vo.title}</a>
                                    <input type="hidden" name="a" value="view">
                                </td>
                            </c:when>
                            <c:otherwise>
                                <td style="padding-left: 0px">
                                    <a href="${pageContext.request.contextPath}/board?a=view&no=${vo.no}">${vo.title}</a>
                                    <input type="hidden" name="a" value="view">
                                </td>
                            </c:otherwise>
                        </c:choose>
                        <td>${vo.name}</td>
                        <td>${vo.hit}</td>
                        <td>${vo.regDate}</td>
                            <%--세션 접근제한--%>
                        <c:if test="${authUser.name eq vo.name}">
                            <td>
                                <a href="${pageContext.request.contextPath}/board?a=delete&no=${vo.no}" class="del">삭제</a>
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>

            <!-- pager 추가 -->
            <div class="pager">
                <ul>
                    <c:if test="${selectedPage > 1}">
                        <li><a href="board?page=${selectedPage - 1}">◀</a></li>
                    </c:if>
                    <c:forEach var="pageNumber" begin="${start}" end="${end}">
                        <c:choose>
                            <c:when test="${pageNumber == selectedPage}">
                                <li class="selected">${pageNumber}</li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="board?page=${pageNumber}">${pageNumber}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${selectedPage < total}">
                        <li><a href="board?page=${selectedPage + 1}">▶</a></li>
                    </c:if>
                </ul>

            </div>
            <!-- pager 추가 -->
            <div class="bottom">
                <%--   로그인 접근 제한  --%>
                <c:if test="${not empty authUser}">
                    <a href="${pageContext.request.contextPath }/board?a=write" id="new-book">글쓰기</a>
                </c:if>
            </div>
        </div>
    </div>
    <c:import url="/WEB-INF/views/includes/navigation.jsp"/>
    <c:import url="/WEB-INF/views/includes/footer.jsp"/>
</div>
</body>
</html>