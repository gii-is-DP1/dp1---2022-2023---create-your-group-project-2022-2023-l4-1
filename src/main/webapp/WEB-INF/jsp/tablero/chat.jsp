<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="game" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- %@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %--> 

<style>
  .celda {
    padding-top: 10px;
    padding-left: 10px;
    margin-left: 10px;
    position: relative;
    float: left;
    width: 30%;
    border: rgba(255, 255, 255, 0) solid 1px;
    height: auto;
  }
  .center {
    padding-top: 10px;
    padding-left: 367px;
    margin-left: 10px;
    position: relative;
    float: left;
    width: auto;
    border: rgba(255, 242, 0, 0) solid 1px;
    height: auto;
  }
  .background{
	background-image: url("${tablero.getBackground()}");
	background-repeat:repeat;
	background-size: 100%;
  }
  .chat_container {
        position: relative;
        top: 10px;
        bottom: 10px;
        width: auto;
        min-height: 200px;
        background-color: #34302d;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        border-radius: 5px;
        gap: 10px;
        padding-top: 10px;
        margin-left: 10px;
        
    }
        .chat_container>div {
            width: 90%;
            overflow-y: scroll;
            height: 400px;
        }
        .chat_container label {
            display: none;
        }
        .chat_container h2 {
            color: white;
        }
        .chat_container p {
            color: white;
        }
  
</style>
<game:layout pageName="home">
    <body class="background">
        <tr> 
            <td>
                <a class="btn btn-default" href="/partida/tablero/${partida.id}">Volver a la partida</a>
            </td>  
        </tr>
        <div class="chat_container">
            <h2>CHAT</h2>
        <div id="chat_id">
            <c:forEach items="${chat}" var="chat">
                <p>(${chat.username}): ${chat.mensaje}</p>
            </c:forEach>
        </div>
        <form:form modelAttribute="chat" action="/partida/tablero/${partida.id}/chat" class="form-horizontal" id="add-owner-form" >
            <div class="form-group has-feedback">
                <input name = "mensaje" path = "mensaje">
            </div>
            <div class="col-sm-offset-2 col-sm-10">
                <button class="btn btn-default" type="submit">Enviar</button>
            </div>
        </form:form>
        </div>
    </body>
</game:layout>

<script>
var objDiv = document.getElementById("chat_id");
objDiv.scrollTop = objDiv.scrollHeight;
</script>