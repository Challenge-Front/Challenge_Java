package org.example.models.assegurado;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Luzes {
    private boolean luzGasolina;
    private boolean luzBateria;
    private boolean luzFreioDeMao;
    private boolean luzTemperaturaMotor;
    private boolean luzOleo;
    private boolean luzAirBag;
    private boolean luzInjecao;
    private boolean luzVelas;
    private boolean luzTracao;
    private boolean luzPressaoPneus;
    private boolean luzFreioABS;
    private boolean luzTransmissao;
    private boolean luzPastilhaFreio;
    private boolean luzImobilizador;

    public Luzes(boolean luzImobilizador, boolean luzPastilhaFreio, boolean luzTransmissao, boolean luzFreioABS, boolean luzPressaoPneus, boolean luzTracao, boolean luzVelas, boolean luzInjecao, boolean luzAirBag, boolean luzOleo, boolean luzTemperaturaMotor, boolean luzFreioDeMao, boolean luzBateria, boolean luzGasolina) {
        this.luzImobilizador = luzImobilizador;
        this.luzPastilhaFreio = luzPastilhaFreio;
        this.luzTransmissao = luzTransmissao;
        this.luzFreioABS = luzFreioABS;
        this.luzPressaoPneus = luzPressaoPneus;
        this.luzTracao = luzTracao;
        this.luzVelas = luzVelas;
        this.luzInjecao = luzInjecao;
        this.luzAirBag = luzAirBag;
        this.luzOleo = luzOleo;
        this.luzTemperaturaMotor = luzTemperaturaMotor;
        this.luzFreioDeMao = luzFreioDeMao;
        this.luzBateria = luzBateria;
        this.luzGasolina = luzGasolina;
    }
    public List<Field> getLuzesAcesas() throws IllegalAccessException {
        List<Field> luzesAcesas = new ArrayList<>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields){
            boolean value = field.getBoolean(this);
            if (value) {
                luzesAcesas.add(field);
            }
        }
        return luzesAcesas;
    }

}
