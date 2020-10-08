package br.ufes.model;

import java.text.DecimalFormat;

public class Desconto {

    private String descricao;
    private double valorDesconto;
    private double valorOrigem;
    private double porcentagem;

    public Desconto(String descricao, double valorDesconto, double valorOrigem, double porcentagem) {
        this.descricao = descricao;
        this.valorDesconto = valorDesconto;
        this.valorOrigem = valorOrigem;
        this.porcentagem = porcentagem;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public double getValor() {
        return this.valorDesconto;
    }

    public double getPorcentagem() {
        return porcentagem;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public double getValorOrigem() {
        return valorOrigem;
    }
            
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return this.descricao + " - "+porcentagem+"% de R$ "+df.format(valorOrigem)+" - Valor do desconto = R$ "+ df.format(valorDesconto);
    }    

}
