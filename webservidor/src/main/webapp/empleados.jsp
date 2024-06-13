<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<main class="container-fluid">
	<h1>Empleados</h1>

	<table class="table table-hover table-striped table-bordered">
		<thead class="table-dark">
			<tr>
				<th class="text-end">Id</th>
				<th>Nombre</th>
				<th>Apellidos</th>
				<th>Teléfono</th>
				<th>NIF</th>
				<th>NSS</th>
				<th class="text-end">Sueldo Mensual</th>
				<th>OPCIONES</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${empleados}" var="e">
				<tr>
					<th class="text-end">${e.id}</th>
					<td>${e.nombre}</td>
					<td>${e.apellidos}</td>
					<td>${e.telefono}</td>
					<td>${e.nif}</td>
					<td>${e.nss}</td>
					<td class="text-end">${e.sueldoMensual}</td>
					<td><a class="btn btn-sm btn-primary" href="admin/formulario?id=${e.id}">Editar</a> <a class="btn btn-sm btn-danger" href="admin/borrar?id=${e.id}">Borrar</a></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot class="table-dark">
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a class="btn btn-sm btn-primary" href="admin/formulario">Añadir</a></td>
			</tr>

		</tfoot>
	</table>
	
</main>
<%@ include file="/WEB-INF/includes/pie.jsp"%>