package org.springframework.samples.petclinic.statistics;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
    public void saveStatistics(Estadistica estadisticas) throws DataAccessException {
        estadisticaRepository.save(estadisticas);
    }
    //Actualiza las estadisticas al finalizar partida
    /*  
    @Transactional
    public void updateStatistics(PlayerState playerState, Estadistica estadisticas, boolean winner) {
        if (winner) estadisticas.partidasGanadas++;
        estadisticas.setOroTotal(estadisticas.oroTotal + playerState.getGold());
        estadisticas.setAceroTotal(estadisticas.aceroTotal + playerState.getSteel());
        estadisticas.setObjetosTotal(estadisticas.hierroTotal + playerState.getObject());
        estadisticas.setHierroTotal(estadisticas.objetosTotal + playerState.getIron());
        estadisticas.setMedallasTotal(estadisticas.medallasTotal + playerState.getMedal());
        estadisticas.setPartidasJugadas(estadisticas.partidasJugadas++);
        estadisticaRepository.save(estadisticas);
    }
    */
}
