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
			for="key">Cpf(Coletor) ou Email(Usuario): </label> <input type="text" name="key"><br>
		<br>
			<label
			for="nome">Senha: </label> <input type="text" name="senha"><br>
		<br> 
		<label for="tipo">Escolha seu tipo de conta:</label>
		<select name="tipo">
			<option value="usuario">Usuario</option>
			<option value="coletor">Coletor</option>
		</select>
		<input type="submit" value="Logar">
	</form>
	<p><% out.println(request.getAttribute("erro")); %></p>
	<a href="escolhaCadastro.html"><button>Não possui conta? Clique aqui para se cadastrar.</button></a>
</body>
</html>