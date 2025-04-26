package model.entity;

public class Usuario {
	private String nome;
	private String cpf;
	private String email;
	private String senha;
	private String imagem;
	private String cep;
	private String cidade;
	private String rua;
	private String numero;
	
	
	public Usuario(String nome, String cpf, String email,String senha, String imagem, String cep, String cidade ,String rua, String numero) {
		setNome(nome);
		setCpf(cpf);
		setEmail(email);
		setSenha(senha);
		setImagem(imagem);
		setCep(cep);
		setCidade(cidade);
		setRua(rua);
		setNumero(numero);
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

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
