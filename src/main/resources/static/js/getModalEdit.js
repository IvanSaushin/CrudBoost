function getModalEdit(id) {

    $.getJSON('http://localhost:8080/r-api/getUser/' + id, function (jsonUser) {


        let modal = document.getElementById('modalWindow');


        modal.innerHTML =
            '<div id="editModal"' +
            '                 class="modal fade" tabindex="-1"' +
            '                 role="dialog"' +
            '                 aria-labelledby="exampleModalCenteredLabel" aria-hidden="true">' +
            '                <div class="modal-dialog modal-dialog-centered" role="document">' +
            '                    <div class="modal-content">' +
            '                        <div class="modal-header">' +
            '                            <h5 class="modal-title" id="exampleModalCenteredLabel">Edit user</h5>' +
            '                            <button type="button" class="close" data-dismiss="modal"' +
            '                                    aria-label="Close">' +
            '                                <span aria-hidden="true">&times;</span>' +
            '                            </button>' +
            '                        </div>' +
            '                        <div class="modal-body container text-center col-8">' +
            '                            <form id="formEditUser"' +
            '                                  role="form"' +
            '                                  class="form-horizontal">' +
            '                                <div class="form-group">' +
            '                                    <label for="editID"' +
            '                                           class="control-label "><strong>ID</strong></label>' +
            '                                    <input type="text" class="form-control"' +
            '                                           id="editID" placeholder="user ID"' +
            '                                           name="id" value="'+jsonUser.id+'" readonly>' +
            '                                </div>' +
            '                                <div class="form-group">' +
            '                                    <label for="editFN" class="control-label "><strong>Firstname</strong></label>' +
            '                                    <input type="text" class="form-control"' +
            '                                           id="editFN" value="'+jsonUser.firstname+'" ' +
            '                                           name="firstname">' +
            '                                </div>' +
            '                                <div class="form-group">' +
            '                                    <label for="editLN" class="control-label"><strong>Lastname</strong></label>' +
            '                                    <input type="text" class="form-control"' +
            '                                           id="editLN" value="'+jsonUser.lastname+'" ' +
            '                                           name="lastname">' +
            '                                </div>' +
            '                                <div class="form-group">' +
            '                                    <label for="editAge"' +
            '                                           class="control-label"><strong>Age</strong></label>' +
            '                                    <input type="text" class="form-control"' +
            '                                           id="editAge" value="'+jsonUser.age+'" ' +
            '                                           name="age">' +
            '                                </div>' +
            '                                <div class="form-group">' +
            '                                    <label for="editEmail" class="control-label"><strong>Email</strong></label>' +
            '                                    <input type="text" class="form-control"' +
            '                                           id="editEmail" value="'+jsonUser.email+'" ' +
            '                                           name="email">' +
            '                                </div>' +
            '                                <div class="form-group">' +
            '                                    <label for="editPass" class="control-label"><strong>Password</strong></label>' +
            '                                    <input type="text" class="form-control"' +
            '                                           id="editPass" placeholder="Enter new password" value="'+jsonUser.password+'" ' +
            '                                           name="password">' +
            '                                </div>' +
            '                                <div class="form-group">' +
            '                                    <label for="editRole" class="control-label"><strong>Role</strong></label>' +
            '                                    <select class="form-control" name="roles[]" required multiple' +
            '                                            id="editRole" size="2">' +
            '                                        <option value="2">ADMIN</option>' +
            '                                        <option value="1">USER</option>' +
            '                                    </select>' +
            '                                </div>' +
            '                            </form>' +
            '                        </div>' +
            '                        <div class="modal-footer">' +
            '                            <button type="button" class="btn btn-secondary"' +
            '                                    data-dismiss="modal">Close' +
            '                            </button>' +
            '                            <button type="submit" form="formEditUser" class="btn btn-primary editBtn" ' +
            '                                   data-dismiss="modal" onclick="editUser()" >Edit</button>' +
            '                        </div>' +
            '                    </div>' +
            '                </div>' +
            '                </div>';

        $("#editModal").modal();

    });


}