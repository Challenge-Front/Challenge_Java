package org.example.service;

public class PessoaServiceFactory {
    private PessoaServiceFactory() {
    }

    public static PessoaService create(){
        return new PessoaServiceImpl();
    }
}
