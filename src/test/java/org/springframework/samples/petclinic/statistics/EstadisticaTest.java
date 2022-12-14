package org.springframework.samples.petclinic.statistics;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.Test;

public class EstadisticaTest {
    
    @Test
    public void getTiempoFormattedSuccessTest(){
        Estadistica estadistica = new Estadistica();
        long tiempoJugado = 25375l;
        estadistica.setTiempoJugado(Duration.ofSeconds(tiempoJugado));
        System.out.println(tiempoJugado);
        boolean actualResult = estadistica.getTiempoFormatted().equals("7h:02m:55s");

        assertTrue(actualResult);
    }

    @Test
    public void getTiempoFormattedUnsuccesfulTest(){
        Estadistica estadistica = new Estadistica();
        long tiempoJugado = 0l;
        estadistica.setTiempoJugado(Duration.ofSeconds(tiempoJugado));

        boolean actualResult = estadistica.getTiempoFormatted().equals("3h:45m:24s");

        assertFalse(actualResult);
    }
}
