package br.ufes.model;

public class DescontoCupom extends Desconto{
    private String codigo;
    private CarrinhoDeCompra carrinho;

    public DescontoCupom(String codigo, CarrinhoDeCompra carrinho) {
        this.codigo = codigo;
        this.carrinho = carrinho;
        this.setDescricao("Desconto Cupom: "+ codigo);
    }
    
    @Override
    public void calcularValor(){
        MapCupomDesconto cupomDesconto = new MapCupomDesconto();
        Double porcentagem = cupomDesconto.buscarDescontoCupom(this.codigo);
        
        if (porcentagem == null)
            this.valor = 0;
        else
            this.valor = carrinho.getValorTotal() * porcentagem;
    }
}
