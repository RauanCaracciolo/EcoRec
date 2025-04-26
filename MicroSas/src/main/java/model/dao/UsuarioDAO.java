package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
