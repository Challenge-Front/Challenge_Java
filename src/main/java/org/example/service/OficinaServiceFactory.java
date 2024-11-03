package org.example.service;

public class OficinaServiceFactory {
    public OficinaServiceFactory() {
    }
    public static OficinaService create(){
        return new OficinaServiceImpl();
    }
}
