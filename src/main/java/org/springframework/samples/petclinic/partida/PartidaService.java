package org.springframework.samples.petclinic.partida;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service

public class PartidaService {


    PartidaRepository repo;
    
    @Autowired
    public PartidaService(PartidaRepository repo) {
        this.repo = repo;
    }

    @Transactional(readOnly = true)
	public Partida findPartidaById(int id) throws DataAccessException {
		return repo.findById(id).get();
	}


    List<Partida> getPartidas(){
        return repo.findAll();
    }


    @Transactional(rollbackFor = Exception.class)
	public void delete(Partida partida) throws Exception{
		repo.delete(partida);
	}

    public void deletePartidaById(int id){
        repo.deleteById(id);
    }

}
