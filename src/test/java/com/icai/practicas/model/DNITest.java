package com.icai.practicas.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class DNITest {
    @Test
    void testValidar() {

        boolean res;
        DNI dni;

        // (1): dniValue insertado está dentro de la tabla de INVALIDOS
        dni = new DNI("00000000T");
        res = dni.validar();
        assertEquals(false,res);

        // (2): dniValue NO está en el formato pedido
        dni = new DNI("1234f");
        res = dni.validar();
        assertEquals(false,res);

        // (3): Letra final de dniValue contiene una letra invalida (I O U)
        dni = new DNI("02572449I");
        res = dni.validar();
        assertEquals(false,res);


        // (4): Todas las condiciones cumplidas --> debería volver true
        dni = new DNI("02572449Z");
        res = dni.validar();
        assertEquals(true,res);

    }
}
