package br.com.enfermagem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.enfermagem.dao.ComentarioDAO;
import br.com.enfermagem.dao.UsuarioDAO;
import br.com.enfermagem.model.Comentario;

@Controller
public class ComentariosController {
	
	@Autowired
	ComentarioDAO daoComentario;
	
	@Autowired
    UsuarioDAO daoUsuario;
    
	@RequestMapping("listaComentarios")
    public String lista(Model modelComentario ) throws ClassNotFoundException {
        modelComentario.addAttribute("comentarios", daoComentario.lista());
        return "comentario/lista";
    }
	
	@RequestMapping("novoComentario")
	public String form(Model modelUsuario) {
		modelUsuario.addAttribute("usuarios", daoUsuario.lista());
		return "comentario/formulario";
	}
	
	@RequestMapping("adicionaComentario")
	public String adiciona(@Valid Comentario comentario, BindingResult result, Model modelUsuario) throws ClassNotFoundException {
		if(result.hasFieldErrors("cod") || result.hasFieldErrors("comentario") || result.hasFieldErrors("idComentarioPaciente")) {
			 modelUsuario.addAttribute("usuarios", daoUsuario.lista());
			 return "comentario/formulario";
	     }
		daoComentario.adiciona(comentario);
		return "redirect:listaComentariosPaciente";
	}
	
	@RequestMapping("mostraComentario")
    public String mostra(Long id, Model modelComentario) throws ClassNotFoundException {
        modelComentario.addAttribute("comentario", daoComentario.buscaPorId(id));
        return "comentario/mostra";
    }
	
	@RequestMapping("alteraComentario")
	public String altera(@Valid Comentario comentario, BindingResult result) throws ClassNotFoundException {
		if(result.hasFieldErrors("cod") || result.hasFieldErrors("comentario") || result.hasFieldErrors("idComentarioPaciente")) {
			 return "comentario/mostra";
	     }
		daoComentario.altera(comentario);
        return "redirect:listaComentarios";
    }
	
    @RequestMapping("removeComentario")
    public String remove(Comentario comentario) throws ClassNotFoundException {
    	daoComentario.remove(comentario);
        return "redirect:listaComentarios";
    }
    
}