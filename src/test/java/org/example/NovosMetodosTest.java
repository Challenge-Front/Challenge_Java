package org.example;

import org.example.models.assegurado.Carro;
import org.example.models.assegurado.Luzes;
import org.example.models.assegurado.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

public class NovosMetodosTest {
    @Test
    public void testando_calcular_idade_do_usuario() {
        Pessoa pessoaMock = new Pessoa("Guilherme", 2005,"123453","123453","email@gmail.com","11912345678");
        Assertions.assertEquals(19, pessoaMock.getIdade());
    }
    @Test
    public void testando_o_funcionamento_do_getLuzesAcesas() throws IllegalAccessException {
        Luzes luzesMock = new Luzes(false,false,false,true,false,false,false,false,false,false,false,false,false,false);
        List<Field> luzesAcesas = luzesMock.getLuzesAcesas();
        Assertions.assertTrue(luzesAcesas.stream().anyMatch(field -> field.getName().equals("luzFreioABS")));
    }
    @Test
    public void testando_o_funcionamento_do_validarEmail(){
        Pessoa pessoaMock = new Pessoa("Guilherme", 18,"123453", "email@gmail.com", "11912345678", "11111111111");
        Assertions.assertEquals("email@gmail.com", pessoaMock.getEmail());
    }
    @Test
    public void testando_o_validarEmail_throw_runtime(){
        Pessoa pessoaMock = new Pessoa("Guilherme", 18,"123453", "email#gmail,com", "11912345678", "11111111111");
        Assertions.assertThrows(RuntimeException.class, () -> pessoaMock.setEmail("email#gmail,com"));
    }
    @Test
    public void testando_verificador_necessidade_de_revisao(){
        Pessoa pessoaMock = new Pessoa("Guilherme", 18,"123453","email@gmail.com","11912345678","11111111111");
        Carro carroMock = new Carro(1L,"Volkswagen","Jetta","ABC1234",2021,pessoaMock.getCpf());
        Assertions.assertEquals("Há necessidade de revisão", carroMock.verificarNecessidadeRevisao(10001));
    }
    @Test
     public void testando_verificador_mostra_quando_nao_precisa_de_revisao() {
        Pessoa pessoaMock = new Pessoa("Guilherme", 18,"123453", "email@gmail.com", "11912345678", "11111111111");
        Carro carroMock = new Carro(1L,"Volkswagen", "Jetta",  "ABC1234", 2021, pessoaMock.getCpf());
        Assertions.assertEquals("Não há necessidade de revisão", carroMock.verificarNecessidadeRevisao(1000));
     }
}