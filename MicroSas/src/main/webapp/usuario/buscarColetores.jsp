<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.entity.Coletor"%>

<%
List<Coletor> coletores = (List<Coletor>) session.getAttribute("coletores");
String cidade = (String) session.getAttribute("cidade");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Coletores de <%=(cidade != null ? cidade : "")%></title>
</head>
<body>
	<h2>Coletores por Cidade</h2>

	<form action="../FrontController" method="get">
		<input type="hidden" name="command" value="GetColetoresByCidade">
		<label for="cidade">Cidade:</label> <select name="cidade" id="cidade">
			<option value="Araraquara"
				<%="Araraquara".equals(cidade) ? "selected" : ""%>>Araraquara</option>
			<option value="São Carlos"
				<%="São Carlos".equals(cidade) ? "selected" : ""%>>São
				Carlos</option>
			<option value="Ibaté" <%="Ibaté".equals(cidade) ? "selected" : ""%>>Ibaté</option>
		</select> <input type="submit" value="Buscar">
	</form>


	<h3>
		Coletores em
		<%=cidade%></h3>
	<table border="1">
		<tr>
			<th>Nome</th>
			<th>Email</th>
			<th>Imagem</th>
		</tr>
		<%
		if (coletores != null && !coletores.isEmpty()) {
			for (Coletor c : coletores) {
		%>
		<tr>
			<td><a
				href="../FrontController?command=VerColetor&cpf=<%=c.getCpf()%>">
					<%=c.getNome()%>
			</a></td>
			<td><%=c.getEmail()%></td>
			<td><img src="<%=c.getImagem()%>" width="100"></td>
		</tr>
		<%
		}
		} else {
		%>
		<tr>
			<td colspan="3">Nenhum coletor encontrado.</td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>
