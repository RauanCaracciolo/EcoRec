<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Lista de Usuários Cadastrados</title>
</head>
<body>
	<form action="FrontController" method="post"  enctype="multipart/form-data">
		<input type="hidden" name="command" value="RegisterUser"> 
		<label
			for="nome">Nome: </label> <input type="text" name="nome"><br>
		<br> 
		<label
			for="cpf">Cpf: </label> <input type="text" name="cpf"><br>
		<br>
		<label for="email">Email: </label> <input type="email"
			name="email"><br> <br>
			<label
			for="nome">Senha: </label> <input type="text" name="senha"><br>
		<br> 

		<p>Endereço:</p>
		<label for="cep">CEP: </label> <input type="text" name="cep"><br>
		<br> <label for="cidade">Cidade:</label> <input type="text"
			name="cidade"><br> <label for="rua">Rua: </label> <input
			type="text" name="rua"><br> <br> <label
			for="numero">Numero: </label> <input type="text" name="numero"><br>
		<br> <br> <label for="foto">Foto:</label> <input type="file"
			name="foto" accept="image/png, image/jpeg"><br> <br>
		<input type="submit" value="Cadastrar">
	</form>
</body>
</html>