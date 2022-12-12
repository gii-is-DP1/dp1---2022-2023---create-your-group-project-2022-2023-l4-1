package org.springframework.samples.petclinic.statistics;

import java.util.Collection;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadisticaRepository extends CrudRepository<Estadistica, Integer>{
    Collection<Estadistica> findAll();

    @Query("SELECT statistics FROM Estadistica statistics WHERE statistics.id = :id")
    Estadistica findByID(@Param("id") int id);

    @Query("SELECT estadistica FROM Estadistica estadistica WHERE estadistica.user.username =:username")
    public Optional<Estadistica> findByUsername(@Param("username") String username) ;
    
}
