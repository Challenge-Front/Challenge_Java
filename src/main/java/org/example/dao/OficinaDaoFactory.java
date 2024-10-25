package org.example.dao;

public class OficinaDaoFactory {
    public OficinaDaoFactory() {
    }
    public static OficinaDao get(){
        return new OficinaDaoImpl();
    }
}
