<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Beauty webshop</title>
</head>
<body style="background: url('https://images.pexels.com/photos/4041392/pexels-photo-4041392.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500') no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;">
<section>
    <div class="jumbotron" style="background: url('https://images.pexels.com/photos/4041392/pexels-photo-4041392.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500') no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;">
        <div class="container">     
        <h1 style="font-family: initial;">   ${greeting} </h1>
        <h1 style="font-family: initial">BEAUTY SHOP</h1>
        <p><br></p>
        <p style="font-style: italic">   ${tagline} </p>
        <p><br></p>  
        <p style="color: grey; font-family: initial"> KONTAKT <span class="glyphicon glyphicon-hand-down"></p>
        <p style="color: grey; font-family: initial"> <span class="glyphicon glyphicon-envelope">  dzejlanasculic@gmail.com </span></p>   
        <p style="color: grey; font-family: initial"> <span class="glyphicon glyphicon-earphone" >  38761465269</span> </p>
        <p><br></p>
        <a href="<spring:url value="/products/all" />" class="btn btn-default" style="font-family: initial; background-color: mistyrose">POGLEDAJ PROIZVODE
         <span class="glyphicon-hand-right glyphicon"></span>  
        </a>         
      </div>
    </div>
  </section>
</body>
</html>
