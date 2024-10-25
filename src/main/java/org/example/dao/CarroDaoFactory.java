package org.example.dao;

public final class CarroDaoFactory {
    public CarroDaoFactory() {
    }
    public static CarroDao get() {
        return new CarroDaoImpl();
    }
}
