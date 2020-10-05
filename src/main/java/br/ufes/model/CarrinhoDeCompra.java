package br.ufes.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public final class CarrinhoDeCompra {

    protected Cliente cliente;
    protected double valorTotal;
    protected final double desconto = 0.05;
    protected double valorDesconto;
    protected double valorFinal;
    protected final ArrayList<Item> itens = new ArrayList<>();

    public CarrinhoDeCompra(Cliente cliente, Produto produto, double quantidade) {
        if (cliente == null) {
            throw new RuntimeException("Informe um cliente válido");
        }
        this.cliente = cliente;        
        this.addItem(produto, quantidade);
    }

    public final void addItem(Produto produto, double quantidade) {
        if (quantidade <= 0) {
            throw new RuntimeException("Informe uma quantidade válida!");
        }
        if (this.getItemPorNome(produto.getNome()).isPresent()) {
            throw new RuntimeException("Produto já existe! Remova-o ou altere a quantidade");
        }
        itens.add(new Item(produto, quantidade));
        calcularValor();
    }

    protected Optional<Item> getItemPorNome(String nomeProduto) {
        Optional<Item> itemEncontrado = Optional.empty();
        for (Item item : itens) {
            if (item.getProduto().getNome().toLowerCase().equals(nomeProduto.toLowerCase())) {
                itemEncontrado = Optional.of(item);
            }
        }
        return itemEncontrado;
    }

    public void calcularValor() {
        valorTotal = 0;
        for (Item item : itens) {
            valorTotal += item.getValorItem();
        }
        aplicarDesconto();
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    private void aplicarDesconto() {
        this.valorDesconto = valorTotal * desconto;
        this.valorFinal = valorTotal - valorDesconto;
    }

    public void removerItem(String nomeProduto) {

        Optional<Item> produtoEncontrado = getItemPorNome(nomeProduto);
        if (!produtoEncontrado.isPresent()) {
            throw new RuntimeException("Item " + nomeProduto + " não encontrado");
        }

        itens.remove(produtoEncontrado.get());
        calcularValor();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public double getDesconto() {
        return desconto;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItens() {
        return Collections.unmodifiableList(itens);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        String retorno = "--------------- Carrinho de Compras --------------\n";
        retorno += "Dados do Cliente: " + this.getCliente().toString() + "\n";
        retorno += "Valor sem desconto: R$ " + df.format(getValorTotal()) + "\n";
        retorno += "Desconto: R$" + df.format(valorDesconto) + " (" + desconto * 100 + "%)\n";
        retorno += "Valor a pagar: R$" + df.format(valorFinal) + "\n";
        retorno += "Itens do pedido:\n";
        for (Item item : itens) {
            retorno += "\t- " + item.toString() + "\n";
        }

        return retorno;
    }

}
