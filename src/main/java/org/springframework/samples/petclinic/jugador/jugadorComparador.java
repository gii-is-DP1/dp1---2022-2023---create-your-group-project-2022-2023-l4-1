package org.springframework.samples.petclinic.jugador;

public class jugadorComparador {
    
    public int cmopareTo(Jugador o1 ,Jugador o2){
        return o1.getId().compareTo(o2.getId());

}

}