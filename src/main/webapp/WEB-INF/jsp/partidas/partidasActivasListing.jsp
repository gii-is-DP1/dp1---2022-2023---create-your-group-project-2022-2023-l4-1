<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<petclinic:layout pageName="partidasActivas">
    <h2>Partidas Activas</h2>
    <c:choose>
        <c:when test="${partidas.size()==0}">
            <p>No hay partidas disponibles en las que poder unirte. En cualquier caso, ¡siempre puedes crear tu propia partida!</p>
            <br/>
            <spring:url value="/partida/create/" var="editUrl"></spring:url>
                <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">Crear partida</a>
        </c:when>
        <c:otherwise>
            <table id="partidaTable" class="table table-striped">
                <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Jugadores</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${partidas}" var="partida">
                    <tr>
                        <td>
                            <c:out value="${partida.nombreSala}"/>
                        </td>
                        <td>
                            <c:forEach items="${partida.usersOnTheGame}" var="entry">
                                <c:out value="${entry.username}"/>
                                <p></p>
                            </c:forEach>
                        </td>
                        <td>
                            <a href="/partida/lobby/${partida.id}">
                                <button type="button" class="btn btn-success">Unirme</button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="row">
                <div class="col-md-12">
                    <spring:url value="/resources/images/meme-shaggy.gif" htmlEscape="true" var="dwarfGif"/>
                    <marquee><img class="img-responsive" src="${dwarfGif}"/></marquee>	

                </div>
            </div>
        </c:otherwise>
    </c:choose>
</petclinic:layout>