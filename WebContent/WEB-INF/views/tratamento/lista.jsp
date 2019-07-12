<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:import url="/WEB-INF/views/principal/cabecalho.jsp"/>
<c:import url="/WEB-INF/views/principal/checklist.jsp"/>

	<style>
		.btn-primary {margin-right:5px;}
		#dtHora {white-space:pre-wrap; word-wrap:break-word;word-break:break-all;}
		th:nth-child(1) {width:25%;}
	</style>
	
		<div class="panel panel-default">
			<div class="panel-heading">
		    	<h4>Tratamento</h4>
		  	</div>
			<div class="panel-body">
				<div class="nome-caso">
					<h5>Caso Clínico: ${caso.identificacao}</h5>
					<h5>Criador: ${usuarioCreador.nome}</h5>
				</div>
				<br />
				<table class="table table-striped table-bordered table-hover" id="dataTables-example">	
					<thead>
						<tr>
							<th>Data Hora da Atualização</th>
							<th>Descrição</th>
						</tr>
					</thead>
					<tbody> 
						<c:forEach items="${quadroPaciente}" var="quadroPaciente">
							<tr>
								<td class="odd gradeX"><fmt:formatDate value="${quadroPaciente.dataHora.time}" pattern="dd/MM/yyyy HH:mm:ss" /></td>
								<td id="dtHora">${quadroPaciente.descricao}</td>
							</tr>
						</c:forEach>	 
					</tbody>
				</table>		
				<br />
				<div>
					<a href="mostraPaciente?idPaciente=${paciente.id}"><button type="button" class="btn btn-primary btn-sm">Anamnese</button></a>
					<a href="listaFluxo24hs?idPaciente=${paciente.id}"><button type="button" class="btn btn-primary btn-sm">Fluxo 24 Horas</button></a>
					<a href="listaEvolucoes?idPaciente=${paciente.id}"><button type="button" class="btn btn-primary btn-sm">Evolução</button></a>
				</div> 
			</div>
		</div>
	
<c:import url="/WEB-INF/views/principal/rodape.jsp"/> 