package br.ufes.model;

import excecoes.QuantidadeNulaException;
import java.text.DecimalFormat;

public final class Item {

    protected double valorUnitario;
    protected double quantidade;
    protected double valorItem;
    protected Produto produto;

    public Item(Produto produto, double quantidadeAdquirida) throws QuantidadeNulaException {
        this.produto = produto;
        this.valorUnitario = produto.getValorUnitario();
        this.setQuantidade(quantidadeAdquirida);
        calculaValorItem();
    }

    private void calculaValorItem() {
        this.valorItem = valorUnitario * quantidade;
    }

    public void diminuirQuantidade(double quantidade) throws QuantidadeNulaException {
        if(quantidade == this.quantidade)
            throw new QuantidadeNulaException("Quantidade inválida! A quantidade do Item não pode ser nula");
        
        if(quantidade > this.quantidade)
            throw new RuntimeException("Quantidade inválida! A quantidade solicitada é maior do que a disponível");
            
        this.quantidade -= quantidade;
    }
    
    public void aumentarQuantidade(double quantidade){
        if(quantidade <= 0)
            throw new RuntimeException("Quantidade inválida! A quantidade solicitada é nula ou negativa");
        
        if(!this.produto.getEstoque().isDisponivel(this.quantidade + quantidade))
            throw new RuntimeException("Estoque indisponível para atender a quantidade solicitada");
            
        this.quantidade += quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public double getValorItem() {
        calculaValorItem();
        return valorItem;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setQuantidade(double quantidade) throws QuantidadeNulaException {
        if(quantidade == 0)
            throw new QuantidadeNulaException("A quantidade do Item não pode ser nula");
        
        if(quantidade < 0)
            throw new RuntimeException("Quantidade do Item não pode ser negativa");
        
        if (!this.produto.getEstoque().isDisponivel(quantidade)) {
            throw new RuntimeException("Estoque indisponível para atender a quantidade solicitada (" + quantidade
                    + ") para o produto " + produto.getNome()
                    + ", restam " + produto.getEstoque().getQuantidade() + " em estoque.");
        }
        
        this.quantidade = quantidade;
    }
    
    

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return produto.getNome()
                + ", valor Unitario: R$ " + valorUnitario
                + ", quantidade no pedido:" + quantidade
                + ", valor Total: R$ " + df.format(getValorItem());
    }

}
