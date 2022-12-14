package org.springframework.samples.petclinic.recurso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecursosService {

    private RecursosRepository RecursosRepo;

    @Autowired
	public RecursosService(RecursosRepository RecursosRepository) {
		this.RecursosRepo = RecursosRepository;
	}
    
    @Transactional(readOnly = true)
	public int RecursosCount() {
		return (int) RecursosRepo.count();
	}

	@Transactional(readOnly = true)
	public Iterable<Recursos> findAll() {
		return RecursosRepo.findAll();
	}

    @Transactional(readOnly = true)
	public Optional<Recursos> findByResourcesId(int id){
		return RecursosRepo.findById(id);
	}

    @Transactional
	public void saveResources(Recursos recursos) throws DataAccessException {
		RecursosRepo.save(recursos);		

	}
	
    
}
