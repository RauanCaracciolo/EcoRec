package model.entity;

public class Endereco {
	private int id;
	private String cep;
	private String cidade;
	private String rua;
	private String numero;
	
	public Endereco(int id, String cep, String cidade, String rua, String numero) {
		setId(id);
		setCep(cep);
		setCidade(cidade);
		setRua(rua);
		setNumero(numero);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
