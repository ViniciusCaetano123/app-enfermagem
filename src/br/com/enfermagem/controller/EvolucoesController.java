package br.com.enfermagem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.enfermagem.dao.CasoDAO;
import br.com.enfermagem.dao.EvolucaoDAO;
import br.com.enfermagem.dao.PacienteDAO;
import br.com.enfermagem.dao.UsuarioDAO;
import br.com.enfermagem.model.Evolucao;
import br.com.enfermagem.model.Paciente;
import br.com.enfermagem.model.Usuario;
import br.com.enfermagem.model.Caso;		

@Controller
public class EvolucoesController {
	@Autowired
    UsuarioDAO daoUsuario;
	
	@Autowired
	CasoDAO daoCaso;
	
	@Autowired
	PacienteDAO daoPaciente;
	
	@Autowired
	EvolucaoDAO daoEvolucao;
	
	@RequestMapping("listaEvolucoes")
    public String lista(long idPaciente, Model modelCaso, Model modelEvolucao, Model modelPaciente, Model modelDiagnostico, Model modelUsuario ) throws ClassNotFoundException {
		Paciente paciente = daoPaciente.buscaPorId(idPaciente);
		modelPaciente.addAttribute("paciente", paciente);

		Caso caso = daoCaso.buscaPorId(paciente.getIdPacienteCaso());
		modelCaso.addAttribute("caso", caso);
		
		Usuario usuarioCreador = daoUsuario.buscaPorId(caso.getIdCasoUsuario());
		modelUsuario.addAttribute("usuarioCreador", usuarioCreador);
		
        modelEvolucao.addAttribute("evolucoes", daoEvolucao.lista());
        
        return "evolucao/lista";
    }
	
	@RequestMapping("novoEvolucao")
	public String form(long idPaciente, Model modelCaso, Model modelUsuario, Model modelDiagnostico, Model modelPaciente) {
		Paciente paciente = daoPaciente.buscaPorId(idPaciente);
		modelPaciente.addAttribute("paciente", paciente);

		Caso caso = daoCaso.buscaPorId(paciente.getIdPacienteCaso());
		modelCaso.addAttribute("caso", caso);
		
		Usuario usuarioCreador = daoUsuario.buscaPorId(caso.getIdCasoUsuario());
		modelUsuario.addAttribute("usuarioCreador", usuarioCreador);
		
		modelUsuario.addAttribute("usuarios", daoUsuario.lista());
		return "evolucao/formulario";
	}
	
	@RequestMapping("adicionaEvolucao")
	public String adiciona(@Valid Evolucao evolucao, BindingResult result, Model modelPaciente) throws ClassNotFoundException {
		if(this.EvolucaoHasFieldErrors(result)) {
			modelPaciente.addAttribute("paciente", daoPaciente.buscaPorId(evolucao.getIdEvolucaoPaciente()));
			return "evolucao/formulario";
		}
		daoEvolucao.adiciona(evolucao);
		return "redirect:listaEvolucoes?idPaciente=" + evolucao.getIdEvolucaoPaciente();
	}
	
	@RequestMapping("mostraEvolucao")
    public String mostra(long idPaciente, Model modelUsuario, Model modelCaso, Model modelPaciente, Model modelEvolucao, Model modelDiagnostico) throws ClassNotFoundException {
		Paciente paciente = daoPaciente.buscaPorId(idPaciente);
		modelPaciente.addAttribute("paciente", paciente);
 
		modelEvolucao.addAttribute("evolucao", daoEvolucao.buscaPorId(idPaciente));
        
		Caso caso = daoCaso.buscaPorId(paciente.getIdPacienteCaso());
		modelCaso.addAttribute("caso", caso);
	
		Usuario usuarioCreador = daoUsuario.buscaPorId(caso.getIdCasoUsuario());
		modelUsuario.addAttribute("usuarioCreador", usuarioCreador);
        
        return "evolucao/mostra";
    }
	
	@RequestMapping("alteraEvolucao")
	public String altera(@Valid Evolucao evolucao, BindingResult result, long idEvolucaoPaciente, Model modelPaciente, Model modelEvolucao) throws ClassNotFoundException {
		if(this.EvolucaoHasFieldErrors(result)) {
			modelPaciente.addAttribute("paciente", daoPaciente.buscaPorId(evolucao.getIdEvolucaoPaciente()));
			modelEvolucao.addAttribute("evolucoes", daoEvolucao.lista());
			modelEvolucao.addAttribute("error", true);
			return "evolucao/lista";
		}
		daoEvolucao.altera(evolucao);
		return "redirect:listaEvolucoes?idPaciente="+idEvolucaoPaciente;
    }
	
    @RequestMapping("removeEvolucao")
    public String remove(Evolucao evolucao, long idEvolucaoPaciente) throws ClassNotFoundException {
    	daoEvolucao.remove(evolucao);
        return "redirect:listaEvolucoes?idPaciente="+idEvolucaoPaciente;
    }
    
    public Boolean EvolucaoHasFieldErrors(BindingResult result) {
    	if(result.hasFieldErrors("descricaoSubjetivo") ||result.hasFieldErrors("descricaoObjetivo") || 
			result.hasFieldErrors("descricaoImpressao") || result.hasFieldErrors("descricaoConduta") || 
			result.hasFieldErrors("descricaoCondigodiagnostico")
    	) {
			return true;
		}
    	return false;
    }
}