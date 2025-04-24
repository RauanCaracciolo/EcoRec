package model.entity;

public class Centro {
	String id;
	String nome;
	String imagem;
	String endereco;
	String[] materiais;
	public Centro(String nome, String imagem, String endereco, String[] materiais ) {
		setNome(nome);
		setImagem(imagem);
		setEndereco(endereco);
		setMateriais(materiais);
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String[] getMateriais() {
		return materiais;
	}
	public void setMateriais(String[] materiais) {
		this.materiais = materiais;
	}
}
