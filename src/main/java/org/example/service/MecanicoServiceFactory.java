package org.example.service;

public class MecanicoServiceFactory {

    public MecanicoServiceFactory() {
    }
    public static MecanicoService get() {
        return new MecanicoServiceImpl();
    }
}
