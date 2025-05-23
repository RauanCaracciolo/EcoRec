package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.entity.Disponibilidade;

public class DisponibilidadeDAO {
	public void cadastrar(Connection conn, Disponibilidade d) {
        String sql = "insert into disponibilidades (cpf_coletor, horario, estado) values (?, ?, ?)";	
        try {
        	PreparedStatement stmt = conn.prepareStatement(sql);
        	stmt.setString(1, d.getCpfColetor());
        	stmt.setTimestamp(2, Timestamp.valueOf(d.getHorario()));
        	stmt.setString(3, d.getEstado());
        	stmt.executeUpdate();
        }catch(Exception ex) {
        	ex.printStackTrace();
        }
	}
	public List<Disponibilidade> listarPorColetor(Connection conn, String cpfColetor){
		List<Disponibilidade> lista = new ArrayList<>();
		String sql = "select * from disponibilidades where cpf_coletor = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, cpfColetor);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				lista.add(new Disponibilidade(
						rs.getInt("id"),
						rs.getString("cpf_coletor"),
						rs.getTimestamp("horario").toLocalDateTime(),
						rs.getString("estado")));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return lista;
	}
	public List<Disponibilidade> listarLivresPorColetor(Connection conn, String cpfColetor) {
	    List<Disponibilidade> lista = new ArrayList<>();
	    String sql = "select * from disponibilidades where cpf_coletor = ? and estado = 'livre' order by horario";

	    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, cpfColetor);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            Disponibilidade d = new Disponibilidade(
	                rs.getInt("id"),
	                rs.getString("cpf_coletor"),
	                rs.getTimestamp("horario").toLocalDateTime(),
	                rs.getString("estado")
	            );
	            lista.add(d);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return lista;
	}
	public void remover(Connection conn, int id) {
	    String sql = "delete from disponibilidades where id = ?";
	    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, id);
	        stmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public Disponibilidade getById(Connection conn, int id) {
	    String sql = "select * from disponibilidades where id = ?";
	    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, id);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            return new Disponibilidade(
	                rs.getInt("id"),
	                rs.getString("cpf_coletor"),
	                rs.getTimestamp("horario").toLocalDateTime(),
	                rs.getString("estado")
	            );
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	public void atualizar(Connection conn, Disponibilidade d) {
	    String sql = "update disponibilidades set estado = ? where id = ?";
	    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, d.getEstado());
	        stmt.setInt(2, d.getId());
	        stmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


}
