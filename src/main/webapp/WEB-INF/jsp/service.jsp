<jsp:include page="header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="d-grid gap-2" style="margin-left: 20%; margin-right: 20%; margin-top: 15%; ">

    <button class="btn btn-primary lol" type="button" style="margin: 1%"
            onmouseleave="clearSize(this)"
            onclick="location.href='/extra/service/courses'"
            onmouseover="changeSize(this)">Courses
    </button>
    <button class="btn btn-primary lol" type="button" style="margin: 1%"
            onmouseleave="clearSize(this)"
            onclick="location.href='/extra/service/teachers'"
            onmouseover="changeSize(this)">Teachers
    </button>
    <button class="btn btn-primary lol" type="button"
            style="margin: 1%" onmouseleave="clearSize(this)"
            onclick="location.href='/extra/service/students'"
            onmouseover="changeSize(this)">Students
    </button>
</div>

<script type="text/javascript">
    function changeSize(input) {
        input.style.width = "102%"
        input.style.high = "102%"
    }

    function clearSize(input) {
        input.style.width = "100%"
        input.style.high = "100%"
    }
</script>


<jsp:include page="footer.jsp"/>