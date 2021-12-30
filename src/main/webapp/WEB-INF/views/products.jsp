<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <title>Proizvodi</title>
  </head>
  <body>
    <section>
        <div class="jumbotron" style="background-color: mistyrose; font-family: initial">
        <div class="container" >           
          <img src="https://images.pexels.com/photos/3018845/pexels-photo-3018845.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500" class="img-responsive" alt="Responsive image" height="125" width="170" style="float: right;">
          <img src="https://images.pexels.com/photos/2535913/pexels-photo-2535913.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500" class="img-responsive" alt="Responsive image" height="125" width="170" style="float: right;">
          <img src="https://images.pexels.com/photos/208052/pexels-photo-208052.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500" class="img-responsive" alt="Responsive image" height="125" width="170" style="float: right;">
          <img src="https://images.pexels.com/photos/1327689/pexels-photo-1327689.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500" class="img-responsive" alt="Responsive image" height="125" width="170" style="float: right;">
          <h1 style="font-weight: bold">PROIZVODI</h1>
          <p>Ovdje možete pogledati sve trenutno dostupne proizvode</p> 
          <i class="fa fa-arrow-down" aria-hidden="true" ></i>
          <i class="fa fa-arrow-down" aria-hidden="true" style="margin-left: 150"></i>
          <i class="fa fa-arrow-down" aria-hidden="true" style="margin-left: 160"></i>
        </div>
      </div>
    </section>

    <section class="container">
      <div class="row">
        <c:forEach items="${products}" var="product">
          <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
              <div class="thumbnail">
               <img class="mx-auto d-block" src="<c:url value="/resource/images/${product.productId}.png">
                </c:url>" alt="image"  style = "height: 300"/> 
              <div class="caption">
                <h3>${product.name}</h3>
                <p>${product.description}</p>
                <p>${product.unitPrice} KM</p>
                <p>Dostupno ${product.unitsInStock} komada</p>
                <p> 
            <a  href=" <spring:url value=  "/products/product?id=${product.productId}" /> " class="btn btn-default" style="color: black; background-color: mistyrose">
            <i class="fa fa-info-circle" aria-hidden="true"></i>
            Detalji
            </a>
           </p>
              </div>
            </div>
          </div>
        </c:forEach>
      </div>
    </section>
  </body>
</html>