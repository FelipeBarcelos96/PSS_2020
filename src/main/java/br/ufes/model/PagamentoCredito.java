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

    @Override
    public void FormaPagamento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pagar(Pedido pedido) {
        try{
           if(pedido.getEstado().toUpperCase().equals("PAGO") ){
               pedido.setEstado("PAGO");
           }
       }catch(Exception e){
           
       }
    }
    
}
