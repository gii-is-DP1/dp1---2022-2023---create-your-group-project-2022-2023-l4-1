<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="partidas">
    <h2>Partidas</h2>

    <table id="partidaTable" class="table table-striped">
        <thead>
        <tr>
            <th>Nombre</th>
            <th>Ganador</th>
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
                    <c:out value="${partida.ganador.user.username}"/>
                </td>
                 <td>
                    <c:out value="${partida.usernameList}"/>
                 </td>
                 <td> 
                    <a href="/partida/partidas/${partida.id}/delete"> 
                        <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>                            
                    </a>       
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</petclinic:layout>