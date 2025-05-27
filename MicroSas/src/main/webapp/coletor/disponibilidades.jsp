<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.Disponibilidade" %>
<%@ page import="model.entity.Coletor" %>

<%
Coletor coletor = (Coletor) session.getAttribute("coletorLogado");
List<Disponibilidade> disponibilidades = (List<Disponibilidade>) session.getAttribute("disponibilidades");
%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Minhas Disponibilidades - ReciclaFácil</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
    <div class="container d-flex justify-content-center mt-5 mb-5">
        <div class="card card-container w-100" style="max-width: 800px;">
            <h3 class="title-text mb-4">Minhas Disponibilidades</h3>

            <p class="text-center">Bem-vindo, <strong><%=coletor.getNome()%></strong>!</p>

            <div class="mb-4">
                <h5 class="title-text">Adicionar nova disponibilidade</h5>
                <form action="../FrontController" method="post" class="row g-3 justify-content-center">
                    <input type="hidden" name="command" value="RegisterDisponibilidade">
                    <input type="hidden" name="cpf_coletor" value="<%=coletor.getCpf()%>">

                    <div class="col-md-6">
                        <input type="datetime-local" name="horario" class="form-control" required>
                    </div>
                    <div class="col-auto">
                        <button type="submit" class="btn btn-green">Adicionar</button>
                    </div>
                </form>
            </div>

            <h5 class="title-text mb-3">Lista de Horários Cadastrados</h5>
            <div class="table-responsive">
                <table class="table table-bordered table-striped text-center align-middle shadow-sm">
                    <thead class="table-success">
                        <tr>
                            <th>ID</th>
                            <th>Horário</th>
                            <th>Estado</th>
                            <th>Ação</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                        if (disponibilidades != null && !disponibilidades.isEmpty()) {
                            for (Disponibilidade d : disponibilidades) {
                        %>
                        <tr>
                            <td><%=d.getId()%></td>
                            <td><%=d.getHorario()%></td>
                            <td><%=d.getEstado()%></td>
                            <td>
                                <form action="../FrontController" method="post">
                                    <input type="hidden" name="command" value="DeleteDisponibilidade">
                                    <input type="hidden" name="id" value="<%=d.getId()%>">
                                    <button type="submit" class="btn btn-outline-danger btn-sm">Remover</button>
                                </form>
                            </td>
                        </tr>
                        <%
                            }
                        } else {
                        %>
                        <tr>
                            <td colspan="4">Nenhuma disponibilidade cadastrada.</td>
                        </tr>
                        <%
                        }
                        %>
                    </tbody>
                </table>
            </div>

            <form action="../FrontController" method="get" class="text-center mt-4">
                <input type="hidden" name="command" value="GetMyDisponibilidades">
                <button type="submit" class="btn btn-outline-success">Recarregar Disponibilidades</button>
            </form>
        </div>
    </div>
</body>
</html>
