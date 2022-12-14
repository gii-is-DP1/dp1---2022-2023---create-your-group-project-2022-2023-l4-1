package org.springframework.samples.petclinic.statistics;

import java.time.Duration;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.user.User;
import org.springframework.stereotype.Service;

@Service
public class EstadisticaService {

    private final EstadisticaRepository estadisticaRepository;
    
    @Autowired
    EstadisticaService(EstadisticaRepository estadisticaRepository) {
        this.estadisticaRepository = estadisticaRepository;
    }
    
    
    @Transactional

    public Iterable<Estadistica> findAll() {
        return estadisticaRepository.findAll();
    }
    
    @Transactional
    public Estadistica findStatisticsByID(Integer id) throws DataAccessException{
        return this.estadisticaRepository.findByID(id);
    }    

    public Optional<Estadistica> findStatisticsByUsername(String username){
        return estadisticaRepository.findByUsername(username);
    }
    
    @Transactional
    public void newStatistics(User user) throws DataAccessException {
        Estadistica estadisticas = new Estadistica();
        estadisticas.setTiempoJugado(Duration.ofSeconds(1234));
		estadisticas.setPartidasJugadas(0);
		estadisticas.setPartidasGanadas(0);
		estadisticas.setHierroTotal(0);
		estadisticas.setOroTotal(0);
		estadisticas.setAceroTotal(0);
		estadisticas.setObjetosTotal(0);
		estadisticas.setMedallasTotal(0);
        estadisticas.setUser(user);
		estadisticaRepository.save(estadisticas);
    }
    //Actualiza las estadisticas al finalizar partida
    /*  
    @Transactional
    public void updateStatistics(Jugador jugador, Estadistica estadisticas, boolean winner) {
        if (winner) estadisticas.partidasGanadas++;
        estadisticas.setOroTotal(estadisticas.oroTotal + jugador.getGold());
        estadisticas.setAceroTotal(estadisticas.aceroTotal + jugador.getSteel());
        estadisticas.setObjetosTotal(estadisticas.hierroTotal + jugador.getObject());
        estadisticas.setHierroTotal(estadisticas.objetosTotal + jugador.getIron());
        estadisticas.setMedallasTotal(estadisticas.medallasTotal + jugador.getMedal());
        estadisticas.setPartidasJugadas(estadisticas.partidasJugadas++);
        estadisticaRepository.save(estadisticas);
    }
    */
}
