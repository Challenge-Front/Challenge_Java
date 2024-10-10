package org.example.oficina;

import org.example.assegurado.Avaliacao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OficinaTest {
    @Test
    void quando_cpnj_diferente__de_14_digitos_throw_exception(){
        // Deve lançar uma exceção de CNPJ inválido
        Assertions.assertThrows(RuntimeException.class, () -> {
            new Oficina(1L, "Oficina DEF", "123");
        });
    }

    @Test
    void quando_cnpj_tiver_14_digitos_retorna_seu_valor(){
        Avaliacao avaliacaoMock = new Avaliacao("Muito Bom", 5,"usuário1");
        Oficina oficinaMock = new Oficina(1L, "Oficina Y", "12345678901234");
        Assertions.assertTrue( oficinaMock.isCnpjValido("12345678901234"));
    }
}
