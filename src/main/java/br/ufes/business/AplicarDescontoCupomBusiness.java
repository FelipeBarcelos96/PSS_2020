package br.ufes.business;

import br.ufes.business.MapCupomDesconto;
import br.ufes.model.CarrinhoDeCompra;
import br.ufes.model.Desconto;

public class AplicarDescontoCupomBusiness {

    private CarrinhoDeCompra carrinho;

    public AplicarDescontoCupomBusiness(CarrinhoDeCompra carrinho) {
        this.carrinho = carrinho;
    }

    public void aplicar(String codigo) {
        MapCupomDesconto cupomDesconto = new MapCupomDesconto();
        Double porcentagem = 0.0;

        porcentagem = cupomDesconto.buscarDescontoCupom(codigo);

        String descricao = "Desconto Cupom: " + codigo;
        double valorOrigem = carrinho.getValorTotal();
        double valorDesconto = valorOrigem * (porcentagem / 100);

        Desconto desconto = new Desconto(descricao, valorDesconto, valorOrigem, porcentagem);
        carrinho.getColecaoDescontos().add(desconto);
    }

}
