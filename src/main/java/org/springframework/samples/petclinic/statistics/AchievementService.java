package org.springframework.samples.petclinic.statistics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.jugador.Jugador;
import org.springframework.samples.petclinic.jugador.JugadorService;
import org.springframework.samples.petclinic.user.UserService;
import org.springframework.stereotype.Service;

@Service
public class AchievementService {
    
    AchievementRepository repo;
    JugadorService jugadorService;
    UserService userService;

    @Autowired
    public AchievementService(AchievementRepository repo, JugadorService jugadorService, UserService userService) {
        this.repo=repo;
        this.jugadorService = jugadorService;
        this.userService = userService;
    }

    List<Achievement> getAchievements(){
        return repo.findAll();
    }

    public Achievement getById(int id){
        return repo.findById(id).get();
    }

    public void deleteAchievementById(int id){
        repo.deleteById(id);
    }

    public void save(Achievement achievement) throws Exception{
        List<Achievement> achievements = repo.findByName(achievement.getName());
        for(Achievement a : achievements){
            if(a.getName() == achievement.getName()){
                throw new Exception();
            }
        }
        repo.save(achievement);
    }

    public void save2(Achievement achievement){
        repo.save(achievement);
    }

    public void achievement1(String username) {
        List<Jugador> partidasJugadas = jugadorService.getJugadoresPorUsername(username);
        Integer partidasGanadas = 0;
        for (Jugador j: partidasJugadas) {
            if (j.getEsGanador()) partidasGanadas++;
        }
        if (partidasGanadas == 10) userService.findUser(username).get().getAchievements().add(repo.findById(1).get());
    }

    public void achievement2(String username) {
        List<Jugador> partidasJugadas = jugadorService.getJugadoresPorUsername(username);
        if (partidasJugadas.size() == 10) userService.findUser(username).get().getAchievements().add(repo.findById(1).get());
    }

    public void achievement4(String username) {
        if (userService.findUser(username).get().getFriends().size() > 0) userService.findUser(username).get().getAchievements().add(repo.findById(4).get());
    }

    public void achievement5(String username) {
        List<Jugador> partidasJugadas = jugadorService.getJugadoresPorUsername(username);
        Integer partidasPerdidas = 0;
        for (Jugador j: partidasJugadas) {
            if (!j.getEsGanador()) partidasPerdidas++;
        }
        if (partidasPerdidas == 10) userService.findUser(username).get().getAchievements().add(repo.findById(5).get());
    }

    public void achievement6(String username) {
        List<Jugador> partidasJugadas = jugadorService.getJugadoresPorUsername(username);
        Integer partidasGanadas = 0;
        for (Jugador j: partidasJugadas) {
            if (j.getEsGanador()) partidasGanadas++;
        }
        if (partidasGanadas == 1) userService.findUser(username).get().getAchievements().add(repo.findById(6).get());
    }

    public void achievement8(String username) {
        List<Jugador> partidasJugadas = jugadorService.getJugadoresPorUsername(username);
        Boolean conseguido = false;
        for (Jugador j: partidasJugadas) {
            if (j.getCantidadAcero() > 0 && j.getCantidadHierro() > 0 && j.getCantidadOro() > 0 && j.getCantidadMedallas() > 0) {
                conseguido = true;
            }
        }
        if (conseguido == true) userService.findUser(username).get().getAchievements().add(repo.findById(8).get());
    }

    public void achievement9(String username) {
        List<Jugador> partidasJugadas = jugadorService.getJugadoresPorUsername(username);
        Boolean conseguido = false;
        for (Jugador j: partidasJugadas) {
            if (j.getCantidadAcero() >= 50 || j.getCantidadHierro() >= 50 && j.getCantidadOro() >= 50 && j.getCantidadMedallas() >= 50) {
                conseguido = true;
            }
        }
        if (conseguido == true) userService.findUser(username).get().getAchievements().add(repo.findById(9).get());
    }

    public void achievement10(String username) {
        if (userService.findUser(username).get().getAchievements().size() == 9) userService.findUser(username).get().getAchievements().add(repo.findById(10).get());
    }


    public void evaluarLogros(String username) {
        this.achievement1(username);
        this.achievement2(username);
        this.achievement4(username);
        this.achievement5(username);
        this.achievement6(username);
        this.achievement8(username);
        this.achievement9(username);
        this.achievement10(username);
    }

    
}