package controler.command;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.connection.ConnectionFactory;
import model.dao.PedidoDAO;
import model.entity.Coletor;
import model.entity.Pedido;

public class GetPedidosCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Coletor coletorLogado = (Coletor) request.getSession().getAttribute("coletorLogado");

        if (coletorLogado == null) {
            return "index.jsp"; // Redireciona para login, se não estiver logado
        }
        try {
        	Connection conn =  ConnectionFactory.getConnection();
            PedidoDAO dao = new PedidoDAO();
			HttpSession session = request.getSession();

            List<Pedido> pedidosSolicitados = dao.listarPorColetorEEstado(conn, "solicitado", coletorLogado.getCpf());
            List<Pedido> pedidosAceitos = dao.listarPorColetorEEstado(conn, "aceito", coletorLogado.getCpf());
            List<Pedido> pedidosConcluidos = dao.listarPorColetorEEstado(conn, "concluido", coletorLogado.getCpf());
            System.out.println("Solicitados: " + pedidosSolicitados.size());
            System.out.println("Aceitos: " + pedidosAceitos.size());
            System.out.println("Concluidos: " + pedidosConcluidos.size());
            session.setAttribute("pedidosSolicitados", pedidosSolicitados);
            session.setAttribute("pedidosAceitos", pedidosAceitos);
            session.setAttribute("pedidosConcluidos", pedidosConcluidos);
        }catch(Exception ex) {
        	ex.printStackTrace();
        }
        return "redirect:coletor/log.jsp";
    }
}
