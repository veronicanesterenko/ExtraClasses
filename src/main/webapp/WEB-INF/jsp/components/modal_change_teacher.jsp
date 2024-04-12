<!-- Button trigger modal -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Modal -->
<form action="/extra/change-teacher" method="post" >
<div class="modal fade" id="change-teacher" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Choose new teacher</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <select name="teacher" class="form-select" aria-label="Select Teacher">
                <c:forEach var="teacher" items="${teachers}">
                    <option value="${teacher.id}">${teacher.firstName} ${teacher.lastName}</option>
                </c:forEach>
            </select>
            <input type="hidden" name="subject" value="${subject_name.id}">
            <input type="hidden" name="subject_name" value="${subject_name.name}">
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>
</form>