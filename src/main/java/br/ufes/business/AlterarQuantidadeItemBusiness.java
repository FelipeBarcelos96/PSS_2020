package br.ufes.business;

import br.ufes.model.CarrinhoDeCompra;
import br.ufes.model.Item;
import excecoes.QuantidadeNulaException;
import java.util.Optional;

public class AlterarQuantidadeItemBusiness {

    private CarrinhoDeCompra carrinho;

    public AlterarQuantidadeItemBusiness(CarrinhoDeCompra carrinho) {
        this.carrinho = carrinho;
    }
    
    private Optional<Item> buscarItem(String nomeProduto){
        Optional<Item> item;

        item = carrinho.getColecaoItens().buscarItemPorNome(nomeProduto);

        item.orElseThrow(() -> new RuntimeException("Produto " + nomeProduto + " não foi encontrado no carrinho"));
        return item;
    }

    public void diminuirQuantidade(String nomeProduto, double quantidade) {
        Optional<Item> item = buscarItem(nomeProduto);
        
        try {
            item.get().diminuirQuantidade(quantidade);
        } catch (QuantidadeNulaException ex) {
            carrinho.getColecaoItens().remover(nomeProduto);
        }
    }
    
    public void setQuantidade(String nomeProduto, double quantidade) {
        Optional<Item> item = buscarItem(nomeProduto);
        
        try {
            item.get().setQuantidade(quantidade);
        } catch (QuantidadeNulaException ex) {
            carrinho.getColecaoItens().remover(nomeProduto);
        }
    }
    
    public void aumentarQuantidade(String nomeProduto, double quantidade) {
        Optional<Item> item = buscarItem(nomeProduto);
        item.get().aumentarQuantidade(quantidade);
    }

}
