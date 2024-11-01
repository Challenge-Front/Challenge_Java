package org.example.models.assegurado;

public class Carro implements ICarro {
    private Long id;
    private String marca;
    private String modelo;
    private String placa;
    private int ano;
    private String cpfDono;
    private String preDiagnostico;

    public Carro() {
    }

    public Carro(Long id, String marca, String modelo, String placa, int ano, String cpfDono) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setCpfDono(String cpfDono) {
        this.cpfDono = cpfDono;
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

    @Override
    public String toString() {
        return "Carro{" +
                "cpfDono='" + cpfDono + '\'' +
                ", ano=" + ano +
                ", placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", id=" + id +
                '}';
    }
}
