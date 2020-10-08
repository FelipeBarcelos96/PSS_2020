package br.ufes.model;

import java.time.LocalDate;

public class DescontoAniversario extends Desconto {

    private CarrinhoDeCompra carrinho;

    public DescontoAniversario(CarrinhoDeCompra carrinho) {
        this.carrinho = carrinho;
        this.porcentagem = 5.0;
        this.setDescricao("Desconto Aniversário");
    }

    @Override
    public void calcular() {
        int clienteDia = carrinho.getCliente().getDataNascimento().getDayOfMonth();
        int clienteMes = carrinho.getCliente().getDataNascimento().getMonthValue();

        int hojeDia = LocalDate.now().getDayOfMonth();
        int hojeMes = LocalDate.now().getMonthValue();

        if ((clienteDia == hojeDia) && (clienteMes == hojeMes)) {
            this.valorOrigem = carrinho.getValorTotal();
            this.valorDesconto = valorOrigem * (porcentagem / 100);
        } else {
            this.valorDesconto = 0;
        }
    }

}
