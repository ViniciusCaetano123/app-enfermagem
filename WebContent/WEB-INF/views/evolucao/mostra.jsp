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
			<div class="panel-heading">Alterar Evolução: ${evolucao.id}</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-lg-6">
						<form role="form"	action="alteraEvolucao?id=${evolucao.id}&idPaciente=${evolucao.idEvolucaoPaciente}"	method="post">
							<div class="form-group">

								<label for="Subjetivo">Subjetivo: </label>
								<textarea class="form-control" name="descricaoSubjetivo"
									rows="10">${evolucao.descricaoSubjetivo}</textarea>

								<label for="Subjetivo">Objetivo:</label>
								<textarea class="form-control" name="descricaoObjetivo"
									rows="10">${evolucao.descricaoObjetivo}</textarea>

								<label for="Impressao">Impressao:</label>
								<textarea class="form-control" name="descricaoImpressao"
									rows="10">${evolucao.descricaoImpressao}</textarea>

								<label for="Conduta">Conduta:</label>
								<textarea class="form-control" name="descricaoConduta" rows="10">${evolucao.descricaoConduta}</textarea>

								<label for="Conduta">Diagnostico:</label>
								<textarea class="form-control"
									name="descricaoCondigodiagnostico" rows="10">${evolucao.descricaoCondigodiagnostico}</textarea>

								<input type="hidden" name="idEvolucaoPaciente"
									value="${evolucao.idEvolucaoPaciente}">
							</div>
							<button type="submit" class="btn btn-default"
								style="margin-right: 3px;">Alterar</button>
							<a href="listaPrincipal"><button type="button"
									class="btn btn-info" style="margin-right: 3px;">voltar</button></a>
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
