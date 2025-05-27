<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="model.entity.Coletor" %>
<%
    Coletor coletor = (Coletor) session.getAttribute("coletorLogado");
%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Dashboard - Coletor</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
    <div class="container mt-5">
        <div class="card shadow text-center">
            <div class="card-body">
                <h3 class="card-title mb-4">Olá, <%= coletor.getNome() %>!</h3>
                <a href="disponibilidades.jsp" class="btn btn-green me-2">Gerenciar Disponibilidades</a>
                <a href="../FrontController?command=Logout" class="btn btn-outline-danger">Sair</a>
            </div>
        </div>
    </div>
</body>
</html>
