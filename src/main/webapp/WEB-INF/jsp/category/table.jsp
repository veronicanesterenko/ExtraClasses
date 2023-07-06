
<jsp:include page="../header.jsp"></jsp:include>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


    <table class="table table-hover">

        <thead>
        <tr>
            <th scope="col"> ID</th>
            <th scope="col"> Name</th>
            <th scope="col"> Discount</th>
            <th scope="col"> Alias_name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach  var= "cat" items="${categories}">

            <tr>
                <th scope="row"> ${cat.id}</th>
                <td>${cat.name}</td>
                <td>${cat.discount}</td>
                <td>${cat.alias}</td>

            </tr>

        </c:forEach>
        </tbody>
    </table>





</body>
</html>
