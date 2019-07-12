<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:import url="/WEB-INF/views/principal/cabecalho.jsp" />
<c:import url="/WEB-INF/views/principal/checklist.jsp" />
<div class="row">
	<div class="col-lg-12"></div>
	<!-- /.col-lg-12 -->
	<c:if test="${caso.code == null}">
					Código inválido.<br />
		<br />
		<input class="btn btn-info" type="button" value="Voltar"
			onClick="history.go(-1)">
	</c:if>
	<c:if test="${caso.code != null}">
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Adicionar aos meus casos clínicos</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-lg-6">
						Caso clínico: ${caso.identificacao}<br/>
						Criador:
						<c:forEach items="${usuarios}" var="usuario">
							<c:if test="${usuario.id == caso.idCasoUsuario}">
								${usuario.nome}
							</c:if>
						</c:forEach>
						<form role="form" action="adicionaPaciente" method="post">
							<div class="form-group">
																
								<input type="hidden" name="idPacienteCaso" value="${caso.id}">
								<input type="hidden" name="code" value="${caso.code}">
							
								<c:forEach items="${usuarios}" var="usuario">
									<c:if test="${usuarioLogado.email == usuario.email}">
										<input type="hidden" name="idPacienteUsuario"
											value="${usuario.id}">
									</c:if>
								</c:forEach>
							</div>
							<button type="submit" class="btn btn-primary">Adicionar</button>
							<button type="button" class="btn btn-info" onClick="history.go(-1)">Voltar</button>
						</form>
						</c:if>
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
<!-- /.row -->
<c:import url="/WEB-INF/views/principal/rodape.jsp" />
