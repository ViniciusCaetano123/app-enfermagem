<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:import url="/WEB-INF/views/principal/cabecalho.jsp"/><br />

<div class="panel panel-default" >	
	<div class="panel-heading">
   	<h4>Editar Usuario</h4>
 	</div>
 	<div class="panel-body">
		<c:forEach items="${usuarios}" var="usuario">
			<tr>			
			<c:if test="${usuarioLogado.email == usuario.email }"> 		
					<div class="col-md-4 ">
						<form role="form" action="alteraUsuario?id=${usuario.id}" method="post">
							<fieldset>						
								<div class="form-group"> 
									<label for="nome">Nome </label>
									<input  class="form-control" type="text" name="nome" value="${usuario.nome}"  >
									<form:errors path="usuario.nome" cssStyle="color:#B71C1C"/><br />
								</div>								
								<div class="form-group"> 
									<label for="senha">Senha </label> 
									<input type="password"  class="form-control" name="senha" value="${usuario.senha}"  >
									<form:errors path="usuario.senha" cssStyle="color:#B71C1C"/><br />
								</div>
								<div class="form-group"> 
									<label for="email">E-mail </label>
									<input type="email"  class="form-control" name="email" value="${usuario.email}">
									<form:errors path="usuario.email" cssStyle="color:#B71C1C"/><br />
									
								</div>	
								<input type="submit" value="Editar" class="btn btn-primary ">	 					
																	
								<a href="listaPrincipal">
									<button type="button" class="btn btn-info">Voltar</button>	
								</a>
							 <fieldset>	
						 </form>
					</div>	
			  	 </c:if> 
			</tr>
		 </c:forEach>  
		</div>
	</div>
	
<c:import url="/WEB-INF/views/principal/rodape.jsp"/>