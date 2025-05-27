package controler.command;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.connection.ConnectionFactory;
import model.dao.ColetorDAO;
import model.dao.DisponibilidadeDAO;
import model.entity.Coletor;
import model.entity.Disponibilidade;

public class VerColetorCommand implements Command {

	@Override
	 public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String cpf = request.getParameter("cpf");
	        HttpSession session = request.getSession();
	        try (Connection conn = ConnectionFactory.getConnection()) {
	            ColetorDAO coletorDAO = new ColetorDAO();
	            DisponibilidadeDAO disponibilidadeDAO = new DisponibilidadeDAO();

	            Coletor coletor = coletorDAO.getByCpf(conn, cpf);
	            List<Disponibilidade> livres = disponibilidadeDAO.listarLivresPorColetor(conn, cpf);

	            session.setAttribute("coletor", coletor);
	            session.setAttribute("horarios", livres);
	            conn.close();
	            return "redirect:usuario/detalhesColetor.jsp";
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "erro.jsp";
	        }
	    }
	}