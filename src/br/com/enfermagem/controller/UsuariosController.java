package br.com.enfermagem.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.enfermagem.dao.UsuarioDAO;
import br.com.enfermagem.model.Usuario;

@Controller
public class UsuariosController {
	
    @Autowired
    UsuarioDAO daoUsuario;    
    
    
    @RequestMapping("enviaEmail")
    public String enviaEmail(String email, @Valid Usuario usuario,  BindingResult result) throws SQLException {    
    	if(result.hasFieldErrors("email")){
    		return "usuario/formularioEsqueciSenha";      
       	}
    	daoUsuario.enviarEmail(email,usuario);
   		return "redirect:loginForm";       	 
    }
    
    @RequestMapping("mostraTelaEnviarEmail")
    public String mostraTelaEnviarEmail() {     	
    	return "usuario/formularioEsqueciSenha";
    }    
    
	@RequestMapping("editaUsuario")
    public String lista(Model modelUsuario, @Valid Usuario usuario, BindingResult result) throws ClassNotFoundException {
		modelUsuario.addAttribute("usuarios", daoUsuario.lista()); 			
		return "usuario/lista";
    }

	@RequestMapping("novoUsuario")
	public String form() {
		return "usuario/formularioNovoUsuario";
	}
	
	@RequestMapping("adicionaUsuario")
	public String adiciona(@Valid Usuario usuario, BindingResult result) throws ClassNotFoundException {
		if(result.hasFieldErrors("nome") || result.hasFieldErrors("senha") || result.hasFieldErrors("email")) {
			 return "usuario/formularioNovoUsuario";
	     }
		daoUsuario.adiciona(usuario);
		return "redirect:loginForm";
	}
	
	@RequestMapping("mostraUsuario")
    public String mostra(Long id, Model modelUsuario) throws ClassNotFoundException {
        modelUsuario.addAttribute("usuario", daoUsuario.buscaPorId(id));
        return "usuario/mostra";
    }
	
	@RequestMapping("alteraUsuario")
	public String altera(@Valid Usuario usuario, BindingResult result) throws ClassNotFoundException {
		if(result.hasFieldErrors("nome") || result.hasFieldErrors("email")) {		
			return "redirect:editaUsuario";
	     }			
		daoUsuario.altera(usuario);		
        return "redirect:loginForm";
    }
	
    @RequestMapping("removeUsuario")
    public String remove(Usuario usuario) throws ClassNotFoundException {    	
    	daoUsuario.remove(usuario);
        return "redirect:listaUsuarios";
    }
    
}