<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
  .chat_container {
            position: absolute;
            top: 750px;
            right: 20px;
            width: 400px;
            min-height: 200px;
            background-color: #34302d;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            border-radius: 5px;
            gap: 10px;
            padding: 20px 0;
        }
        .chat_container>div {
            width: 90%;
            overflow-y: scroll;
            height: 300px;
        }
        .chat_container label {
            display: none;
        }
        .chat_container h2 {
            color: white;
        }
        .chat_container p {
            color: white;
        }
</style>

<game:layout pageName="home">
    <body class="background">

        <h2 style="color:rgb(255, 255, 255)">Sala ${partida.getNombreSala()}</h2>
        <h2 style="color:rgb(255, 255, 255)">Jugador1 ${jugador1.getUser().getUsername()} Color azul.</h2>
        <h2 style="color:rgb(255, 255, 255)">Jugador2 ${jugador2.getUser().getUsername()} Color rojo.</h2>
        <c:if test = "${partida.getUser2()!=null}"><h2 style="color:rgb(255, 255, 255)">Jugador3 ${jugador3.getUser().getUsername()} Color verde.</h2></c:if>
        <h2 style="color:rgb(255, 255, 255)">El turno lo tiene ${partida.getJugadorActivo()}. El siguiente jugador sera ${partida.getSiguienteJugador()}.</h2>

        <div class="board">
            <div class="celda">
                <c:choose>
                    <c:when test="${tablero.getCeldas().get(0).getOcupado()==false && actual==partida.getJugadorActivo() && partida.getFaseActual()==fase2}">
                        <spring:url value="/partida/tablero/celda1/${partida.id}" var="editUrl"></spring:url>
                            <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">
                                <img id= "celda0" width="190" height="266" src="${tablero.getCeldas().get(0).getCartas().get(0).getImagen()}">
                            </a>
                    </c:when>
                    <c:otherwise>
                        <img id= "celda0" width="202" height="282" src="${tablero.getCeldas().get(0).getCartas().get(0).getImagen()}">
                        <c:if test="${tablero.getCeldas().get(0).getOcupado()==true}">
                            <img id= "ficha0" width="100" height="150" src="${tablero.getCeldas().get(0).getFicha()}" style = "position: absolute; right: 180;top: 40;">
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="celda">
                <c:choose>
                    <c:when test="${tablero.getCeldas().get(1).getOcupado()==false && actual==partida.getJugadorActivo() && partida.getFaseActual()==fase2}">
                        <spring:url value="/partida/tablero/celda2/${partida.id}" var="editUrl"></spring:url>
                            <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">
                                <img id= "celda1" width="190" height="266" src="${tablero.getCeldas().get(1).getCartas().get(0).getImagen()}">
                            </a>
                    </c:when>
                    <c:otherwise>
                        <img id= "celda1" width="202" height="282" src="${tablero.getCeldas().get(1).getCartas().get(0).getImagen()}">
                        <c:if test="${tablero.getCeldas().get(1).getOcupado()==true}">
                            <img id= "ficha0" width="100" height="150" src="${tablero.getCeldas().get(1).getFicha()}" style = "position: absolute; right: 180;top: 40;">
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="celda">
                <c:choose>
                    <c:when test="${tablero.getCeldas().get(2).getOcupado()==false && actual==partida.getJugadorActivo() && partida.getFaseActual()==fase2}">
                        <spring:url value="/partida/tablero/celda3/${partida.id}" var="editUrl"></spring:url>
                            <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">
                                <img id= "celda2" width="190" height="266" src="${tablero.getCeldas().get(2).getCartas().get(0).getImagen()}">
                            </a>
                    </c:when>
                    <c:otherwise>
                        <img id= "celda2" width="202" height="282" src="${tablero.getCeldas().get(2).getCartas().get(0).getImagen()}">
                        <c:if test="${tablero.getCeldas().get(2).getOcupado()==true}">
                            <img id= "ficha0" width="100" height="150" src="${tablero.getCeldas().get(2).getFicha()}"style = "position: absolute; right: 180;top: 40;">
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="celda">
                <c:choose>
                    <c:when test="${tablero.getCeldas().get(3).getOcupado()==false && actual==partida.getJugadorActivo() && partida.getFaseActual()==fase2}">
                        <spring:url value="/partida/tablero/celda4/${partida.id}" var="editUrl"></spring:url>
                            <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">
                                <img id= "celda3" width="190" height="266" src="${tablero.getCeldas().get(3).getCartas().get(0).getImagen()}">
                            </a>
                    </c:when>
                    <c:otherwise>
                        <img id= "celda3" width="202" height="282" src="${tablero.getCeldas().get(3).getCartas().get(0).getImagen()}">
                        <c:if test="${tablero.getCeldas().get(3).getOcupado()==true}">
                            <img id= "ficha0" width="100" height="150" src="${tablero.getCeldas().get(3).getFicha()}"style = "position: absolute; right: 180;top: 40;">
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="celda">
                <c:choose>
                    <c:when test="${tablero.getCeldas().get(4).getOcupado()==false && actual==partida.getJugadorActivo() && partida.getFaseActual()==fase2}">
                        <spring:url value="/partida/tablero/celda5/${partida.id}" var="editUrl"></spring:url>
                            <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">
                                <img id= "celda4" width="190" height="266" src="${tablero.getCeldas().get(4).getCartas().get(0).getImagen()}">
                            </a>
                    </c:when>
                    <c:otherwise>
                        <img id= "celda4" width="202" height="282" src="${tablero.getCeldas().get(4).getCartas().get(0).getImagen()}">
                        <c:if test="${tablero.getCeldas().get(4).getOcupado()==true}">
                            <img id= "ficha0" width="100" height="150" src="${tablero.getCeldas().get(4).getFicha()}"style = "position: absolute; right: 180;top: 40;">
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="celda">
                <c:choose>
                    <c:when test="${tablero.getCeldas().get(5).getOcupado()==false && actual==partida.getJugadorActivo() && partida.getFaseActual()==fase2}">
                        <spring:url value="/partida/tablero/celda6/${partida.id}" var="editUrl"></spring:url>
                            <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">
                                <img id= "celda5" width="190" height="266" src="${tablero.getCeldas().get(5).getCartas().get(0).getImagen()}">
                            </a>
                    </c:when>
                    <c:otherwise>
                        <img id= "celda5" width="202" height="282" src="${tablero.getCeldas().get(5).getCartas().get(0).getImagen()}">
                        <c:if test="${tablero.getCeldas().get(5).getOcupado()==true}">
                            <img id= "ficha0" width="100" height="150" src="${tablero.getCeldas().get(5).getFicha()}"style = "position: absolute; right: 180;top: 40;">
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="celda">
                <c:choose>
                    <c:when test="${tablero.getCeldas().get(6).getOcupado()==false && actual==partida.getJugadorActivo() && partida.getFaseActual()==fase2}">
                        <spring:url value="/partida/tablero/celda7/${partida.id}" var="editUrl"></spring:url>
                            <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">
                                <img id= "celda6" width="190" height="266" src="${tablero.getCeldas().get(6).getCartas().get(0).getImagen()}">
                            </a>
                    </c:when>
                    <c:otherwise>
                        <img id= "celda6" width="202" height="282" src="${tablero.getCeldas().get(6).getCartas().get(0).getImagen()}">
                        <c:if test="${tablero.getCeldas().get(6).getOcupado()==true}">
                            <img id= "ficha0" width="100" height="150" src="${tablero.getCeldas().get(6).getFicha()}"style = "position: absolute; right: 180;top: 40;">
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="celda">
                <c:choose>
                    <c:when test="${tablero.getCeldas().get(7).getOcupado()==false && actual==partida.getJugadorActivo() && partida.getFaseActual()==fase2}">
                        <spring:url value="/partida/tablero/celda8/${partida.id}" var="editUrl"></spring:url>
                            <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">
                                <img id= "celda7" width="190" height="266" src="${tablero.getCeldas().get(7).getCartas().get(0).getImagen()}">
                            </a>
                    </c:when>
                    <c:otherwise>
                        <img id= "celda7" width="202" height="282" src="${tablero.getCeldas().get(7).getCartas().get(0).getImagen()}">
                        <c:if test="${tablero.getCeldas().get(7).getOcupado()==true}">
                            <img id= "ficha0" width="100" height="150" src="${tablero.getCeldas().get(7).getFicha()}"style = "position: absolute; right: 180;top: 40;">
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="celda">
                <c:choose>
                    <c:when test="${tablero.getCeldas().get(8).getOcupado()==false && actual==partida.getJugadorActivo() && partida.getFaseActual()==fase2}">
                        <spring:url value="/partida/tablero/celda9/${partida.id}" var="editUrl"></spring:url>
                            <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">
                                <img id= "celda8" width="190" height="266" src="${tablero.getCeldas().get(8).getCartas().get(0).getImagen()}">
                            </a>
                    </c:when>
                    <c:otherwise>
                        <img id= "celda8" width="202" height="282" src="${tablero.getCeldas().get(8).getCartas().get(0).getImagen()}">
                        <c:if test="${tablero.getCeldas().get(8).getOcupado()==true}">
                            <img id= "ficha0" width="100" height="150" src="${tablero.getCeldas().get(8).getFicha()}"style = "position: absolute; right: 180;top: 40;">
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </div>


            <div class="celda"></div><div class="celda"></div><div class="celda"></div><div class="celda"></div>
            <div class="celda"></div><div class="celda"></div><div class="celda"></div><div class="celda"></div>
            <div class="celda"></div><div class="celda"></div><div class="celda"></div><div class="celda"></div>
            <div class="celda"></div><div class="celda"></div><div class="celda"></div>
            <div class="celda"></div><div class="celda"></div><div class="celda"></div>


            <div class="celda">
                <c:choose>
                    <c:when test="${tablero.getCeldasEspeciales().get(0).getOcupado()==false && actual==partida.getJugadorActivo() && partida.getFaseActual()==fase2}">
                        <spring:url value="/partida/tablero/celda_especial1/${partida.id}" var="editUrl"></spring:url>
                            <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">
                                <img id= "celda_especial0" width="190" height="266" src="${tablero.getCeldasEspeciales().get(0).getCartas().get(0).getImagenEspecial()}">
                            </a>
                    </c:when>
                    <c:otherwise>
                        <img id= "celda_especial0" width="202" height="282" src="${tablero.getCeldasEspeciales().get(0).getCartas().get(0).getImagenEspecial()}">
                        <c:if test="${tablero.getCeldasEspeciales().get(0).getOcupado()==true}">
                            <img id= "ficha_especial0" width="100" height="150" src="${tablero.getCeldasEspeciales().get(0).getFicha()}"style = "position: absolute; right: 180;top: 40;">
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="celda">
                <c:choose>
                    <c:when test="${tablero.getCeldasEspeciales().get(1).getOcupado()==false && actual==partida.getJugadorActivo() && partida.getFaseActual()==fase2}">
                        <spring:url value="/partida/tablero/celda_especial2/${partida.id}" var="editUrl"></spring:url>
                            <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">
                                <img id= "celda_especial1" width="190" height="266" src="${tablero.getCeldasEspeciales().get(1).getCartas().get(0).getImagenEspecial()}">
                            </a>
                    </c:when>
                    <c:otherwise>
                        <img id= "celda_especial1" width="202" height="282" src="${tablero.getCeldasEspeciales().get(1).getCartas().get(0).getImagenEspecial()}">
                        <c:if test="${tablero.getCeldasEspeciales().get(1).getOcupado()==true}">
                            <img id= "ficha_especial1" width="100" height="150" src="${tablero.getCeldasEspeciales().get(1).getFicha()}"style = "position: absolute; right: 180;top: 40;">
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="celda">
                <c:choose>
                    <c:when test="${tablero.getCeldasEspeciales().get(2).getOcupado()==false && actual==partida.getJugadorActivo() && partida.getFaseActual()==fase2}">
                        <spring:url value="/partida/tablero/celda_especial3/${partida.id}" var="editUrl"></spring:url>
                            <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">
                                <img id= "celda_especial2" width="190" height="266" src="${tablero.getCeldasEspeciales().get(2).getCartas().get(0).getImagenEspecial()}">
                            </a>
                    </c:when>
                    <c:otherwise>
                        <img id= "celda_especial2" width="202" height="282" src="${tablero.getCeldasEspeciales().get(2).getCartas().get(0).getImagenEspecial()}">
                        <c:if test="${tablero.getCeldasEspeciales().get(2).getOcupado()==true}">
                            <img id= "ficha_especial2" width="100" height="150" src="${tablero.getCeldasEspeciales().get(2).getFicha()}"style = "position: absolute; right: 180;top: 40;">
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </div>


            <div class="celda"></div><div class="celda"></div><div class="celda"></div><div class="celda"></div>
            <div class="celda"></div><div class="celda"></div><div class="celda"></div><div class="celda"></div>
            <div class="celda"></div><div class="celda"></div><div class="celda"></div><div class="celda"></div>
            <div class="celda"></div><div class="celda"></div><div class="celda"></div><div class="celda"></div>
            <div class="celda"></div><div class="celda"></div><div class="celda"></div><div class="celda"></div>


            <div class="center">
                <c:choose>
                    <c:when test="${actual==partida.getJugadorActivo() && partida.getCartasIguales() && partida.getCartasColocadas()!=3 && partida.getFaseActual()==fase1}">
                        <spring:url value="/partida/tablero/celda_montana/${partida.id}" var="editUrl"></spring:url>
                            <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">
                                <img id= "celda_montana" width="190" height="266" src="/resources/images/cartas/carta_trasera.png">
                            </a>
                    </c:when>
                    <c:when test="${actual==partida.getJugadorActivo() && !partida.getCartasIguales() && partida.getCartasColocadas()!=2 && partida.getFaseActual()==fase1}">
                        <spring:url value="/partida/tablero/celda_montana/${partida.id}" var="editUrl"></spring:url>
                            <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">
                                <img id= "celda_montana" width="190" height="266" src="/resources/images/cartas/carta_trasera.png">
                            </a>
                    </c:when>
                    <c:otherwise>
                        <img id= "celda_montana" width="202" height="282" src="/resources/images/cartas/carta_trasera.png">
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </body>
</game:layout>
</div>
    <div class="chat_container">
        <h2>CHAT</h2>
        <div id="chat_id">
            <c:forEach items="${chat}" var="chat">
                <p>(${chat.username}): ${chat.mensaje}</p>
            </c:forEach>
        </div>
        <form:form modelAttribute="chat" action="/partida/tablero/${partida.id}/chat" class="form-horizontal" id="add-owner-form" >
            <div class="form-group has-feedback">
                <input name = "mensaje" path = "mensaje">
            </div>
            <div class="col-sm-offset-2 col-sm-10">
                <button class="btn btn-default" type="submit">Enviar</button>
            </div>
        </form:form>
    </div>
</div>
<script>
    var objDiv = document.getElementById("chat_id");
    objDiv.scrollTop = objDiv.scrollHeight;
</script>

