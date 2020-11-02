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
        <th>Email</th>
        <th>Location</th>
        <th>Phone</th>
        <th>Registered</th>
    </tr>
    <tr>
        <td>
            <img src="${picture}" alt="Photo">
        </td>
        <td>
            ${name}
        </td>
        <td>
            ${email}
        </td>
        <td>
            ${location}
        </td>
        <td>
            ${phone}
        </td>
        <td>
            ${registered}
        </td>
    </tr>
</table>
</body>
</html>
