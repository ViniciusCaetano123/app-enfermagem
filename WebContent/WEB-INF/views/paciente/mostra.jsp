<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:import url="/WEB-INF/views/principal/cabecalho.jsp" />
<c:import url="/WEB-INF/views/principal/checklist.jsp" />


<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3>Anamnese</h3>
			</div>
			<div class="panel-body">
				<div class="identificacao">
					<h5>Criador: ${usuarioCreador.nome}</h5>
					<br />
				</div>
				<div class="row">
					<div class="col-md-12">
						<form role="form" action="alteraPaciente" method="post">
							<div class="form-group">
								<div class="row">
									<div class="col-md-12">
										<div class="panel panel-default">
											<div class="panel-heading">
												<span>Identificação</span>
											</div>
											<div class="panel-body">
												<input type="hidden" name="id" value="${paciente.id}" />
												<div class="row">
													<div class="col-md-6">
														<div class="input-group">
														  <span class="input-group-addon">Nome</span>
														  <input class="form-control" type="text" name="nome" disabled value="${caso.identificacao}">
														</div>
													</div>
													<div class="col-md-6">
														<div class="input-group">
														  <span class="input-group-addon">Informante</span>
														  <input class="form-control" type="text" name="informante" value="${paciente.informante}">
														</div>
													</div>
												</div>
												<br/>
												
												<div class="row">
													<div class="col-md-3">
														<div class="input-group">
														  <span class="input-group-addon">Sexo</span>
														  <select class="form-control" name="sexo">
														    <option value="0" <c:if test="${paciente.sexo == 0}">selected</c:if>>Selecionar</option>
														    <option value="1" <c:if test="${paciente.sexo == 1}">selected</c:if>>Masculino</option>
													    	<option value="2" <c:if test="${paciente.sexo == 2}">selected</c:if>>Feminino</option>
													  	</select>
														</div>
													</div>
													<div class="col-md-3">
														<div class="input-group">
														  <span class="input-group-addon">Estado Civil</span>
															<select class="form-control" name="estadoCivil">
														    <option value="0" <c:if test="${paciente.estadoCivil == 0}">selected</c:if>>Selecionar</option>
														    <option value="1" <c:if test="${paciente.estadoCivil == 1}">selected</c:if>>Solteiro(a)</option>
													    	<option value="2" <c:if test="${paciente.estadoCivil == 2}">selected</c:if>>Casado(a)</option>
													    	<option value="3" <c:if test="${paciente.estadoCivil == 3}">selected</c:if>>Separado(a)</option>
													    	<option value="4" <c:if test="${paciente.estadoCivil == 4}">selected</c:if>>Divorciado(a)</option>
													    	<option value="5" <c:if test="${paciente.estadoCivil == 5}">selected</c:if>>Viúvo(a)</option>
													  	</select>
														</div>
													</div>
													<div class="col-md-3">
														<div class="input-group">
														  <span class="input-group-addon">Nascimento</span>
															<input class="form-control" type="text" name="dataNascimento" value="<fmt:formatDate value="${paciente.dataNascimento.time}" pattern="dd/MM/yyyy" />">
														</div>
													</div>
													<div class="col-md-3">
														<div class="input-group">
														  <span class="input-group-addon">Idade</span>
															<input class="form-control"	type="text" name="idade"	value="Calcular data!">
														</div>
													</div>
												</div>
												<br/>
												
												<div class="row">
													<div class="col-md-3">
														<div class="input-group">
														  <span class="input-group-addon">N° filhos</span>
															<input class="form-control"	type="text" name="quantidadeFilhos"	value="${paciente.quantidadeFilhos}">
														</div>
													</div>
													<div class="col-md-3">
														<div class="input-group">
														  <span class="input-group-addon">Profissão</span>
															<input class="form-control" type="text" name="profissao" value="${paciente.profissao}">
														</div>
													</div>
													<div class="col-md-3">
														<div class="input-group">
														  <span class="input-group-addon">Endereco</span>
															<input class="form-control" type="text"	name="endereco" value="${paciente.endereco}">
														</div>
													</div>
													<div class="col-md-3">
														<div class="input-group">
														  <span class="input-group-addon">Naturalidade</span>
															<input class="form-control" type="text"	name="naturalidade" value="${paciente.naturalidade}">
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							
								<div class="row">
									<div class="col-md-12">
										<div class="panel panel-default">
											<div class="panel-heading">
												<span>Queixa e Histórico</span>
											</div>
											<div class="panel-body">
												<ul class="nav nav-tabs">
													<li class="active"><a href="#queixaPrincipal${paciente.id}"	data-toggle="tab">Queixa Principal</a></li>
													<li><a href="#historicoDoencaAtual${paciente.id}" data-toggle="tab">Histórico da Doença Atual</a></li>
													<li><a href="#historicoFamiliar${paciente.id}" data-toggle="tab">Histórico Familiar</a></li>
												</ul>
												<div class="row">
													<div class="col-md-12">
														<div class="tab-content">
															<div class="tab-pane fade in active" id="queixaPrincipal${paciente.id}">
																<br/>
																<div class="col-md-12">
																	<div class="input-group">
																	  <span class="input-group-addon">Motivo da Internação</span>
																	  <textarea class="form-control" name="motivoInternacao"	rows="2">${paciente.motivoInternacao}</textarea>
																	</div>
																	<br/>
																	<div class="input-group">
																	  <span class="input-group-addon">Diagnóstico Médico - SID (Se hover)</span>
																	  <textarea class="form-control" name="diagnosticoMedico"	rows="1">${paciente.diagnosticoMedico}</textarea>
																	</div>
																</div>
															</div>
															<div class="tab-pane fade" id="historicoDoencaAtual${paciente.id}">
																<br/>
																<div class="col-md-12">
																	<div class="input-group">
																	  <span class="input-group-addon">Descrição</span>
																	  <textarea class="form-control" name="historicoDoencaAtual"	rows="2">${paciente.historicoDoencaAtual}</textarea>
																	</div>
																</div>
															</div>
															<div class="tab-pane fade" id="historicoFamiliar${paciente.id}">
																<br/>
																<div class="col-md-12">
																	<div class="input-group">
																		<span class="input-group-addon">Descrição</span>
																	  <textarea class="form-control" name="historicoFamiliar"	rows="2">${paciente.historicoFamiliar}</textarea>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								
								<div class="row">
									<div class="col-md-12">
										<div class="panel panel-default">
											<div class="panel-heading">
												<span>Histórico de Doença Pregressa</span>
											</div>
											<div class="panel-body">
												<div class="row">
													<div class="col-md-6">
														<div class="input-group">
														  <span class="input-group-addon">Doenças</span>
														  <select class="form-control" name="doenca">
														    <option value="0" <c:if test="${paciente.doenca == 0}">selected</c:if>>Selecionar</option>
														    <option value="1" <c:if test="${paciente.doenca == 1}">selected</c:if>>Graves</option>
													    	<option value="2" <c:if test="${paciente.doenca == 2}">selected</c:if>>Crônicas</option>
													  	</select>
													  	<span class="input-group-addon" style="width:0px; padding-left:0px; padding-right:0px; border:none;"></span>
													  	<textarea class="form-control" rows="1" name="doencaObs" placeholder="Obs">${paciente.doencaObs}</textarea>
														</div>
													</div>
													<div class="col-md-6">
														<div class="input-group">
														  <span class="input-group-addon">Medicamento Uso Domiciliar</span>
														  <textarea class="form-control" name="medicamentoUsoDomiciliar" rows="1">${paciente.medicamentoUsoDomiciliar}</textarea>
														</div>
													</div>
												</div>
												<br/>
												
												<div class="row">
													<div class="col-md-6">
														<div class="input-group">
														  <span class="input-group-addon">Doenças na Infância</span>
														  <textarea class="form-control" name="doencasInfancia" rows="1">${paciente.doencasInfancia}</textarea>
														</div>
													</div>
													<div class="col-md-6">
														<div class="input-group">
														  <span class="input-group-addon">Tratamentos Anteriores</span>
														  <textarea class="form-control" name="tratamentosAnteriores"	rows="1">${paciente.tratamentosAnteriores}</textarea>
														</div>
													</div>
												</div>
												<br/>
												
												<div class="row">
													<div class="col-md-6">
														<div class="input-group">
														  <span class="input-group-addon">Internações Anteriores</span>
														  <textarea class="form-control" name="internacoesAnteriores"	rows="1">${paciente.internacoesAnteriores}</textarea>
														</div>
													</div>
													<div class="col-md-6">
														<div class="input-group">
														  <span class="input-group-addon">Cirurgias</span>
														  <textarea class="form-control" name="cirurgias" rows="1">${paciente.cirurgias}</textarea>
														</div>
													</div>
												</div>
												<br/>
												
												<div class="row">
													<div class="col-md-12">
														<div class="well well-sm">Alergias</div>
												  	<div class="col-md-4">
												  		<div class="input-group">
													  		<span class="input-group-addon">Medicamentos</span>
															  <textarea class="form-control" name="alergiasMedicamentos"	rows="1">${paciente.alergiasMedicamentos}</textarea>
															</div>
												  	</div>
												  	<div class="col-md-4">
											  		 <div class="input-group">
														  	<span class="input-group-addon">Alimentares</span>
															  <textarea class="form-control" name="alergiasAlimentar"	rows="1">${paciente.alergiasAlimentar}</textarea>
															</div>
												  	</div>
												  	<div class="col-md-4">
											  		 <div class="input-group">
														  	<span class="input-group-addon">Outras</span>
															  <textarea class="form-control" name="alergiasOutras"	rows="1">${paciente.alergiasOutras}</textarea>
															</div>
												  	</div>
													</div>
												</div>
												<br/>
												
												<div class="row">	
													<div class="col-md-12">
														<div class="well well-sm">Histórico Obstétrico</div>
												  	<div class="col-md-4">
												  		<div class="input-group">
														  	<span class="input-group-addon">Gesta</span>
														  	<input class="form-control" type="text"	name="historicoObstetricaGesta"	value="${paciente.historicoObstetricaGesta}">
														  </div>
												  	</div>
												  	<div class="col-md-4">
												  		<div class="input-group">
												  			<span class="input-group-addon">Para</span>
														  	<input class="form-control" type="text"	name="historicoObstetricaPara"	value="${paciente.historicoObstetricaPara}">
												  		</div>
												  	</div>
												  	<div class="col-md-4">
												  		<div class="input-group">
												  			<span class="input-group-addon">Aborto</span>
														  	<input class="form-control" type="text"	name="historicoObstetricaAborto"	value="${paciente.historicoObstetricaAborto}">
												  		</div>
												  	</div>
														</div>
													</div>
											</div>
										</div>
									</div>
								</div>
	
								<div class="row">
									<div class="col-md-12">
										<div class="panel panel-default">
											<div class="panel-heading">
												<span>Histório Psicossocial/Hábitos</span>
											</div>
											<div class="panel-body">
												<div class="row">
													<div class="col-md-12">
														<div class="well well-sm">Fatores de Risco</div>
														<div class="col-md-6">
															<div class="input-group">
															  <span class="input-group-addon">Fumante</span>
															  <select class="form-control" name="fumante">
															    <option value="0" <c:if test="${paciente.fumante == 0}">selected</c:if>>Selecionar</option>
															    <option value="1" <c:if test="${paciente.fumante == 1}">selected</c:if>>Sim</option>
														    	<option value="2" <c:if test="${paciente.fumante == 2}">selected</c:if>>Não</option>
														  	</select>
														  	<span class="input-group-addon" style="width:0px; padding-left:0px; padding-right:0px; border:none;"></span>
														  	<textarea class="form-control" rows="1" name="fumanteObs" placeholder="Obs">${paciente.fumanteObs}</textarea>
															</div>
														</div>
														<div class="col-md-6">
															<div class="input-group">
															  <span class="input-group-addon">Uso de Álcool</span>
															  <select class="form-control" name="usoAlcool">
															    <option value="0" <c:if test="${paciente.usoAlcool == 0}">selected</c:if>>Selecionar</option>
															    <option value="1" <c:if test="${paciente.usoAlcool == 1}">selected</c:if>>Sim</option>
														    	<option value="2" <c:if test="${paciente.usoAlcool == 2}">selected</c:if>>Não</option>
														  	</select>
														  	<span class="input-group-addon" style="width:0px; padding-left:0px; padding-right:0px; border:none;"></span>
														  	<textarea class="form-control" name="usoAlcoolObs" rows="1" placeholder="Obs">${paciente.usoAlcoolObs}</textarea>
															</div>
														</div>
													</div>
												</div>
												<br/>
												
												<div class="row">
													<div class="col-md-12">
														<div class="col-md-6">
																<div class="input-group">
																  <span class="input-group-addon">Uso de Drogas</span>
																  <select class="form-control" name="usoDrogas">
																    <option value="0" <c:if test="${paciente.usoDrogas == 0}">selected</c:if>>Selecionar</option>
																    <option value="1" <c:if test="${paciente.usoDrogas == 1}">selected</c:if>>Sim</option>
															    	<option value="2" <c:if test="${paciente.usoDrogas == 2}">selected</c:if>>Não</option>
															  	</select>
															  	<span class="input-group-addon" style="width:0px; padding-left:0px; padding-right:0px; border:none;"></span>
															  	<textarea class="form-control" name="usoDrogasObs" rows="1" placeholder="Obs">${paciente.usoDrogasObs}</textarea>
															  </div>
															</div>
														<div class="col-md-6">
															<div class="input-group">
															  <span class="input-group-addon">Histórico de Câncer</span>
														  	<select class="form-control" name="historicoCancer">
															    <option value="0" <c:if test="${paciente.historicoCancer == 0}">selected</c:if>>Selecionar</option>
															    <option value="1" <c:if test="${paciente.historicoCancer == 1}">selected</c:if>>Sim</option>
														    	<option value="2" <c:if test="${paciente.historicoCancer == 2}">selected</c:if>>Não</option>
														  	</select>
														  	<span class="input-group-addon" style="width:0px; padding-left:0px; padding-right:0px; border:none;"></span>
														  	<textarea class="form-control" name="historicoCancerObs" rows="1" placeholder="Obs">${paciente.historicoCancerObs}</textarea>
														  </div>
													</div>
													</div>
												</div>
												<br/>
												
												<div class="row">
													<div class="col-md-12">
														<div class="well well-sm">Necessidades Humanas Básicas</div>
														<div class="col-md-6">
															<div class="input-group">
														  	<span class="input-group-addon">Condição Moradia</span>
																<select class="form-control" name="condicaoMoradia">
															    <option value="0" <c:if test="${paciente.condicaoMoradia == 0}">selected</c:if>>Selecionar</option>
															    <option value="1" <c:if test="${paciente.condicaoMoradia == 1}">selected</c:if>>Área Urbana</option>
														    	<option value="2" <c:if test="${paciente.condicaoMoradia == 2}">selected</c:if>>Área Rural</option>
														    	<option value="3" <c:if test="${paciente.condicaoMoradia == 3}">selected</c:if>>Casa</option>
														    	<option value="4" <c:if test="${paciente.condicaoMoradia == 4}">selected</c:if>>Apartamento</option>
														  	</select>
													  		<span class="input-group-addon" style="width:0px; padding-left:0px; padding-right:0px; border:none;"></span>
													  		<textarea class="form-control" name="condicaoMoradiaObs" rows="1" placeholder="Obs">${paciente.condicaoMoradiaObs}</textarea>
															</div>
														</div>
														<div class="col-md-6">
															<div class="input-group">
																<span class="input-group-addon">Saneamento Básico</span>
														  	<select class="form-control" name="saneamentoBasico">
															    <option value="0" <c:if test="${paciente.saneamentoBasico == 0}">selected</c:if>>Selecionar</option>
															    <option value="1" <c:if test="${paciente.saneamentoBasico == 1}">selected</c:if>>Sim</option>
														    	<option value="2" <c:if test="${paciente.saneamentoBasico == 2}">selected</c:if>>Não</option>
														  	</select>
														  	<span class="input-group-addon" style="width:0px; padding-left:0px; padding-right:0px; border:none;"></span>
														  	<textarea class="form-control" name="saneamentoBasicoObs" rows="1" placeholder="Obs">${paciente.saneamentoBasicoObs}</textarea>
															</div>
														</div>
													</div>
												</div>
												<br/>
												
												<div class="row">
													<div class="col-md-12">
														<div class="col-md-6">
															<div class="input-group">
																<span class="input-group-addon">Realiza atividade física</span>
														  	<select class="form-control" name="atividadeFisica">
															    <option value="0" <c:if test="${paciente.atividadeFisica == 0}">selected</c:if>>Selecionar</option>
															    <option value="1" <c:if test="${paciente.atividadeFisica == 1}">selected</c:if>>Sim</option>
														    	<option value="2" <c:if test="${paciente.atividadeFisica == 2}">selected</c:if>>Não</option>
														  	</select>
															</div>
														</div>
														<div class="col-md-6">
															<div class="input-group">
																<span class="input-group-addon">Quantas vezes por semana</span>
														  	<input class="form-control"  name="atividadeFisicaQtde" value="${paciente.atividadeFisicaQtde}">
														  	<span class="input-group-addon" style="width:0px; padding-left:0px; padding-right:0px; border:none;"></span>
														  	<textarea class="form-control" name="atividadeFisicaObs" rows="1" placeholder="Tipo">${paciente.atividadeFisicaObs}</textarea>
															</div>
														</div>
													</div>
												</div>
												<br/>
												
												<div class="row">
													<div class="col-md-12">
														<div class="col-md-6">
															<div class="input-group">
																<span class="input-group-addon">Sono e Repouso</span>
														  	<select class="form-control" name="sonoRepouso">
															    <option value="0" <c:if test="${paciente.sonoRepouso == 0}">selected</c:if>>Selecionar</option>
															    <option value="1" <c:if test="${paciente.sonoRepouso == 1}">selected</c:if>>Nao tem insonia</option>
														    	<option value="2" <c:if test="${paciente.sonoRepouso == 2}">selected</c:if>>Apresenta dificuldade em conciliar o sono</option>
														    	<option value="3" <c:if test="${paciente.sonoRepouso == 3}">selected</c:if>>Acorda	varias vezes anoite</option>
														    	<option value="4" <c:if test="${paciente.sonoRepouso == 4}">selected</c:if>>Sonolência</option>
														    	<option value="5" <c:if test="${paciente.sonoRepouso == 5}">selected</c:if>>Dorme durante o dia</option>
														  	</select>
													  	</div>
												  	</div>
												  	<div class="col-md-6">
															<div class="input-group">
																<span class="input-group-addon">Dormir Hs por noite</span>
														  	<input class="form-control" name="sonoRepousoHrs" value="${paciente.sonoRepousoHrs}">
																<span class="input-group-addon" style="width:0px; padding-left:0px; padding-right:0px; border:none;"></span>
														  	<textarea class="form-control" type="text" name="sonoRepousoHrsObs" rows="1" placeholder="Obs">${paciente.sonoRepousoHrsObs}</textarea>
															</div>
														</div>
												 	</div>
													</div>
												<br/>
												
												<div class="row">
												<div class="col-md-12">
													<div class="col-md-6">
														<div class="input-group">
															<span class="input-group-addon">Hábitos	Higiene Banho</span>
															<input class="form-control" type="text"	name="habitosHigieneBanho"	value="${paciente.habitosHigieneBanho}">
														</div>
													</div>
													<div class="col-md-6">
														<div class="input-group">
															<span class="input-group-addon">Hábitos Higiene Bucal</span>
															<input class="form-control" type="text"	name="habitosHigieneBucal"	value="${paciente.habitosHigieneBucal}">
															</div>
														</div>
													</div>
												</div>
												<br/>
												
												<div class="row">
													<div class="col-md-12">
														<div class="well well-sm">Hábitos Alimentares</div>
														<div class="col-md-3">
															<div class="input-group">
																<div class="input-group">
													      	<div class="checkbox">
																		<label> <input type="checkbox" name="frutasVerduras"	value="1"
																			<c:if test="${paciente.frutasVerduras == 1}">checked</c:if>>Frutas Verdura
																		</label>
																	</div>
													      	<div class="checkbox">
																		<label> <input type="checkbox" name="carneVermelha"	value="1"
																			<c:if test="${paciente.carneVermelha == 1}">checked</c:if>>Carne vermelha
																		</label>
																	</div>																	
														    </div>
															</div>
														</div>
														<div class="col-md-3">
															<div class="input-group">
																<div class="input-group">
																	<div class="checkbox">
																		<label> <input type="checkbox" name="peixe"	value="1"
																			<c:if test="${paciente.peixe == 1}">checked</c:if>>Peixe
																		</label>
																	</div>
													      	<div class="checkbox">
																		<label> <input type="checkbox" name="frangoSuco"	value="1"
																			<c:if test="${paciente.frangoSuco == 1}">checked</c:if>>Frango, suco
																		</label>
																	</div>
														    </div>
															</div>
														</div>
														<div class="col-md-3">
															<div class="input-group">
																<div class="input-group">
													      	<div class="checkbox">
																		<label> <input type="checkbox" name="agua"	value="1"
																			<c:if test="${paciente.agua == 1}">checked</c:if>>Agua
																		</label>
																	</div>
																	<div class="checkbox">
																		<label> <input type="checkbox" name="cafe"	value="1"
																			<c:if test="${paciente.cafe == 1}">checked</c:if>>Cafe
																		</label>
																	</div>
														    </div>
															</div>
														</div>
														<div class="col-md-3">
															<div class="input-group">
																<div class="input-group">
													      	<div class="checkbox">
																		<label> <input type="checkbox" name="leite"	value="1"
																			<c:if test="${paciente.leite == 1}">checked</c:if>>Leite
																		</label>
																	</div>
													      	<div class="checkbox">
																		<label> <input type="checkbox" name="fritura"	value="1"
																			<c:if test="${paciente.fritura == 1}">checked</c:if>>Fritura
																		</label>
																	</div>
														    </div>
															</div>
														</div>
													</div>
												</div>
												<br/>
												
												<div class="row">
													<div class="col-md-12">
														<div class="col-md-6">
															<div class="input-group">
																<span class="input-group-addon">Come quantas vezes por dia</span>
																<input class="form-control" type="text" name="comeQuantasVezesDia" value="${paciente.comeQuantasVezesDia}"/>
														  	<span class="input-group-addon" style="width:0px; padding-left:0px; padding-right:0px; border:none;"></span>
														  	<textarea class="form-control" rows="1" name="comeQuantasVezesDiaObs" placeholder="Obs">${paciente.comeQuantasVezesDiaObs}</textarea>
													  	</div>
												  	</div>
												  	<div class="col-md-6">
															<div class="input-group">
																<span class="input-group-addon">Equilíbrio Emocional</span>
																<textarea class="form-control" name="equilibrioEmocional"	rows="1">${paciente.equilibrioEmocional}</textarea>
															</div>
														</div>
												 	</div>
												</div>
												<br/>
												
												<div class="row">
													<div class="col-md-12">
														<div class="col-md-6">
															<div class="input-group">
															<span class="input-group-addon" >Eliminações Urinárias</span>
																<select class="form-control" name="eliminacoesUrinarias">
															    <option value="0" <c:if test="${paciente.eliminacoesUrinarias == 0}">selected</c:if>>Selecionar</option>
															    <option value="1" <c:if test="${paciente.eliminacoesUrinarias == 1}">selected</c:if>>Normais</option>
														    	<option value="2" <c:if test="${paciente.eliminacoesUrinarias == 2}">selected</c:if>>Alterações</option>
														  	</select>
														  	<span class="input-group-addon" style="width:0px; padding-left:0px; padding-right:0px; border:none;"></span>
														  	<textarea class="form-control" rows="1" name="eliminacoesUrinariasObs" placeholder="Obs">${paciente.eliminacoesUrinariasObs}</textarea>
															</div>
														</div>
														<div class="col-md-6">
															<div class="input-group">
																<span class="input-group-addon">Eliminaçoes Intestinais</span>
																<select class="form-control" name="eliminacoesIntestinais">
															    <option value="0" <c:if test="${paciente.eliminacoesIntestinais == 0}">selected</c:if>>Selecionar</option>
															    <option value="1" <c:if test="${paciente.eliminacoesIntestinais == 1}">selected</c:if>>Normal</option>
														    	<option value="2" <c:if test="${paciente.eliminacoesIntestinais == 2}">selected</c:if>>Constipação</option>
														    	<option value="3" <c:if test="${paciente.eliminacoesIntestinais == 3}">selected</c:if>>Diarreia</option>
														    	<option value="4" <c:if test="${paciente.eliminacoesIntestinais == 4}">selected</c:if>>Mudança de hábito</option>
														  	</select>
														  	<span class="input-group-addon" style="width:0px; padding-left:0px; padding-right:0px; border:none;"></span>
														  	<textarea class="form-control" name="eliminacoesIntestinaisObs" rows="1" placeholder="Obs">${paciente.eliminacoesIntestinaisObs}</textarea>
																</div>
															</div>
														</div>
												</div>
												<br/>
												
												<div class="row">
													<div class="col-md-12">
														<div class="col-md-6">
															<div class="input-group">
																<span class="input-group-addon">Atividade Sexual</span>
																<select class="form-control" name="atividadeSexual">
															    <option value="0" <c:if test="${paciente.atividadeSexual == 0}">selected</c:if>>Selecionar</option>
															    <option value="1" <c:if test="${paciente.atividadeSexual == 1}">selected</c:if>>Satisfatório</option>
														    	<option value="2" <c:if test="${paciente.atividadeSexual == 2}">selected</c:if>>Não satisfatório</option>
														    	<option value="3" <c:if test="${paciente.atividadeSexual == 3}">selected</c:if>>Não tem relacionamento sexual</option>
														  	</select>
													  	</div>
												  	</div>
												  	<div class="col-md-6">
															<div class="input-group">
																<span class="input-group-addon">Problemas de Saúde</span>
																<select class="form-control" name="problemaSaude">
															    <option value="0" <c:if test="${paciente.problemaSaude == 0}">selected</c:if>>Selecionar</option>
															    <option value="1" <c:if test="${paciente.problemaSaude == 1}">selected</c:if>>Demonstra conhecimento do problema</option>
														    	<option value="2" <c:if test="${paciente.problemaSaude == 2}">selected</c:if>>Demonstra pouco do problema</option>
														    	<option value="3" <c:if test="${paciente.problemaSaude == 3}">selected</c:if>>Tem dificuldade de entendimento</option>
														    	<option value="4" <c:if test="${paciente.problemaSaude == 4}">selected</c:if>>Não sabe sobre a doença e tratamento</option>
														    	<option value="5" <c:if test="${paciente.problemaSaude == 5}">selected</c:if>>Solicita informações</option>
														  	</select>
														  	<span class="input-group-addon" style="width:0px; padding-left:0px; padding-right:0px; border:none;"></span>
														  	<textarea class="form-control" name="problemaSaudeObs" rows="1" placeholder="Obs">${paciente.problemaSaudeObs}</textarea>
															</div>
														</div>
												 	</div>
													</div>
												<br/>
												
												<!-- 12 -->
												<div class="row">
													<div class="col-md-12">
														<div class="col-md-6">
															<div class="input-group">
																<span class="input-group-addon">Estado Nutricional</span>
																<select class="form-control" name="estadoNutricional">
															    <option value="0" <c:if test="${paciente.estadoNutricional == 0}">selected</c:if>>Selecionar</option>
															    <option value="1" <c:if test="${paciente.estadoNutricional == 1}">selected</c:if>>Normal</option>
														    	<option value="2" <c:if test="${paciente.estadoNutricional == 2}">selected</c:if>>Sobrepeso</option>
														    	<option value="3" <c:if test="${paciente.estadoNutricional == 3}">selected</c:if>>Desnutrido</option>
														    	<option value="4" <c:if test="${paciente.estadoNutricional == 4}">selected</c:if>>Relato	de perda provável</option>
														  	</select>
															</div>
														</div>
														<div class="col-md-6">
															<div class="input-group">
																<span class="input-group-addon">Peso</span>
																<input class="form-control" type="text"	name="peso"	value="${paciente.peso}">
																<span class="input-group-addon" style="width:0px; padding-left:0px; padding-right:0px; border:none;"></span>
																<span class="input-group-addon">Altura</span>
																<input class="form-control" type="text"	name="altura"	value="${paciente.altura}">
															</div>
														</div>
													</div>
												</div>
												<br/>
											</div>
										</div>
									</div>
								</div>
							
								<div class="row">
									<div class="col-md-12">
										<div class="panel panel-default">
											<div class="panel-heading">
												<span>Sinais Vitais</span>
											</div>
											<div class="panel-body">
												<div class="row">
													<div class="col-md-12">
														<div class="row">
															<div class="col-md-9">
																<div class="input-group">
																	<span class="input-group-addon">Dor</span>
																  <select class="form-control"  name="sinaisVitaisDor">
																    <option value="0" <c:if test="${paciente.sinaisVitaisDor == 0}">selected</c:if>>Selecionar</option>
																    <option value="1" <c:if test="${paciente.sinaisVitaisDor == 1}">selected</c:if>>0-1 Sem dor</option>
															    	<option value="2" <c:if test="${paciente.sinaisVitaisDor == 2}">selected</c:if>>2-3 Dor Suave</option>
															    	<option value="3" <c:if test="${paciente.sinaisVitaisDor == 3}">selected</c:if>>4-5-6 Dor moderada</option>
															    	<option value="4" <c:if test="${paciente.sinaisVitaisDor == 4}">selected</c:if>>7-8 Dor intensa</option>
															    	<option value="5" <c:if test="${paciente.sinaisVitaisDor == 5}">selected</c:if>>9-10 Dor insuportável</option>
															  	</select>
															  	<span class="input-group-addon" style="width:0px; padding-left:0px; padding-right:0px; border:none;"></span>
																	<textarea class="form-control" name="sinaisVitaisDorObs" rows="1" placeholder="Obs">${paciente.sinaisVitaisDorObs}</textarea>
																</div>
															</div>
															<div class="col-md-3">
																<div class="input-group">
																	<span class="input-group-addon">FR</span>
																	<input class="form-control"	name="sinaisVitaisFR" value="${paciente.sinaisVitaisFR}">
																</div>
															</div>
														</div>
														<br/>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12">
														<div class="row">
															<div class="col-md-3">
																<div class="input-group">
																	<span class="input-group-addon">FC/PULSO</span>
																	<input class="form-control"	name="sinaisVitaisFCPULSO" value="${paciente.sinaisVitaisFCPULSO}">
																</div>
															</div>
															<div class="col-md-3">
																<div class="input-group">
																	<span class="input-group-addon">SAT</span>
																	<input class="form-control"	name="sinaisVitaisSAT" value="${paciente.sinaisVitaisSAT}">
																</div>
															</div>
															<div class="col-md-3">
																<div class="input-group">
																	<span class="input-group-addon">PA</span>
																	<input class="form-control"	name="sinaisVitaisPA" value="${paciente.sinaisVitaisPA}">
																</div>
															</div>
															<div class="col-md-3">
																<div class="input-group">
																	<span class="input-group-addon">TEMP</span>
																	<input class="form-control"	name="sinaisVitaisTemp" value="${paciente.sinaisVitaisTemp}">
																</div>
															</div>
														</div>
														<br/>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<a ><button type="submit" class="btn btn-primary">Salvar</button></a>
							<a href="listaTratamento?idPaciente=${paciente.id}"><button type="button" class="btn btn-info">Voltar</button></a>
							<br />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<c:import url="/WEB-INF/views/principal/rodape.jsp" />
