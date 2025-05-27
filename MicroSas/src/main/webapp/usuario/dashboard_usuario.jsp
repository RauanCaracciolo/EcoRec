<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="model.entity.Usuario" %>
<%
    Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Dashboard - Usuário</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
    <div class="container mt-5">
        <div class="card shadow text-center">
            <div class="card-body">
                <h3 class="card-title mb-4">Bem-vindo, <%= usuarioLogado.getNome() %>!</h3>
                <a href="buscarColetores.jsp" class="btn btn-green me-2">Buscar Coletores</a>
                <a href="../FrontController?command=Logout" class="btn btn-outline-danger">Sair</a>
            </div>
        </div>
    </div>
</body>
</html>
