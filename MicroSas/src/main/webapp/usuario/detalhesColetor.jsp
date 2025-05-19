<%@ page import="model.entity.Coletor, model.entity.Disponibilidade, java.util.List" %>
<%
    Coletor coletor = (Coletor) request.getAttribute("coletor");
    List<Disponibilidade> horarios = (List<Disponibilidade>) request.getAttribute("horarios");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalhes do Coletor</title>
</head>
<body>
    <h2><%= coletor.getNome() %></h2>
    <img src="<%= "Imagens/" + coletor.getImagem() %>" width="200" height="200" />

    <h3>Horários Disponíveis</h3>
    <ul>
    <% for (Disponibilidade d : horarios) { %>
        <li>
            <%= d.getHorario() %> -
            <form action="FrontController" method="post" style="display:inline;">
                <input type="hidden" name="command" value="SolicitarHorario">
                <input type="hidden" name="id_disponibilidade" value="<%= d.getId() %>">
                <input type="submit" value="Solicitar">
            </form>
        </li>
    <% } %>
    </ul>
</body>
</html>
