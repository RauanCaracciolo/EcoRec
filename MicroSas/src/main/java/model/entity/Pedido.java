package model.entity;

public class Pedido {
	private String cpf_cliente;
	private String cpf_coletor;
	private String descricao;
	private double valor;
	
	public Pedido(String cpf_cliente, String cpf_coletor, String descricao, double valor) {
		setCpf_cliente(cpf_cliente);
		setCpf_coletor(cpf_coletor);
		setDescricao(descricao);
		setValor(valor);
	}
	
	public String getCpf_cliente() {
		return cpf_cliente;
	}
	public void setCpf_cliente(String cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
	}
	public String getCpf_coletor() {
		return cpf_coletor;
	}
	public void setCpf_coletor(String cpf_coletor) {
		this.cpf_coletor = cpf_coletor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}
