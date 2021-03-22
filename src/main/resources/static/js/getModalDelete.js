function getModalDelete(id) {


    $.getJSON('http://localhost:8080/r-api/getUser/' + id, function (jsonUser) {

        let modal = document.getElementById('modalWindow');

        modal.innerHTML = '<div id="deleteUser"' +
            '                     class="modal fade" tabindex="-1"' +
            '                     role="dialog"' +
            '                     aria-labelledby="exampleModalCenteredLabel" aria-hidden="true">' +
            '                    <div class="modal-dialog modal-dialog-centered" role="document">' +
            '                        <div class="modal-content">' +
            '                            <div class="modal-header">' +
            '                                <h5 class="modal-title">Delete user</h5>' +
            '                                <button type="button" class="close" data-dismiss="modal"' +
            '                                        aria-label="Close">' +
            '                                    <span aria-hidden="true">&times;</span>' +
            '                                </button>' +
            '                            </div>' +
            '                            <div class="modal-body container text-center col-8">' +
            '                                <form role="form" class="form-horizontal">' +
            '                                    <fieldset disabled>' +
            '                                        <div class="form-group">' +
            '                                            <label for="deleteId"' +
            '                                                   class="control-label "><strong>ID</strong></label>' +
            '                                            <input type="text" class="form-control"' +
            '                                                   id="deleteId" value="' + jsonUser.id + '" >' +
            '                                        </div>' +
            '                                        <div class="form-group">' +
            '                                            <label for="deletefn"' +
            '                                                   class="control-label "><strong>Firstname</strong></label>' +
            '                                            <input type="text" class="form-control"' +
            '                                                   id="deletefn" value="' + jsonUser.firstname + '">' +
            '                                        </div>' +
            '                                        <div class="form-group">' +
            '                                            <label for="deleteln" class="control-label"><strong>Lastname</strong></label>' +
            '                                            <input type="text" class="form-control"' +
            '                                                   id="deleteln" value="' + jsonUser.lastname + '">' +
            '                                        </div>' +
            '                                        <div class="form-group">' +
            '                                            <label for="deleteAge"' +
            '                                                   class="control-label"><strong>Age</strong></label>' +
            '                                            <input type="number" class="form-control"' +
            '                                                   id="deleteAge" value="' + jsonUser.age + '">' +
            '                                        </div>' +
            '                                        <div class="form-group">' +
            '                                            <label for="deleteEmail"' +
            '                                                   class="control-label"><strong>Email</strong></label>' +
            '                                            <input type="email" class="form-control"' +
            '                                                   id="deleteEmail" value="' + jsonUser.email + '">' +
            '                                        </div>' +
            '                                        <div class="form-group">' +
            '                                            <label for="deleteRole"' +
            '                                                   class="control-label"><strong>Role</strong></label>' +
            '                                            <input type="text" class="form-control"' +
            '                                                   id="deleteRole" ' +
            '                                                   value="' + listRoles(jsonUser).textContent + '">' +
            '                                        </div>' +
            '' +
            '                                    </fieldset>' +
            '                                    <div class="modal-footer">' +
            '                                        <button type="button" class="btn btn-secondary"' +
            '                                                data-dismiss="modal">Close' +
            '                                        </button>' +
            '                                        <a href="" class="btn btn-danger" onclick="deleteUser('+jsonUser.id+')"' +
            '                                               id="DeleteButton" data-dismiss="modal">Delete</a>' +
            '                                    </div>' +
            '                                    <br/><br/>' +
            '                                </form>' +
            '                            </div>' +
            '' +
            '                        </div>' +
            '                    </div>' +
            '                </div>';

        $('#deleteUser').modal();


    });

}