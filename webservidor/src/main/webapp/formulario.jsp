<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<main class="container">

	<form action="admin/formulario" method="post" class="needs-validation" novalidate>
		<div class="row mb-3">
			<label for="id" class="col-sm-2 col-form-label">Id</label>
			<div class="col-sm">
				<input type="number" class="form-control" id="id" readonly name="id"
					placeholder="Id" value="${empleado.id}">
			</div>
		</div>
		<div class="row mb-3">
			<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
			<div class="col-sm">
				<input type="text"
					class="form-control ${empleado.errores.nombre != null ? 'is-invalid' : ''}"
					id="nombre" name="nombre" placeholder="Nombre"
					value="${empleado.nombre}"> <span class="invalid-feedback">${empleado.errores.nombre}</span>
			</div>
		</div>
		<div class="row mb-3">
			<label for="apellidos" class="col-sm-2 col-form-label">Apellidos</label>
			<div class="col-sm">
				<input type="text"
					class="form-control ${empleado.errores.apellidos != null ? 'is-invalid' : ''}"
					id="apellidos" name="apellidos" placeholder="Apellidos"
					value="${empleado.apellidos}"> <span
					class="invalid-feedback">${empleado.errores.apellidos}</span>
			</div>
		</div>
		<div class="row mb-3">
			<label for="telefono" class="col-sm-2 col-form-label">Teléfono</label>
			<div class="col-sm">
				<input type="tel" class="form-control" id="telefono" name="telefono"
					placeholder="Teléfono" value="${empleado.telefono}">
			</div>
		</div>
		<div class="row mb-3">
			<label for="nif" class="col-sm-2 col-form-label">NIF</label>
			<div class="col-sm">
				<input type="text" pattern="^[XYZ\d]\d{7}[A-Z]$"
					class="form-control ${empleado.errores.nif != null ? 'is-invalid' : ''}"
					id="nif" name="nif" placeholder="NIF" value="${empleado.nif}">
				<span class="invalid-feedback">${empleado.errores.nif}</span>
			</div>
		</div>
		<div class="row mb-3">
			<label for="nss" class="col-sm-2 col-form-label">NSS</label>
			<div class="col-sm">
				<input type="text" pattern="^\d{11}$" class="form-control ${empleado.errores.nss != null ? 'is-invalid' : ''}" id="nss"
					name="nss" placeholder="NSS" value="${empleado.nss}">
				<span class="invalid-feedback">El número de la SS debe tener 11 dígitos</span>
			</div>
		</div>
		<div class="row mb-3">
			<label for="sueldo-mensual" class="col-sm-2 col-form-label">Sueldo
				Mensual</label>
			<div class="col-sm">
				<input type="number" step=".01" class="form-control"
					id="sueldo-mensual" name="sueldo-mensual"
					placeholder="Sueldo Mensual" value="${empleado.sueldoMensual}">
			</div>
		</div>

		<button type="submit" class="btn btn-primary">Guardar</button>
	</form>

	<script>
	// Example starter JavaScript for disabling form submissions if there are invalid fields
	(() => {
	  'use strict'

	  // Fetch all the forms we want to apply custom Bootstrap validation styles to
	  const forms = document.querySelectorAll('.needs-validation')

	  // Loop over them and prevent submission
	  Array.from(forms).forEach(form => {
	    form.addEventListener('submit', event => {
	      if (!form.checkValidity()) {
	        event.preventDefault()
	        event.stopPropagation()
	      }

	      form.classList.add('was-validated')
	    }, false)
	  })
	})()
	</script>

</main>

<%@ include file="/WEB-INF/includes/pie.jsp"%>