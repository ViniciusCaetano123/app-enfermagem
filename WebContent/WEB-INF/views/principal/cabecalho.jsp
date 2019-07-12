<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<link rel="icon" href="/enfermagem/resources/image/icon.png"
	type="image/png" sizes="16x16">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Simulador de Evoluções de Casos Clínicos</title>

<!-- Bootstrap Core CSS -->
<link
	href="/enfermagem/resources/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="/enfermagem/resources/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="/enfermagem/resources/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="/enfermagem/resources/vendor/morrisjs/morris.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="/enfermagem/resources/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Navegacao</span> <span class="icon-bar"></span>
				<span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="listaPrincipal">Simulador de
				Evoluções de Casos Clínicos</a>
		</div>
		<!-- /.navbar-header -->
		<ul class="nav navbar-top-links navbar-right">
			<!-- /.dropdown -->
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
					<i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-user">
					<li class="divider"></li>					
							<c:forEach items="${usuarios}" var="usuario">
								<c:if test="${usuarioLogado.email == usuario.email}">
						 			<li><a href="editaUsuario"> <i class="fa fa-user fa-fw"></i>
						 				${usuario.nome}
						 			</a>
								</c:if>
							</c:forEach>
					</li>

					<li class="divider"></li>
					<li><a href="logout"><i class="fa fa-sign-out fa-fw"></i>
							Sair</a></li>
				</ul> <!-- /.dropdown-user --></li>
			<!-- /.dropdown -->
		</ul>
		<ul class="nav navbar-top-links navbar-right">
			<!-- /.dropdown -->
			<li class="dropdown">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> <i class="fa fa-bell fa-fw"></i>
					<i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-alerts">
					<li><a href="#">
							<div>
								<i class="fa fa-comment fa-fw"></i> Novo comentario <span
									class="pull-right text-muted small">2 minutos atras</span>
							</div>
					</a></li>
					<li class="divider"></li>
					<li><a href="#">
							<div>
								<i class="fa fa-envelope fa-fw"></i> Quadro do paciente <span
									class="pull-right text-muted small">4 minutos atras</span>
							</div>
					</a></li>
					<li class="divider"></li>
					<li><a class="text-center" href="#"> <strong>Ver
								todos os Alertas</strong> <i class="fa fa-angle-right"></i>
					</a></li>
				</ul> <!-- /.dropdown-alerts --></li>
		</ul>
		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<li><a href="listaPrincipal"><i class="fa fa-home"></i>
							Home</a></li>
					<!--  
							<li>
								<a href="listaUsuarios"><i class="fa fa-bar-chart-o"></i> Relatórios</a>
							</li>
							
					<li><a href="#" data-toggle="modal"
						data-target="#myModalchecklist"><i
							class="fa fa-check-square-o"></i>Checklist</a></li>
					-->
				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<div class="row">

						<div class="col-lg-12">
							<h3 class="page-header"></h3>
						</div>
					</div>