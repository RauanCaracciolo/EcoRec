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
import model.entity.Coletor;

public class GetColetoresByCidade implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String cidade = request.getParameter("cidade");
        int pagina = 1;

        String pagParam = request.getParameter("pagina");
        if (pagParam != null) {
            try {
                pagina = Integer.parseInt(pagParam);
            } catch (NumberFormatException e) {
                pagina = 1;
            }
        }

        try (Connection conn = ConnectionFactory.getConnection()) {
            ColetorDAO dao = new ColetorDAO();
            List<Coletor> lista = dao.getColetorByCidade(conn, cidade, pagina);

            session.setAttribute("coletores", lista);
            session.setAttribute("cidade", cidade);
            session.setAttribute("paginaAtual", pagina);
            
            response.sendRedirect("usuario/buscarColetores.jsp");
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return "erro.jsp";
        }
    }
}
