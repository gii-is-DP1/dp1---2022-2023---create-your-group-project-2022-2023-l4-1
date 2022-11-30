<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="perfil">

    <h2>Mi perfil</h2>


    <table class="table table-striped">
        <tr>
            <th>Name</th>
            <td><b><c:out value="${user.username}"/></b></td>
            <th>Contrasena</th>
            <td><b><c:out value="${user.password}"/></b></td>
            <th>Nombre</th>
            <td><b><c:out value="${user.nombre}"/></b></td>
        </tr>
    </table>

    <spring:url value="perfil/edit/${user.username}" var="editUrl">
    </spring:url>
    <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">Editar perfil</a>


</petclinic:layout>