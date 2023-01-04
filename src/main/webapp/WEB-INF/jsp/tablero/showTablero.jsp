<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="game" tagdir="/WEB-INF/tags" %>

<!-- %@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %--> 

<style>
  .right {
    padding-top: 10px;
    padding-left: 10px;
    margin-left: 10px;
    position: relative;
    float: left;
    width: 30%;
    border: rgb(255, 255, 255) solid 1px;
    height: auto;
  }
  .background{
	background-image: url("${tablero.getBackground()}");
	background-repeat:repeat;
	background-size: 100%;
  }
</style>

<game:layout pageName="home">
    <body class="background">

        <h2 style="color:rgb(255, 255, 255)">Sala ${partida.getNombreSala()}</h2>

        <div class="board">
            <div class="right">
                <img id= "celda0" width="200" height="285" src="${tablero.getCeldas().get(0).getCartas().get(0).getImagen()}">
            </div>
            <div class="right">
                <img id= "celda1" width="200" height="285" src="${tablero.getCeldas().get(1).getCartas().get(0).getImagen()}">
            </div>
            <div class="right">
                <img id= "celda2" width="200" height="285" src="${tablero.getCeldas().get(2).getCartas().get(0).getImagen()}">
            </div>
            <div class="right">
                <img id= "celda3" width="200" height="285" src="${tablero.getCeldas().get(3).getCartas().get(0).getImagen()}">
            </div>
            <div class="right">
                <img id= "celda4" width="200" height="285" src="${tablero.getCeldas().get(4).getCartas().get(0).getImagen()}">
            </div>
            <div class="right">
                <img id= "celda5" width="200" height="285" src="${tablero.getCeldas().get(5).getCartas().get(0).getImagen()}">
            </div>
            <div class="right">
                <img id= "celda6" width="200" height="285" src="${tablero.getCeldas().get(6).getCartas().get(0).getImagen()}">
            </div>
            <div class="right">
                <img id= "celda7" width="200" height="285" src="${tablero.getCeldas().get(7).getCartas().get(0).getImagen()}">
            </div>
            <div class="right">
                <img id= "celda8" width="200" height="285" src="${tablero.getCeldas().get(8).getCartas().get(0).getImagen()}">
            </div>
        </div>
    </body>
</game:layout>