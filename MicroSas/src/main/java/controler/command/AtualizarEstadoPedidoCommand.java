package controler.command;

import java.io.IOException;
import java.sql.Connection;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.connection.ConnectionFactory;
import model.dao.PedidoDAO;
import model.dao.DisponibilidadeDAO;
import model.entity.Pedido;
import model.entity.Disponibilidade;

public class AtualizarEstadoPedidoCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idPedido = Integer.parseInt(request.getParameter("id"));
        String novoEstado = request.getParameter("novo_estado");

        try (Connection conn = ConnectionFactory.getConnection()) {
            PedidoDAO pDao = new PedidoDAO();
            Pedido pedido = pDao.getById(conn, idPedido);

            if (pedido == null) {
                request.setAttribute("erro", "Pedido não encontrado.");
                return "erro.jsp";
            }

            if ("cancelado".equals(novoEstado)) {
                DisponibilidadeDAO dDao = new DisponibilidadeDAO();
                Disponibilidade disp = dDao.getById(conn, pedido.getId_dispo());
                if (disp != null) {
                    disp.setEstado("livre");
                    dDao.atualizar(conn, disp);
                }
            }

            pedido.setEstado(novoEstado);
            pDao.atualizar(conn, pedido);

            return "redirect:FrontController?command=GetPedidos";
        } catch (Exception e) {
            e.printStackTrace();
            return "erro.jsp";
        }
    }
}
