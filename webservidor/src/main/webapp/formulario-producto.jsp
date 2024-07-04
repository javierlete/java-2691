<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<main class="container">

	<form action="admin/formulario-producto" method="post" class="needs-validation" novalidate>
		<div class="row mb-3">
			<label for="id" class="col-sm-2 col-form-label">Id</label>
			<div class="col-sm">
				<input type="number" class="form-control" id="id" readonly name="id"
					placeholder="Id" value="${producto.id}">
			</div>
		</div>
		<div class="row mb-3">
			<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
			<div class="col-sm">
				<input type="text"
					class="form-control ${errores.nombre != null ? 'is-invalid' : ''}"
					id="nombre" name="nombre" placeholder="Nombre"
					value="${producto.nombre}"> <span class="invalid-feedback">${errores.nombre}</span>
			</div>
		</div>
		<div class="row mb-3">
			<label for="stock" class="col-sm-2 col-form-label">Stock</label>
			<div class="col-sm">
				<input type="text"
					class="form-control ${errores.stock != null ? 'is-invalid' : ''}"
					id="stock" name="stock" placeholder="Stock"
					value="${producto.stock}"> <span
					class="invalid-feedback">${errores.stock}</span>
			</div>
		</div>
		<div class="row mb-3">
			<label for="categoria" class="col-sm-2 col-form-label">Categoría</label>
			<div class="col-sm">
				<select class="form-select" id="categoria" name="categoria">
					<c:forEach items="${categorias}" var="c">
						<option value="${c.id}" ${producto.categoria.id == c.id ? 'selected' : ''}>${c.nombre}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="row mb-3">
			<label for="precio" class="col-sm-2 col-form-label">Precio</label>
			<div class="col-sm">
				<input type="number" step=".01" class="form-control"
					id="precio" name="precio"
					placeholder="Precio" value="${producto.precio}">
			</div>
		</div>
		<div class="row mb-3">
			<label for="descripcion" class="col-sm-2 col-form-label">Descripción</label>
			<div class="col-sm">
				<textarea class="form-control ${errores.nss != null ? 'is-invalid' : ''}" id="descripcion"
					name="descripcion" placeholder="Descripción">${producto.descripcion}</textarea>
				<span class="invalid-feedback"></span>
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