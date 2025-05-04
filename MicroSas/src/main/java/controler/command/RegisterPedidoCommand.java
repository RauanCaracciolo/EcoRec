package controler.command;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.connection.ConnectionFactory;
import model.dao.PedidoDAO;
import model.entity.Pedido;

public class RegisterPedidoCommand implements Command {
	PedidoDAO dao = new PedidoDAO();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cpfUsuario = request.getParameter("cpf_usuario");
        String descricao = request.getParameter("descricao");
        String horarioStr = request.getParameter("horario");

        try (Connection conn = ConnectionFactory.getConnection()) {
            LocalDateTime horario = LocalDateTime.parse(horarioStr);
            
            Pedido pedido = new Pedido(cpfUsuario, descricao, horario);
            dao.cadastrar(conn, pedido);
          //  response.sendRedirect("usuario/loginSucess.jsp"); // ou página de pedidos
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("erro.jsp");
        }

        return null;
	}

}
