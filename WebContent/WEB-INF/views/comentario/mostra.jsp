<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:import url="/WEB-INF/views/principal/cabecalho.jsp"/>
<c:import url="/WEB-INF/views/principal/checklist.jsp"/>

	<br />
	Alterar comentario clinico: ${comentario.id}	
	<br />
	<br />
	
	<form action="alteraComentario" method="post" class="form-horizontal">
	
	<input type="hidden" name="id" value="${comentario.id}" />
				
	<label for="Cod">Cod</label>  
	<input type="text" name="cod" value="${comentario.cod}" >
	<form:errors path="comentario.cod" cssStyle="color:#B71C1C"/><br />
	
	<label for="Comentario">Comentario</label>  
	<input type="text" name="comentario" value="${comentario.comentario}" >
	<form:errors path="comentario.comentario" cssStyle="color:#B71C1C"/><br />
	
	<label for="IdComentarioPaciente">ID Usuário</label>  
	<input type="text" name="idComentarioPaciente" value="${comentario.idComentarioPaciente}">
	<form:errors path="comentario.idComentarioPaciente" cssStyle="color:#B71C1C"/><br />
	
	<input type="submit" value="Alterar">
	
	</form>
	
<c:import url="/WEB-INF/views/principal/rodape.jsp"/>  