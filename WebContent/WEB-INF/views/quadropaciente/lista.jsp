<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:import url="/WEB-INF/views/principal/cabecalho.jsp"/>
<c:import url="/WEB-INF/views/principal/checklist.jsp"/>
	<div class="panel panel-default">
		<div class="panel-heading">
	    	<h4>Quadro do Paciente</h4>
	  	</div>
		<div class="panel-body">
			<h5>Caso clínico: ${caso.identificacao}</h5>
			<br/>
		 	<a href="novoQuadropaciente?id=${caso.id}"><button type="button" class="btn btn-primary btn-sm">Inserir / Atualizar</button></a>
			<br /><br />                              
			<table class="table table-striped table-bordered table-hover" id="dataTables-example">
				<thead>
					<tr>
						<th>Status</th>
						<th>Data Hora da Atualização</th>
						<th>Quadro paciente</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody> 	
					<c:forEach items="${quadropacientes}" varStatus="contador" var="quadropaciente">
						<c:if test="${quadropaciente.idQuadropacienteCaso == caso.id}"> 
							<tr <c:if test="${contador.count > 1}">style="color: gray;"</c:if> >
								<td><c:if test="${contador.count == 1}">Quadro Atual</c:if><c:if test="${contador.count > 1}">Quadro Anterior</c:if></td>
								<td><fmt:formatDate value="${quadropaciente.dataHora.time}" pattern="dd/MM/yyyy HH:mm:ss" /></td>
								<td style=white-space:pre-wrap; word-wrap:break-word;><c:if test="${contador.count > 1} color: gray;"></c:if>${quadropaciente.descricao}</td>					
								<td><a href="mostraQuadropaciente?id=${quadropaciente.id}" title="Alterar quadro paciente"><span class="glyphicon glyphicon-edit"></span></a></td>
								<td><a href="removeQuadropaciente?id=${quadropaciente.id}&idCaso=${caso.id}" title="Excluir quadro paciente"><p class="fa fa-trash-o"></p></a></td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div> 
	</div>
<c:import url="/WEB-INF/views/principal/rodape.jsp"/>  