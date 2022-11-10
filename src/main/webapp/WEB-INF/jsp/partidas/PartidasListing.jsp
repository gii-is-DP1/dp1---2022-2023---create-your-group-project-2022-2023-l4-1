<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="partidas">
    <h2>Partidas</h2>

    <table id="partidas" class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Duracion</th>
            <th>Ganador</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${partidas}" var="partida">
            <tr>
                <td>
                    <c:out value="${partida.name}"/>
                </td>
                <td>                    
                      <c:out value="${partida.description} "/>                                        
                </td>
                <td>       
                    <c:out value="${achievement.ganador} "/>
                </td>

                <td> 
                    <a href="/partida/partida/${partida.id}/edit"> 
                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>                            
                    </a>       
                </td>
                <td> 
                    <a href="/partida/partida/${partida.id}/delete"> 
                        <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                    </a>      
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</petclinic:layout>