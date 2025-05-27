<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Usuário - ReciclaFácil</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="container">
        <div class="form-container">
            <h3 class="text-center title-text">Cadastro de Usuário</h3>
            <form action="FrontController" method="post" enctype="multipart/form-data">
                <input type="hidden" name="command" value="RegisterUser">

                <div class="mb-3">
                    <label for="nome" class="form-label">Nome:</label>
                    <input type="text" name="nome" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label for="email" class="form-label">Email:</label>
                    <input type="email" name="email" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label for="senha" class="form-label">Senha:</label>
                    <input type="password" name="senha" class="form-control" required>
                </div>

                <h5 class="mt-4 title-text">Endereço</h5>

                <div class="mb-3">
                    <label for="cep" class="form-label">CEP:</label>
                    <input type="text" name="cep" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label for="cidade" class="form-label">Cidade:</label>
                    <select name="cidade" class="form-select" required>
                        <option value="Araraquara">Araraquara</option>
                        <option value="São Carlos">São Carlos</option>
                        <option value="Ibaté">Ibaté</option>
                    </select>
                </div>

                <div class="mb-3">
                    <label for="rua" class="form-label">Rua:</label>
                    <input type="text" name="rua" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label for="numero" class="form-label">Número:</label>
                    <input type="text" name="numero" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label for="foto" class="form-label">Foto:</label>
                    <input type="file" name="foto" class="form-control" accept="image/png, image/jpeg" required>
                </div>

                <div class="d-grid">
                    <button type="submit" class="btn btn-green">Cadastrar</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
