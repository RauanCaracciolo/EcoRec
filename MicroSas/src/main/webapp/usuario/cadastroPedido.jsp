<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="model.entity.Usuario" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastrar Pedido</title>
</head>
<body>
    <h2>Fazer novo pedido</h2>
    
    <%
        Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
        String cpfUsuario = (usuarioLogado != null) ? usuarioLogado.getCpf() : "";
    %>

    <p>CPF do usuário logado: <%= cpfUsuario %></p>

    <form action="../FrontController" method="post">
        <input type="hidden" name="command" value="RegisterPedido">
        <input type="hidden" name="cpf_usuario" value="<%= cpfUsuario %>">
        
        <label>Descrição:</label><br>
        <textarea name="descricao" rows="4" cols="50" required></textarea><br><br>
        
        <label>Data e Hora para buscar (formato: yyyy-MM-ddTHH:mm):</label><br>
        <input type="datetime-local" name="horario" required><br><br>
        
        <input type="submit" value="Cadastrar Pedido">
    </form>
</body>
</html>
