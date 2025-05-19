<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.entity.Disponibilidade"%>
<%@ page import="model.entity.Coletor"%>

<%
Coletor coletor = (Coletor) session.getAttribute("coletorLogado");
List<Disponibilidade> disponibilidades = (List<Disponibilidade>) session.getAttribute("disponibilidades");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Minhas Disponibilidades</title>
</head>
<body>
	<h2>Minhas Disponibilidades</h2>

	<p>
		Bem-vindo,
		<%=coletor.getNome()%>!
	</p>

	<h3>Adicionar nova disponibilidade</h3>
	<form action="../FrontController" method="post">
		<input type="hidden" name="command" value="RegisterDisponibilidade">
		<input type="hidden" name="cpf_coletor"
			value="<%=coletor.getCpf()%>"> <label for="horario">Horário
			(yyyy-MM-ddTHH:mm):</label> <input type="datetime-local" name="horario"
			required> <input type="submit" value="Adicionar">
	</form>

	<h3>Lista de Horários Cadastrados</h3>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Horário</th>
			<th>Estado</th>
			<th>Ação</th>
		</tr>
		<%
		if (disponibilidades != null && !disponibilidades.isEmpty()) {
			for (Disponibilidade d : disponibilidades) {
		%>
		<tr>
			<td><%=d.getId()%></td>
			<td><%=d.getHorario()%></td>
			<td><%=d.getEstado()%></td>
			<td>
				<form action="../FrontController" method="post"
					style="display: inline;">
					<input type="hidden" name="command" value="DeleteDisponibilidade">
					<input type="hidden" name="id" value="<%=d.getId()%>"> <input
						type="submit" value="Remover">
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
	</table>
	<form action="../FrontController" method="get">
		<input type="hidden" name="command" value="GetMyDisponibilidades">
		<input type="submit" value="Carregar Minhas Disponibilidades">
	</form>
</body>
</html>
