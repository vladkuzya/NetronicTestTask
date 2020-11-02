<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Picture</th>
        <th>Name</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>
                <img src="${user.picture.thumbnail}" alt="Photo">
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/show/user?id=${user.id}">
                    <c:out value="${user.name.title} ${user.name.first} ${user.name.last}"/></a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
