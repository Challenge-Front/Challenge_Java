package org.example.dao;

public class PessoaDaoFactory {
    public PessoaDaoFactory() {
    }

    public static PessoaDao get() {
        return new PessoaDaoImpl();
    }
}
