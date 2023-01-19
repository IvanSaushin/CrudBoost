

function findUser() {

    let stringName = window.searchForm.searchField.value

    detachTable();

    $.get('http://localhost:8080/r-api/search?name=' + stringName, function (json) {

            var tr = [];
            for (var i = 0; i < json.length; i++) {
                tr.push('<tr id="'+json[i].id+'">');
                tr.push('<td>'+json[i].id + '</td>');
                tr.push('<td>'+json[i].firstname + '</td>');
                tr.push('<td>'+json[i].lastname + '</td>');
                tr.push('<td>'+json[i].age + '</td>');
                tr.push('<td>'+json[i].email + '</td>');
                tr.push('<td>'+listRoles(json[i]).textContent + '</td>');
                tr.push('<td><button type="button" onclick="getModalEdit('+json[i].id+')" ' +
                    'class="btn btn-primary btn-sm eBtn">Edit</button>')
                tr.push('<td><button type="button" onclick="getModalDelete(' + json[i].id + ');return false" ' +
                    'class="btn btn-danger btn-sm deleteBtn">Delete</button>')
                tr.push('</tr>');
            }
            $('.mainTable').append($(tr.join('')));
        })


}

    function detachTable() {
        for (var i = 0; i < 100; i++) {
           $('#'+i).remove();
        }
    }