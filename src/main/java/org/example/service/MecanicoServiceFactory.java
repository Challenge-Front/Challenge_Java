package org.example.service;

public class MecanicoServiceFactory {

    public MecanicoServiceFactory() {
    }
    public MecanicoService get() {
        return new MecanicoServiceImpl();
    }
}
