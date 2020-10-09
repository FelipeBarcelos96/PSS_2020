/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.business;

import br.ufes.model.Item;
import br.ufes.model.Pedido;

/**
 *
 * @author Felps
 */
public class RemoverItemPedidoBusiness {
    
    private Pedido pedido;
    public RemoverItemPedidoBusiness(Pedido pedido) {
        this.pedido = pedido;
    }

    public void remover(String nomeProduto) {
        pedido.getCarrinho().getColecaoItens().remover(nomeProduto);
        pedido.getCarrinho().getColecaoDescontos().remover("Desconto Produto: "+ nomeProduto);
    }

}
