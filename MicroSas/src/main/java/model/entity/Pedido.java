package model.entity;

import java.time.LocalDateTime;

public class Pedido {
	private int id;
	private String email_usuario;
	private String cpf_coletor;
	private String descricao;
	private LocalDateTime horario;
	private String estado;

	public Pedido(int id, String email_usuario, String cpf_coletor, String descricao, LocalDateTime horario, String estado) {
		setId(id);
		setEmail_usuario(email_usuario);
		setCpf_coletor(cpf_coletor);
		setDescricao(descricao);
		setHorario(horario);
		setEstado(estado);
	}
	
	public Pedido(String cpf_usuario, String cpf_coletor, String descricao, LocalDateTime horario, String estado) {
		setEmail_usuario(cpf_usuario);
		setCpf_coletor(cpf_coletor);
		setDescricao(descricao);
		setHorario(horario);
		setEstado(estado);
	}

		public void atualizaEstado() {
		setEstado("aceito");
	}
	
	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public LocalDateTime getHorario() {
		return horario;
	}


	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
	}


	public String getEmail_usuario() {
		return email_usuario;
	}
	public void setEmail_usuario(String cpf_usuario) {
		this.email_usuario = cpf_usuario;
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
}
