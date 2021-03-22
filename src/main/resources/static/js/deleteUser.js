

function deleteUser(id) {

    $.ajax({
        'url':'http://localhost:8080/r-api/delete/' + id,
            'type':'DELETE',
            'success': function (res) {
            deleteTr();
        }
    });

    function deleteTr() {
        $('#'+id).replaceWith("");
    }
}