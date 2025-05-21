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
		String sql = "insert into pedidos (email_usuario, descricao, horario, estado) values (?, ?, ?, ?)";
	    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	    	stmt.setString(1, p.getEmail_usuario());
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
                rs.getString("email_usuario"),
                rs.getString("cpf_coletor"),
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
                rs.getString("email_usuario"),
                rs.getString("cpf_coletor"),
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
	public List<Pedido> listarPorColetorEEstado(Connection conn, String cpfColetor, String estado) {
	    List<Pedido> pedidos = new ArrayList<>();
	    String sql = "select * from pedidos where cpf_coletor = ? and estado = ?";
	    
	    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, cpfColetor);
	        stmt.setString(2, estado);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            pedidos.add(new Pedido(
	                rs.getInt("id"),
	                rs.getString("email_usuario"),
	                rs.getString("cpf_coletor"),
	                rs.getString("descricao"),
	                rs.getTimestamp("horario").toLocalDateTime(),
	                rs.getString("estado")
	            ));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return pedidos;
	}

}
