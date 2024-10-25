package org.example.dao;

public class EnderecoDaoFactory {
    public EnderecoDaoFactory() {
    }
    public static EnderecoDao get() {
        return new EnderecoDaoImpl();
    }
}
