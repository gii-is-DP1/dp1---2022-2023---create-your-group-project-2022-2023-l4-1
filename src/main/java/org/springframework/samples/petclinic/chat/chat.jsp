//Provisional

<body>
    <a href="<spring:url value="/partida/lobby/${id}" htmlEscape="true" /> </a>

        <h1>CHAT</h1>
        <h2>
            <c:forEach items = "${chat}" var = "mensaje">
                <br> 
                <c:out value = "${mensaje.jugador.user.username}"/>: &nbsp;<c:out value = "${mensaje.text}"/>
            </c:forEach>
        </h2>


        <form:form modelAttribute="mensaje" class="form-horizontal">
            <input name="text" type="text" label=" "/>
            <div class="form-group submit-buttons">
                <div class="col-sm-offset-2 col-sm-10">
                   <button class="button" type="submit">Enviar</button>
                </div>
            </div>
        
        </form:form>



</body>