package org.example.models.oficina;

public class Oficina {
    private String endereco;
    private String nome;
    private String cnpj;
    private String listaDeServicos;

    public Oficina() {
    }

    public Oficina(String endereco, String nome, String cnpj) {
        this.endereco = endereco;
        this.nome = nome;
        setCnpj(cnpj);
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getListaDeServicos() {
        return listaDeServicos;
    }

    public void setCnpj(String cnpj) {
        if(isCnpjValido(cnpj)){
            this.cnpj = cnpj;
        }else {
            throw new RuntimeException("CNPJ invalido");
        }
    }

    public void setListaDeServicos(String listaDeServicos) {
        this.listaDeServicos = listaDeServicos;
    }

    public boolean isCnpjValido(String cnpj){
        cnpj = cnpj.replaceAll("[^0-9]", "");
        if(cnpj.length() == 14 || cnpj.matches("(\\d)\\1{13}")){
            return true;
        }else {
            return false;
        }
    }
}
