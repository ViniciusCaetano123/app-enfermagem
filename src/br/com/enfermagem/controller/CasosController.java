package br.com.enfermagem.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.enfermagem.dao.UsuarioDAO;
import br.com.enfermagem.dao.CasoDAO;
import br.com.enfermagem.dao.PacienteDAO;
import br.com.enfermagem.dao.Fluxo24hDAO;
import br.com.enfermagem.dao.EvolucaoDAO;
import br.com.enfermagem.dao.ComentarioDAO;

import br.com.enfermagem.model.Caso;
import br.com.enfermagem.model.Paciente;
import br.com.enfermagem.model.Usuario;
import br.com.enfermagem.model.Fluxo24h;
import br.com.enfermagem.model.Evolucao;
import br.com.enfermagem.model.Comentario;


@Controller
public class CasosController {
	
	@Autowired
    UsuarioDAO daoUsuario;
	
	@Autowired
	CasoDAO daoCaso;
	
	@Autowired
	PacienteDAO daoPaciente;
	
	@Autowired
	Fluxo24hDAO daoFluxo24h;
	
	@Autowired
	EvolucaoDAO daoEvolucao;
	
	@Autowired
	ComentarioDAO daoComentario;
	
	
	@RequestMapping("listaCasos")
    public String lista(Model modelCaso, Model modelUsuario) throws ClassNotFoundException {
		modelCaso.addAttribute("casos", daoCaso.lista());
		modelUsuario.addAttribute("usuarios", daoUsuario.lista());
        return "caso/lista";
    }
	
	@RequestMapping("listaPacientesCaso")
    public String listaPacientesCaso(long idCaso, Model modelCaso, Model modelPaciente, Model modelUsuario) throws ClassNotFoundException {
		List<Paciente> listaPaciente = new ArrayList<Paciente>();
		listaPaciente = daoPaciente.listaPacientesCaso(idCaso);
		HashMap<Usuario, Paciente> listaUsuariosPacientes = new HashMap<Usuario,Paciente>();
		Usuario usuario = new Usuario();
		
		for (Paciente paciente : listaPaciente) {
			usuario = daoUsuario.buscaPorId(paciente.getIdPacienteUsuario());
			listaUsuariosPacientes.put( usuario, paciente);
		}
		
		modelUsuario.addAttribute("listaUsuariosPacientesCaso", listaUsuariosPacientes);
		modelCaso.addAttribute("caso", daoCaso.buscaPorId(idCaso));
		
		return "caso/listaPacientes";
    }
	
	@RequestMapping("listaComentariosPaciente")
	public String comentariosCaso(long idPaciente, long idUsuarioCreadorCaso, Model modelComentario, Model modelCaso, Model modelUsuario, Model modelPaciente,
			Model modelFluxo24h, Model modelEvolucao) {
		
		modelComentario.addAttribute("listaComentarios", daoComentario.listaComentariosCasoClinico(idPaciente, idUsuarioCreadorCaso));
		modelFluxo24h.addAttribute("listaFluxo24hs", daoFluxo24h.buscaPorIdFluxo24hPaciente(idPaciente));
		modelEvolucao.addAttribute("listaEvolucoes", daoEvolucao.listaEvolucoesPaciente(idPaciente));
		
		Paciente paciente = new Paciente();
		paciente = daoPaciente.buscaPorId(idPaciente);
		modelPaciente.addAttribute("paciente", paciente);
		modelCaso.addAttribute("caso", daoCaso.buscaPorId(paciente.getIdPacienteCaso()));
		modelUsuario.addAttribute("usuario", daoUsuario.buscaPorId(paciente.getIdPacienteUsuario()));
		
		return "caso/listaComentariosPaciente";
	}
		
	@RequestMapping("adicionarComentario")
	public String adicionarComentario(Comentario comentario, long idPaciente, long idUsuarioCreadorCaso, Model modelComentario) {
		daoComentario.adiciona(comentario);
//		Stmt.setLong(1, idPaciente)
		return "redirect:listaComentariosPaciente?idPaciente="+idPaciente+"&idUsuarioCreadorCaso="+idUsuarioCreadorCaso+"";
	}
	
	@RequestMapping("novoCaso")
	public String form(Model modelUsuario) {
		modelUsuario.addAttribute("usuarios", daoUsuario.lista());
		return "caso/formulario";
	}
	
	@RequestMapping("adicionaCaso")
	public String adiciona(@Valid Caso caso, BindingResult result, Model modelUsuario) throws ClassNotFoundException {
		if(result.hasFieldErrors("identificacao")) {
			 modelUsuario.addAttribute("usuarios", daoUsuario.lista());
			 return "caso/formulario";
	     }
		daoCaso.adiciona(caso);
		return "redirect:listaPrincipal";
	}
	
	@RequestMapping("mostraCaso")
    public String mostra(Long idCaso, Model modelCaso, Model modelUsuario) throws ClassNotFoundException {
		modelUsuario.addAttribute("usuarios", daoUsuario.lista());
        modelCaso.addAttribute("caso", daoCaso.buscaPorId(idCaso));
        return "caso/mostra";
    }
	
	@RequestMapping("alteraCaso")
	public String altera(@Valid Caso caso, BindingResult result, Model modelUsuario) throws ClassNotFoundException {
		if(result.hasFieldErrors("identificacao")) {
			 return "caso/mostra";
	     }
		modelUsuario.addAttribute("usuarios", daoUsuario.lista());
		daoCaso.altera(caso);
        return "redirect:listaPrincipal";
    }
	
	@RequestMapping("copiaCaso")
    public String copia(Caso caso) throws ClassNotFoundException {
		daoCaso.copiaPorId(caso);
        return "redirect:listaPrincipal";
    }
	
	
    @RequestMapping("removeCaso")
    public String remove(Caso caso) throws ClassNotFoundException {
    	daoCaso.remove(caso);
        return "redirect:listaPrincipal";
    }
    
	
    
}