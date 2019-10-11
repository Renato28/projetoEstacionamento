package com.api.dto;

import java.io.Serializable;

import com.api.models.Vaga;
import com.api.models.enums.VagaStatus;

public class VagaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String numero;
 
	private VagaStatus status;

	public VagaDTO() {

	}

	public VagaDTO(Vaga obj) {
		id = obj.getId();
		numero = obj.getNumero();
		status = obj.getStatus();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public VagaStatus getStatus() {
		return status;
	}

	public void setStatus(VagaStatus status) {
		this.status = status;
	}

}
