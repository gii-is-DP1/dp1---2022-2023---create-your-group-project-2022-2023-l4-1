package org.springframework.samples.petclinic.chat;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.jugador.Jugador;
import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Mensaje extends BaseEntity{
    

    private String text;

    @NotBlank
    @Size(min=1, max=100)
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;

    @ManyToOne
    @JoinColumn(name = "jugador_id")
    private Jugador jugador;

    public Mensaje() {
        this.contenido = "";
        this.jugador = null;
        this.chat = null;
    }

}