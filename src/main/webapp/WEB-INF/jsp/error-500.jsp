<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<style>

	.background{
	background-image: url("/resources/images/cuevaNueva.jpg");
	background-repeat:no-repeat;
	background-size: 100%;
    }
    </style>

<petclinic:layout pageName="error">
    <body class="background"></body>
    <spring:url value="/resources/images/enanito_durmiendo.gif" var="enano"/>
    <div style="text-align: center;">
        <h1 style="padding-left: 2em ; color:aliceblue">ERROR 500</h1>
        <h1 style="padding-left: 2em ; color:aliceblue">Alto ahi!</h1>
        <iframe width="956" height="538" src="https://www.youtube.com/embed/K7ylwMki3mw?autoplay=1" title="ankara messi chiquito" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
    </div>
    
    <br><br>
    <h2 style="color:aliceblue">Te has encontrado con el enano exclusivo!!!</h2>
    <h3 style="color:aliceblue">Se trata de Messi chiquito, toda una proeza. Por ahora sera mejor volver</h3>
    <p style="color:aliceblue">${exception.message}</p>
    <a style="font-weight: bold; size: 50rem;" href="/"><span class="glyphicon glyphicon-chevron-left"> </span>Volver al inicio</a>
</petclinic:layout>