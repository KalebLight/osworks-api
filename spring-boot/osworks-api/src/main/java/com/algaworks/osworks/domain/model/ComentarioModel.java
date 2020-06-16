package com.algaworks.osworks.domain.model;

import java.time.OffsetDateTime;

public class ComentarioModel {
	private Long id;
	private String descricao;
	private OffsetDateTime envio;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public OffsetDateTime getEnvio() {
		return envio;
	}
	public void setEnvio(OffsetDateTime envio) {
		this.envio = envio;
	}
	
	
}
