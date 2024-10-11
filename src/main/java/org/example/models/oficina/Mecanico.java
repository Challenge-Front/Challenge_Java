package org.example.models.oficina;

import org.example.models.assegurado.Pessoa;

public class Mecanico extends Pessoa {

    private String cnpjOficina;

    public Mecanico(String nome, int anoNascimento, String email, String telefone, String cpf,String cnpjOficina) {
        super(nome, anoNascimento, email, telefone, cpf);
        this.cnpjOficina = cnpjOficina;
    }


    public String getCnpjOficina() {
        return cnpjOficina;
    }
}
