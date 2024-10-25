package org.example.dao;

public class MecanicoDaoFactory {
    public MecanicoDaoFactory() {
    }
    public static MecanicoDao get() {
        return new MecanicoDaoImpl();
    }
}
