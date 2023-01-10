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
    <spring:url value="/resources/images/enano_legendario.png" var="enano"/>
    <div style="text-align: center;">
        
        <h1 style="padding-left: 2em ; color:aliceblue">ERROR 403</h1>
        <h1 style="padding-left: 2em ; color:aliceblue">Alto ahi!</h1>
        <img src="${enano}" width="500px"/>
    </div>
    <br><br>
    <h2 style="color:aliceblue">Te has encontrado con el enano legendario</h2>
    <h3 style="color:aliceblue">Parece que no puedes pasar</h3>
    <p style="color:aliceblue">${exception.message}</p>
    <a style="font-weight: bold; size: 50rem;" href="/"><span class="glyphicon glyphicon-chevron-left"> </span>Volver al inicio</a>
</petclinic:layout>