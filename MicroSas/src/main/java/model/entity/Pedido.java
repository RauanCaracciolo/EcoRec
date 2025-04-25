package model.entity;

public class Pedido {
	private String email_cliente;
	private String id_centro;
	private String descricao;
	private double valor;
	
	public Pedido(String email_cliente, String id_centro, String descricao, double valor) {
		setEmail_cliente(email_cliente);
		setId_centro(id_centro);
		setDescricao(descricao);
		setValor(valor);
	}
	
	public String getEmail_cliente() {
		return email_cliente;
	}
	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}
	public String getId_centro() {
		return id_centro;
	}
	public void setId_centro(String id_centro) {
		this.id_centro = id_centro;
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
