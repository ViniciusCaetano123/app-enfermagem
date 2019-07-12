<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:import url="/WEB-INF/views/principal/cabecalho.jsp"/>
<c:import url="/WEB-INF/views/principal/checklist.jsp"/>

<style>
	.action-buttons input, a {margin-right:3px;}
</style>

<div class="panel panel-default">
	<div class="panel-heading">
 		<h4>Alterar Fluxo 24 Horas</h4>
 	</div>
 	
	<div class="panel-body">
		<form action="alteraFluxo24h" method="post">
			<h5>Caso Cl�nico: ${caso.identificacao}</h5>
			<h5>Criado Por: ${usuarioCreador.nome}</h5>
			<div class="action-buttons">
				<input type="submit" class="btn btn-primary" value="Alterar">
				<a href="listaFluxo24hs?idPaciente=${fluxo24h.idFluxo24hPaciente}"><button type="button" class="btn btn-info" >Voltar</button></a>
			</div>
			<br/>
			
			<div class="form-group">
				<div class="table-responsive">
					<table class="table table-bordered table-hover" id="dataTables-example">
						<thead>
							<tr>
								<th>#</th>
								<th>PA</th>
								<th>FC</th>
								<th>FR</th>
								<th>TAX</th>
								<th>DOR</th>
								<th>SAT</th>
								<th>PVC</th>
								<th>HGT</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									<input class="form-control" type="hidden" name="id" value="${fluxo24h.id}" />
									<input class="form-control" type="text" name="cod" value="${fluxo24h.cod}" >
									<form:errors path="fluxo24h.cod" cssStyle="color:#B71C1C"/><br />
								</td>
								<td>
									<input class="form-control" type="text" name="pa" value="${fluxo24h.pa}" >
									<form:errors path="fluxo24h.pa" cssStyle="color:#B71C1C"/><br />
								</td>
								<td>
									<input class="form-control" type="text" name="fc" value="${fluxo24h.fc}" >
									<form:errors path="fluxo24h.fc" cssStyle="color:#B71C1C"></form:errors><br />
								</td>
								<td>
									<input class="form-control" type="text" name="fr" value="${fluxo24h.fr}" >
									<form:errors path="fluxo24h.fr" cssStyle="color:#B71C1C"></form:errors><br />
								</td>
								<td>
									<input class="form-control" type="text" name="tax" value="${fluxo24h.tax}" >
									<form:errors path="fluxo24h.tax" cssStyle="color:#B71C1C"></form:errors><br />
								</td>
								<td>
									<input class="form-control" type="text" name="dor" value="${fluxo24h.dor}" >
									<form:errors path="fluxo24h.dor" cssStyle="color:#B71C1C"></form:errors><br />
								</td>
								<td>
									<input class="form-control" type="text" name="sat" value="${fluxo24h.sat}" >
									<form:errors path="fluxo24h.sat" cssStyle="color:#B71C1C"></form:errors><br />
								</td>
								<td>
									<input class="form-control" type="text" name="pvc" value="${fluxo24h.pvc}" >
									<form:errors path="fluxo24h.pvc" cssStyle="color:#B71C1C"></form:errors><br />
								</td>
								<td>
									<input class="form-control" type="text" name="hgt" value="${fluxo24h.hgt}" >
									<form:errors path="fluxo24h.hgt" cssStyle="color:#B71C1C"></form:errors><br />
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="table-responsive">
					<table class="table table-bordered table-hover" id="dataTables-example">
						<thead>
							<tr>
								<th>Aministrados</th>
								<th>Eliminados</th>
								<th>Observa��es</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									<textarea class="form-control" rows="2" name="administrados" >${fluxo24h.administrados}</textarea>
								</td>
								<td>
									<textarea class="form-control" rows="2" name="eliminados" >${fluxo24h.eliminados}</textarea>
								</td>
								<td>
								<textarea class="form-control" rows="2" name="observacoes" >${fluxo24h.observacoes}</textarea>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<input class="form-control" type="hidden" name="idFluxo24hPaciente" value="${fluxo24h.idFluxo24hPaciente}">
			</div>
		</form>
	</div>
</div>
<c:import url="/WEB-INF/views/principal/rodape.jsp"/>