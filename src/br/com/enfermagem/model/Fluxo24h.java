package br.com.enfermagem.model;

import java.util.Calendar;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Fluxo24h {
	private Long id;
	@NotNull(message="Preencher Campo")
	private Long cod;
	@Size(max=10, message="Máximo 10 Caracteres")
	private String pa;
	@Size(max=10, message="Máximo 10 Caracteres")
	private String fc;
	@Size(max=10, message="Máximo 10 Caracteres")
	private String fr;
	@Size(max=10, message="Máximo 10 Caracteres")
	private String tax;
	@Size(max=10, message="Máximo 10 Caracteres")
	private String dor;
	@Size(max=10, message="Máximo 10 Caracteres")
	private String sat;
	@Size(max=10, message="Máximo 10 Caracteres")
	private String pvc;
	@Size(max=10, message="Máximo 10 Caracteres")
	private String hgt;
	private String administrados;
	private String eliminados;
	private String observacoes;
	private Long idFluxo24hPaciente;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataHora;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Long getCod() {
		return cod;
	}
	public void setCod(Long cod) {
		this.cod = cod;
	}
	public String getPa() {
		return pa;
	}
	public void setPa(String pa) {
		this.pa = pa;
	}
	public String getFc() {
		return fc;
	}
	public void setFc(String fc) {
		this.fc = fc;
	}
	public String getFr() {
		return fr;
	}
	public void setFr(String fr) {
		this.fr = fr;
	}
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public String getDor() {
		return dor;
	}
	public void setDor(String dor) {
		this.dor = dor;
	}
	public String getSat() {
		return sat;
	}
	public void setSat(String sat) {
		this.sat = sat;
	}
	public String getPvc() {
		return pvc;
	}
	public void setPvc(String pvc) {
		this.pvc = pvc;
	}
	public String getHgt() {
		return hgt;
	}
	public void setHgt(String hgt) {
		this.hgt = hgt;
	}
	public String getAdministrados() {
		return administrados;
	}
	public void setAdministrados(String administrados) {
		this.administrados = administrados;
	}
	public String getEliminados() {
		return eliminados;
	}
	public void setEliminados(String eliminados) {
		this.eliminados = eliminados;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public Long getIdFluxo24hPaciente() {
		return idFluxo24hPaciente;
	}
	public void setIdFluxo24hPaciente(Long idFluxo24hPaciente) {
		this.idFluxo24hPaciente = idFluxo24hPaciente;
	}
	public Calendar getDataHora() {
		return dataHora;
	}
	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}
	
}
