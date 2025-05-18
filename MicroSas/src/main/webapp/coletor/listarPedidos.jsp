<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="FrontController" method="get">
		<input type="hidden" name="command" value="GetPedidos"> 
		<label for="cidade">Deseja filtrar por cidade?</label> 
		
		<select name="cidade">
			<option value="todos">Todos</option>
			<option value="Araraquara">Araraquara</option>
			<option value="São Carlos">São Carlos</option>
			<option value="Ibaté">Ibaté</option>
		</select>
		<input type="submit" value="Carregar pedidos">
</form>		
</body>
</html>