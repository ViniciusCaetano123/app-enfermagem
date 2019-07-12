<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:import url="/WEB-INF/views/principal/cabecalho.jsp" />
<c:import url="/WEB-INF/views/principal/checklist.jsp" />
<style>
th:nth-child(1) {
	width: 25%;
}

td {
	white-space: pre-wrap;
	word-wrap: break-word;
	word-break: break-all;
}

.inner-headers h5 {
	float: left;
	padding: 2px 15px 0 0;
	margin: 0;
}

.inner-headers i {
	padding-left: 10px;
}
/*.table tbody tr:hover td, .table tbody tr:hover th {background-color:gray;}*/
</style>

<c:if test="${error}">
	<script type="text/javascript">
		this.onload = function() {
			modalEditarClick();
			modalRegistrarClick();
		};
		function modalEditarClick() {
			document.getElementById("linkEditar").click()
		};
		function modalRegistrarClick() {
			document.getElementById("linkRegistrar").click()
		}
	</script>

</c:if>

<div class="row">
	
</div>
<br/>
<div class="row">
	<div class="panel panel-default">
	<div class="panel-heading">
		<h4>Evoluções</h4>
	</div>
	<div class="panel-body">
		<div class="inner_tables">
			<h6>Caso clínico: ${usuarioCreador.nome}</h6>
			<h6>Criado por: ${caso.identificacao}</h6>
			<a href="novoEvolucao?idPaciente=${paciente.id}"><button type="button" class="btn btn-primary">registrar de evolução</button></a>
			<a href="listaTratamento?idPaciente=${paciente.id}"><button	type="button" class="btn btn-info"	style="margin-right: 3px;">voltar</button></a>
			<br/>
			<br/>
	
			<c:forEach items="${evolucoes}" var="evolucao">
				<c:if test="${evolucao.idEvolucaoPaciente == paciente.id}">
					<div class="panel panel-default">
						
						<div class="panel-heading">
							<div class="inner-headers">
								<h5>
									<fmt:formatDate value="${evolucao.dataHora.time}"
										pattern="dd/MM/yyyy HH:mm:ss" />
								</h5>
								<a href="#" id="linkEditar" title="Editar" data-toggle="modal" data-target="#modalEditarEvolucao${evolucao.id}"><i class="glyphicon glyphicon-edit" style="color: #333"></i></a>
								<a href="removeEvolucao?id=${evolucao.id}&idEvolucaoPaciente=${evolucao.idEvolucaoPaciente}"	title="Excluir"><i class="fa fa-trash-o"	style="color: #333"></i></a>
							</div>
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<!-- Nav tabs -->
							<ul class="nav nav-tabs">
								<li class="active"><a href="#home${evolucao.id}"	data-toggle="tab">Subjetivo</a></li>
								<li><a href="#profile${evolucao.id}" data-toggle="tab">Objetivo</a></li>
								<li><a href="#messages${evolucao.id}" data-toggle="tab">Impressão</a></li>
								<li><a href="#settings${evolucao.id}" data-toggle="tab">Conduta</a></li>
								<li><a href="#settingss${evolucao.id}" data-toggle="tab">Diagnóstico</a></li>
							</ul>
							<!-- Tab panes -->
							<div class="tab-content">
								<div class="tab-pane fade in active" id="home${evolucao.id}">
									<br/>
									<textarea class="form-control" rows="2" disabled style="background:white">	${evolucao.descricaoSubjetivo}	</textarea>
								</div>
								<div class="tab-pane fade" id="profile${evolucao.id}">
									<br/>
									<textarea class="form-control" rows="2" disabled style="background:white">	${evolucao.descricaoObjetivo}	</textarea>
								</div>
								<div class="tab-pane fade" id="messages${evolucao.id}">
									<br/>
									<textarea class="form-control" rows="2" disabled style="background:white">	${evolucao.descricaoImpressao}	</textarea>
								</div>
								<div class="tab-pane fade" id="settings${evolucao.id}">
									<br/>
									<textarea class="form-control" rows="2" disabled style="background:white">	${evolucao.descricaoConduta}	</textarea>
								</div>
								<div class="tab-pane fade" id="settingss${evolucao.id}">
									<br/>
									<textarea class="form-control" rows="2" disabled style="background:white"> ${evolucao.descricaoCondigodiagnostico} </textarea>
								</div>
							</div>
						</div>
						<!-- /.panel-body -->
						
						<div class="modal fade" id="modalEditarEvolucao${evolucao.id}"
							tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
							aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header" style="background-color:#ddd">
										<button type="button" class="close" data-dismiss="modal"	aria-hidden="true">&times;</button>
										<h5>	Alterar Evolução:	<fmt:formatDate value="${evolucao.dataHora.time}"	pattern="dd/MM/yyyy HH:mm:ss" />	</h5>
									</div>
									<div class="modal-body">
											<form role="form"	action="alteraEvolucao?id=${evolucao.id}&idEvolucaoPaciente=${evolucao.idEvolucaoPaciente}"	method="post">
												<h6>Caso clínico: ${usuarioCreador.nome}</h6>
												<h6>Criado por: ${caso.identificacao}</h6>
												<button type="submit" class="btn btn-primary"	style="margin-right: 3px;">alterar</button>
												<button type="button" class="btn btn-info"	data-dismiss="modal">voltar</button>
												</br>
												</br>
												<div class="form-group">
													<label for="Subjetivo">Subjetivo: </label>
													<textarea class="form-control" name="descricaoSubjetivo"	rows="2">${evolucao.descricaoSubjetivo}</textarea>
													<form:errors path="evolucao.descricaoSubjetivo"	cssStyle="color:#B71C1C" />
													<br/> 
													<label for="Subjetivo">Objetivo:</label>
													<textarea class="form-control" name="descricaoObjetivo"	rows="2">${evolucao.descricaoObjetivo}</textarea>
													<form:errors path="evolucao.descricaoObjetivo"	cssStyle="color:#B71C1C" />
													<br/>
													<label for="Impressao">Impressao:</label>
													<textarea class="form-control" name="descricaoImpressao"	rows="2">${evolucao.descricaoImpressao}</textarea>
													<form:errors path="evolucao.descricaoImpressao"	cssStyle="color:#B71C1C" />
													<br/>
													<label for="Conduta">Conduta:</label>
													<textarea class="form-control" name="descricaoConduta"	rows="2">${evolucao.descricaoConduta}</textarea>
													<form:errors path="evolucao.descricaoConduta"	cssStyle="color:#B71C1C" />
													<br/>
													<label for="Diagnosticos">Diagnostico:</label>
													<textarea class="form-control"	name="descricaoCondigodiagnostico" rows="2">${evolucao.descricaoCondigodiagnostico}</textarea>
													<form:errors path="evolucao.descricaoCondigodiagnostico"	cssStyle="color:#B71C1C" />
													<input type="hidden" name="idEvolucaoPaciente" value="${paciente.id}">
												</div>
											</form>
									</div>
								</div>
								<!-- /.modal-content -->
							</div>
							<!-- /.modal-dialog -->
						</div>
						<!-- /.modal -->
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>
</div>
</div>

<c:import url="/WEB-INF/views/principal/rodape.jsp" />
