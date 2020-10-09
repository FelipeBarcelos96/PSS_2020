package br.ufes.model;

/**
 *
 * @author nandi
 */
public class Estoque {

    double quantidade;

    public Estoque(double quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isDisponivel(double quantidade) {
        return this.quantidade >= quantidade;
    }

    private void adicionarQuantidade(double quantidadeAdicionada) {
        this.quantidade += quantidadeAdicionada;
    }

    public void removerQuantidade(double quantidade) {
        if(quantidade > this.quantidade)
            throw new RuntimeException("Estoque indisponível para atender a quantidade solicitada");
        
        this.quantidade -= quantidade;
    }

    public double getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return Double.toString(quantidade);
    }

}
