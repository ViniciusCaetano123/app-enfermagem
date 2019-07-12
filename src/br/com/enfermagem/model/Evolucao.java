package br.com.enfermagem.model;

import java.util.Calendar;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Evolucao {
	
	private Long id;
	@NotNull
	@Size(min=1, message="Preencher Campo")
	private String descricaoSubjetivo;
	@NotNull
	@Size(min=1, message="Preencher Campo")
	private String descricaoObjetivo;
	@NotNull
	@Size(min=1, message="Preencher Campo")
	private String descricaoImpressao;
	@NotNull
	@Size(min=1, message="Preencher Campo")
	private String descricaoConduta;
	@NotNull
	@Size(min=1, message="Preencher Campo")
	private String descricaoCondigodiagnostico;
	private Long idEvolucaoPaciente;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataHora;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricaoSubjetivo() {
		return descricaoSubjetivo;
	}
	public void setDescricaoSubjetivo(String descricaoSubjetivo) {
		this.descricaoSubjetivo = descricaoSubjetivo;
	}
	public String getDescricaoObjetivo() {
		return descricaoObjetivo;
	}
	public void setDescricaoObjetivo(String descricaoObjetivo) {
		this.descricaoObjetivo = descricaoObjetivo;
	}
	public String getDescricaoImpressao() {
		return descricaoImpressao;
	}
	public void setDescricaoImpressao(String descricaoImpressao) {
		this.descricaoImpressao = descricaoImpressao;
	}
	public String getDescricaoConduta() {
		return descricaoConduta;
	}
	public void setDescricaoConduta(String descricaoConduta) {
		this.descricaoConduta = descricaoConduta;
	}
	public String getDescricaoCondigodiagnostico() {
		return descricaoCondigodiagnostico;
	}
	public void setDescricaoCondigodiagnostico(String descricaoCondigodiagnostico) {
		this.descricaoCondigodiagnostico = descricaoCondigodiagnostico;
	}
	public Long getIdEvolucaoPaciente() {
		return idEvolucaoPaciente;
	}
	public void setIdEvolucaoPaciente(Long idEvolucaoPaciente) {
		this.idEvolucaoPaciente = idEvolucaoPaciente;
	}
	public Calendar getDataHora() {
		return dataHora;
	}
	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}


}
