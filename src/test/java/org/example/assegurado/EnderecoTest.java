package org.example.assegurado;

import org.example.models.assegurado.Endereco;
import org.junit.jupiter.api.Test;

public class EnderecoTest {
    @Test
    void teste_construtor_endereco(){
        Endereco e1 = new Endereco(1L,"Rua tal","250","Jd.Barbacena","SP","Cotia","06710-400","111111111-06");
    }
}
