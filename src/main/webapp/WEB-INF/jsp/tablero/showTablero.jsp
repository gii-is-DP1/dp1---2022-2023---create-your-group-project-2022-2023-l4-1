<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="game" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- %@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %--> 

<style>
  .celda {
    padding-top: 10px;
    padding-left: 10px;
    margin-left: 10px;
    position: relative;
    float: left;
    width: 30%;
    border: rgba(255, 255, 255, 0) solid 1px;
    height: auto;
  }
  .center {
    padding-top: 10px;
    padding-left: 367px;
    margin-left: 10px;
    position: relative;
    float: left;
    width: auto;
    border: rgba(255, 242, 0, 0) solid 1px;
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
            <div class="celda">
                <spring:url value="/" var="editUrl"></spring:url>
                    <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">
                        <img id= "celda0" width="200" height="285" src="${tablero.getCeldas().get(0).getCartas().get(0).getImagen()}">
                    </a>
            </div>
            <div class="celda">
                <spring:url value="/" var="editUrl"></spring:url>
                    <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">
                        <img id= "celda1" width="200" height="285" src="${tablero.getCeldas().get(1).getCartas().get(0).getImagen()}">
                    </a>
            </div>
            <div class="celda">
                <spring:url value="/" var="editUrl"></spring:url>
                    <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">
                        <img id= "celda2" width="200" height="285" src="${tablero.getCeldas().get(2).getCartas().get(0).getImagen()}">
                    </a>
            </div>
            <div class="celda">
                <spring:url value="/" var="editUrl"></spring:url>
                    <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">
                        <img id= "celda3" width="200" height="285" src="${tablero.getCeldas().get(3).getCartas().get(0).getImagen()}">
                    </a>
            </div>
            <div class="celda">
                <spring:url value="/" var="editUrl"></spring:url>
                    <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">
                        <img id= "celda4" width="200" height="285" src="${tablero.getCeldas().get(4).getCartas().get(0).getImagen()}">
                    </a>
            </div>
            <div class="celda">
                <spring:url value="/" var="editUrl"></spring:url>
                    <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">
                        <img id= "celda5" width="200" height="285" src="${tablero.getCeldas().get(5).getCartas().get(0).getImagen()}">
                    </a>
            </div>
            <div class="celda">
                <spring:url value="/" var="editUrl"></spring:url>
                    <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">
                        <img id= "celda6" width="200" height="285" src="${tablero.getCeldas().get(6).getCartas().get(0).getImagen()}">
                    </a>
            </div>
            <div class="celda">
                <spring:url value="/" var="editUrl"></spring:url>
                    <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">
                        <img id= "celda7" width="200" height="285" src="${tablero.getCeldas().get(7).getCartas().get(0).getImagen()}">
                    </a>
            </div>
            <div class="celda">
                <spring:url value="/" var="editUrl"></spring:url>
                    <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">
                        <img id= "celda8" width="200" height="285" src="${tablero.getCeldas().get(8).getCartas().get(0).getImagen()}">
                    </a>
            </div>


            <div class="celda"></div><div class="celda"></div><div class="celda"></div><div class="celda"></div>
            <div class="celda"></div><div class="celda"></div><div class="celda"></div><div class="celda"></div>
            <div class="celda"></div><div class="celda"></div><div class="celda"></div><div class="celda"></div>
            <div class="celda"></div><div class="celda"></div><div class="celda"></div>
            <div class="celda"></div><div class="celda"></div><div class="celda"></div>


            <div class="celda">
                <spring:url value="/" var="editUrl"></spring:url>
                    <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">
                        <img id= "celda9" width="200" height="285" src="${tablero.getCeldasEspeciales().get(0).getCartas().get(0).getImagenEspecial()}">
                    </a>
            </div>
            <div class="celda">
                <spring:url value="/" var="editUrl"></spring:url>
                    <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">
                        <img id= "celda10" width="200" height="285" src="${tablero.getCeldasEspeciales().get(1).getCartas().get(0).getImagenEspecial()}">
                    </a>
            </div>
            <div class="celda">
                <spring:url value="/" var="editUrl"></spring:url>
                    <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">
                        <img id= "celda11" width="200" height="285" src="${tablero.getCeldasEspeciales().get(2).getCartas().get(0).getImagenEspecial()}">
                    </a>
            </div>


            <div class="celda"></div><div class="celda"></div><div class="celda"></div><div class="celda"></div>
            <div class="celda"></div><div class="celda"></div><div class="celda"></div><div class="celda"></div>
            <div class="celda"></div><div class="celda"></div><div class="celda"></div><div class="celda"></div>
            <div class="celda"></div><div class="celda"></div><div class="celda"></div><div class="celda"></div>
            <div class="celda"></div><div class="celda"></div><div class="celda"></div><div class="celda"></div>


            <div class="center">
                <spring:url value="/" var="editUrl"></spring:url>
                    <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">
                        <img id= "celda12" width="200" height="285" src="/resources/images/cartas/carta_trasera.png">
                    </a>
            </div>
        </div>
    </body>
</game:layout>