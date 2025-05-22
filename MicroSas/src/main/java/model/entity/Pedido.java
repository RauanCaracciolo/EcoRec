package model.entity;

import java.time.LocalDateTime;

public class Pedido {
	private int id;
	private int id_dispo;
	private String email_usuario;
	private String cpf_coletor;
	private String descricao;
	private LocalDateTime horario;
	private String estado;

	public Pedido(int id, int id_dispo, String email_usuario, String cpf_coletor, String descricao, LocalDateTime horario, String estado) {
		setId(id);
		setId_dispo(id_dispo);
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
	public Pedido(int id_dispo, String cpf_usuario, String cpf_coletor, String descricao, LocalDateTime horario, String estado) {
		setId_dispo(id_dispo);
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

	public int getId_dispo() {
		return id_dispo;
	}

	public void setId_dispo(int id_dispo) {
		this.id_dispo = id_dispo;
	}
}
