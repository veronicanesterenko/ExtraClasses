<div style="width: available; padding: 20px" class="modal fade" id="exampleModalToggle" aria-hidden="true"
     aria-labelledby="exampleModalToggleLabel" tabindex="-1">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalToggleLabel">Add new teacher</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>


            <form class="row g-3 needs-validation" method="post" novalidate action="/extra/teachers/add" enctype="multipart/form-data">
                <div class="col-md-4">
                    <label for="validationCustom01" class="form-label">First name</label>
                    <input type="text" class="form-control" name="teacherFirstName" id="validationCustom01" value="Mark" required>
                </div>
                <div class="col-md-4">
                    <label for="validationCustom02" class="form-label">Last name</label>
                    <input type="text" name="teacherLastName" class="form-control" id="validationCustom02" value="Otto" required>
                </div>


                <div class="col-md-4">
                    <label for="validationCustomUsername" class="form-label">Username</label>
                    <div class="input-group has-validation">
                        <span class="input-group-text" id="inputGroupPrepend">@</span>
                        <input type="text" name="teacherLogin" class="form-control" id="validationCustomUsername"
                               aria-describedby="inputGroupPrepend" required>
                    </div>
                </div>

                <div class="col-md-4">
                    <label for="validationCustom02"  class="form-label">Password</label>
                    <input type="text" name="teacherPassword" class="form-control" id="validationCustomPassword" value="pwd" required>
                </div>

                <div class="mb-3">
                    <label for="formFile" class="form-label">upload a photo</label>
                    <input class="form-control" name="teacherPhoto" type="file" id="formFile">
                </div>


                <div class="col-12">
                    <button class="btn btn-primary" type="submit">Save</button>
                </div>
            </form>

        </div>
    </div>
</div>
<a class="btn btn-primary" style="margin-top: 2%; margin-left: 85%" data-bs-toggle="modal" href="#exampleModalToggle"
   role="button">ADD</a>