<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="perfil">

    <h2>Mi perfil</h2>


    <table class="table table-striped">
        <td>                    
            <c:if test="${user.fotoPerfil == ''}">none</c:if>
            <c:if test="${user.fotoPerfil != ''}">
                <img src="${user.fotoPerfil}" width="500px"  /> 
            </c:if>
        </td>
        
        <tr>
            <th>Name</th>
            <td><b><c:out value="${user.username}"/></b></td>
        </tr>
        <tr>
            <th>Contrasena</th>
            <td><b><c:out value="${user.password}"/></b></td>
        </tr>

        <tr>
            <th>Email</th>
            <td><b><c:out value="${user.email}"/></b></td>
        </tr>

        <tr>
            <th>Biografia</th>
            <td><b><c:out value="${user.biografia}"/></b></td>
        </tr>

        <tr>
            <th>Nombre</th>
            <td><b><c:out value="${user.nombre}"/></b></td>
        </tr>

        <tr>
            <th>Apellidos</th>
            <td><b><c:out value="${user.apellidos}"/></b></td>
        </tr>
        

    </table>

    <spring:url value="{usurname}/edit" var="editUrl">
        <spring:param name="usurname" value="${usurname}"/>
    </spring:url>
    <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">Edit Usuario</a>

    
	
</petclinic:layout>

