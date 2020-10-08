package br.ufes.model;

import java.time.LocalDate;

public class DescontoAniversario extends Desconto {

    private CarrinhoDeCompra carrinho;
    private double porcentagem;

    public DescontoAniversario(CarrinhoDeCompra carrinho) {
        this.carrinho = carrinho;
        porcentagem = 0.05;
        this.setDescricao("Desconto Aniversário");
    }

    @Override
    public void calcularValor() {
        int clienteDia = carrinho.getCliente().getDataNascimento().getDayOfMonth();
        int clienteMes = carrinho.getCliente().getDataNascimento().getMonthValue();

        int hojeDia = LocalDate.now().getDayOfMonth();
        int hojeMes = LocalDate.now().getMonthValue();

        if ((clienteDia == hojeDia) && (clienteMes == hojeMes)) {
            this.valor = carrinho.getValorTotal() * porcentagem;
        } else {
            this.valor = 0;
        }
    }

}
