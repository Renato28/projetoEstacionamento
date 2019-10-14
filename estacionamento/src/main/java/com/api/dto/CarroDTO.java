package com.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.api.models.Carro;

public class CarroDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String modelo;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String ano;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String cor;

	private BigDecimal precoHora;

	private Date horaEntrada;

	private BigDecimal totalPagar;

	public CarroDTO() {

	}

	public CarroDTO(Carro obj) {
		id = obj.getId();
		modelo = obj.getModelo();
		ano = obj.getAno();
		cor = obj.getCor();
		precoHora = obj.getPrecoHora();
		horaEntrada = obj.getHoraEntrada();
		totalPagar = obj.getTotalPagar();
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

	public BigDecimal getPrecoHora() {
		return precoHora;
	}

	public void setPrecoHora(BigDecimal precoHora) {
		this.precoHora = precoHora;
	}

	public Date getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(Date horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public BigDecimal getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(BigDecimal totalPagar) {
		this.totalPagar = totalPagar;
	}

}
