<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejemplo JSTL</title>
</head>
<body>

<% request.setAttribute("nombre", "Javier"); %>

<c:if test="${nombre == 'Javier'}">
	<h1>Hola Profe</h1>
</c:if>

<%
var al = new java.util.ArrayList<String>();

al.add("Uno");
al.add("Dos");
al.add("Tres");

request.setAttribute("lista", al);
%>

<ul>
	<c:forEach items="${lista}" var="e">
		<li>${e}</li>
	</c:forEach>
</ul>


</body>
</html>