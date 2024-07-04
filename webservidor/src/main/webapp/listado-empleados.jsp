<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<main class="container-fluid">
	<h1>Empleados</h1>

	<div
		class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 row-cols-xxl-6 g-4">
		<c:forEach items="${empleados}" var="e">
			<div class="col">
				<div class="card h-100">
					<img src="https://picsum.photos/400/300?${e.id}" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">${e.nombre} ${e.apellidos}</h5>
						<p class="card-text">${e.telefono}, ${e.sueldoMensual}</p>
					</div>
					<div class="card-footer">
						<small class="text-body-secondary">${e.nif} ${e.nss}</small>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>

</main>
<%@ include file="/WEB-INF/includes/pie.jsp"%>