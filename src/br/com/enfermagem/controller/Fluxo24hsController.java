package br.com.enfermagem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.enfermagem.dao.Fluxo24hDAO;
import br.com.enfermagem.dao.PacienteDAO;
import br.com.enfermagem.dao.CasoDAO;
import br.com.enfermagem.dao.UsuarioDAO;
import br.com.enfermagem.model.Fluxo24h;
import br.com.enfermagem.model.Paciente;
import br.com.enfermagem.model.Caso;
import br.com.enfermagem.model.Usuario;

@Controller
public class Fluxo24hsController {
	@Autowired
	UsuarioDAO daoUsuario;
	
	@Autowired
	CasoDAO daoCaso;
	
	@Autowired
	PacienteDAO daoPaciente;
	
	@Autowired
	Fluxo24hDAO daoFluxo24h;
	
	@RequestMapping("listaFluxo24hs")
    public String lista(long idPaciente, Model modelFluxo24h ,Model modelPaciente, Model modelCaso, Model modelUsuario) throws ClassNotFoundException {
		Paciente paciente = daoPaciente.buscaPorId(idPaciente);
		modelPaciente.addAttribute("paciente", paciente);
		
        Caso caso = daoCaso.buscaPorId(paciente.getIdPacienteCaso());
		modelCaso.addAttribute("caso", caso);
		
		Usuario usuarioLocado = daoUsuario.buscaPorId(paciente.getIdPacienteUsuario());
		modelUsuario.addAttribute("usuarioLogado", usuarioLocado);
		
		Usuario usuarioCreador = daoUsuario.buscaPorId(caso.getIdCasoUsuario());
		modelUsuario.addAttribute("usuarioCreador", usuarioCreador);
		
		modelFluxo24h.addAttribute("fluxos24h", daoFluxo24h.buscaPorIdFluxo24hPaciente(idPaciente));
		
        return "fluxo24h/lista";
    }
	
	@RequestMapping("novoFluxo24h")
	public String form(long idPaciente, Model modelPaciente, Model modelCaso, Model modelUsuario) throws ClassNotFoundException {
		Paciente paciente = daoPaciente.buscaPorId(idPaciente);
		modelPaciente.addAttribute("paciente", paciente);
		
		Caso caso = daoCaso.buscaPorId(paciente.getIdPacienteCaso());
		modelCaso.addAttribute("caso", caso);
		
		Usuario usuarioLocado = daoUsuario.buscaPorId(paciente.getIdPacienteUsuario());
		modelUsuario.addAttribute("usuarioLogado", usuarioLocado);
		
		Usuario usuarioCreador = daoUsuario.buscaPorId(caso.getIdCasoUsuario());
		modelUsuario.addAttribute("usuarioCreador", usuarioCreador);
		
		return "fluxo24h/formulario";
	}
	
	@RequestMapping("adicionaFluxo24h")
	public String adiciona(@Valid Fluxo24h fluxo24h, BindingResult result, Model modelPaciente) throws ClassNotFoundException {
		if(this.fluxo24hHasFieldErrors(result)) {
			modelPaciente.addAttribute("paciente", daoPaciente.buscaPorId(fluxo24h.getIdFluxo24hPaciente()));
			return "fluxo24h/formulario";
		}
		daoFluxo24h.adiciona(fluxo24h);
		return "redirect:listaFluxo24hs?idPaciente=" + fluxo24h.getIdFluxo24hPaciente();
	}
	
	@RequestMapping("mostraFluxo24h")
    public String mostra(long idFluxo24h, long idPaciente, Model modelFluxo24h, Model modelPaciente, Model modelCaso, Model modelUsuario) throws ClassNotFoundException {
		Paciente paciente = daoPaciente.buscaPorId(idPaciente);
		modelPaciente.addAttribute("paciente", paciente);
		
		Caso caso = daoCaso.buscaPorId(paciente.getIdPacienteCaso());
		modelCaso.addAttribute("caso", caso);
		
		Usuario usuarioLocado = daoUsuario.buscaPorId(paciente.getIdPacienteUsuario());
		modelUsuario.addAttribute("usuarioLogado", usuarioLocado);
		
		Usuario usuarioCreador = daoUsuario.buscaPorId(caso.getIdCasoUsuario());
		modelUsuario.addAttribute("usuarioCreador", usuarioCreador);
		
		modelFluxo24h.addAttribute("fluxo24h", daoFluxo24h.buscaPorId(idFluxo24h));
        return "fluxo24h/mostra";
    }
	
	@RequestMapping("alteraFluxo24h")
	public String altera(@Valid Fluxo24h fluxo24h, BindingResult result, Model modelPaciente) throws ClassNotFoundException {	
		if(this.fluxo24hHasFieldErrors(result)) {
			modelPaciente.addAttribute("paciente", daoPaciente.buscaPorId(fluxo24h.getIdFluxo24hPaciente()));
			
			return "fluxo24h/mostra";
		}
		daoFluxo24h.altera(fluxo24h);
		return "redirect:listaFluxo24hs?idPaciente=" + fluxo24h.getIdFluxo24hPaciente();
    }
	
    @RequestMapping("removeFluxo24h")
    public String remove(Fluxo24h fluxo24h) throws ClassNotFoundException {
    	daoFluxo24h.remove(fluxo24h);
    	return "redirect:listaFluxo24hs?idPaciente=" + fluxo24h.getIdFluxo24hPaciente();
    }
    public Boolean fluxo24hHasFieldErrors(BindingResult result) {
    	if(result.hasFieldErrors("cod") ||result.hasFieldErrors("pa") || 
			result.hasFieldErrors("fc") || result.hasFieldErrors("fr") || 
			result.hasFieldErrors("tax") || result.hasFieldErrors("dor") ||
			result.hasFieldErrors("sat") || result.hasFieldErrors("pvc") ||  
			result.hasFieldErrors("hgt")
    	) {
			return true;
		}
    	return false;
    }
    
} 
