package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.entity.Coletor;
import model.entity.Usuario;

public class UsuarioDAO {
	public void cadastrar(Connection conn, Usuario u) {
        String sql = "insert into usuarios (nome, email, senha,  imagem, cep, cidade, rua, numero) values (?, ?, ?, ?, ?, ?, ?, ?)";	

        try{
        	PreparedStatement smt = conn.prepareStatement(sql);
        	smt.setString(1, u.getNome());
        	smt.setString(2, u.getEmail());
        	smt.setString(3, u.getSenha());
        	smt.setString(4, u.getImagem());
        	smt.setString(5, u.getCep());
        	smt.setString(6, u.getCidade());
        	smt.setString(7, u.getRua());
        	smt.setString(8, u.getNumero());
        	smt.execute();
        }catch(Exception ex) {
        	ex.printStackTrace();
        }
	}
	public Usuario getByEmail(Connection conn, String email) {
		Usuario usuario = null;
		String sql = "select * from usuarios where email = ?";
		if(email != null && !email.isEmpty()) {
			try {
				PreparedStatement smt = conn.prepareStatement(sql);
				smt.setString(1, email);
				ResultSet result = smt.executeQuery();
				
				if(result.next()) {
					usuario = new Usuario(
							result.getString("nome"),
							result.getString("email"),
							result.getString("senha"),
							result.getString("imagem"),
							result.getString("cep"),
							result.getString("cidade"),
							result.getString("rua"),
							result.getString("numero")
						);
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}
		return usuario;
	}
	public Usuario validarLogin(Connection conn, String email, String senha) {
		Usuario u = getByEmail(conn, email);
		if(u != null) {
			
			if (u.getSenha().equals(senha)) {
				return u;
			} else {
			}
		}
		return null;
	}
}
