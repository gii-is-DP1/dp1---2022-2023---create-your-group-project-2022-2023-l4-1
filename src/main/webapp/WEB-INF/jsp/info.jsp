<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<% response.setContentType( "text/html; charset=utf-8" ); %>

<style>

    .colorletter{
    color:"white";
    }
	.background{
	background-image: url("/resources/images/fondoInfo.jpg");
	background-repeat:no-repeat;
	background-size: 100%;
    }
    </style>

<petclinic:layout pageName="info">
    <body class="background">
        <div class="row">
        <center><h2 style="color: white; text-shadow: 3px 3px 6px #000000;"><font face="verdana" SIZE="10">Informacion del juego</font></h2></center><br/>

        <center><p style="color: rgb(143, 219, 219)"><font SIZE="5">
            En la majestuosa Montana, conocida por tu pueblo como Montana del perpetuo
            trabajo comunal se hallan profundas minas, minas llenas de musica. Un millar de
            voces se elevan como una sola, siguiendo el ritmico golpear de los picos. Mas arriba,
            los martillos interpretan sus solos sobre el yunque mientras forjan objetos legendarios.
            Quejumbrosas elegias se susurran en los claustrofobicos tuneles, mientras el hierro
            fundido resurge como acero, un proceso mitico que requiere concentracion y
            dedicacion. A veces, los canticos devienen en horribles aullidos que se tornan en gritos
            de guerra al sentir la presencia del enemigo, atraido por los tesoros que guardan las minas.
            
            Estas orgulloso se haber nacido en las minas. Orgulloso hasta el punto de no haberlas
            dejado jamas; despues de todo, si hubiera cosas mejores en el exterior, ¿por que otras
            criaturas querrian entrar? Aportas tu grano de arena para defender tu hogar -nadie
            podra llamarte cobarde- pero tu verdadera pasion reside en elaborar hermosos
            objetos. La primera vez que viste los hermosos artefactos elaborados por tu pueblo,
            supiste que querias contribuir a engrandecer ese legado. Para ello necesitas algo de
            perseverancia y dar con las materias primas adecuadas...</p>
        </font></center><br/>


        <spring:url value="/resources/images/DwarfGif.gif" htmlEscape="true" var="dwarfGif"/>
        <marquee><img class="img-responsive" src="${dwarfGif}"/></marquee>


        <center><p><h2>...</h2></p></center><br/>


        <p><h2 style="color: white; text-shadow: 3px 3px 6px #000000;"><font face="verdana" SIZE="15"></font> Objetivo del juego</h2></p>
        <p style="color: rgb(143, 219, 219)"><font SIZE="5">
            Un enano se vuelve leyenda mediante su contribucion a la sociedad. Esta
            contribucion se mide a traves de los bienes que ha aportado y que ha defendido. Al
            final del juego, cada jugador determina la cantidad de Acero, Oro y Objetos
            que ha acumulado. El ganador se convertira en el 'Heroe bajo la Montana' y sera
            el jugador que consiga ostentar mas mayorias entre las tres categorias. Los empates
            son ganados por el jugador con mas Medallas. Si perdura el empate, el Hierro
            es el segundo criterio para deshacer empates y los Objetos el tercero.</p>
        </font><br/>
            
        </div>
        </body>
</petclinic:layout>