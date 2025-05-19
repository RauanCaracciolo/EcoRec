package model.entity;

public class Coletor {
	private String nome;
	private String cpf;
	private String senha;
	private String email;
	private String cidade;
	private String imagem;
	
	public Coletor(String nome, String cpf, String senha, String email, String cidade, String imagem) {
		setNome(nome);
		setCpf(cpf);
		setSenha(senha);
		setEmail(email);
		setCidade(cidade);
		setImagem(imagem);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
		}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	

}
