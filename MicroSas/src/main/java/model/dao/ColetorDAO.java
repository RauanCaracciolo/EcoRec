package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.entity.Coletor;

public class ColetorDAO {
	public void cadastrar(Connection conn, Coletor c) {
        String sql = "insert into coletores (nome, cpf, email, senha, imagem) values (?, ?, ?, ?, ?)";	

        try{
        	PreparedStatement smt = conn.prepareStatement(sql);
        	smt.setString(1, c.getNome());
        	smt.setString(2, c.getCpf());
        	smt.setString(3, c.getEmail());
        	smt.setString(4, c.getSenha());
        	smt.setString(5, c.getImagem());
        	smt.execute();
        }catch(Exception ex) {
        	ex.printStackTrace();
        }

	}
}
