/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public boolean estoqueDisponivel(double quantidadeNecessaria) {
        return this.quantidade >= quantidadeNecessaria;
    }
    
    private void adicionarQuantidade(double quantidade){
        
    }
    
    public void removerQuantidade (double quantidade){
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
