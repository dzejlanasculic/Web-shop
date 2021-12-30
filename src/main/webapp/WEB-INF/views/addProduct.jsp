<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Unos proizvoda</title>
</head>
<body>
	<section>
		<div class="jumbotron" style="background-color: mistyrose; font-family: initial">
			<a  href="<c:url value="/j_spring_security_logout" />" class="btn btn-danger btn-mini pull-right">Odjava</a>  
			<div class="pull-right" style="padding-right:50px">
  <a  href="?language=en" >Bosanski</a>|<a href="?language=bs" >Engleski</a>
</div>
                        <div class="container">
				<h1>Proizvodi</h1>
				<p>Dodaj proizvode</p>
			</div>
		</div>
	</section>
	<section class="container">
            <form:form modelAttribute="newProduct" class="form-horizontal">
                <form:errors path="*" cssClass="alert alert-danger" element="div"/>
                <fieldset>
				<legend>Dodaj novi proizvod</legend>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="productId">
                                            <spring:message code="addProduct.form.productId.label"/></label>
					<div class="col-lg-10">
						<form:input id="productId" path="productId" type="text" class="form:input-large"/>
                                                <form:errors path="productId" cssClass="text-danger"/>
					</div>
				</div>
				
				<div class="form-group">
                                    <label class="control-label col-lg-2 col-lg-2" for="name">
                                        <spring:message code="addProduct.form.name.label"/>                 
                                    </label>
					<div class="col-lg-10">
						<form:input id="name" path="name" type="text" class="form:input-large"/>
                                                <form:errors path="name" cssClass="text-danger"/>
					</div>
				</div>
				
				<div class="form-group">
                                    <label class="control-label col-lg-2 col-lg-2" for="unitPrice">
                                        <spring:message code="addProduct.form.unitPrice.label"/>
                                    </label>
					<div class="col-lg-10">
						<form:input id="unitPrice" path="unitPrice" type="text" class="form:input-large"/>
					<form:errors path="unitPrice" cssClass="text-danger"/>
                                        </div>
				</div>
				
				<div class="form-group">
                                    <label class="control-label col-lg-2 col-lg-2" for="manufacturer">
                                        <spring:message code="addProduct.form.manufacturer.label"/>
                                    </label>
					<div class="col-lg-10">
						<form:input id="manufacturer" path="manufacturer" type="text" class="form:input-large"/>
					</div>
				</div>
				
				<div class="form-group">
                                    <label class="control-label col-lg-2 col-lg-2" for="category">
                                        <spring:message code="addProduct.form.category.label"/>
                                    </label>
					<div class="col-lg-10">
						<form:input id="category" path="category" type="text" class="form:input-large"/>
					</div>
				</div>
				
				<div class="form-group">
                                    <label class="control-label col-lg-2 col-lg-2" for="unitsInStock">
                                        <spring:message code="addProduct.form.unitsInStock.label"/>
                                    </label>
					<div class="col-lg-10">
						<form:input id="unitsInStock" path="unitsInStock" type="text" class="form:input-large"/>
					</div>
				</div>
			
				
				<div class="form-group">
                                    <label class="control-label col-lg-2 col-lg-2" for="description">
                                        <spring:message code="addProduct.form.description.label"/>
                                    </label>
					<div class="col-lg-10">
						<form:textarea id="description" path="description" rows="2"/>
					</div>
				</div>
				
				<div class="form-group">
                                    <label class="control-label col-lg-2 col-lg-2" for="condition">
                                        <spring:message code="addProduct.form.condition.label"/>
                                    </label>
					<div class="col-lg-10">
						<form:radiobutton path="condition" value="Nov"/> Novo <br/>
						<form:radiobutton path="condition" value="Korišten"/> Korišteno <br/>	
					</div>
				</div>
				
                           
                                        
                                        
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value="Dodaj" style="background-color: mistyrose; color:black"/>
					</div>
                                    <p> <br> </p>
            <a  href="<spring:url value="/products/all" />" class="btn btn-default">
            <span class="glyphicon-hand-left glyphicon"></span> Nazad
           </a>
				</div>
			</fieldset>
		</form:form>
	</section>
</body>
</html>