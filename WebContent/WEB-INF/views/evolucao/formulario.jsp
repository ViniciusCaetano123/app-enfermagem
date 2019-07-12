<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:import url="/WEB-INF/views/principal/cabecalho.jsp" />
<c:import url="/WEB-INF/views/principal/checklist.jsp" />

<div class="row">
	<div class="col-lg-6">
		<div class="panel panel-default" >
			<div class="panel-heading" color:white">Registrar Evolução</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-lg-12">
						<form role="form" action="adicionaEvolucao" method="post">
							<h6>Caso clínico: ${usuarioCreador.nome}</h6>
							<h6>Criado por: ${caso.identificacao}</h6>
							<button type="submit" class="btn btn-primary"	style="margin-right: 3px;">registar</button>
							<a href="listaEvolucoes?idPaciente=${paciente.id}"><button	type="button" class="btn btn-info"	style="margin-right: 3px;">voltar</button></a>
							</br>
							</br>
							<div class="form-group">
								<input class="form-control" type="hidden" name="idEvolucaoPaciente" value="${paciente.id}" >
								<label for="Subjetivo">Subjetivo: </label>
								<textarea class="form-control" name="descricaoSubjetivo"	rows="2">${evolucao.descricaoSubjetivo}</textarea>
								<form:errors path="evolucao.descricaoSubjetivo"	cssStyle="color:#B71C1C"></form:errors>
								<br/>
								<label for="Subjetivo">Objetivo:</label>
								<textarea class="form-control" name="descricaoObjetivo"	rows="2">${evolucao.descricaoObjetivo}</textarea>
								<form:errors path="evolucao.descricaoObjetivo"	cssStyle="color:#B71C1C"></form:errors>
								<br/>
								<label for="Impressao">Impressão:</label>
								<textarea class="form-control" name="descricaoImpressao"	rows="2">${evolucao.descricaoImpressao}</textarea>
								<form:errors path="evolucao.descricaoImpressao"	cssStyle="color:#B71C1C"></form:errors>
								<br/>
								<label for="Conduta">Conduta:</label>
								<textarea class="form-control" name="descricaoConduta" rows="2">${evolucao.descricaoConduta}</textarea>
								<form:errors path="evolucao.descricaoConduta"	cssStyle="color:#B71C1C"></form:errors>
								<br/>
								<label for="Conduta">Diagnóstico:</label>
								<textarea class="form-control"	name="descricaoCondigodiagnostico" rows="2">${evolucao.descricaoCondigodiagnostico}</textarea>
								<form:errors path="evolucao.descricaoCondigodiagnostico"	cssStyle="color:#B71C1C"></form:errors>
							</div>
						</form>
					</div>
				</div>
				<!-- /.row (nested) -->
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>

<c:import url="/WEB-INF/views/principal/rodape.jsp" />
