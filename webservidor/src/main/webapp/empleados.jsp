<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Empleados</title>
</head>
<body>

	<h1>Empleados</h1>

	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Apellidos</th>
				<th>Teléfono</th>
				<th>NIF</th>
				<th>NSS</th>
				<th>Sueldo Mensual</th>
			</tr>
		</thead>
		<c:forEach items="${empleados}" var="e">
			<tr>
				<th>${e.id}</th>
				<td>${e.nombre}</td>
				<td>${e.apellidos}</td>
				<td>${e.telefono}</td>
				<td>${e.nif}</td>
				<td>${e.nss}</td>
				<td>${e.sueldoMensual}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>