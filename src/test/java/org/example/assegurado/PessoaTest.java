package org.example.assegurado;

import org.example.models.assegurado.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PessoaTest {
    @Test
    void quando_cpf_tiver_11_digitos_da_certo(){
        Pessoa pessoaMock = new Pessoa("Guilherme", 2005,"email@gmail.com","11912345678","11111111111");
        Assertions.assertEquals("11111111111", pessoaMock.isCpfValido());
    }
    @Test
    void quando_cpf_nao_tiver_11_digitos_throw_exception(){
        Pessoa pessoaMock = new Pessoa("Guilherme", 2005,"email@gmail.com","11912345678","1");
        Assertions.assertThrows(RuntimeException.class,() -> pessoaMock.isCpfValido());
    }

    @Test
    void quando_idade_menor_que_18_throws_runtime(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            new Pessoa("Guilherme", 2010,"email@gmail.com","11912345678","11111111111");
        });
    }

    @Test
    void quando_idade_maior_que_18_return_true(){
        Pessoa pessoaMock = new Pessoa("Guilherme", 1990,"email@gmail.com","11912345678","11111111111");
        Assertions.assertTrue(pessoaMock.isMaiorIdade(pessoaMock.getIdade()));
    }
}
