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
import model.entity.Usuario;

public class SolicitarHorarioCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idDisponibilidade = Integer.parseInt(request.getParameter("id_disponibilidade"));
        Usuario u = (Usuario) request.getSession().getAttribute("usuarioLogado");
        String email = u.getEmail();

        try (Connection conn = ConnectionFactory.getConnection()) {
            conn.setAutoCommit(false);

            DisponibilidadeDAO dDao = new DisponibilidadeDAO();
            PedidoDAO pDao = new PedidoDAO();

            Disponibilidade disp = dDao.getById(conn, idDisponibilidade);

            if (disp == null || !"livre".equals(disp.getEstado())) {
                request.setAttribute("erro", "Horário indisponível.");
                return "erro.jsp";
            }

            Pedido pedido = new Pedido(
                idDisponibilidade,
                email,
                disp.getCpfColetor(),
                "Solicitação de agendamento",
                disp.getHorario(),
                "solicitado"
            );
            pDao.cadastrar(conn, pedido);
            disp.setEstado("reservado");
            dDao.atualizar(conn, disp);
            conn.commit();
            response.sendRedirect("FrontController?command=VerColetor&cpf=" + disp.getCpfColetor());
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            try (Connection conn = ConnectionFactory.getConnection()) {
                conn.rollback();
            } catch (Exception rollbackEx) {
                rollbackEx.printStackTrace();
            }
            return "erro.jsp";
        }
    }
}
