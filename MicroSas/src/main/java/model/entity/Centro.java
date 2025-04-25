package model.entity;

public class Centro {
	private String id;
	private String nome;
	private String imagem;
	private Endereco endereco;
	private String[] materiais;
	
	public Centro(String nome, String imagem, Endereco endereco, String[] materiais ) {
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String[] getMateriais() {
		return materiais;
	}
	public void setMateriais(String[] materiais) {
		this.materiais = materiais;
	}
}
