function findAthlete() {

	var name = $('#inputName').val();

	if (!name) {
		alert("Insira um nome para consulta!");
		return;
	}

	var data = 'name=' + encodeURIComponent(name);
	$.ajax({
		url : "findAthlete.html",
		data : data,
		type : "GET",
		success : function(response) {
			alert('Sucesso' + response);
		},
		error : function(xhr, status, error) {
			alert('Error' + xhr.responseText);
		}
	});
	return false;
}