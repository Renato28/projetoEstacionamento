package com.api.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.api.models.Carro;

public class CarroDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message="Preenchimento obrigatório")
	private String modelo;

	@NotEmpty(message="Preenchimento obrigatório")
	private String ano;

	@NotEmpty(message="Preenchimento obrigatório")
	private String cor;

	public CarroDTO() {

	}

	public CarroDTO(Carro obj) {
		id = obj.getId();
		modelo = obj.getModelo();
		ano = obj.getAno();
		cor = obj.getCor();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

}
