<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="users">
    <h2>Available Users</h2>

    <table id="usersTable" class="table table-striped">
        <thead>
        <tr>
            <th>First Name</th>
            <th>Username</th>
            <th>Invite</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${availableList}" var="user">
                <tr>
                    <td>
                        <c:out value="${user.nombre}"/>
                    </td>
                    <td>                    
                        <c:out value="${user.username}"/>
                    </td>
                    <td> 
                        <a href="/users/${username}/invitate/${user.username}"> 
                            <span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>                            
                        </a>       
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    
    </petclinic:layout>