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

    public RemoverItemPedidoBusiness() {

    }

    public void remover(Pedido pedido, String nomeProduto, int quantidade) {
        for (Item item : pedido.getCarrinho().getColecaoItens().getListaItens()) {
            if (item.getProduto().getNome().toUpperCase().equals(nomeProduto.toUpperCase())) {
                if(item.getQuantidade() < quantidade){
				  pedido.getCarrinho().getColecaoItens().remover(nomeProduto);
				}else{
					try{
						if(quantidade >= 0){
                                                    item.removeQuantidade(quantidade);							
						}else{
                                                    throw new RuntimeException("Não é possível retirar valores negativos do Item!");
                                                }	
						
					}catch(Exception e) {
                                          System.out.println("Não foi possível Retirar esta quantidade dos produtos do Item!!!");
                                        }	
				}
            }
        }
    }

}
