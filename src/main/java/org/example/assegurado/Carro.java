package org.example.assegurado;

public class Carro {
    private Long id;
    private String marca;
    private String modelo;
    private String placa;
    private int ano;
    private String cpfDono;
    private String preDiagnostico;

    public Carro(Long id,String marca, String modelo, String placa, int ano, String cpfDono) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.cpfDono = cpfDono;
    }

    public Long getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }


    public String getPlaca() {
        return placa;
    }

    public int getAno() {
        return ano;
    }

    public String  getCpfDono() {
        return cpfDono;
    }

    public String getPreDiagnostico() {
        return preDiagnostico;
    }

    public void setPreDiagnostico(String preDiagnostico) {
        this.preDiagnostico = preDiagnostico;
    }
    public String isPlacaValida(){
        if (placa.length() == 7){
            return placa;
        }else {
            throw new RuntimeException("Número de caracteres na placa inválido");
        }
    }
    public boolean isCarroComSintomas(){
        if(preDiagnostico == null){
            return false;
        }else{
            return true;
        }
    }
    public String verificarNecessidadeRevisao(int quilometragemAtual) {

        return quilometragemAtual > 10000 ? "Há necessidade de revisão" : "Não há necessidade de revisão";
    }

}
