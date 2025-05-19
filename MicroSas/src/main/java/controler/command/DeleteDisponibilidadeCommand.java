package controler.command;

import java.io.IOException;
import java.sql.Connection;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.dao.DisponibilidadeDAO;
import model.connection.ConnectionFactory;

public class DeleteDisponibilidadeCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try (Connection conn = ConnectionFactory.getConnection()) {
            DisponibilidadeDAO dao = new DisponibilidadeDAO();
            dao.remover(conn, id);

            return "redirect:FrontController?command=GetMyDisponibilidades";
        } catch (Exception e) {
            e.printStackTrace();
            return "erro.jsp";
        }
    }
}
