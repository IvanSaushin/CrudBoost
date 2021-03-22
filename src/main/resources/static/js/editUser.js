

function editUser() {
    let form = window.formEditUser.editRole;
    let setRoleId = new Set();
    let roleNames = [];

    for (var i = 0; i < form.length; i ++) {
        if (form.options[i].selected) {
            setRoleId.add({"id" : form.options[i].value})
            switch (form.options[i].value) {
                case '1' : roleNames.push("USER"); break;
                case '2' : roleNames.push("ADMIN"); break;
            }
        }
    }

    let userDataUpdate = {id: window.formEditUser.editID.value,
                firstname: window.formEditUser.editFN.value,
                lastname: window.formEditUser.editLN.value,
                age: window.formEditUser.editAge.value,
                email: window.formEditUser.editEmail.value,
                password: window.formEditUser.editPass.value,
                roles: Array.from(setRoleId)
    }

    $.ajax({
        'url':'http://localhost:8080/r-api/update',
        'method':'PUT',
        'dataType': 'json',
        'contentType': 'application/json',
        'data': JSON.stringify(userDataUpdate),
        'processData': false,
        'success': function () {
            insertTrEdit();
        }
    });

    function insertTrEdit() {
        $('#'+userDataUpdate.id).replaceWith('<tr id="'+userDataUpdate.id+'">' +
            '<td>'+userDataUpdate.id+'</td>' +
            '<td>'+userDataUpdate.firstname+'</td>' +
            '<td>'+userDataUpdate.lastname+'</td>' +
            '<td>'+userDataUpdate.age+'</td>' +
            '<td>'+userDataUpdate.email+'</td>' +
            '<td>'+roleNames.toString()+'</td>' +
            '<td><button type="button" onclick="getModalEdit('+userDataUpdate.id+')" ' +
            '       class="btn btn-primary btn-sm eBtn">Edit</button>'+
            '<td><button type="button" onclick="getModalDelete(' + userDataUpdate.id + ');return false" ' +
            '       class="btn btn-danger btn-sm deleteBtn">Delete</button>'+
            '</tr>');
    }
}