package controler.command;

import java.io.IOException;
import java.sql.Connection;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.connection.ConnectionFactory;
import model.dao.ColetorDAO;
import model.dao.UsuarioDAO;
import model.entity.Coletor;
import model.entity.Usuario;

public class LoginCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cpf = request.getParameter("key");
		String senha = request.getParameter("senha");
		String tipo = request.getParameter("tipo");
		System.out.println(cpf + senha);
		if(tipo.equals("coletor")) {
			ColetorDAO dao = new ColetorDAO();
			System.out.println("Entrou no Coletor");
			try {
				Connection conn = ConnectionFactory.getConnection();
				Coletor c = dao.validarLogin(conn, cpf, senha);
				if(c != null) {
					HttpSession session = request.getSession();
					session.setAttribute("coletorLogado", c);
					session.setAttribute("mensagem", "Bem vindo coletor!");
					System.out.println("Entrou no LoginColetor");
					conn.close();
					return "redirect:coletor/dashboard_coletor.jsp";
				}else {
					conn.close();
					return "redirect:index.jsp";
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}else if(tipo.equals("usuario")) {
			UsuarioDAO dao = new UsuarioDAO();
			System.out.println("Entrou no usuario");
			try {
				Connection conn = ConnectionFactory.getConnection();
				Usuario u = dao.validarLogin(conn, cpf, senha);
				if(u != null) {				
					System.out.println(u.getEmail());
					HttpSession session = request.getSession();
					session.setAttribute("usuarioLogado", u);
					session.setAttribute("mensagem", "Bem vindo Usuario!");
					System.out.println("Entrou no LoginUsuario");
					conn.close();
					return "redirect:usuario/dashboard_usuario.jsp";
				}else{
					conn.close();
					return "redirect:index.jsp";
			
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}else {
			System.out.println("Erro");
		}
		return null;
	}

}
