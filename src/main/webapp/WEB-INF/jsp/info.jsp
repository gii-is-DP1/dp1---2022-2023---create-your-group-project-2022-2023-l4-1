<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
        <center><h2 style="color: white; text-shadow: 3px 3px 6px #000000;"><font face="verdana" SIZE="10">Información del juego.</font></h2></center><br/>

        <center><p style="color: rgb(143, 219, 219)"><font SIZE="5">
            En la majestuosa Montaña, conocida por tu pueblo como Montaña del perpetuo
            trabajo comunal se hallan profundas minas, minas llenas de música. Un millar de
            voces se elevan como una sola, siguiendo el rítmico golpear de los picos. Más arriba,
            los martillos interpretan sus solos sobre el yunque mientras forjan objetos legendarios.
            Quejumbrosas elegías se susurran en los claustrofóbicos túneles, mientras el hierro
            fundido resurge como acero, un proceso mítico que requiere concentración y
            dedicación. A veces, los cánticos devienen en horribles aullidos que se tornan en gritos
            de guerra al sentir la presencia del enemigo, atraído por los tesoros que guardan las minas.
            
            Estás orgulloso se haber nacido en las minas. Orgulloso hasta el punto de no haberlas
            dejado jamás; después de todo, si hubiera cosas mejores en el exterior, ¿por qué otras
            criaturas querrían entrar? Aportas tu grano de arena para defender tu hogar -nadie
            podrá llamarte cobarde- pero tu verdadera pasión reside en elaborar hermosos
            objetos. La primera vez que viste los hermosos artefactos elaborados por tu pueblo,
            supiste que querías contribuir a engrandecer ese legado. Para ello necesitas algo de
            perseverancia y dar con las materias primas adecuadas...</p>
        </font></center><br/>


        <spring:url value="/resources/images/DwarfGif.gif" htmlEscape="true" var="dwarfGif"/>
        <marquee><img class="img-responsive" src="${dwarfGif}"/></marquee>


        <center><p><h2>...</h2></p></center><br/>


        <p><h2 style="color: white; text-shadow: 3px 3px 6px #000000;"><font face="verdana" SIZE="15"></font> Objetivo del juego.</h2></p>
        <p style="color: rgb(143, 219, 219)"><font SIZE="5">
            Un enano se vuelve leyenda mediante su contribución a la sociedad. Esta
            contribución se mide a través de los bienes que ha aportado y que ha defendido. Al
            final del juego, cada jugador determina la cantidad de Acero, Oro y Objetos
            que ha acumulado. El ganador se convertirá en el 'Héroe bajo la Montaña' y será
            el jugador que consiga ostentar mas mayorías entre las tres categorías. Los empates
            son ganados por el jugador con mas Medallas. Si perdura el empate, el Hierro
            es el segundo criterio para deshacer empates y los Objetos el tercero.</p>
        </font><br/>

        <p><h2 style="color: white; text-shadow: 3px 3px 6px #000000;"><font face="verdana" SIZE="15"></font> Vídeo explicativo del juego.</h2></p>
        <iframe width="1190" height="670" src="https://www.youtube.com/embed/ymlLH3CXCE8" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
            
        </div>
        </body>
</petclinic:layout>