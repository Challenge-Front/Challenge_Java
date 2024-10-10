package org.example.assegurado;

public class Avaliacao {
    private String comentario;
    private int estrelas;
    private String nome;

    public Avaliacao(String comentario, int estrelas, String nome) {
        this.comentario = comentario;
        this.estrelas = estrelas;
        this.nome = nome;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getEstrelas() {
        return estrelas;
    }

    public void setEstrelas(int estrelas) {
        this.estrelas = estrelas;
    }

    public String getNome() {
        return nome;
    }
}
