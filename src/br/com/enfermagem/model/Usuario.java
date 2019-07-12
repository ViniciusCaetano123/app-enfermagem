package br.com.enfermagem.model;

import java.util.Calendar;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Usuario{
	
	private Long id;
	@Size(min=1 , message="Preencher Campo")
	private String login;	
	@Size(min=1 , message="Preencher Campo")
	private String senha;
	@Size(min=1 , message="Preencher Campo")
	private String nome;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataHora;
	@Size(min=1 , message="Preencher Campo")
	private String email;	

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Calendar getDataHora() {
		return dataHora;
	}
	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getLogin() {		
		return this.login;
	}

}