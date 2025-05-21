<%@ page import="java.util.List, model.entity.Pedido" %>
<%
    List<Pedido> pedidos = (List<Pedido>) request.getAttribute("pedidos");
    String estado = (String) request.getAttribute("estado");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pedidos - <%= estado %></title>
</head>
<body>
    <h2>Pedidos - <%= estado %></h2>

    <form action="FrontController" method="get">
        <input type="hidden" name="command" value="ListarPedidos">
        <label for="estado">Filtrar por estado:</label>
        <select name="estado" onchange="this.form.submit()">
            <option value="solicitado" <%= "solicitado".equals(estado) ? "selected" : "" %>>Solicitado</option>
            <option value="confirmado" <%= "confirmado".equals(estado) ? "selected" : "" %>>Confirmado</option>
            <option value="finalizado" <%= "finalizado".equals(estado) ? "selected" : "" %>>Finalizado</option>
        </select>
    </form>

    <table border="1">
        <tr>
            <th>Usuário</th>
            <th>Descrição</th>
            <th>Horário</th>
        </tr>
        <% if (pedidos != null && !pedidos.isEmpty()) {
            for (Pedido p : pedidos) { %>
                <tr>
                    <td><%= p.getCpf_usuario() %></td>
                    <td><%= p.getDescricao() %></td>
                    <td><%= p.getHorario() %></td>
                </tr>
        <%  }} else { %>
            <tr><td colspan="3">Nenhum pedido encontrado.</td></tr>
        <% } %>
    </table>
</body>
</html>
