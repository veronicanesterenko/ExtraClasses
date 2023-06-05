
<jsp:include page="../header.jsp"></jsp:include>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:forEach  var= "subj" items="${subjects}">
    <tr>
        <th scope="row" >${subj.name}</th>

        <td><a ${subj.description} href="http://google.com/search?q=${subj.description}" </td>
        <td scope="row"> ${subj.hoursCount}</td>
    </tr>

    <h1>${subj.description}</h1>
</c:forEach>



</body>
</html>
