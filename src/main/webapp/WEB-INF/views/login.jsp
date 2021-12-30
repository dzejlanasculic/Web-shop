<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta charset="utf-8">
<title>Login forma</title>
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
	<section>
		<div class="jumbotron" style="background-color: mistyrose; font-family: initial">
			<div class="container">
				<h1>Proizvodi</h1>
				<p>Dodaj novi proizvod</p>
			</div>
		</div>
	</section>
	<div class="container" style=" font-family: initial">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Molimo Vas da se prijavite za nastavak</h3>
					</div>
					<div class="panel-body">
						<c:if test="${not empty error}">
							<div class="alert alert-danger">
								<spring:message code="greska.losiPodaci"/><br/>
							</div>
						</c:if>
						<form action="<c:url value="/j_spring_security_check"></c:url>" method="post">
						<fieldset>
							<div class="form-group">
                  				<input class="form-control" placeholder="Korisničko ime" name='j_username' type="text">
              				</div>
              				<div class="form-group">
                				<input class="form-control" placeholder="Lozinka" name='j_password'  type="password" value="">
                			</div>
              				<input class="btn btn-lg btn-success btn-block" type="submit" value="Prijava">
						</fieldset>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>