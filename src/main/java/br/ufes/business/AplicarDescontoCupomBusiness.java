package br.ufes.business;

import br.ufes.business.MapCupomDesconto;
import br.ufes.model.CarrinhoDeCompra;
import br.ufes.model.Desconto;

public class AplicarDescontoCupomBusiness {

    private String codigo;
    private CarrinhoDeCompra carrinho;

    public AplicarDescontoCupomBusiness(String codigo, CarrinhoDeCompra carrinho) {
        this.codigo = codigo;
        this.carrinho = carrinho;
    }

    public void aplicar() {
        MapCupomDesconto cupomDesconto = new MapCupomDesconto();
        Double porcentagem = 0.0;
        
        try{
            porcentagem = cupomDesconto.buscarDescontoCupom(this.codigo);
        }catch(Exception ex){
            throw new RuntimeException("O cupom '" + codigo + "' não é válido! ");
        }
            

        String descricao = "Desconto Cupom: " + codigo;
        double valorOrigem = carrinho.getValorTotal();
        double valorDesconto = valorOrigem * (porcentagem / 100);

        Desconto desconto = new Desconto(descricao, valorDesconto, valorOrigem, porcentagem);
        carrinho.getColecaoDescontos().add(desconto);
    }

}
