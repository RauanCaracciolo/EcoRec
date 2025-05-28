<%@ page import="java.util.List" %>
<%@ page import="model.entity.Pedido" %>
<%@ page import="model.entity.Coletor" %>

<%
    Coletor coletorLogado = (Coletor) session.getAttribute("coletorLogado");
    List<Pedido> pedidosSolicitados = (List<Pedido>) session.getAttribute("pedidosSolicitados");
    List<Pedido> pedidosAceitos = (List<Pedido>) session.getAttribute("pedidosAceitos");
    List<Pedido> pedidosConcluidos = (List<Pedido>) session.getAttribute("pedidosConcluidos");
%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Log de Pedidos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
    <div class="container mt-5">
        <div class="card shadow">
            <div class="card-body">
                <h3 class="text-center mb-4">Log de Pedidos - <%= coletorLogado.getNome() %></h3>

                <h5>Pedidos Solicitados</h5>
                <% if (pedidosSolicitados != null && !pedidosSolicitados.isEmpty()) { %>
                    <table class="table table-bordered table-striped mb-4">
                        <thead>
                            <tr>
                                <th>Descrição</th>
                                <th>Horário</th>
                                <th>Ações</th>
                            </tr>
                        </thead>
                        <tbody>
                        <% for (Pedido p : pedidosSolicitados) { %>
                            <tr>
                                <td><%= p.getDescricao() %></td>
                                <td><%= p.getHorario() %></td>
                                <td>
                                    <form action="../FrontController?AtualizarEstadoPedido" method="post" class="d-inline">
                                        <input type="hidden" name="command" value="AtualizarEstadoPedido">
                                        <input type="hidden" name="id" value="<%= p.getId() %>">
                                        <input type="hidden" name="novo_estado" value="aceito">
                                        <button type="submit" class="btn btn-success btn-sm">Aceitar</button>
                                    </form>
                                    <form action="../FrontController" method="post" class="d-inline">
                                        <input type="hidden" name="command" value="AtualizarEstadoPedido">
                                        <input type="hidden" name="id" value="<%= p.getId() %>">
                                        <input type="hidden" name="novo_estado" value="cancelado">
                                        <button type="submit" class="btn btn-danger btn-sm">Cancelar</button>
                                    </form>
                                </td>
                            </tr>
                        <% } %>
                        </tbody>
                    </table>
                <% } else { %>
                    <p class="text-muted">Nenhum pedido solicitado encontrado.</p>
                <% } %>

                <h5>Pedidos Aceitos</h5>
                <% if (pedidosAceitos != null && !pedidosAceitos.isEmpty()) { %>
                    <table class="table table-bordered table-striped mb-4">
                        <thead>
                            <tr>
                                <th>Descrição</th>
                                <th>Horário</th>
                                <th>Ações</th>
                            </tr>
                        </thead>
                        <tbody>
                        <% for (Pedido p : pedidosAceitos) { %>
                            <tr>
                                <td><%= p.getDescricao() %></td>
                                <td><%= p.getHorario() %></td>
                                <td>
                                    <form action="../FrontController?command=AtualizarEstadoPedido" method="post" class="d-inline">                         
                                        <input type="hidden" name="id" value="<%= p.getId() %>">
                                        <input type="hidden" name="novo_estado" value="concluido">
                                        <button type="submit" class="btn btn-primary btn-sm">Concluir</button>
                                    </form>
                                    <form action="../FrontController?command=AtualizarEstadoPedido" method="post" class="d-inline">
                                        <input type="hidden" name="command" value="AtualizarEstadoPedido">
                                        <input type="hidden" name="id" value="<%= p.getId() %>">
                                        <input type="hidden" name="novo_estado" value="cancelado">
                                        <button type="submit" class="btn btn-danger btn-sm">Cancelar</button>
                                    </form>
                                </td>
                            </tr>
                        <% } %>
                        </tbody>
                    </table>
                <% } else { %>
                    <p class="text-muted">Nenhum pedido aceito encontrado.</p>
                <% } %>

                <h5>Pedidos Concluídos</h5>
                <% if (pedidosConcluidos != null && !pedidosConcluidos.isEmpty()) { %>
                    <table class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th>Descrição</th>
                                <th>Horário</th>
                            </tr>
                        </thead>
                        <tbody>
                        <% for (Pedido p : pedidosConcluidos) { %>
                            <tr>
                                <td><%= p.getDescricao() %></td>
                                <td><%= p.getHorario() %></td>
                            </tr>
                        <% } %>
                        </tbody>
                    </table>
                <% } else { %>
                    <p class="text-muted">Nenhum pedido concluído encontrado.</p>
                <% } %>
            </div>
        </div>
    </div>
</body>
</html>
