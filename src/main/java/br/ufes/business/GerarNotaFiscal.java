/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.business;

import br.ufes.model.NotaFiscal;
import br.ufes.model.Pedido;
import java.util.Random;

/**
 *
 * @author Felps
 */
public class GerarNotaFiscal {
    private Pedido pedido;
    
    public GerarNotaFiscal(Pedido pedido){
        setPedido(pedido);
    }

    public Pedido getPedido() {
        return pedido;
    }

    private void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }        
    
    public NotaFiscal gerar(){
        Random random = new Random();
        return new NotaFiscal(random.nextInt(9999), this.getPedido());
    }
}
