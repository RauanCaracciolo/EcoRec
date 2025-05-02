package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.entity.Coletor;

public class ColetorDAO {
	public void cadastrar(Connection conn, Coletor c) {
        String sql = "insert into coletores (nome, cpf, senha, email, imagem) values (?, ?, ?, ?, ?)";	

        try{
        	PreparedStatement smt = conn.prepareStatement(sql);
        	smt.setString(1, c.getNome());
        	smt.setString(2, c.getCpf());
        	smt.setString(3, c.getSenha());
        	smt.setString(4, c.getEmail());
        	smt.setString(5, c.getImagem());
        	smt.execute();
        }catch(Exception ex) {
        	ex.printStackTrace();
        }
	}
	public Coletor getByCpf(Connection conn, String cpf) {
		Coletor coletor = null;
		String sql = "select * from coletores where cpf = ?";
		if(!cpf.isEmpty() || cpf != null) {
			try {
				PreparedStatement smt = conn.prepareStatement(sql);
				smt.setString(1, cpf);
				ResultSet result = smt.executeQuery();
				
				if(result.next()) {
					coletor = new Coletor(
							result.getString("nome"),
							result.getString("cpf"),
							result.getString("senha"),
							result.getString("email"),
							result.getString("imagem")
						);
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
		}
		return coletor;
	}
	public Coletor validarLogin(Connection conn, String cpf, String senha) {
		Coletor c = getByCpf(conn, cpf);
		if(c != null) {
			System.out.println("Senha digitada: [" + senha + "]");
			System.out.println("Senha do banco: [" + c.getSenha() + "]");

			if(c.getSenha().equals(senha)) {
				return c;
			}
		}
		return null;
	}
}
