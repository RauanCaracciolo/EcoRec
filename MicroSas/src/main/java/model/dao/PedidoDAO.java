package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

import model.entity.Pedido;

public class PedidoDAO {
	public void cadastrar(Connection conn, Pedido p) {
		String sql = "insert into pedidos (cpf_usuario, descricao, horario, estado) values (?, ?, ?, ?)";
	    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, p.getCpf_usuario());
	        stmt.setString(2, p.getDescricao());
	        stmt.setTimestamp(3, Timestamp.valueOf(p.getHorario()));
	        stmt.setString(4, p.getEstado());
	        stmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
