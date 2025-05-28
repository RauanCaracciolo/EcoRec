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
                                <button type="button" class="btn btn-green" onclick="abrirModal(<%= d.getId() %>)">Solicitar</button>
                            </li>
                        <% } %>
                    </ul>
                <% } else { %>
                    <p class="text-muted">Nenhum horário disponível no momento.</p>
                <% } %>
            </div>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="descricaoModal" tabindex="-1" aria-labelledby="descricaoModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <form id="formDescricao" action="../FrontController" method="post">
          <input type="hidden" name="command" value="SolicitarHorario">
          <input type="hidden" name="id_disponibilidade" id="inputDisponibilidadeId">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="descricaoModalLabel">Descreva seu pedido</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Fechar"></button>
            </div>
            <div class="modal-body">
              <div class="mb-3">
                <label for="descricao" class="form-label">Descrição</label>
                <textarea class="form-control" name="descricao" id="descricao" required></textarea>
              </div>
            </div>
            <div class="modal-footer">
              <button type="submit" class="btn btn-primary">Enviar</button>
            </div>
          </div>
        </form>
      </div>
    </div>

    <!-- Scripts -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script>
      function abrirModal(idDisponibilidade) {
          document.getElementById('inputDisponibilidadeId').value = idDisponibilidade;
          const modal = new bootstrap.Modal(document.getElementById('descricaoModal'));
          modal.show();
      }
    </script>
</body>
</html>
