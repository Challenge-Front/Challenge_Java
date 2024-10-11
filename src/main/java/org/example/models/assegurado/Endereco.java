package org.example.models.assegurado;

public class Endereco {
    private Long id;
    private String logradouro, numero, bairro, cidade, estadoUf, cep ,cpfCliente;

    public Endereco(Long id, String logradouro, String numero, String bairro, String uf, String cidade, String cep, String cpfCliente) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.estadoUf = uf;
        this.cidade = cidade;
        this.cep = cep;
        this.cpfCliente = cpfCliente;
    }

    public Long getId() {
        return id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getEstadoUf() {
        return estadoUf;
    }

    public String getCidade() {
        return cidade;
    }

    public String getCep() {
        return cep;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstadoUf(String estadoUf) {
        this.estadoUf = estadoUf;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", logradouro='" + logradouro + '\'' +
                ", numero='" + numero + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estadoUf='" + estadoUf + '\'' +
                ", cep='" + cep + '\'' +
                ", cpfCliente='" + cpfCliente + '\'' +
                '}';
    }
}
