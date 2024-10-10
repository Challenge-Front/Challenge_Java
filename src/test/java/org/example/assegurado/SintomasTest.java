package org.example.assegurado;

import org.junit.jupiter.api.Test;

public class SintomasTest {
    @Test
    void teste_construtor(){
        Luzes luzesMock = new Luzes(true,true,true,true,true,true,true,true,true,true,true,true,true,true);
        Sintomas sintomas = new Sintomas(1L,1l, luzesMock,"Sintomas Relatados","Diagnostico");
    }
}
