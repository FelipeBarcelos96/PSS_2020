/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.model;

/**
 *
 * @author Felipe
 */
public interface FormaPagamento {
    
    public void FormaPagamento();
    public void pagar(Pedido pedido);
    @Override
    public String toString();
    
}
