package org.example.assegurado;


import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private int idade;
    private int dtNascimento;

    public Pessoa(String nome, int anoNascimento, String email, String telefone, String cpf) {
        this.nome = nome;
        this.idade = setIdade(calculaIdade(anoNascimento));
        this.dtNascimento = anoNascimento;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }


    public int getIdade() {
        return idade;
    }


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public int getDtNascimento() {
        return dtNascimento;
    }

    public int setIdade(int idade) {
        if(isMaiorIdade(idade)){
            this.idade = idade;
            return idade;
        }else {
            throw new RuntimeException("Não possuimos clientes menores de idade.");
        }
    }

    public void setEmail(String email) {
        if(validarEmail(email)){
            this.email = email;
        }else {
            throw new RuntimeException("Email inválido");
        }
    }

    public String isCpfValido(){
        if (cpf.length() == 11){
            return cpf;
        }else {
            throw new RuntimeException("Número de cpf Inválido");
        }
    }
    public int calculaIdade(int anoNascimento){
        idade = LocalDate.now().getYear() - anoNascimento;
        return idade;

    }
    public boolean validarEmail(String email) {
        return email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }
    public boolean isMaiorIdade(int idade){
        if (idade >= 18){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", idade=" + idade +
                ", dtNascimento=" + dtNascimento +
                '}';
    }
}
