<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:import url="/WEB-INF/views/principal/cabecalho.jsp"/>
<c:import url="/WEB-INF/views/principal/checklist.jsp"/>
<style>
.containerComentaio {
 	margin: 0 auto;
  border: 1px solid #dedede;
  background-color: #f1f1f1;
  border-radius: 5px;
  padding: 10px;
  margin: 10px 0;
  border-color: #ccc;
  background-color: #eee;
}

.time-right {
  float: right;
  color: #aaa;
}
</style>


<script type="text/javascript">

function modalRegistrarClick() {
	document.getElementById("linkRegistrar").click()
}
</script>


<c:set var="teste" value="${usuario.id}"/>

<div class="panel panel-default" >			
	<div class="panel-heading" >
		<h4>Cadastrar Comentários Caso Clínico - ${caso.identificacao}</h4>
		<h5>Aluno: ${usuario.nome}</h5>
		
	</div>
	 
	<!-- /.panel-heading -->
	<div class="panel-body">
		
		<a href="#" id="linkRegistrar" data-toggle="modal" data-target="#modalAddComentaio${paciente.id}"><button type="button" class="btn btn-primary">Adicionar Comentário</button></a>
		<a href="listaPacientesCaso?idCaso=${caso.id}"><button type="button" class="btn btn-info">Voltar</button></a>
		<br/>
		<br/>
		
		
		<div class="panel panel-default">
		  <div class="panel-heading">Lista de Comentários</div>
		  <div class="panel-body">
			  <c:if test="${listaComentarios.size() == 0}">
					Nenhum Comentário.
				</c:if>
				<c:if test="${listaComentarios.size() > 0}">
					<c:forEach var="comentario" items="${listaComentarios}">
						<div class="containerComentaio">
						  <p>${comentario.descricaoComentario}</p>
						</div>
	   			</c:forEach>
	 			</c:if>
		  </div>
		</div>
		
		<c:if test="${teste == 0}">
			Nenhum registro 
		</c:if>		   	
		<c:if test="${teste > 0}">
			<ul class="nav nav-tabs nav-justified">
				<li class="active"><a href="#fluxo24hs${paciente.id}" data-toggle="tab">Fluxo 24hs</a></li>
				<li><a href="#evolucao${paciente.id}" data-toggle="tab">Evolução</a></li>
				<li><a href="#anamnese${paciente.id}"	data-toggle="tab">Anamnese</a></li>
			</ul>

			<div class="tab-content">
				<div class="tab-pane fade in active" id="fluxo24hs${paciente.id}">
					<br/>
					<c:if test="${listaFluxo24hs.size() == 0}">
						Nenhum Fluxo 24 Horas criado
					</c:if>
					<c:if test="${listaFluxo24hs.size() > 0}">
						<c:forEach var="fluxo24hs" items="${listaFluxo24hs}">
								<div class="col-md-12">
									<div class="panel panel-default">
										<div class="table-responsive">
											<table class="table table-hover">
										    <tr> 
										    	<th>#</th>
										    	<th>Data Hora</th>
										    	<th>PA</th>
										    	<th>FC</th>
										    	<th>FR</th>
										    	<th>TAX</th>
										    	<th>DOR</th>
										    	<th>SAT</th>
										    	<th>PVC</th>
										    	<th>HGT</th>
										    	<th>Administrados</th>
										    	<th>Eliminados</th>
										    	<th>Administrados</th>
										    </tr>
										    <tr> 
										    	<td>${fluxo24hs.cod}</td>
										    	<td><small><fmt:formatDate value="${fluxo24hs.dataHora.time}" pattern="dd/MM/yyyy HH:mm:ss"/></small></td>
										    	<td>${fluxo24hs.pa}</td>
										    	<td>${fluxo24hs.fc}</td>
										    	<td>${fluxo24hs.fr}</td>
										    	<td>${fluxo24hs.tax}</td>
													<td>${fluxo24hs.dor}</td>
													<td>${fluxo24hs.sat}</td>
													<td>${fluxo24hs.pvc}</td>
													<td>${fluxo24hs.hgt}</td>
													<td><textarea class="form-control" rows="2" disabled>${fluxo24hs.administrados}</textarea></td>
													<td><textarea class="form-control" rows="2" disabled>${fluxo24hs.eliminados}</textarea></td>
													<td><textarea class="form-control" rows="2" disabled>${fluxo24hs.observacoes}</textarea></td>
										    </tr>
										  </table>
										</div>
									</div>
								</div>
						</c:forEach>
					</c:if>
				</div>
				<div class="tab-pane fade" id="evolucao${paciente.id}">
					<br/>
					<c:if test="${listaEvolucoes.size() == 0}">
						Nenhuma evolução criar
					</c:if>
					<c:if test="${listaEvolucoes.size() > 0}">
						<c:forEach var="evolucao" items="${listaEvolucoes}">
							<div class="col-md-12">
									<div class="panel panel-default">
										<div class="table-responsive">
											<table class="table table-hover">
										    <tr> 
										    	<th>Data Hora</th>
										    	<th>Descrição Subjetivo</th>
										    	<th>Descrição Objetivo</th>
										    	<th>Descrição Impressao</th>
										    	<th>Descrição Conduta</th>
										    	<th>Descrição Condigodiagnostico</th>
										    </tr>
										    <tr> 
										    	<td><small><fmt:formatDate value="${evolucao.dataHora.time}" pattern="dd/MM/yyyy HH:mm:ss" /></small></td>
										    	<td><textarea class="form-control" rows="2" disabled>${evolucao.descricaoSubjetivo}</textarea></td>
										    	<td><textarea class="form-control" rows="2" disabled>${evolucao.descricaoObjetivo}</textarea></td>
										    	<td><textarea class="form-control" rows="2" disabled>${evolucao.descricaoImpressao}</textarea></td>
										    	<td><textarea class="form-control" rows="2" disabled>${evolucao.descricaoConduta}</textarea></td>
										    	<td><textarea class="form-control" rows="2" disabled>${evolucao.descricaoCondigodiagnostico}</textarea></td>
												</tr>
										  </table>
									  </div>
									</div>	
								</div>
							</c:forEach>
						</c:if>
				</div>
				<div class="tab-pane fade" id="anamnese${paciente.id}">
					<br/>
					<div class="col-md-8">
						<div class="panel panel-default">
						  <div class="panel-body">
						  	<div>Anamnese: ${paciente.id}</div><br/>
						  </div>
					  </div>
					</div>
				</div>
			</div>
			<div class="modal fade" id="modalAddComentaio${paciente.id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header" style="background-color:#ddd">
						<button type="button" class="close" data-dismiss="modal"	aria-hidden="true">&times;</button>
						<h5>	Adicionar Comentário </h5>
					</div>
					<div class="modal-body">
							<form	role="form" action="adicionarComentario?idPaciente=${paciente.id}&idUsuarioCreadorCaso=${caso.idCasoUsuario}"	method="post">
								<div class="form-group">
									<input class="form-control"  type="hidden" name="idComentarioPaciente" value="${paciente.id}">
									<textarea class="form-control"	name="descricaoComentario" rows="2">${comentario.descricaoComentario}</textarea>
									<br/>
								</div>
								<div class="action-buttons">
									<input type="submit" class="btn btn-primary" style="margin-right:3px;" value="Adicionar Comentário">
									<button type="button" class="btn btn-info"	data-dismiss="modal">voltar</button>
								</div>
							</form>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
			<!-- /.modal -->
		</c:if>
		
		
	</div>
</div>


<c:import url="/WEB-INF/views/principal/rodape.jsp"/>  