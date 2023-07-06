


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <table class="table table-hover">

        <thead>
        <tr>
            <th scope="col"> Course</th>
            <th scope="col"> Description</th>
            <th scope="col"> Teacher</th>
            <th scope="col"> Count hours</th>
            <th scope="col"> Count students</th>
        </tr>
        </thead>
        <tbody>
<c:forEach  var= "subj" items="${subjects}">

    <tr>
        <th scope="row">
            <a href="${pageContext.request.contextPath}/subject?subject_name=${subj.name}" > ${subj.name}</a>
    </th>
        <td>${subj.description}</td>
        <td></td>
        <td>${subj.hoursCount}</td>
        <td></td>
    </tr>

</c:forEach>
        </tbody>
    </table>
