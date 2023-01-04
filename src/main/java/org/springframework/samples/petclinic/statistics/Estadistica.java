package org.springframework.samples.petclinic.statistics;

import java.time.Duration;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.user.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "estadistica")
public class Estadistica extends BaseEntity{

    @Column(name="tiempo_jugado")
    @NotNull
    public Duration tiempoJugado;

    @Column(name="partidas_jugadas")
    @NotNull
    @PositiveOrZero
    public Integer partidasJugadas;

    @Column(name="partidas_ganadas")
    @NotNull
    @PositiveOrZero
    public Integer partidasGanadas;

    @Column(name="hierro_total")
    @NotNull
    @PositiveOrZero
    public Integer hierroTotal;

    @Column(name="oro_total")
    @NotNull
    @PositiveOrZero
    public Integer oroTotal;

    @Column(name="acero_total")
    @NotNull
    @PositiveOrZero
    public Integer aceroTotal;

    @Column(name="objetos_total")
    @NotNull
    @PositiveOrZero
    public Integer objetosTotal;

    @Column(name="medallas_total")
    @NotNull
    @PositiveOrZero
    public Integer medallasTotal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="username", referencedColumnName = "username", unique = true)
    public User user;


    public String getTiempoFormatted(){
        long seconds = tiempoJugado.getSeconds();
        String result = String.format("%dh:%02dm:%02ds", seconds / 3600, (seconds % 3600) / 60, seconds % 60);
        return result;
    }

}
