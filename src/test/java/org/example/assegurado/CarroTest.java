package org.example.assegurado;

import org.example.models.assegurado.Carro;
import org.example.models.assegurado.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarroTest {
    @Test
    void quando_diagnostico_for_nulo_retorna_falso(){
        Pessoa pessoaMock = new Pessoa("Guilherme", 18,"email@gmail.com","11912345678","11111111111");
        Carro carroMock = new Carro(1L,"Volkswagen","Jetta","ABC1234",2021,pessoaMock.getCpf());
        carroMock.setPreDiagnostico(null);
        Assertions.assertFalse(carroMock.isCarroComSintomas());
    }

    @Test
    void quando_tiver_diagnostico_retornar_true(){
        Pessoa pessoaMock = new Pessoa("Guilherme", 18,"email@gmail.com","11912345678","11111111111");
        Carro carroMock = new Carro(1L,"Volkswagen","Jetta","ABC1234",2021,pessoaMock.getCpf());
        carroMock.setPreDiagnostico("Carro está com problema no motor");
        Assertions.assertTrue(carroMock.isCarroComSintomas());
    }

    @Test
    void quando_placa_tiver_7_digitos_retorna_seu_valor(){
        Pessoa pessoaMock = new Pessoa("Guilherme", 18,"email@gmail.com","11912345678","11111111111");
        Carro carroMock = new Carro(1L,"Volkswagen","Jetta","ABC1234",2021,pessoaMock.getCpf());
        Assertions.assertEquals("ABC1234",carroMock.isPlacaValida());
    }
    @Test
    void quando_placa_nao_tiver_7_digitos_retorna_exception(){
        Pessoa pessoaMock = new Pessoa("Guilherme", 18,"email@gmail.com","11912345678","11111111111");
        Carro carroMock = new Carro(1L,"Volkswagen","Jetta","ABC12345",2021,pessoaMock.getCpf());
        Assertions.assertThrows(RuntimeException.class, ()->carroMock.isPlacaValida());
    }
}
