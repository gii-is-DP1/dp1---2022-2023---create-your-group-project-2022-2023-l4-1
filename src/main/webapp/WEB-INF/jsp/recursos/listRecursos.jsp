<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="dwarf" tagdir="/WEB-INF/tags" %>

<dwarf:layout pageName="recursos">
    <h2>Recursos</h2>

    <table id="recursosTable" class="table table-striped">
        <thead>
        <tr>
         	<th style="width: 150px;">ID</th>
            <th style="width: 150px;">PartidaID</th>
            <th style="width: 150px;">Jugador</th>
            <th style="width: 150px;">Hierro</th>
            <th style="width: 150px;">Acero</th>
            <th style="width: 150px;">Oro</th>
            <th style="width: 150px;">Objetos</th>
            <th style="width: 150px;">Medalla</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${recursos}" var="recursos">
            <tr>
             	<td>
                    <c:out value="${recursos.id}"/>
                </td>
                <td>
                    <c:out value="${recursos.partida.id}"/>
                </td>
                <td>
                    <c:out value="${recursos.jugador.username}"/>
                </td>
                <td>
                    <c:out value="${recursos.hierro}"/>
                </td>
                <td>
                    <c:out value="${recursos.acero}"/>
                </td>
                <td>
                    <c:out value="${recursos.oro}"/>
                </td>
                <td>
                    <c:out value="${recursos.objetos}"/>
                </td>
                <td>
                    <c:out value="${recursos.medalla}"/>
                </td>
                 
                    
    			<td>              
                    <spring:url value="/recursos/{recursosId}/edit" var="editUrl">
       					 <spring:param name="recursosId" value="${recursos.id}"/>
    				</spring:url>
    				 <a href="${fn:escapeXml(editUrl)}"><span class=" glyphicon glyphicon-edit" aria-hidden="true"></span>
							<span>Update</span></a>
                 </td> 
            </tr>
            
        </c:forEach>
        </tbody>
    </table>

	
</dwarf:layout>