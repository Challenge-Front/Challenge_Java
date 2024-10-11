package org.example.oficina;

import org.example.models.oficina.Mecanico;
import org.example.models.oficina.Oficina;
import org.junit.jupiter.api.Test;

public class MecanicoTest {
    @Test
    void teste_construtor(){
        Oficina oficinaMock = new Oficina(1L, "Oficina Y", "12345678901234");
        Mecanico mecanicoMock = new Mecanico("Vagner", 1983,"email@gmail.com","11912345678","11111111111",oficinaMock.getCnpj());
    }
}
