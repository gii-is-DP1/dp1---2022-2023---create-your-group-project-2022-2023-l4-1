package org.springframework.samples.petclinic.chat;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MensajeService {

    private MensajeRepository mensajeRepository;

    @Autowired
    public MensajeService(MensajeRepository mensajeRepository) {
        this.mensajeRepository = mensajeRepository;
    }

    @Transactional
    public Mensaje save(Mensaje m){
       return mensajeRepository.save(m);
    }

    @Transactional(readOnly = true)
    public Integer devuelveIdMax(){
        Integer idMax;
        List<Mensaje> todos = getAll();
        if(todos.isEmpty()){
            idMax=0;
        }else{
            idMax= todos.stream().max(Comparator.comparing(x -> x.getId())).map(x -> x.getId()).get();
        }
        return idMax;
    }

    @Transactional(readOnly = true)
    public List<Mensaje> getAll(){
        List<Mensaje> m = mensajeRepository.findAll();
        return m;
    }
}
