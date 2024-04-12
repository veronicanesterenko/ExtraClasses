<jsp:include page="../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../components/modal_user.jsp"/>

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
    <c:forEach  var= "teacher" items="${teachers}">

        <tr>
     <%--       <th scope="row">
                <a href="${pageContext.request.contextPath}/subject?subject_name=${subj.name}" > ${subj.name}</a>
            </th>--%>
            <td>${teacher.firstName}</td>

            <td>
                <a href="${pageContext.request.contextPath}/teachers?id=${teacher.id}"> ${teacher.lastName}</a>

           </td>
        </tr>

    </c:forEach>
    </tbody>
</table>

<jsp:include page="../footer.jsp"/>