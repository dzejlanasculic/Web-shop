<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

<script  src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min. js"></script>
<script src="/webstore/resource/js/controllers.js"></script>

<title>Korpa</title>
</head>
<body>
  <section>
    <div class="jumbotron" style="background-color: mistyrose; font-family: initial">
      <div class="container">
          <img src="https://images.pexels.com/photos/2536965/pexels-photo-2536965.jpeg?cs=srgb&dl=pexels-suzy-hazelwood-2536965.jpg&fm=jpg" class="img-responsive" alt="Responsive image" height="125" width="170" style="float: right;">
        <h1>Korpa</h1>
        <p>Svi odabrani proizvodi su u korpi</p>
      </div>
    </div>
  </section>

  <section class="container" ng-app="cartApp">
    <div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">

      <div>
        <a  class="btn btn-danger pull-left" ng-click="clearCart()"> <span class="glyphicon glyphicon-remove-sign"></span> Isprazni korpu
        </a> <a  href="#" class="btn btn-success pull-right"> <span
          class="glyphicon-shopping-cart glyphicon"></span> Potvrdi
        </a>
      </div>
      <table class="table table-hover">
        <tr>
          <th>Proizvod</th>
          <th>Cijena po komadu</th>
          <th>Količina</th>
          <th>Ukupna cijena</th>
          <th>Radnja</th>
        </tr>
        <tr ng-repeat="item in cart.cartItems">
          <td>{{item.product.productId}}-{{item.product.name}}</td>
          <td>{{item.product.unitPrice}}</td>
          <td>{{item.quantity}}</td>
          <td>{{item.totalPrice}}</td>
          <td><a href="#" class="label label-danger" ng- click="removeFromCart(item.product.productId)"> <span
              class="glyphicon glyphicon-remove" /></span> Ukloni
          </a></td>
        </tr>
        <tr>
          <th></th>
          <th></th>
          <th>Ukupan iznos</th>
          <th>{{cart.grandTotal}}</th>
          <th></th>
        </tr>
      </table>
   
        <a  href="<spring:url value="/products/all" />" class="btn btn-default" style="background-color: mistyrose; color: black">
            <span class="glyphicon-hand-left glyphicon"></span> Nastavi kupovati
      </a>
    </div>
  </section>
</body>
</html>
