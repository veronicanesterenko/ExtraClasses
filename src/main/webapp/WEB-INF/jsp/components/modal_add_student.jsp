<!-- Button trigger modal -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Modal -->
<form action="/extra/add-student" method="post" >
    <div class="modal fade" id="add-student" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Choose student</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <select name="student" class="form-select" aria-label="Select Student">
                    <c:forEach var="student" items="${students}">
                        <option value="${student.id}">${student.firstName} ${student.lastName}</option>
                    </c:forEach>
                </select>
                <input type="hidden" name="subject" value="${subject_name.id}">
                <input type="hidden" name="subject_name" value="${subject_name.name}">
                <input type="hidden" name="teacher" value="${teacher.id}">
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>
</form>