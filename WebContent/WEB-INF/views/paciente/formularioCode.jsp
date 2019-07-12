<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:import url="/WEB-INF/views/principal/cabecalho.jsp" />
<c:import url="/WEB-INF/views/principal/checklist.jsp" />

<style>
.codigo-buttons>* {
	margin-right: 3px;
}
</style>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Informe o código do caso clínico</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-lg-6">
						<form role="form" action="criaPaciente" method="post">
							<div class="form-group">

								<label for="Code">Código</label> <input class="form-control"
									type="text" name="code" value="${caso.code}" size="5"
									maxlength="5">
								<form:errors path="caso.code" cssStyle="color:#B71C1C" />
								<br />

							</div>
							<div class="codigo-buttons">
								<button type="submit" class="btn btn-primary">Criar</button>
								<a href="listaPrincipal"><button type="button"	class="btn btn-info">Voltar</button></a>
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
<!-- /.row -->
<c:import url="/WEB-INF/views/principal/rodape.jsp" />
