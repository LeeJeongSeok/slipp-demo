<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="kr">
<head>
    <%@ include file="/include/header.jspf" %>
</head>
<body>
<%@ include file="/include/navigation.jspf" %>

<div class="container" id="main">
    <div class="col-md-10 col-md-offset-1">
        <div class="panel panel-default">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>#</th> <th>사용자 아이디</th> <th>이름</th> <th>이메일</th><th></th>
                </tr>
                </thead>
                <tbody>
                <c:choose>
                    <c:when test="${not empty sessionScope.user}">
                        <c:forEach items="${users}" var="user" varStatus="status">
                            <tr>
                                <th scope="row">${status.count}</th>
                                <td>${user.userId}</td>
                                <td>${user.name}</td>
                                <td>${user.email}</td>
                                <c:choose>
                                    <c:when test="${user.userId eq sessionScope.user.userId}">
                                        <td><a href="/user/update?user=${user.userId}" class="btn btn-success" role="button">수정</a>
                                    </c:when>
                                </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td>로그인 후 확인할 수 있습니다.</td>
                        </tr>
                    </c:otherwise>
                </c:choose>

                </tbody>
            </table>
        </div>
    </div>
</div>

<%@ include file="/include/footer.jspf" %>
</body>
</html>
