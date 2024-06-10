<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<main>
	<pre>${empleado}</pre>

	<p>${empleado.errores}</p>

	<form action="formulario" method="post">
		<input readonly name="id" placeholder="Id" value="${empleado.id}">
		<input name="nombre" placeholder="Nombre" value="${empleado.nombre}">
		<span>${empleado.errores.nombre}</span> <input name="apellidos"
			placeholder="Apellidos" value="${empleado.apellidos}"> <span>${empleado.errores.apellidos}</span>
		<input name="telefono" placeholder="Teléfono"
			value="${empleado.telefono}"> <input name="nif"
			placeholder="NIF" value="${empleado.nif}"> <input name="nss"
			placeholder="NSS" value="${empleado.nss}"> <input
			name="sueldo-mensual" placeholder="Sueldo Mensual"
			value="${empleado.sueldoMensual}">

		<button>Guardar</button>
	</form>
</main>

<%@ include file="/WEB-INF/includes/pie.jsp"%>