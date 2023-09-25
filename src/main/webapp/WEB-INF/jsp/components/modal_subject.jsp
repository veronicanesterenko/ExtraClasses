<div style="width: available; padding: 20px" class="modal fade" id="exampleModalToggle" aria-hidden="true"
     aria-labelledby="exampleModalToggleLabel" tabindex="-1">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalToggleLabel">Add new subject</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>


            <form class="row g-3 needs-validation" method="post" novalidate action="/extra/subjects/add" enctype="multipart/form-data">
                <div class="col-md-4">
                    <label for="validationCustom01" class="form-label">Name</label>
                    <input type="text" class="form-control" name="subjectName" id="validationCustom01" value="" required>
                </div>
                <div class="col-md-4">
                    <label for="validationCustom02" class="form-label">Description</label>
                    <input type="text" name="subjectDescription" class="form-control" id="validationCustom02" value="" required>
                </div>
                <div class="col-md-4">
                    <label for="validationCustom02" class="form-label">Hours</label>
                    <input type="text" name="hoursCount" class="form-control" id="validationCustom03" value="" required>
                </div>

                <div class="col-md-4">
                    <label for="validationCustom02" class="form-label">Is free</label>
                    <input type="text" name="isFree" class="form-control" id="validationCustom04" value="" required>
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