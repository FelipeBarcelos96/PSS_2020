/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.business;

import br.ufes.model.FormaPagamento;
import br.ufes.model.Item;
import br.ufes.model.Pedido;

/**
 *
 * @author Felps
 */
public class RealizarPagamento {
    private Pedido pedido;
    private FormaPagamento formaPagamento;
    
    public RealizarPagamento(Pedido pedido, FormaPagamento formaPagamento){
        setPedido(pedido);
        setFormaPagamento(formaPagamento);
    }
    
    public RealizarPagamento(Pedido pedido, FormaPagamento formaPagamento, int numero){
        setPedido(pedido);
        setFormaPagamento(formaPagamento);
        this.getFormaPagamento().setNumero(numero);
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    
    public void pagar(){        
        ValidaDataVencimento validador = new ValidaDataVencimento(this.getPedido());
        if(validador.verificaValidade(this.getPedido())){
            this.getFormaPagamento().pagar(this.getPedido());
            this.getPedido().setFormaPagamento(this.getFormaPagamento());
            try{
               for(Item item : this.getPedido().getCarrinho().getItens()){
                   if(item.getProduto().getEstoque().estoqueDisponivel(item.getQuantidade())){
                       item.getProduto().getEstoque().removerQuantidade(item.getQuantidade());
                   }else{
                       throw new RuntimeException("Estoque indisponível para atender a quantidade solicitada (" + Double.toString(item.getQuantidade())
                    + ") para o produto " + item.getProduto().getNome()
                    + ", restam " + item.getProduto().getEstoque().getQuantidade() + " em estoque.");
                   }
               }
            }catch(Exception e){
                System.out.println("Não foi possível Retirar os produtos do Estoque!!!");
            }
        }else{
            throw new RuntimeException("Validade do Pedido Expirou! Realize um novo Pedido!");
        }        
    }                   
}
