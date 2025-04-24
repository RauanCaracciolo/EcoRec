package model.entity;

public class Usuario {
	String nome;
	String email;
	String imagem;
	String endereco;
	
	public Usuario(String nome, String email, String imagem, String endereco) {
		setNome(nome);
		setEmail(email);
		setImagem(imagem);
		setEndereco(endereco);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}	
}
