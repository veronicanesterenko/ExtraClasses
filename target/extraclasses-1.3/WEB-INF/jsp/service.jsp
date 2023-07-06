<jsp:include page="header.jsp"/>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="d-grid gap-2" style="margin: 15% 20% 20% 20%;">
    <button class="btn btn-primary lol"  type="button" style="margin: 1%;"
    onclick="location.href='/extra/service/courses'">Courses</button>
    <button class="btn btn-primary lol" type="button" style="margin: 1%;">Teachers</button>
    <button class="btn btn-primary lol" type="button" style="margin: 1%;">Students</button>
</div>



<jsp:include page="footer.jsp"/>