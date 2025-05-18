package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
	public List<Pedido> getAllPendentes(Connection conn){
		List<Pedido> pedidos = new ArrayList<>();
		String sql = "select * from pedidos where estado = 'pendente' ";
		try {PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
            Pedido p = new Pedido(
                rs.getInt("id"),
                rs.getString("cpf_usuario"),
                rs.getString("descricao"),
                rs.getTimestamp("horario").toLocalDateTime(),
                rs.getString("estado")
            );
            pedidos.add(p);
        }
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return pedidos;
	}
	public List<Pedido> getPendenteByCidade(Connection conn, String cidade){
		List<Pedido> pedidos = new ArrayList<>();
		String sql = "select * from pedidos where estado = 'pendente' ";
		try {PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
            Pedido p = new Pedido(
                rs.getInt("id"),
                rs.getString("cpf_usuario"),
                rs.getString("descricao"),
                rs.getTimestamp("horario").toLocalDateTime(),
                rs.getString("estado")
            );
            pedidos.add(p);
        }
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return pedidos;
	}
}
