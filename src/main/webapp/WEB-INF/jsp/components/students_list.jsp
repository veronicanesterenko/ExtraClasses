
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="table table-hover">

    <thead>
    <tr>
        <th scope="col"> First name</th>
        <th scope="col"> Last name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach  var= "student" items="${students}">

        <tr>
            <td>${student.firstName}</td>

            <td>
                <a href="${pageContext.request.contextPath}/students?id=${student.id}"> ${student.lastName}</a>

            </td>
        </tr>

    </c:forEach>
    </tbody>
</table>
