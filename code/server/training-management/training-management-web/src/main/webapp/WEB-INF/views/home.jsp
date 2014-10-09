<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Training Management - Home</title>
		
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
		
		<!-- Optional theme -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
		
		<!-- Latest compiled and minified JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
		
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

		<script type="text/javascript">
		
			function findAthlete() {
				
				var name = $('#name').val();
				var data = 'name='
						+ encodeURIComponent(name);
				$.ajax({
					url : "/tm-web/findAthlete",
					data : data,
					type : "GET",
					success : function(response) {
						alert('Sucesso' + response );
					},
					error : function(xhr, status, error) {
						alert('Error' + xhr.responseText);
					}
				});
				return false;
				
			}
	
		</script>

	</head>
	
	<body>
		
		<div>
			<input type="text" name="name" id="name"><input type="button" onclick="findAthlete();" value="Find" >
		</div>		
	</body>
</html>