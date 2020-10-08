package br.ufes.model;

public class DescontoCupom extends Desconto {

    private String codigo;
    private CarrinhoDeCompra carrinho;

    public DescontoCupom(String codigo, CarrinhoDeCompra carrinho) {
        this.codigo = codigo;
        this.carrinho = carrinho;
        this.setDescricao("Desconto Cupom: " + codigo);
    }

    @Override
    public void calcular() {
        MapCupomDesconto cupomDesconto = new MapCupomDesconto();
        Double porcentagemCupom = cupomDesconto.buscarDescontoCupom(this.codigo);

        if (porcentagemCupom == null) {
            this.valorDesconto = 0;
        } else {
            this.porcentagem = porcentagemCupom;
            this.valorOrigem = carrinho.getValorTotal();
            this.valorDesconto = valorOrigem * (porcentagem/100);
        }
    }
}
