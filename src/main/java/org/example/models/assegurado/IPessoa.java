package org.example.models.assegurado;

public interface IPessoa {
    int calculaIdade(int anoNascimento);
    String isCpfValido();
    boolean isMaiorIdade(int idade);
}
