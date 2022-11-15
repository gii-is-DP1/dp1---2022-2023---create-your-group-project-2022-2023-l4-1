package org.springframework.samples.petclinic.partida;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.user.Authorities;
import org.springframework.samples.petclinic.user.AuthoritiesRepository;
import org.springframework.stereotype.Service;


@Service

public class PartidaService {


    PartidaRepository repo;

    AuthoritiesRepository authRepo;
    
    @Autowired
    public PartidaService(PartidaRepository repo, AuthoritiesRepository authRepo) {
        this.repo = repo;
        this.authRepo = authRepo;
    }


    List<Partida> getPartidas(){
        return repo.findAll();
    }

    Authorities getAuthorityByUsername(String username){
        return authRepo.findByUser(username);
    }
}
