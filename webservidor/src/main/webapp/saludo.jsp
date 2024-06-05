<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Saludar</title>
</head>
<body>

<form action="saludar">
	<input name="nombre" placeholder="Dime tu nombre">
	<button>Saludar</button>
	<span>${nombre != null ? nombre : 'Hola'}</span>
</form>

</body>
</html>