<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:import url="/WEB-INF/views/principal/cabecalho.jsp"/>
<c:import url="/WEB-INF/views/principal/checklist.jsp"/>
	
	Cadastro de Comentario Clínico <br /><br />
	
	
	<form action="adicionaComentario" method="post">
	
		<label for="Cod">cod</label>  
		<input type="text" name="cod" value="${comentario.cod}" >
		<form:errors path="comentario.cod" cssStyle="color:#B71C1C"/><br />
	
		<label for="Comentario">Comentario</label>  
		<input type="text" name="comentario" value="${comentario.comentario}" >
		<form:errors path="comentario.comentario" cssStyle="color:#B71C1C"/><br />
		
		<label for="IdComentarioPaciente">IdComentarioPaciente</label>  
		<input type="text" name="id_comentario_paciente" value="${comentario.idComentarioPaciente}" >
		<form:errors path="comentario.id_comentario_paciente" cssStyle="color:#B71C1C"/><br />
	
		<input type="submit" value="Criar">
		
	</form>
<c:import url="/WEB-INF/views/principal/rodape.jsp"/> 