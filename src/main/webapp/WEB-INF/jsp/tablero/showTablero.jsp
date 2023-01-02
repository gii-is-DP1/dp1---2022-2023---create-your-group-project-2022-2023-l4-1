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
    border: rgb(0, 0, 0) solid 1px;
    height: auto;
  }
</style>

<game:layout pageName="home">

    <div class="board">
        <div class="right">
            <img id= "celda0" width="200" height="285" src="/resources/images/cartas/Carta 1.png" name="${tablero.celdas[0].cartas[0]}">
        </div>
        <div class="right">
            <img id= "celda1" width="200" height="285" src="/resources/images/cartas/Carta 2.png" name="${tablero.celdas[1].cartas[0]}">
        </div>
        <div class="right">
            <img id= "celda2" width="200" height="285" src="/resources/images/cartas/Carta 3.png" name="${tablero.celdas[2].cartas[0]}">
        </div>
        <div class="right">
            <img id= "celda3" width="200" height="285" src="/resources/images/cartas/Carta 4.png" name="${tablero.celdas[3].cartas[0]}">
        </div>
        <div class="right">
            <img id= "celda4" width="200" height="285" src="/resources/images/cartas/Carta 5.png" name="${tablero.celdas[4].cartas[0]}">
        </div>
        <div class="right">
            <img id= "celda5" width="200" height="285" src="/resources/images/cartas/Carta 6.png" name="${tablero.celdas[5].cartas[0]}">
        </div>
        <div class="right">
            <img id= "celda6" width="200" height="285" src="/resources/images/cartas/Carta 7.png" name="${tablero.celdas[6].cartas[0]}">
        </div>
        <div class="right">
            <img id= "celda7" width="200" height="285" src="/resources/images/cartas/Carta 8.png" name="${tablero.celdas[7].cartas[0]}">
        </div>
        <div class="right">
            <img id= "celda8" width="200" height="285" src="/resources/images/cartas/Carta 9.png" name="${tablero.celdas[8].cartas[0]}">
        </div>
    </div>

</game:layout>