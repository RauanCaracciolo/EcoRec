package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.entity.Usuario;

public class UsuarioDAO {
	public void cadastrar(Connection conn, Usuario u) {
        String sql = "insert into usuarios (nome, cpf, email, senha,  imagem, cep, cidade, rua, numero) values (?, ?,  ?, ?, ?, ?, ?, ?, ?)";	

        try{
        	PreparedStatement smt = conn.prepareStatement(sql);
        	smt.setString(1, u.getNome());
        	smt.setString(2, u.getCpf());
        	smt.setString(3, u.getEmail());
        	smt.setString(4, u.getSenha());
        	smt.setString(5, u.getImagem());
        	smt.setString(6, u.getCep());
        	smt.setString(7, u.getCidade());
        	smt.setString(8, u.getRua());
        	smt.setString(9, u.getNumero());
        	smt.execute();
        }catch(Exception ex) {
        	ex.printStackTrace();
        }
	}
	public Usuario getByCpf(Connection conn, String cpf) {
		Usuario usuario = null;
		String sql = "select * from usuarios where cpf = ?";
		if(!cpf.isEmpty() || cpf != null) {
			try {
				PreparedStatement smt = conn.prepareStatement(sql);
				smt.setString(1, cpf);
				ResultSet result = smt.executeQuery();
				
				if(result.next()) {
					usuario = new Usuario(
							result.getString("nome"),
							result.getString("cpf"),
							result.getString("senha"),
							result.getString("email"),
							result.getString("imagem"),
							result.getString("cep"),
							result.getString("cidade"),
							result.getString("rua"),
							result.getString("numeo")
						);
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}
		return usuario;
	}
}
