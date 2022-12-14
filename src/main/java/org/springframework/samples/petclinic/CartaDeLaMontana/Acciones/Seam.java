package org.springframework.samples.petclinic.CartaDeLaMontana.Acciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.carta.enums.NombreCartaMontana;
import org.springframework.samples.petclinic.jugador.Jugador;
import org.springframework.samples.petclinic.partida.Partida;
import org.springframework.samples.petclinic.partida.PartidaService;
import org.springframework.samples.petclinic.recurso.Recursos;
import org.springframework.samples.petclinic.recurso.RecursosService;
import org.springframework.samples.petclinic.recurso.enums.TipoRecurso;
import org.springframework.stereotype.Component;

@Component
public class Seam implements Accion{

    @Override
    public void actions(Jugador player, String nombreCarta) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public NombreCartaMontana getName() {
        return NombreCartaMontana.Seam;
    }

    /*

    @Autowired
	private RecursosService recursosService;
	@Autowired
	private PartidaService partidaService;

	protected Integer addCantidad;
	protected TipoRecurso recurso;
	
	@Override
	public void actions(Jugador player, String nombreCarta) throws Exception {
		this.setResources(nombreCarta);
		
		Partida game = partidaService.findPlayerUnfinishedGames(player).get();
		Recursos playerResources = recursosService.findByPlayerIdAndGameId(player.getId(),game.getId()).get();			
		playerResources.addRecurso(recurso, addCantidad);
		recursosService.saveResources(playerResources);
	}

	protected void setResources(String cardName) {
		if(cardName.equals("Iron Seam")){
			this.addCantidad = 3;
			this.recurso = TipoRecurso.Hierro;
		}else if(cardName.equals("Gold Seam")){
			this.addCantidad = 1;
			this.recurso = TipoRecurso.Oro;
		}
	}

    */
    
}
