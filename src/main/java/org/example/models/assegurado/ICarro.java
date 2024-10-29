package org.example.models.assegurado;

public interface ICarro {
    String isPlacaValida();
    boolean isCarroComSintomas();
    String verificarNecessidadeRevisao(int quilometragemAtual);
}
