<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:import url="/WEB-INF/views/principal/cabecalho.jsp"/>
<c:import url="/WEB-INF/views/principal/checklist.jsp"/>
	<br />
	<a href="novoCaso">Cadastrar caso clinico</a>
	<br />
	<br />
	
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Identificação</th>
			<th>Code</th>
			<th>Id Usuário</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${casos}" var="caso">
			<tr>
				<td>${caso.id}</td>
				<td><a href="listaQuadropacientes?id=${caso.id}" >${caso.identificacao}</a></td>
				<td>${caso.code}</td>
				<td>${caso.idCasoUsuario}</td>				
				<td><a href="mostraCaso?id=${caso.id}" title="Alterar">Alterar</a></td>
				<td><a href="removeCaso?id=${caso.id}" title="Excluir">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>	
<c:import url="/WEB-INF/views/principal/rodape.jsp"/>