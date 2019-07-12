package br.com.enfermagem.model;

import java.util.Calendar;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Caso {
	
	private Long id;
	@Size(min=1 , message="Preencher Campo")
	private String identificacao;
	@Size(min=5 , max = 5 ,message="Campo deve ter 5 digitos")
	private String code; 
	private Long idCasoUsuario;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataHora;
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdentificacao() {
		return identificacao;
	}
	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Long getIdCasoUsuario() {
		return idCasoUsuario;
	}
	public void setIdCasoUsuario(Long idCasoUsuario) {
		this.idCasoUsuario = idCasoUsuario;
	}	
	public Calendar getDataHora() {
		return dataHora;
	}
	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}

}
