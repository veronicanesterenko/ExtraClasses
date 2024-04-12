<div class="btn-group" role="group" aria-label="Button group with nested dropdown">

    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#change-teacher">Change teacher</button>
    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#edit-description">Edit description</button>

    <div class="btn-group" role="group">
        <button id="btnGroupDrop1" type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
            Students
        </button>
        <ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">
            <li><a class="dropdown-item" data-bs-toggle="modal" href="#add-student">Add student</a></li>
            <li><a class="dropdown-item" href="#">Remove student</a></li>
        </ul>
    </div>
    <button type="submit" class="btn btn-primary" style="background-color:red;">Remove course</button>
</div>

<jsp:include page="modal_change_teacher.jsp"/>
<jsp:include page="modal_edit_description.jsp"/>
<jsp:include page="modal_add_student.jsp"/>