<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:import url="/WEB-INF/views/principal/cabecalho.jsp"/>
<c:import url="/WEB-INF/views/principal/checklist.jsp"/>

<style>
	.caso-buttons > * {margin-right:8px;}
	.paciente-buttons > * {margin-right:8px;}
</style>		
						
<c:forEach items="${usuarios}" var="usuario">
	<c:if test="${usuarioLogado.email == usuario.email}">
		<c:set var="idUsuario" value="${usuario.id}"/>
	</c:if>
</c:forEach>

<c:set var="caso" value="0"/>
<c:forEach items="${casos}" var="caso">
	<c:if test="${idUsuario == caso.idCasoUsuario}">
		<c:set var="idCaso" value="${caso.id}"/>
	</c:if>
</c:forEach>

<c:set var="idPaciente" value="0"/>
	<c:forEach items="${pacientes}" var="paciente">
		<c:if test="${idUsuario == paciente.idPacienteUsuario}">
			<c:set var="idPaciente" value="${paciente.id}"/>
		</c:if>
</c:forEach>

<div class="panel panel-default" >			
	<div class="panel-heading" >
		<h4>Meus Casos Clínicos</h4>
	</div>
	 
	<!-- /.panel-heading -->
	<div class="panel-body">
		<a href="novoCaso"><button type="button" class="btn btn-primary btn-sm">Criar Caso Clínico</button></a>
		<br /><br />
		<c:if test="${idCaso == 0}">
		Nenhum caso Clínico Criado
		</c:if>		   	
		<c:if test="${idCaso > 0}">
		    <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
		    	<thead>
		            <tr>
						<th>Identificação</th>
						<th>Code</th>
						<th></th>
		            </tr>
		      	</thead>
			  	<tbody>                           
			  	<c:forEach items="${casos}" var="caso">
				   	<c:if test="${idUsuario == caso.idCasoUsuario}">
						<tr class="odd gradeX">
							<td>${caso.identificacao}</td>
							<td><code style="background-color: transparent; color:#353535">${caso.code}</code></td>
							<td>
								<div class="caso-buttons">
									<a href="listaPacientesCaso?idCaso=${caso.id}" title="Listar Casos Clínicos Criados"><p class="fa fa-users"></p></a>
									<a href="listaQuadropacientes?id=${caso.id}" title="Adicionar Quadro Clínico"><p class="fa fa-medkit"></p></a>
									<a href="mostraCaso?idCaso=${caso.id}" title="Editar Caso Clínico"><p class="glyphicon glyphicon-edit"></p></a>
									<a href="copiaCaso?id=${caso.id}" title="Copiar Caso Clínico"><p class="glyphicon glyphicon-duplicate"></p></a>
									<a href="removeCaso?id=${caso.id}" title="Excluir Caso Clínico"><p class="fa fa-trash-o"></p></a>
								</div>
							</td>
						</tr>
					</c:if>
				</c:forEach>
			 	</tbody>
		 	</table>
		 	<!-- /.table-responsive -->
	 	</c:if>

	 	
	</div>
</div>				 
						 

<div class="panel panel-default">
	<div class="panel-heading">
		<h4>Casos Clínicos</h4>
	</div>
	 
	<!-- /.panel-heading -->
	<div class="panel-body">
	 
	 	<a href="novoPaciente"><button type="button" class="btn btn-primary btn-sm">Adiconar Caso Clínico</button></a>
		<br />
		<br />
	                      
	   	<c:if test="${idPaciente == 0}">
			Nenhum Caso Clínico Criado
		</c:if>
		<c:if test="${idPaciente > 0}">           
		<table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
	    	<thead>
	        	<tr>
					<!--  <th>Id</th>  -->	
					<th>Nome do Caso Clínico</th>	
					<th>Criador</th>
					<th></th>	
	                </tr>
	        </thead>
	       	<tbody>
	        	<c:forEach items="${pacientes}" var="paciente">
	     			<c:if test="${idUsuario == paciente.idPacienteUsuario}">
	                	<tr class="odd gradeX">
							
							
							<c:forEach items="${casos}" var="caso">
     						<c:if test="${caso.id == paciente.idPacienteCaso}">
									<td>${caso.identificacao}</td>
									<c:forEach items="${usuarios}" var="usuario">
		     						<c:if test="${usuario.id == caso.idCasoUsuario}">
											<td>${usuario.nome}</td>
										</c:if>
									</c:forEach>
								</c:if>
							</c:forEach>
											
							<td>
								<div class="paciente-buttons">
									<a href="listaTratamento?idPaciente=${paciente.id}" title="Visualizar"><p class="fa fa-ambulance"></p></a>
<!-- refazer! O id mudou para idPaciente --><a href="removePaciente?id=${paciente.id}" title="Excluir"><p class="fa fa-trash-o"></p></a>
								</div>
							</td>
	                    </tr>
	               	</c:if>               
	    		</c:forEach>
	    	</tbody>
		</table>   
		<!-- /.table-responsive -->
		</c:if>
	</div> 
</div>
                        
<c:import url="/WEB-INF/views/principal/rodape.jsp"/>                