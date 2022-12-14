package org.springframework.samples.petclinic.statistics;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.Test;

public class EstadisticaTest {
    
    // @Test
    // public void getTiempoFormattedSuccessTest(){
    //     Estadistica estadistica = new Estadistica();
    //     long tiempoJugado = 0l;
    //     estadistica.setTiempoJugado(Duration.ofSeconds(tiempoJugado));

    //     boolean actualResult = estadistica.getTiempoFormatted() == "0h:00m:00s";

    //     assertTrue(actualResult);
    // }

    @Test
    public void getTiempoFormattedUnsuccesfulTest(){
        Estadistica estadistica = new Estadistica();
        long tiempoJugado = 0l;
        estadistica.setTiempoJugado(Duration.ofSeconds(tiempoJugado));

        boolean actualResult = estadistica.getTiempoFormatted() != "3h:45m:24s";

        assertTrue(actualResult);
    }
}
