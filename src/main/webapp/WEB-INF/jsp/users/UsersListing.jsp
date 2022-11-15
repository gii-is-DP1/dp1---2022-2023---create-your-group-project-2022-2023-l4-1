<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="usuarios">
    <h2>Usuarios</h2>

    <table id="usuarioTable" class="table table-striped">
        <thead>
        <tr>
            <th>Username</th>
            <th>Password</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Foto de Perfil</th>
            <th>Biografia</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${usuarios}" var="usuario">
            <tr>
                <td>
                    <c:out value="${usuario.username}"/>
                </td>
                <td>
                    <c:out value="${usuario.password}"/>
                </td>
                 <td>
                    <c:out value="${usuario.nombre}"/>
                 </td>
                 <td>
                    <c:out value="${usuario.apellido}"/>
                </td>
                <td>                    
                    <c:if test="${usuario.fotoPerfil == ''}">none</c:if>
                    <c:if test="${usuario.fotoPerfil != ''}">
                        <img src="${usuario.fotoPerfil}" width="100px"  /> 
                    </c:if>
                </td>
                <td>
                    <c:out value="${usuario.biografia}"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</petclinic:layout>