<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>list of courses</title>
</head>
<body>
<c:forEach var="subj" items="${subjects}">
    <tr>
        <th scope="row" >${subj.name}</th>
        <td>${subj.description}</td>
    </tr>

<h1>${subj.description}</h1>
    <a lol href="vk.ru"></a>
</c:forEach>

</body>
</html>