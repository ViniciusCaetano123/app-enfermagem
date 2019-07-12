<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<link rel="icon" href="/enfermagem/resources/image/icon.png" type="image/png" sizes="16x16">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Simulador de Evoluções de Casos Clínicos</title>

    <!-- Bootstrap Core CSS -->
    <link href="/enfermagem/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/enfermagem/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/enfermagem/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/enfermagem/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                    <p align="center">
                   		<img src="/enfermagem/resources/image/pront1.png" alt="Prontuario1" width="80" height="100" >
                   		<img src="/enfermagem/resources/image/pront3.png" alt="Prontuario3" width="30" height="100" >
                   		<img src="/enfermagem/resources/image/pront2.png" alt="Prontuario2" width="100" height="100" >
                        <h3 class="text-center">Simulador de Evoluções de Casos Clínicos</h3>
                    <p/>
                    </div>
                    <div class="panel-body">
                        <form role="form" action="efetuaLogin" method="post" >
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="E-mail" name="email" type="text" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Senha" name="senha" type="password" value="">
                                </div>

                                <!-- Change this to a button or input when using this as a form -->
                                <input type="submit" value="Login" class="btn btn-lg btn-primary btn-block">
								<div class="text-center">
								<br />
									<a href="mostraTelaEnviarEmail" >Esqueci minha senha</a></br>
									<a href="novoUsuario" >Criar conta</a>
								</div>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="/enfermagem/resources/vendor/jquery/jquery.min.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="/enfermagem/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
    <!-- Metis Menu Plugin JavaScript -->
    <script src="/enfermagem/resources/vendor/metisMenu/metisMenu.min.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="/enfermagem/resources/dist/js/sb-admin-2.js"></script>
</body>
</html>