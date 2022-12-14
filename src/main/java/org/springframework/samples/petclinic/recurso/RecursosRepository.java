package org.springframework.samples.petclinic.recurso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursosRepository extends  CrudRepository<Recursos, Integer>{
    

    
}
