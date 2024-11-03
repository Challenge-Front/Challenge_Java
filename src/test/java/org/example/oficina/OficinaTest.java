package org.example.oficina;

import org.example.models.oficina.Oficina;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OficinaTest {
    @Test
    void quando_cpnj_diferente__de_14_digitos_throw_exception(){
        // Deve lançar uma exceção de CNPJ inválido
        Assertions.assertThrows(RuntimeException.class, () -> {
            new Oficina("Rua tal 210 Jardim y", "Oficina DEF", "123");
        });
    }

    @Test
    void quando_cnpj_tiver_14_digitos_retorna_seu_valor(){
        Oficina oficinaMock = new Oficina("Rua tal 210 Jardim y", "Oficina Y", "12345678901234");
        Assertions.assertTrue( oficinaMock.isCnpjValido("12345678901234"));
    }
}
