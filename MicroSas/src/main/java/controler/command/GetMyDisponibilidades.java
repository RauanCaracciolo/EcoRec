package controler.command;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.connection.ConnectionFactory;
import model.dao.DisponibilidadeDAO;
import model.entity.Coletor;
import model.entity.Disponibilidade;

public class GetMyDisponibilidades implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Coletor coletor = (Coletor) request.getSession().getAttribute("coletorLogado");

        if (coletor != null) {
            try (Connection conn = ConnectionFactory.getConnection()) {
                DisponibilidadeDAO dao = new DisponibilidadeDAO();
                List<Disponibilidade> lista = dao.listarPorColetor(conn, coletor.getCpf());
                request.getSession().setAttribute("disponibilidades", lista);
                return "redirect:coletor/disponibilidades.jsp";
            } catch (Exception e) {
                e.printStackTrace();
                return "redirect:erro.jsp";
            }
        } else {
            return "redirect:index.jsp";
        }
    }
}
