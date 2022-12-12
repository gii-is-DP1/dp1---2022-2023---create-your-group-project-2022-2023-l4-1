<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="estadistica">

    <h2>Mis Estadisticas</h2><br/>
    

        <table class="table table-striped">
            
            <tr> 
                <th>Tiempo Jugado</th>
                <td><c:out value="${estadistica.getTiempoFormatted()}"/></td>
            </tr>
            <tr>
                <th>Partidas Jugadas</th>
                <td><c:out value="${estadistica.partidasJugadas}"/></td>
            </tr>
            <tr>
                <th>Partidas Ganadas</th>
                <td><c:out value="${estadistica.partidasGanadas}"/></td>
            </tr>
            
            <tr>
                <th>Total de Hierro</th>
                <td><c:out value="${estadistica.hierroTotal}"/></td>
            </tr>
            <tr>
                <th>Total de Oro</th>
                <td><c:out value="${estadistica.oroTotal}"/></td>
            </tr>
            <tr>
                <th>Total de Acero</th>
                <td><c:out value="${estadistica.aceroTotal}"/></td>
            </tr>
            <tr>
                <th>Total de Objetos</th>
                <td><c:out value="${estadistica.objetosTotal}"/></td>
            </tr>
            <tr>
                <th>Total de Medallas</th>
                <td><c:out value="${estadistica.medallasTotal}"/></td>
            </tr>
        </table>

	
</petclinic:layout>