package com.api.models.enums;

public enum VagaStatus {

	DISPONIVEL(1, "Disponivel"), INDISPONIVEL(2, "Indisponivel"), OCUPADO(3, "Ocupado");

	private int cod;
	private String descricao;

	private VagaStatus(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static VagaStatus toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (VagaStatus x : VagaStatus.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
