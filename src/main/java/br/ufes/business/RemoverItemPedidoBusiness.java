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
    public RemoverItemPedidoBusiness(){
        
    }
    
    public void remover(Pedido pedido, String nomeProduto){
        for(Item item : pedido.getCarrinho().getItens()){
            if(item.getProduto().getNome().toUpperCase().equals(nomeProduto.toUpperCase())){
                pedido.getCarrinho().removerItem(nomeProduto);
            }
        }
    }
    
}
