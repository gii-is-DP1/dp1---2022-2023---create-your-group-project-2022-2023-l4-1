<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="dwarf" tagdir="/WEB-INF/tags" %>

<dwarf:layout pageName="recursos">
    <h2>
        Update Recursos
    </h2>
    <form:form modelAttribute="recursos" class="form-horizontal" id="add-recursos-form">
        <div class="form-group has-feedback">
            <dwarf:inputField label="Hierro" name="hierro"/>
            <dwarf:inputField label="Acero" name="acero"/>
            <dwarf:inputField label="Oro" name="oro"/>
            <dwarf:inputField label="Objetos" name="objetos"/> 
            <dwarf:inputField label="Medalla" name="medalla"/>
            <dwarf:inputField label="PartidaId" name="partida"/>
            <dwarf:inputField label="JugadorId" name="jugador"/>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">   
                        <button class="btn btn-default" type="submit">Update Recursos</button>   
            </div>
        </div>
    </form:form>
    
</dwarf:layout>