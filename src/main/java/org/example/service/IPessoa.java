package org.example.service;

public interface IPessoa {
    int calculaIdade(int anoNascimento);
    String isCpfValido();
    boolean isMaiorIdade(int idade);
}
