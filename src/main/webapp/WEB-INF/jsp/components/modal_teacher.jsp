<div class="modal fade" id="exampleModalToggle" aria-hidden="true" aria-labelledby="exampleModalToggleLabel"
     tabindex="-1">
    <div class="modal-dialog modal-dialog-centered modal-xl">
        <div class="modal-content" style="padding: 10px">
            <form class="row g-3" method="post" action="/extra/service/teachers/add" enctype="multipart/form-data">
                <div class="col-md-4">
                    <label for="validationDefault01" class="form-label">First name</label>
                    <input type="text" class="form-control" name="teacherFirstName" id="validationDefault01" value="Mark" required>
                </div>
                <div class="col-md-4">
                    <label for="validationDefault02" class="form-label">Last name</label>
                    <input type="text" class="form-control" name="teacherLastName" id="validationDefault02" value="Otto" required>
                </div>
                <div class="col-md-4">
                    <label for="validationDefaultUsername" class="form-label">Username</label>
                    <div class="input-group">
                        <input type="text" class="form-control" name="teacherUsername" id="validationDefaultUsername"
                               aria-describedby="inputGroupPrepend2" required>
                    </div>
                </div>
                <div class="col-md-4">
                    <label for="validationDefault02" class="form-label">Password</label>
                    <input type="text" class="form-control" name="teacherPassword" id="validationDefault03" value="Otto" required>
                </div>

                <div class="mb-3">
                    <label for="formFile" class="form-label">Upload a photo</label>
                    <input class="form-control" type="file" name="teacherPhoto" id="formFile">
                </div>
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