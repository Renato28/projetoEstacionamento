package com.api.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Estacionamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private Carro carro;

	@ManyToOne
	private Vaga vaga;

	@NotNull
	@JsonFormat(pattern = "#,##0.00")
	private BigDecimal precoHora;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "dd-mm-yyyy")
	private Date horaEntrada;

	@JsonFormat(pattern = "#,##0.00")
	private BigDecimal totalPagar;

	public Estacionamento() {

	}

	public Estacionamento(Integer id, BigDecimal precoHora, Date horaEntrada, BigDecimal totalPagar) {
		super();
		this.id = id;
		this.precoHora = precoHora;
		this.horaEntrada = horaEntrada;
		this.totalPagar = totalPagar;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estacionamento other = (Estacionamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
