<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<petclinic:layout pageName="partidas">
    <jsp:attribute name="customScript">
        <script>
            $(function () {
                $("#birthDate").datepicker({dateFormat: 'yy/mm/dd'});
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <h2>
            <c:if test="${partida['new']}">Crear </c:if> Partida
        </h2>
        <form:form modelAttribute="partida"
                   class="form-horizontal">
            <input type="hidden" name="id" value="${partida.id}"/>
            <div class="form-group has-feedback">                
                <petclinic:inputField label="Nombre de la sala" name="nombreSala"/>
                <petclinic:selectField label="Numero de rondas"  name="rondas" names="${numRondas}" size="2"/>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <c:choose>
                        <c:when test="${partida['new']}">
                            <button class="btn btn-default" type="submit">Confirmar</button>
                        </c:when>
                        <c:otherwise>
                            <button class="btn btn-default" type="submit">Confirmar</button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </form:form>                
    </jsp:body>
</petclinic:layout>