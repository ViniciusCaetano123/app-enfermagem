package br.com.enfermagem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.enfermagem.dao.CasoDAO;
import br.com.enfermagem.dao.QuadropacienteDAO;
import br.com.enfermagem.dao.UsuarioDAO;
import br.com.enfermagem.model.Quadropaciente;


@Controller
public class QuadropacientesController {
	
	@Autowired
	QuadropacienteDAO daoQuadropaciente;
	
	@Autowired
    UsuarioDAO daoUsuario;
	
	@Autowired
    CasoDAO daoCaso;
	
    
	@RequestMapping("listaQuadropacientes")
    public String lista(long id , Model modelCaso , Model modelQuadropaciente) throws ClassNotFoundException {
        modelQuadropaciente.addAttribute("quadropacientes", daoQuadropaciente.selecionaPorId(id));
        modelCaso.addAttribute("caso", daoCaso.buscaPorId(id));
        return "quadropaciente/lista";
    }
	
	@RequestMapping("novoQuadropaciente")
	public String form(long id ,Model modelUsuario, Model modelCaso) {
		modelUsuario.addAttribute("usuarios", daoUsuario.lista());
		modelCaso.addAttribute("caso", daoCaso.buscaPorId(id));
		return "quadropaciente/formulario";
	}
	
	@RequestMapping("adicionaQuadropaciente")
	public String adiciona(@Valid Quadropaciente quadropaciente, BindingResult result, long id ,Model modelUsuario,Model modelCaso) throws ClassNotFoundException {
		if(result.hasFieldErrors("descricao")) {
			modelUsuario.addAttribute("usuarios", daoUsuario.lista());
			modelCaso.addAttribute("caso", daoCaso.buscaPorId(id));
			return "quadropaciente/formulario";
	     }
		daoQuadropaciente.adiciona(quadropaciente);
		return "redirect:listaQuadropacientes?id="+id;
	}
	
	@RequestMapping("mostraQuadropaciente")
    public String mostra(Long id, Model modelQuadropaciente) throws ClassNotFoundException {
        modelQuadropaciente.addAttribute("quadropaciente", daoQuadropaciente.buscaPorId(id));
        return "quadropaciente/mostra";
    }
	
	@RequestMapping("alteraQuadropaciente")
	public String altera(@Valid Quadropaciente quadropaciente, long idCaso, BindingResult result) throws ClassNotFoundException {
		if(result.hasFieldErrors("descricao")) {
			 	return "quadropaciente/mostra";
	     }
		daoQuadropaciente.altera(quadropaciente);
        return "redirect:listaQuadropacientes?id="+idCaso;
    }
	
    @RequestMapping("removeQuadropaciente")
    public String remove(Quadropaciente quadropaciente, long idCaso) throws ClassNotFoundException {
    	daoQuadropaciente.remove(quadropaciente);
        return "redirect:listaQuadropacientes?id="+idCaso;
    }
    
}