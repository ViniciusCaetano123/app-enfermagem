<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:import url="/WEB-INF/views/principal/cabecalho.jsp"/>
<c:import url="/WEB-INF/views/principal/checklist.jsp"/>

<style>
	td {white-space:pre-wrap; word-wrap:break-word; word-break:break-all;}
	.inner-headers h5 {float:left; padding:2px 15px 0 0 ; margin:0;}
	.inner-headers i {padding-left:10px; }		
</style>

<div class="panel panel-default">
	<div class="panel-heading">
		<h4>Fluxo 24 Horas </h4>
	</div>
	<div class="panel-body">
		<div class="inner_tables">
			<h5>Caso Clínico: ${caso.identificacao}</h5>
			<h5>Criado Por: ${usuarioCreador.nome}</h5>
			<a href="novoFluxo24h?idPaciente=${paciente.id}"><button type="button" class="btn btn-primary">Cadastrar Fluxo 24h</button></a>
			<a href="listaTratamento?idPaciente=${paciente.id}"><button type="button" class="btn btn-info">Voltar</button></a>
			<br/>
			<br/>
			<c:forEach items="${fluxos24h}" var="fluxo24h">
			
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="inner-headers">
							<h5><fmt:formatDate value="${fluxo24h.dataHora.time}" pattern="dd/MM/yyyy HH:mm:ss" /></h5>
							<a href="mostraFluxo24h?idFluxo24h=${fluxo24h.id}&idPaciente=${paciente.id}" title="Alterar"><i class="glyphicon glyphicon-edit"></i></a>
							<a href="removeFluxo24h?id=${fluxo24h.id}&idFluxo24hPaciente=${fluxo24h.idFluxo24hPaciente}" title="Excluir"><i class="fa fa-trash-o"></i></a>
						</div>
					</div>
					<div class="table-responsive">
						<table class="table table-bordered table-hover" id="pequeno">
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
									<th>Aministrados</th>
									<th>Eliminados</th>
									<th>Observações</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>${fluxo24h.cod}</td>
									<td>${fluxo24h.pa}</td>
									<td>${fluxo24h.fc}</td>
									<td>${fluxo24h.fr}</td>
									<td>${fluxo24h.tax}</td>
									<td>${fluxo24h.dor}</td>
									<td>${fluxo24h.sat}</td>
									<td>${fluxo24h.pvc}</td>
									<td>${fluxo24h.hgt}</td>
									<td>${fluxo24h.administrados}</td>
									<td>${fluxo24h.eliminados}</td>
									<td>${fluxo24h.observacoes}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</c:forEach>
			<br/>
		</div>
	</div>
</div>	
<c:import url="/WEB-INF/views/principal/rodape.jsp"/>