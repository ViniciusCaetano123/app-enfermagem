package br.com.enfermagem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.enfermagem.dao.LoginDAO;
import br.com.enfermagem.model.Usuario;

@Controller
public class LoginController{

    @RequestMapping("loginForm")
    public String loginForm() {
        return "login/formularioLogin";
    }
   
    @RequestMapping("efetuaLogin")
    public String efetuaLogin(Usuario usuario, HttpSession session) throws ClassNotFoundException {
        if(new LoginDAO().existeUsuario(usuario)) {
            session.setAttribute("usuarioLogado", usuario);
            return "redirect:listaPrincipal";
        }
        
        return "redirect:loginForm";
    }    
   
    @RequestMapping("logout")
    public String logout(HttpSession session) {
    	
        session.invalidate();
        return "redirect:loginForm";
    }
    
}