package br.com.enfermagem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.enfermagem.dao.CasoDAO;
import br.com.enfermagem.dao.PacienteDAO;
import br.com.enfermagem.dao.UsuarioDAO;
import br.com.enfermagem.model.Caso;
import br.com.enfermagem.model.Fluxo24h;
import br.com.enfermagem.model.Paciente;
import br.com.enfermagem.model.Usuario;

@Controller
public class PacientesController {
	
	@Autowired
	PacienteDAO daoPaciente;
	
	@Autowired
    CasoDAO daoCaso;
	
	@Autowired
    UsuarioDAO daoUsuario;
    
	@RequestMapping("listaPacientes")
    public String lista(Model modelPaciente, Model modelUsuario) throws ClassNotFoundException {
        modelPaciente.addAttribute("pacientes", daoPaciente.lista());
		modelUsuario.addAttribute("usuarios", daoUsuario.lista());
        return "paciente/lista";
    }
	
	@RequestMapping("novoPaciente")
	public String form(Model modelUsuario) {
		modelUsuario.addAttribute("usuarios", daoUsuario.lista());
		return "paciente/formularioCode";
	}
	
	@RequestMapping("criaPaciente")
    public String cria(@Valid Caso caso, BindingResult result,  String code, Model modelCaso,Model modelUsuario) throws ClassNotFoundException {
		if(result.hasFieldErrors("code")) {
			modelCaso.addAttribute("casos", daoCaso.lista());
			return "paciente/formularioCode";
		}
		System.out.println(code);
		modelUsuario.addAttribute("usuarios", daoUsuario.lista());
		modelCaso.addAttribute("caso", daoCaso.buscaPorCode(code));
        return "paciente/formularioPaciente";
    }
	
	@RequestMapping("adicionaPaciente")
	public String adiciona(@Valid Paciente paciente, BindingResult result, Model modelUsuario, Model modelPaciente, Model modelCaso, String code) throws ClassNotFoundException {
		if(result.hasFieldErrors("nome")) {
			 modelCaso.addAttribute("caso", daoCaso.buscaPorCode(code));
			 modelPaciente.addAttribute("pacientes", daoPaciente.lista());
			 modelUsuario.addAttribute("usuarios", daoUsuario.lista());
			 return "paciente/formularioPaciente";
	     }
		daoPaciente.adiciona(paciente);
		return "redirect:listaPrincipal";
	}
	
	@RequestMapping("mostraPaciente")
    public String mostra(long idPaciente, Model modelPaciente, Model modelUsuario, Model modelCaso) throws ClassNotFoundException {
		Paciente paciente = daoPaciente.buscaPorId(idPaciente);
		modelPaciente.addAttribute("paciente", paciente);
		
		
		Caso caso = daoCaso.buscaPorId(paciente.getIdPacienteCaso());
		modelCaso.addAttribute("caso", caso);
		
		Usuario usuarioCreador = daoUsuario.buscaPorId(caso.getIdCasoUsuario());
		modelUsuario.addAttribute("usuarioCreador", usuarioCreador);
        
        return "paciente/mostra";
    }
	
	@RequestMapping("alteraPaciente")
	public String altera(@Valid Paciente paciente, BindingResult result) throws ClassNotFoundException {
		daoPaciente.altera(paciente);
        return "redirect:mostraPaciente?idPaciente="+paciente.getId();
    }
	
    @RequestMapping("removePaciente")
    public String remove(Paciente paciente) throws ClassNotFoundException {
    	daoPaciente.remove(paciente);
        return "redirect:listaPrincipal";
    }
    
}