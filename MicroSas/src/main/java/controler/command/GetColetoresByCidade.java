package controler.command;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.connection.ConnectionFactory;
import model.dao.ColetorDAO;
import model.entity.Coletor;

public class GetColetoresByCidade implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cidade = request.getParameter("cidade");

        try (Connection conn = ConnectionFactory.getConnection()) {
            ColetorDAO dao = new ColetorDAO();
            List<Coletor> lista = dao.getColetorByCidade(conn, cidade);
            request.getSession().setAttribute("coletores", lista);
            request.getSession().setAttribute("cidade", cidade);
            return "redirect:" + request.getContextPath() + "/usuario/buscarColetores.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:" + request.getContextPath() + "/erro.jsp";
        }
    }
}
