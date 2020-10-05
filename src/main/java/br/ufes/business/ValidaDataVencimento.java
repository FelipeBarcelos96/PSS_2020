/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.business;

import br.ufes.model.Pedido;
import java.time.LocalDate;

/**
 *
 * @author Felps
 */
public class ValidaDataVencimento {
    private Pedido pedido;
    
    public ValidaDataVencimento(Pedido pedido){
        setPedido(pedido);        
    }

    public Pedido getPedido() {
        return pedido;
    }

    private void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public boolean verificaValidade(Pedido pedido){
        if(LocalDate.now().isAfter(pedido.getDataValidade())){
            if(!"PAGO".equals(pedido.getEstado().toUpperCase())){
                this.getPedido().setEstado("VENCIDO");
                return false;
            }else{
                return false;
            }
        }else{
            return true;
        }
    }
}
