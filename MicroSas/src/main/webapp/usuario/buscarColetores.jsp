<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.entity.Coletor"%>

<%
List<Coletor> coletores = (List<Coletor>) session.getAttribute("coletores");
String cidade = (String) session.getAttribute("cidade");
int paginaAtual = session.getAttribute("paginaAtual") != null ? (Integer) session.getAttribute("paginaAtual") : 1;
%>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Coletores em <%=(cidade != null ? cidade : "")%> -
	ReciclaFácil
</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="../css/styles.css">
</head>
<body>
	<div class="container mt-5 mb-5">
		<div class="card card-container">
			<h3 class="title-text mb-4 text-center">Buscar Coletores por
				Cidade</h3>

			<form class="row justify-content-center mb-4"
				action="../FrontController" method="get">
				<input type="hidden" name="command" value="GetColetoresByCidade">
				<div class="col-md-4">
					<select name="cidade" class="form-select" required>
						<option disabled selected value="">Selecione uma cidade</option>
						<option value="Araraquara"
							<%="Araraquara".equals(cidade) ? "selected" : ""%>>Araraquara</option>
						<option value="São Carlos"
							<%="São Carlos".equals(cidade) ? "selected" : ""%>>São
							Carlos</option>
						<option value="Ibaté"
							<%="Ibaté".equals(cidade) ? "selected" : ""%>>Ibaté</option>
					</select>
				</div>
				<div class="col-md-3 d-grid">
					<button type="submit" class="btn btn-success btn-lg">Buscar</button>
				</div>

			</form>

			<%
			if (cidade != null) {
			%>
			<h5 class="text-center title-text mb-4">
				Coletores em
				<%=cidade%></h5>
			<%
			}
			%>

			<%
			if (coletores != null && !coletores.isEmpty()) {
			%>
			<div class="row">
				<%
				for (Coletor c : coletores) {
				%>
				<div class="col-md-6 mb-4">
					<div class="card shadow-sm h-100">
						<div class="card-body text-center">
							<img src="../Imagens?nome=<%= c.getImagem() %>"

								class="rounded-circle mb-3" width="100" height="100"
								alt="Foto do coletor">
							<h5 class="card-title">
								<a
									href="../FrontController?command=VerColetor&cpf=<%=c.getCpf()%>"
									class="text-decoration-none text-success"> <%=c.getNome()%>
								</a>
							</h5>
							<p class="card-text"><%=c.getEmail()%></p>
						</div>
					</div>
				</div>
				<%
				}
				%>
			</div>
			<%
			} else if (cidade != null) {
			%>
			<div class="alert alert-warning text-center">Nenhum coletor
				encontrado.</div>
			<%
			}
			%>

			<!-- Paginação -->
			<div class="d-flex justify-content-center align-items-center mt-4">
				<form action="../FrontController" method="get" class="me-2">
					<input type="hidden" name="command" value="GetColetoresByCidade">
					<input type="hidden" name="cidade" value="<%=cidade%>"> <input
						type="hidden" name="pagina" value="<%=paginaAtual - 1%>">
					<%
					if (paginaAtual > 1) {
					%>
					<button type="submit" class="btn btn-outline-secondary">Anterior</button>
					<%
					}
					%>
				</form>

				<span class="mx-3">Página <%=paginaAtual%></span>

				<form action="../FrontController" method="get" class="ms-2">
					<input type="hidden" name="command" value="GetColetoresByCidade">
					<input type="hidden" name="cidade" value="<%=cidade%>"> <input
						type="hidden" name="pagina" value="<%=paginaAtual + 1%>">
					<%
					if (coletores != null && coletores.size() == 5) {
					%>
					<button type="submit" class="btn btn-outline-secondary">Próxima</button>
					<%
					}
					%>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
