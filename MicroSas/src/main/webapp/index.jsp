<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Cadastro de Usuario</title>
</head>
<body>
	<form action="FrontController" method="post">
		<input type="hidden" name="command" value="Login"> 
		<label
			for="cpf">Cpf: </label> <input type="text" name="cpf"><br>
		<br>
			<label
			for="nome">Senha: </label> <input type="text" name="senha"><br>
		<br> 
		<input type="submit" value="Logar">
	</form>
	<a href="escolhaCadastro.html"><button>Não possui conta? Clique aqui para se cadastrar.</button></a>
</body>
</html>