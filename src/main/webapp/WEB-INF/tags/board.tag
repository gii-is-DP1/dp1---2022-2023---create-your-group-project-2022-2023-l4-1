<%@ attribute name="tablero" required="false" rtexprvalue="true" type="org.springframework.samples.petclinic.tablero.Tablero"
 description="Chessboard to be rendered" %>
<canvas id="canvas" width="${tablero.width}" height="${tablero.height}"></canvas>
<img id="source" src="${tablero.background}" style="display:none">
<script>
function drawBoard(){ 
    var canvas = document.getElementById("canvas");
    var ctx = canvas.getContext("2d");
    var image = document.getElementById('source');
    ctx.drawImage(image, 0, 0, ${tablero.width}, ${tablero.height});     
    <jsp:doBody/>
}
window.onload =drawBoard();
</script>