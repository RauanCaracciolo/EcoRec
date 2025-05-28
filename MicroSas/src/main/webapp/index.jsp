<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
       <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="container">
        <div class="form-container">
            <h3 class="text-center title-text">Login - ReciclaFácil</h3>
            <form action="FrontController" method="post">
                <input type="hidden" name="command" value="Login">
                <div class="mb-3">
                    <label for="key" class="form-label">CPF (Coletor) ou Email (Usuário)</label>
                    <input type="text" name="key" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label for="senha" class="form-label">Senha</label>
                    <input type="password" name="senha" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label for="tipo" class="form-label">Tipo de Conta</label>
                    <select name="tipo" class="form-select" required>
                        <option value="usuario">Usuário</option>
                        <option value="coletor">Coletor</option>
                    </select>
                </div>
                <div class="d-grid">
                    <button type="submit" class="btn btn-green">Entrar</button>
                </div>
            </form>
            <div class="text-center mt-3">
                <a href="escolhaCadastro.html" class="btn btn-outline-success">Não possui conta? Cadastre-se</a>
            </div>
        </div>
    </div>
</body>
</html>
