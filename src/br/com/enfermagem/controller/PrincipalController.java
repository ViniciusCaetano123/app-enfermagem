package br.com.enfermagem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.enfermagem.dao.CasoDAO;
import br.com.enfermagem.dao.PacienteDAO;
import br.com.enfermagem.dao.UsuarioDAO;
import br.com.enfermagem.model.Caso;
import br.com.enfermagem.model.Usuario;

@Controller
public class PrincipalController{
	
	@Autowired
	CasoDAO daoCaso;
	
	@Autowired
	PacienteDAO daoPaciente;
	
    @Autowired
    UsuarioDAO daoUsuario;
	
	@RequestMapping("listaPrincipal")
	public String listaPrincipal(Model modelCaso, Model modelPaciente, Model modelUsuario) throws ClassNotFoundException {
		modelCaso.addAttribute("casos", daoCaso.lista());
		modelPaciente.addAttribute("pacientes", daoPaciente.lista());
        modelUsuario.addAttribute("usuarios", daoUsuario.lista());
		return "principal/principal";
	}
	
	@RequestMapping("/")
	public String listaPrincipalRaiz(Model modelCaso, Model modelPaciente, Model modelUsuario) throws ClassNotFoundException {
		modelCaso.addAttribute("casos", daoCaso.lista());
		modelPaciente.addAttribute("pacientes", daoPaciente.lista());
        modelUsuario.addAttribute("usuarios", daoUsuario.lista());
		return "principal/principal";
	}
	
	@RequestMapping("/simulador")
	public String listaPrincipalSimulador(Model modelCaso, Model modelPaciente, Model modelUsuario) throws ClassNotFoundException {
		modelCaso.addAttribute("casos", daoCaso.lista());
		modelPaciente.addAttribute("pacientes", daoPaciente.lista());
        modelUsuario.addAttribute("usuarios", daoUsuario.lista());
		return "principal/principal";
	}
	
	@RequestMapping("/enfermagem")
	public String listaPrincipalEnfermagem(Model modelCaso, Model modelPaciente, Model modelUsuario) throws ClassNotFoundException {
		modelCaso.addAttribute("casos", daoCaso.lista());
		modelPaciente.addAttribute("pacientes", daoPaciente.lista());
        modelUsuario.addAttribute("usuarios", daoUsuario.lista());
		return "principal/principal";
	}
	
	/*
	@RequestMapping("listaErro500")
	public String listaMenuErro500() {
		return "principal/erro500";
	}
	
	@RequestMapping("Erro")
	public String listaMenuErro() {
		return "principal/erro";
	}
	*/
	
}