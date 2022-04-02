package com.icai.practicas.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TelefonoTest {
    @Test
    void testValidar() {
        boolean res;
        Telefono tel;

        // (1): tel no está en el formato correcto 
        tel = new Telefono("No tengo telefono");
        res = tel.validar();
        assertEquals(false,res);

        // (2): Todo correcto
        tel = new Telefono("+34 688148129");
        res = tel.validar();
        assertEquals(true,res);
    }
}
