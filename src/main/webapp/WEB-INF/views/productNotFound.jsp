<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/boo tstrap.min.css">
    <title>BEAUTYSHOP</title>
    </head>
  <body>
    <section>
      <div class="jumbotron" style="background-color: mistyrose; font-family: initial">
        <div class="container">
          <h1 class="alert alert-danger"> Ne postoji proizvod sa ID brojem: ${invalidProductId}</h1>
        </div>
      </div>
    </section>

    <section>
      <div class="container">
        <p>${url}</p>
        <p>${exception}</p>
      </div>

      <div class="container">
        <p>
          <a  href="<spring:url value="/products/all" /> " class="btn btn- primary">
            <span class="glyphicon-hand-left glyphicon"></span> Proizvodi
          </a>
        </p>
      </div>

    </section>
  </body>
</html>
