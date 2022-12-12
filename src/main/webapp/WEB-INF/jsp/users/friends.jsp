<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="users">
    <table id="usersTable" class="table table-striped">
        <thead>
        <tr>
            <th>Nombre</th>
            <th>Username</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${friends}" var="friend">
            <tr>
                <td>
                    <c:out value="${friend.nombre}"/>
                </td>
                <td>                    
                    <c:out value="${friend.username}"/>
                </td>
                <td> 
                    <a href="/users/${user.username}/friends/${friend.username}/delete"> 
                        <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                    </a>      
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <tr> 
        <td>
            <a class="btn btn-default" href="/users/perfil">Volver</a>
        </td>  
    </tr>

</petclinic:layout>