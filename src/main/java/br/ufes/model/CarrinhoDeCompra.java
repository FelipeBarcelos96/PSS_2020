package br.ufes.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public final class CarrinhoDeCompra {

    private Cliente cliente;
    private double valorTotal;
    private ColecaoDesconto colecaoDescontos;
    private ColecaoItem colecaoItens;
    private double valorDesconto;
    private double valorFinal;

    public CarrinhoDeCompra(Cliente cliente, Produto produto, double quantidade) {
        if (cliente == null) {
            throw new RuntimeException("Informe um cliente válido");
        }

        colecaoItens = new ColecaoItem();
        colecaoDescontos = new ColecaoDesconto();

        this.cliente = cliente;
        colecaoItens.add(produto, quantidade);
    }

    private void calcularValorTotal() {
        this.valorTotal = colecaoItens.calcularValorTotal();
    }

    private void calcularValorDesconto() {
        this.valorDesconto = colecaoDescontos.calcularTotalDesconto();
    }

    private void calcularValorFinal() {
        calcularValorTotal();
        calcularValorDesconto();
        this.valorFinal = this.valorTotal - this.valorDesconto;
    }

    public double getValorDesconto() {
        calcularValorDesconto();
        return valorDesconto;
    }

    public double getValorTotal() {
        calcularValorTotal();
        return valorTotal;
    }

    public double getValorFinal() {
        calcularValorFinal();
        return valorFinal;
    }

    public ColecaoDesconto getColecaoDescontos() {
        return colecaoDescontos;
    }

    public ColecaoItem getColecaoItens() {
        return colecaoItens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        String retorno = "--------------- Carrinho de Compras --------------\n";
        retorno += "Dados do Cliente: " + this.getCliente().toString() + "\n";
        retorno += "Valor sem desconto: R$ " + df.format(getValorTotal()) + "\n";
        retorno += "Desconto: R$" + df.format(getValorDesconto()) + "\n";
        retorno += "Valor a pagar: R$" + df.format(valorFinal) + "\n";
        retorno += "Itens do pedido:\n";
        retorno += colecaoItens;

        return retorno;
    }

}
