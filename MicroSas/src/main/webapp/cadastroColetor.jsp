<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Cadastro de Coletores</title>
</head>
<body>
	<form action="FrontController" method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="command" value="RegisterColetor"> <label
			for="nome">Nome: </label> <input type="text" name="nome"><br>
		<br> <label for="cpf">Cpf: </label> <input type="text" name="cpf"><br>
		<br> <label for="email">Email: </label> <input type="email"
			name="email"><br> <br> <label for="nome">Senha:
		</label> <input type="text" name="senha"><br> <br> 
		<label for="cidade">Cidade:</label> 
		
		<select name="cidade">
			<option value="Araraquara">Araraquara</option>
			<option value="São Carlos">São Carlos</option>
			<option value="Ibaté">Ibaté</option>
		</select
		><br><label
			for="foto">Foto:</label> <input type="file" name="foto"
			accept="image/png, image/jpeg"><br> <br> <input
			type="submit" value="Cadastrar">
	</form>
</body>
</html>