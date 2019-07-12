<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:import url="/WEB-INF/views/principal/cabecalho.jsp" />
<c:import url="/WEB-INF/views/principal/checklist.jsp" />
<div class="panel panel-default">
	<div class="panel-heading">
		<h4>Lista dos Alunos Criadores do Caso Clínico:
			${caso.identificacao}</h4>
		<a href="listaPrincipal"><button type="button"
				class="btn btn-info">Voltar</button></a> <br />
	</div>

	<c:set var="teste1" value="${listaUsuariosPacientesCaso.size()}" />

	<!-- /.panel-heading -->
	<div class="panel-body">

		<c:if test="${teste1 == 0}">
			Nenhum paciente criado
		</c:if>
		<c:if test="${teste1 > 0}">
			<table width="100%"
				class="table table-striped table-bordered table-hover"
				id="dataTables-example">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Comentários</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="usuario" items="${listaUsuariosPacientesCaso.keySet()}">

						<tr class="odd gradeX">
							<td>${usuario.nome}</td>
							<td>
								<div class="paciente-buttons">
									<a href="listaComentariosPaciente?idPaciente=${listaUsuariosPacientesCaso.get(usuario).id}&idUsuarioCreadorCaso=${caso.idCasoUsuario}"
										title="Vizualizar"><p class="fa fa-commenting"></p></a>
								</div>
							</td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
			<!-- /.table-responsive -->
		</c:if>
	</div>
</div>
<c:import url="/WEB-INF/views/principal/rodape.jsp" />