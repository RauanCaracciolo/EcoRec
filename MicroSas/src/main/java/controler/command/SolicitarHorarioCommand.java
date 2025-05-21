package controler.command;

import java.io.IOException;
import java.sql.Connection;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.connection.ConnectionFactory;
import model.dao.DisponibilidadeDAO;
import model.dao.PedidoDAO;
import model.entity.Disponibilidade;
import model.entity.Pedido;

public class SolicitarHorarioCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idDisponibilidade = Integer.parseInt(request.getParameter("id_disponibilidade"));
        String emailUsuario = (String) request.getSession().getAttribute("email");

        try (Connection conn = ConnectionFactory.getConnection()) {
            DisponibilidadeDAO dDao = new DisponibilidadeDAO();
            PedidoDAO pDao = new PedidoDAO();

            Disponibilidade disp = dDao.getById(conn, idDisponibilidade);

            if (disp == null || !"livre".equals(disp.getEstado())) {
                request.setAttribute("erro", "Horário indisponível.");
                return "erro.jsp";
            }
            Pedido pedido = new Pedido(
                emailUsuario,
                disp.getCpfColetor(),
                "Solicitação de agendamento",
                disp.getHorario(),
                "solicitado"
            );
            pDao.cadastrar(conn, pedido);

            // Atualiza disponibilidade para "reservado"
            disp.setEstado("reservado");
            dDao.atualizar(conn, disp);

            response.sendRedirect("FrontController?command=VerColetor&cpf=" + disp.getCpfColetor());
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return "erro.jsp";
        }
    }
}
