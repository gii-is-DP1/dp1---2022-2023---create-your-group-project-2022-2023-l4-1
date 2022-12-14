package org.springframework.samples.petclinic.CartaDeLaMontana.Acciones;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.CartaDeLaMontana.CartaDeLaMontana;
import org.springframework.samples.petclinic.carta.enums.NombreCartaMontana;
import org.springframework.samples.petclinic.jugador.Jugador;
import org.springframework.samples.petclinic.partida.Partida;
import org.springframework.samples.petclinic.partida.PartidaService;
import org.springframework.samples.petclinic.recurso.Recursos;
import org.springframework.samples.petclinic.recurso.RecursosService;
import org.springframework.stereotype.Component;

@Component
public class Shide implements Accion{

    @Override
    public void actions(Jugador jugador, String nombreCarta) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
	public NombreCartaMontana getName() {
		return NombreCartaMontana.Shide;
	}

    /* 

    @Autowired
	private PartidaService gameService;
	@Autowired
	private RecursosService resourcesService;


	
	@Override
	public void actions(Jugador jugador, String cardName) throws Exception {
		
		Partida partida = partidaService.findByGameId(partidaService.getCurrentGameId(loggedUser)).get();
		Boolean defended = jugador != null || partida.getMusterAnArmyEffect();
		
		if(!defended) {
			for(Jugador p: partida.getPlayersList()) {
				this.exchangeResources(p, partida);
			}
		} else {
			if(partida.getMusterAnArmyEffect())
				return;
			Recursos playerDefenderResources = resourcesService.findByPlayerIdAndGameId(jugador.getId(),partida.getId()).get();
			playerDefenderResources.addResource(ResourceType.BADGES, 1);
		}
	}
	
	protected void exchangeResources(Jugador jugador, Partida partida) throws Exception{
		Recursos playerResources = resourcesService.findByPlayerIdAndGameId(jugador.getId(),game.getId()).get();
		playerResources.addResource(ResourceType.GOLD, -2);
		playerResources.addResource(ResourceType.IRON, 2);
	}

	*/
    
}
