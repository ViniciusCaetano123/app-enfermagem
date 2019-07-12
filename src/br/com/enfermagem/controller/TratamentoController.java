package br.com.enfermagem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.enfermagem.dao.PacienteDAO;
import br.com.enfermagem.dao.CasoDAO;
import br.com.enfermagem.dao.QuadropacienteDAO;
import br.com.enfermagem.dao.UsuarioDAO;
import br.com.enfermagem.model.Caso;
import br.com.enfermagem.model.Paciente;
import br.com.enfermagem.model.Usuario;



@Controller
public class TratamentoController {
	@Autowired
	PacienteDAO daoPaciente;
	
	@Autowired
	CasoDAO daoCaso;
	
	@Autowired
	QuadropacienteDAO daoQuadropaciente;
	
	@Autowired
	UsuarioDAO daoUsuario;

	@RequestMapping("listaTratamento")
	public String lista(long idPaciente, Model modelPaciente, Model modelQuadropaciente, Model modelCaso, Model modelUsuario) throws ClassNotFoundException{
		Paciente paciente = daoPaciente.buscaPorId(idPaciente);
		modelPaciente.addAttribute("paciente", paciente);

		Caso caso = daoCaso.buscaPorId(paciente.getIdPacienteCaso());
		modelCaso.addAttribute("caso", caso);

		Usuario usuarioLocado = daoUsuario.buscaPorId(paciente.getIdPacienteUsuario());
		modelUsuario.addAttribute("usuarioLogado", usuarioLocado);

		Usuario usuarioCreador = daoUsuario.buscaPorId(caso.getIdCasoUsuario());
		modelUsuario.addAttribute("usuarioCreador", usuarioCreador);

		modelQuadropaciente.addAttribute("quadroPaciente", daoQuadropaciente.selecionaPorId(caso.getId()));
		return "tratamento/lista";
	}
	
}
