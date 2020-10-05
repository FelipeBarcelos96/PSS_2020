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
public class PagamentoCredito implements FormaPagamento{

    private int numero;
   
    @Override
    public void FormaPagamento() {
        
    }
    
    public void PagamentoDebito(int numero){
        setNumero(numero);
    }

    @Override
    public void pagar(Pedido pedido) {
       try{
           if(pedido.getEstado().toUpperCase().equals("PAGO") ){
               pedido.setEstado("PAGO");
               pedido.setFormaPagamento(this);
           }
       }catch(Exception e){
           System.out.println("Erro durante o Pagamento!");
       }
    }

    public int getNumero() {
        return numero;
    }

    private void setNumero(int numero) {
        this.numero = numero;
    }
    
    @Override
    public String toString() {
        return " Cartão de Crédito Número do Cartão: "+Integer.toString(this.getNumero());
    }
       
}
