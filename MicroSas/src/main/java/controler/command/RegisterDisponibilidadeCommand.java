package controler.command;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.dao.DisponibilidadeDAO;
import model.entity.Disponibilidade;
import model.connection.ConnectionFactory;

public class RegisterDisponibilidadeCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cpf = request.getParameter("cpf_coletor");
        String horarioStr = request.getParameter("horario");

        try (Connection conn = ConnectionFactory.getConnection()) {
            LocalDateTime horario = LocalDateTime.parse(horarioStr);
            Disponibilidade d = new Disponibilidade(
            cpf,
            horario,
            "livre");

            DisponibilidadeDAO dao = new DisponibilidadeDAO();
            dao.cadastrar(conn, d);

            return "redirect:FrontController?command=GetMyDisponibilidades";
        } catch (Exception e) {
            e.printStackTrace();
            return "erro.jsp";
        }
    }
}
