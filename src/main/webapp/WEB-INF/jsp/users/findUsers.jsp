<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!--  >%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%-->

<style>

	.background{
	background-image: url("/resources/images/cuevaNueva.jpg");
	background-repeat:no-repeat;
	background-size: 100%;
    }
    </style>

<petclinic:layout pageName="findUsers">
    <body class="background">
    <h2 style="color:aliceblue">Find Users</h2>

    
    <form:form modelAttribute="user" action="/users" method="get" class="form-horizontal"
               id="search-user-form">
        <div class="form-group">
            <div class="control-group" id="username">
                <label style="color:aliceblue" class="col-sm-2 control-label">Nombre </label>
                <div class="col-sm-10">
                    <form:input class="form-control" path="username" size="30" maxlength="80"/>
                    <span class="help-inline"><form:errors path="*"/></span>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Find User</button>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <spring:url value="/resources/images/shrek-gif-2.gif" htmlEscape="true" var="dwarfGif"/>
                <marquee><img class="img-responsive" src="${dwarfGif}"/></marquee>	

            </div>
        </div>
    </form:form>

    <br/> 
	
</petclinic:layout>