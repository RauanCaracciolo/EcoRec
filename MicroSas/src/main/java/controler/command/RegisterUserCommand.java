package controler.command;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.connection.ConnectionFactory;
import model.dao.UsuarioDAO;
import model.entity.Usuario;

public class RegisterUserCommand implements Command {
	UsuarioDAO dao = new UsuarioDAO();
	List<String> tiposPermitidos = Arrays.asList("image/png", "image/jpeg");

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		Part fotoPart = request.getPart("foto");
		String contentType = fotoPart.getContentType();
		if (!tiposPermitidos.contains(contentType)) {
			throw new ServletException("Tipo de arquivo inválido: " + contentType);
		}
		String imagem = UUID.randomUUID().toString() + "_"
				+ Paths.get(fotoPart.getSubmittedFileName()).getFileName().toString();
		String uploadPath = "/home/rauan/Desenvolvimento/Java/Imagens";
		Files.createDirectories(Paths.get(uploadPath));
		fotoPart.write(uploadPath + File.separator + imagem);
		String cep = request.getParameter("cep");
		String cidade = request.getParameter("cidade");
		String rua = request.getParameter("rua");
		String numero = request.getParameter("numero");
		Connection conn = null;
		try {
			conn = ConnectionFactory.getConnection();
			dao.cadastrar(conn, new Usuario(nome, cpf, email, senha, imagem, cep, cidade, rua, numero));
			conn.close();
			response.sendRedirect("index.jsp");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
