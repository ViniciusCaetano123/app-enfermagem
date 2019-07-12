package br.com.enfermagem.model;

import java.util.Calendar;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Quadropaciente {
	
	private Long id;
	@Size(min=1 , message="Preencher Campo")
	private String descricao;
	private Long idQuadropacienteCaso;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataHora;
	
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
	public Long getIdQuadropacienteCaso() {
		return idQuadropacienteCaso;
	}
	public void setIdQuadropacienteCaso(Long idQuadropacienteCaso) {
		this.idQuadropacienteCaso = idQuadropacienteCaso;
	}
	public Calendar getDataHora() {
		return dataHora;
	}
	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}
	


}
