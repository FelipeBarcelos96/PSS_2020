package br.ufes.business;

import br.ufes.model.CarrinhoDeCompra;
import br.ufes.model.Desconto;
import br.ufes.model.Item;

public class AplicarDescontoPorTipoProdutoBusiness{

    private CarrinhoDeCompra carrinho;

    public AplicarDescontoPorTipoProdutoBusiness(CarrinhoDeCompra carrinho) {
        this.carrinho = carrinho;
    }

    
    public void aplicar() {
        MapTipoDesconto descontoTipo = new MapTipoDesconto();
        
        for(Item item : carrinho.getColecaoItens().getListaItens()){
            double porcentagem = 0;
            try{
                 porcentagem = descontoTipo.buscarDescontoPorTipo(item.getProduto().getTipo());
            }catch(Exception ex){
                continue;
            }
            
            String descricao = "Desconto Produto: " + item.getProduto().getNome();
            double valorOrigem = item.getValorItem();
            double valorDesconto = valorOrigem * (porcentagem / 100);

            Desconto desconto = new Desconto(descricao, valorDesconto, valorOrigem, porcentagem);
            carrinho.getColecaoDescontos().add(desconto);
        }
    }
}
