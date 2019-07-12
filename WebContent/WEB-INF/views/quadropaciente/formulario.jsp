<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:import url="/WEB-INF/views/principal/cabecalho.jsp"/>
<c:import url="/WEB-INF/views/principal/checklist.jsp"/>
	
	            <div class="row">
	                <div class="col-lg-12">
	                    <div class="panel panel-default">
	                        <div class="panel-heading">
	                            Inserir quadro paciente
	                        </div>
	                        <div class="panel-body">
	                            <div class="row">
	                                <div class="col-lg-6">
	                                    <form role="form" action="adicionaQuadropaciente?id=${caso.id}" method="post">
	                                        <div class="form-group">

												<label for="Descricao">Descrição</label> 
												<textarea class="form-control" name="descricao" rows="10">${quadropaciente.descricao}</textarea>
												<form:errors path="quadropaciente.descricao" cssStyle="color:#B71C1C"/><br />
												
												<input type="hidden" name="idQuadropacienteCaso" value="${caso.id}" >
												<form:errors path="quadropaciente.idQuadropacienteCaso" cssStyle="color:#B71C1C"/><br />
											</div>
                                        <button type="submit" class="btn btn-default" style="margin-right:3px;">Inserir</button>
                                        <a href="listaQuadropacientes?id=${caso.id}"><button type="button" class="btn btn-default" style="margin-right:3px;">Cancelar</button></a>
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
<c:import url="/WEB-INF/views/principal/rodape.jsp"/> 