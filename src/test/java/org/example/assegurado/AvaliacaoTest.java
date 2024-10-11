package org.example.assegurado;

import org.example.models.assegurado.Avaliacao;
import org.junit.jupiter.api.Test;

public class AvaliacaoTest {
    @Test
    void testar_construtor(){
        Avaliacao avaliacaoMock = new Avaliacao("Muito Bom", 5,"usuário1");
    }
}
