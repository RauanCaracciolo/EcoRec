package controler.command;

import java.io.IOException;
import java.sql.Connection;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.connection.ConnectionFactory;
import model.dao.UsuarioDAO;
import model.entity.Usuario;

public class RegisterUserCommand implements Command {
	UsuarioDAO dao = new UsuarioDAO();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String imagem = request.getParameter("imagem");
		String cep = request.getParameter("cep");
		String cidade = request.getParameter("cidade");
		String rua = request.getParameter("rua");
		String numero = request.getParameter("numero");
		Connection conn = null;
		try {
			conn = ConnectionFactory.getConnection();
			dao.cadastrar(conn, new Usuario(nome, email, senha, imagem, cep, cidade, rua, numero));
			conn.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
