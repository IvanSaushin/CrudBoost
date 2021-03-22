
function newUser() {


    let form = document.getElementById('role');
    let setRoleId = new Set();

    for (var i = 0; i < form.length; i++) {
        if (form.options[i].selected) {
            setRoleId.add({
                "id": form.options[i].value
            })
        }
    }

    let userData = {
        firstname: window.newUserForm.inputFirstname.value,
        lastname: window.newUserForm.inputlastname.value,
        age: window.newUserForm.inputAge.value,
        email: window.newUserForm.inputEmail.value,
        password: window.newUserForm.inputPass.value,
        roles: Array.from(setRoleId)
    };

    $.ajax({
        'url': 'http://localhost:8080/r-api/create',
        'method': 'POST',
        'dataType': "text json",
        'contentType': 'application/json',
        'data': JSON.stringify(userData),
        'success': function () {
            insertTr();

        }
    });

    function insertTr() {
        fetch('http://localhost:8080/r-api/getAllUsers')
            .then(response => response.json())
            .then(users => users[users.length-1])
            .then(user => {
                let tr = [];
                tr.push('<tr id="'+user.id+'">');
                tr.push('<td>' + user.id + '</td>');
                tr.push('<td>' + user.firstname + '</td>');
                tr.push('<td>' + user.lastname + '</td>');
                tr.push('<td>' + user.age + '</td>');
                tr.push('<td>' + user.email + '</td>');
                tr.push('<td>' + listRoles(user).textContent + '</td>');
                tr.push('<td><button type="button" onclick="getModalEdit(' + user.id + ')" ' +
                    'class="btn btn-primary btn-sm eBtn">Edit</button>')
                tr.push('<td><button type="button" onclick="getModalDelete(' + user.id + ')" ' +
                    'class="btn btn-danger btn-sm deleteBtn">Delete</button>')
                tr.push('</tr>');
                $('.mainTable').append($(tr.join('')));
            });
    }
}



// let selectedRoles = window.formEdit.querySelectorAll('#eSelectRoles option:checked');
// let rolesArr = Array.from(selectedRoles).map(role => role.value);

// let form = window.formNewUser.newRoles;
// let new_Roles = "";
// let rolesList = document.createElement('ul');
//
// for (var i = 0; i < form.length; i++) {
//     var option = form.options[i];
//     let role = document.createElement('li');
//     if (option.selected) {
//         new_Roles = new_Roles.concat(option.value + (i != (form.length - 1) ? "," : ""));
//
//         role.textContent = option.value + " ";
//         rolesList.appendChild(role);
//     }
// }
//
// fetch('http://localhost:8080/create', {
//     method: 'POST',
//     body: JSON.stringify({
//         name: window.formNewUser.newName.value,
//         lastName: window.formNewUser.newLastName.value,
//         age: window.formNewUser.newAge.value,
//         email: window.formNewUser.newEmail.value,
//         password: window.formNewUser.newPassword.value,
//         roles: new_Roles
//     }),