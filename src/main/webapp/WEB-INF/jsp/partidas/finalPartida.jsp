<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style>

    .colorletter{
    color:"white";
    }
	.background{
	background-image: url("/resources/images/cueva-juego.png");
	background-repeat:no-repeat;
	background-size: 100%;
    }
    </style>

<petclinic:layout pageName="info">
    <body class="background">
        <h2 style="color:rgb(255, 255, 255)">PARTIDA FINALIZADA</h2>
        <h2 style="color:rgb(255, 255, 255)">GANADOR: ${ganador.getUser().getUsername()}</h2>
    </body>
</petclinic:layout>