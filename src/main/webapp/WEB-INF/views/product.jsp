<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    <script src="/webshop/resource/js/controllers.js"></script>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Proizvodi</title>
</head>
<body>
  <section>
    <div class="jumbotron" style="background-color: mistyrose; font-family: initial">
      <div class="container">
        <h1>Proizvodi</h1>
      </div>
    </div>
  </section>
  <section class="container" ng-app="cartApp">
    <div class="row">
      <div class="col-md-5">
        <img src="<c:url value="/resource/images/${product.productId}.png">
        </c:url>" alt="image"  style="height: 300"/>
      </div>
      <div class="col-md-5">
        <h3>${product.name}</h3>
        <p>${product.description}</p>
        <p>
          <strong>Šifra proizvoda : </strong><span>${product.productId}</span>
        </p>
        <p>
          <strong>Proizvođač</strong> : ${product.manufacturer}
        </p>
        <p>
          <strong>Kategorija</strong> : ${product.category}
        </p>
        <p>
          <strong>Količina dostupnih proizvoda </strong> : ${product.unitsInStock}
        </p>
        <h4>${product.unitPrice} KM</h4>
        <p ng-controller="cartCtrl">
           <a  href="<spring:url value="/products/all" />" class="btn btn-default">
            <span class="glyphicon-hand-left glyphicon"></span> Nazad
           </a>
        
           <a  href="<spring:url value="/login" />" class="btn btn-default">
            <span class="glyphicon glyphicon-plus"></span> Dodaj novi proizvod
           </a>
            
            <a  href="<spring:url value="/login" />" class="btn btn-default">
            <span class="glyphicon glyphicon-edit"></span> Ažuriraj proizvod
           </a>
            
           <a  href="#" class="btn btn-large" ng-click="addToCart('${product.productId}')" style="background-color: mistyrose; color: black" ng-app="cartApp">
            <span class="glyphicon-shopping-cart glyphicon"></span> Naruči odmah
           </a>
        
           <a  href="<spring:url value="/cart" />" class="btn btn-default" ng-controller="cartCtrl">
            <span class="glyphicon-hand-right glyphicon"></span> Pregled korpe
           </a>
            
           <section class="container" ng-app="cartApp">
           <p  ng-controller="cartCtrl">
      </div>
    </div>
  </section>
</body>
</html>
