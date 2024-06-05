<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String nombre = request.getParameter("nombre"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario</title>
</head>
<body>

<form>
	<input name="nombre" placeholder="Dime tu nombre">
	<button>Saludar</button>
	<%
		if(nombre == null) {
			out.println("<span>Hola</span>");
		} else { %>
			<span>Hola <%=nombre%></span>
		<% } %>
</form>

</body>
</html>