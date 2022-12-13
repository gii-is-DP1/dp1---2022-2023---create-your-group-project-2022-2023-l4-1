<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="invitations">
    <table id="invitationsTable" class="table table-striped">
        <thead>
        <tr>
            <th>Solicitudes</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${invitationsList}" var="invitation">
            <tr>
                <td>
                    <c:out value="${invitation.sender.username}"/>
                </td> 
                <td style="text-align:right">
                    <a class="btn btn-default" href="/users/${invitation.receiver.username}/accept/${invitation.id}">Aceptar</a>
                    <a class="btn btn-default" href="/users/${invitation.receiver.username}/cancelInvite/${invitation.id}">Rechazar</a>
                </td> 
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <tr> 
        <td>
            <a class="btn btn-default" href="/users/${username}/invite">Enviar Solicitud</a>
        </td>  
    </tr>

    <tr> 
        <td>
            <a class="btn btn-default" href="/users/perfil">Volver</a>
        </td>  
    </tr>

</petclinic:layout>