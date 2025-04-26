package model.entity;

public class Centro {
	private String cnpj;
	private String nome;
	private String senha;
	private String imagem;
	private String cep;
	private String cidade;
	private String rua;
	private String numero;
	private String[] materiais;
	
	public Centro(String cnpj, String nome,String senha, String imagem, String cep, String cidade ,String rua, String numero, String[] materiais ) {
		setCnpj(cnpj);
		setNome(nome);
		setImagem(imagem);
		setSenha(senha);
		setCep(cep);
		setCidade(cidade);
		setRua(rua);
		setNumero(numero);
		setMateriais(materiais);
	}
	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public String[] getMateriais() {
		return materiais;
	}
	public void setMateriais(String[] materiais) {
		this.materiais = materiais;
	}
}
