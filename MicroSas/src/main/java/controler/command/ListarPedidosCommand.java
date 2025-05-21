package controler.command;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.connection.ConnectionFactory;
import model.dao.PedidoDAO;
import model.entity.Pedido;

public class ListarPedidosCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cpf = (String) request.getSession().getAttribute("cpf");
        String estado = request.getParameter("estado");

        try (Connection conn = ConnectionFactory.getConnection()) {
            PedidoDAO dao = new PedidoDAO();
            List<Pedido> pedidos = dao.listarPorColetorEEstado(conn, cpf, estado);

            request.setAttribute("estado", estado);
            request.setAttribute("pedidos", pedidos);
            return "coletor/pedidos.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            return "erro.jsp";
        }
    }
}
