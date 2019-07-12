package br.com.enfermagem.model;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Comentario {
	
	private Long id;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataHora;
	private String descricaoComentario;
	private Long idComentarioPaciente;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Calendar getDataHora() {
		return dataHora;
	}
	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}
	public String getDescricaoComentario() {
		return descricaoComentario;
	}
	public void setDescricaoComentario(String descricaoComentario) {
		this.descricaoComentario = descricaoComentario;
	}
	public Long getIdComentarioPaciente() {
		return idComentarioPaciente;
	}
	public void setIdComentarioPaciente(Long idComentarioPaciente) {
		this.idComentarioPaciente = idComentarioPaciente;
	}
}
