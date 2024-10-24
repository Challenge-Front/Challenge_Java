package org.example.service;

public interface ICarro {
    String isPlacaValida();
    boolean isCarroComSintomas();
    String verificarNecessidadeRevisao(int quilometragemAtual);
}
