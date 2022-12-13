<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<petclinic:layout pageName="lobby">
    <h2>Lobby</h2>
    <table id="lobby" class="table table-striped">
        <thead>
        <tr>
            <th>Nombre</th>
            <th>Jugadores</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td>
                    <c:out value="${partida.nombreSala}"/>
                </td>
                 <td>
                    <c:out value="${partida.user0.username}"/>
                    <c:out value=" (Administrador de la partida)"/>
                    <p></p>
                    <c:out value="${partida.user1.username}"/>
                    <p></p>
                    <c:out value="${partida.user2.username}"/>
                 </td>
            </tr>
        </tbody>
    </table>
    <c:choose>
        <c:when test="${partida.user0.username==logged}">
            <spring:url value="/partida/delete/${partida.id}" var="editUrl"></spring:url>
                        <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">Eliminar sala</a>
        </c:when>
        <c:otherwise>
            <spring:url value="/partida/leave/${partida.id}" var="editUrl"></spring:url>
                        <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">Abandonar sala</a>
        </c:otherwise>
    </c:choose>
    <div class="row">
        <div class="col-md-12">
            <spring:url value="/resources/images/meme-shaggy.gif" htmlEscape="true" var="dwarfGif"/>
            <marquee><img class="img-responsive" src="${dwarfGif}"/></marquee>	

        </div>
    </div>

</petclinic:layout>