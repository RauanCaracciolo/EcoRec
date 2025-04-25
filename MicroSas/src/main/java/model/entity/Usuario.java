package model.entity;

public class Usuario {
	private String nome;
	private String email;
	private String imagem;
	private Endereco endereco;
	
	public Usuario(String nome, String email, String imagem, Endereco endereco) {
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}	
}
