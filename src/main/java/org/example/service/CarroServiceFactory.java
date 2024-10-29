package org.example.service;

public class CarroServiceFactory {
    public CarroServiceFactory() {
    }
    public static CarroService create(){
        return new CarroServiceImpl();
    }
}
