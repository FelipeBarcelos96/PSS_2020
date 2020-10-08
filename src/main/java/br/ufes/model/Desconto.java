package br.ufes.model;

import java.text.DecimalFormat;

public abstract class Desconto {

    protected String descricao;
    protected double valorDesconto;
    protected double valorOrigem;
    protected double porcentagem;
    
    public abstract void calcular();

    public String getDescricao() {
        return this.descricao;
    }
    
    public double getValor() {
        return this.valorDesconto;
    }

    public double getPorcentagem() {
        return porcentagem;
    }
    
    protected void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return this.descricao + " - "+porcentagem+"% de R$ "+df.format(valorOrigem)+"- Total = R$ "+ df.format(valorDesconto);
    }    

}
