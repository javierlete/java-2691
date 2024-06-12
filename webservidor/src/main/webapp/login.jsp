<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<main class="container">

	<form action="login" method="post">
		<div class="row mb-3">
			<label for="nombre" class="col-sm-2 col-form-label">Email</label>
			<div class="col-sm">
				<input type="email" class="form-control" id="email" name="email"
					placeholder="Email" value="${requestScope.email}">
			</div>
		</div>
		<div class="row mb-3">
			<label for="apellidos" class="col-sm-2 col-form-label">Contraseña</label>
			<div class="col-sm">
				<input type="password" class="form-control" id="password"
					name="password" placeholder="Contraseña">
			</div>
		</div>

		<button type="submit" class="btn btn-primary">Iniciar sesión</button>
	</form>

</main>

<%@ include file="/WEB-INF/includes/pie.jsp"%>