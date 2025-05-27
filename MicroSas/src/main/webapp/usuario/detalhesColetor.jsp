<%@ page import="model.entity.Coletor, model.entity.Disponibilidade, java.util.List" %>
<%
    Coletor coletor = (Coletor) session.getAttribute("coletor");
    List<Disponibilidade> horarios = (List<Disponibilidade>) session.getAttribute("horarios");
%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Detalhes do Coletor</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
    <div class="container mt-5">
        <div class="card shadow card-container">
            <div class="card-body text-center">
                <h3 class="card-title title-text mb-4"><%= coletor.getNome() %></h3>
                <img src="<%= "../Imagens?nome=" + coletor.getImagem() %>" class="rounded mb-4" width="200" height="200" alt="Foto do coletor" />

                <h5 class="mb-3">Horários Disponíveis</h5>
                <% if (horarios != null && !horarios.isEmpty()) { %>
                    <ul class="list-group">
                        <% for (Disponibilidade d : horarios) { %>
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                <%= d.getHorario() %>
                                <form action="../FrontController" method="post" class="mb-0">
                                    <input type="hidden" name="command" value="SolicitarHorario">
                                    <input type="hidden" name="id_disponibilidade" value="<%= d.getId() %>">
                                    <button type="submit" class="btn btn-green">Solicitar</button>
                                </form>
                            </li>
                        <% } %>
                    </ul>
                <% } else { %>
                    <p class="text-muted">Nenhum horário disponível no momento.</p>
                <% } %>
            </div>
        </div>
    </div>
</body>
</html>
