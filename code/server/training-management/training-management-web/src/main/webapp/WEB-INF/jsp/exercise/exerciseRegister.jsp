<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Manutenção de Exercícios</title>
	</head>

	<body>
		
		<jsp:include page="menu.jsp" />

		<div class="container">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<a id="modal-129039" href="#modal-container-129039" role="button" class="btn" data-toggle="modal">Novo</a>
					<div class="modal fade" id="modal-container-129039" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
									<h4 class="modal-title" id="myModalLabel">
										Novo Exercício
									</h4>
								</div>
								<div class="modal-body">
									<form class="form-horizontal" role="form" method="post" action="doLogin.html">
										<div class="form-group">
											 <label for="inputExercisePart" class="col-sm-2 control-label">Parte</label>
											<div class="col-sm-10">
												<input type="text" name="part" class="form-control" id="inputExercisePart" />
											</div>
										</div>
										<div class="form-group">
											 <label for="inputExerciseName" class="col-sm-2 control-label">Nome</label>
											<div class="col-sm-10">
												<input type="text" name="exercise" class="form-control" id=inputExerciseName />
											</div>
										</div>
									</form>
								</div>
								<div class="modal-footer">
									 <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button> 
									 <button type="button" class="btn btn-primary">Salvar</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>				
	</body>
</html>