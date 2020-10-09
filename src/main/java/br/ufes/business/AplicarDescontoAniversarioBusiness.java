package br.ufes.business;

import br.ufes.model.CarrinhoDeCompra;
import br.ufes.model.Desconto;
import java.time.LocalDate;

public class AplicarDescontoAniversarioBusiness {

    private double porcentagem;
    private CarrinhoDeCompra carrinho;

    public AplicarDescontoAniversarioBusiness(CarrinhoDeCompra carrinho) {
        this.carrinho = carrinho;
        this.porcentagem = 5.0;
    }

    public void aplicar() {
        int clienteDia = carrinho.getCliente().getDataNascimento().getDayOfMonth();
        int clienteMes = carrinho.getCliente().getDataNascimento().getMonthValue();

        int hojeDia = LocalDate.now().getDayOfMonth();
        int hojeMes = LocalDate.now().getMonthValue();

        if (!((clienteDia == hojeDia) && (clienteMes == hojeMes))) {
            throw new RuntimeException("O cliente '" + carrinho.getCliente().getNome() + "' não está fazendo aniversário hoje!");
        }

        String descricao = "Desconto Aniversário";
        double valorOrigem = carrinho.getValorTotal();
        double valorDesconto = valorOrigem * (porcentagem / 100);

        Desconto desconto = new Desconto(descricao, valorDesconto, valorOrigem, porcentagem);
        carrinho.getColecaoDescontos().add(desconto);
    }

}
