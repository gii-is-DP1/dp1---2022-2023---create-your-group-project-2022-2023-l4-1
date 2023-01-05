package org.springframework.samples.petclinic.chat;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.partida.Partida;

import lombok.Getter;
import lombok.Setter;


    
@Entity
@Getter
@Setter
@Table(name="chat")
public class Chat extends BaseEntity{
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chat")
    private List<Mensaje> mensajes;

    @OneToOne
    @JoinColumn(name = "partida_id")
    private Partida partida;

    public Chat(){
        this.mensajes = new ArrayList<>();
        this.partida = null;
    }

}
