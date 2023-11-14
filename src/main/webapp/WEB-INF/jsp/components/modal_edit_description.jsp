<!-- Button trigger modal -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Modal -->
<form action="/extra/edit-description" method="post" >
    <div class="modal fade" id="edit-description" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Edit description</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>

                <div class="input-group input-group-sm mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-sm">Change name</span>
                    <input name="changedName" type="text" class="form-control" value="${subject_name.name}" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                </div>

                <div class="form-floating">
                    <textarea name="changedDesc" type="text" class="form-control"  id="floatingTextarea2" style="height: 100px">${subject_name.description}</textarea>
                </div>


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