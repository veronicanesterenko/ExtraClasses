<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="exampleModalToggle" aria-hidden="true" aria-labelledby="exampleModalToggleLabel"
     tabindex="-1" >
    <div class="modal-dialog modal-dialog-centered modal-xl" >
        <div class="modal-content" style="padding: 10px">
            <form class="row g-3" method="post" action="/extra/service/subjects/add" enctype="multipart/form-data">
                <div class="col-md-4">
                    <label for="validationDefault01" class="form-label">Name</label>
                    <input type="text" class="form-control" name="subjectName" id="validationDefault01" value="" required>
                </div>
                <div class="col-md-4">
                    <label for="validationDefault02" class="form-label">Description</label>
                    <input type="text" class="form-control" name="subjectDescription" id="validationDefault02" value="" required>
                </div>
                <div class="col-md-4">
                    <label for="validationDefaultUsername" class="form-label">Hours</label>
                    <div class="input-group">
                        <input type="text" class="form-control" name="hoursCount" id="validationDefaultUsername"
                               aria-describedby="inputGroupPrepend2" required>
                    </div>
                </div>
                <div class="col-md-4">
                    <label for="validationDefault02" class="form-label">isFree</label>
                    <input type="text" class="form-control" name="isFree" id="validationDefault03" value="" required>
                </div>
                <select name="teacher" class="form-select" aria-label="Select Teacher">
                    <c:forEach var="teacher" items="${teachers}">
                        <option value="${teacher.id}">${teacher.firstName} ${teacher.lastName}</option>
                    </c:forEach>
                </select>

                <div class="modal-footer">
                    <div class="col-12">
                        <button class="btn btn-primary" type="submit">Submit form</button>
                    </div>
                </div>


            </form>

        </div>
    </div>
</div>

<a class="btn btn-primary" data-bs-toggle="modal" href="#exampleModalToggle" role="button"
   style="margin-left: 90%; margin-top: 2%">Add New</a>