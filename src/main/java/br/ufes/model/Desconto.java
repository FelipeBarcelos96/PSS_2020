package br.ufes.model;

public abstract class Desconto {

    private String descricao;
    double valor;

    public abstract void calcularValor();

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return this.valor;
    }
}
