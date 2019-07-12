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
			<div class="panel-heading">Criar caso clínico</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-lg-6">
						<form role="form" action="adicionaCaso" method="post">
							<div class="form-group">

								<label for="Identificacao">Identificação</label> <input
									class="form-control" type="text" name="identificacao"
									value="${caso.identificacao}">
								<form:errors path="caso.identificacao" cssStyle="color:#B71C1C" />
								<br />

								<c:forEach items="${usuarios}" var="usuario">
									<c:if test="${usuarioLogado.email == usuario.email}">
										<input type="hidden" name="idCasoUsuario"
											value="${usuario.id}">
									</c:if>
								</c:forEach>
							</div>
							<button type="submit" class="btn btn-default"
								style="margin-right: 3px;">Criar</button>
							<a href="listaPrincipal"><button type="button"
									class="btn btn-default" style="margin-right: 3px;">Cancelar</button></a>
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
<!-- /.row -->
<c:import url="/WEB-INF/views/principal/rodape.jsp" />