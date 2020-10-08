package br.ufes.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ColecaoItem {

    private final ArrayList<Item> itens;

    public ColecaoItem() {
        itens = new ArrayList<>();
    }

    public void add(Produto produto, double quantidade) {
        if (quantidade <= 0) {
            throw new RuntimeException("Informe uma quantidade válida!");
        }

        if (!getItemPorNome(produto.getNome()).isEmpty()) {
            throw new RuntimeException("O Produto '" + produto.getNome() + "' já existe! Remova-o ou altere a quantidade");
        }

        itens.add(new Item(produto, quantidade));
    }

    public Optional<Item> getItemPorNome(String nomeProduto) {
        Optional<Item> itemEncontrado = Optional.empty();
        for (Item item : itens) {
            if (item.getProduto().getNome().equalsIgnoreCase(nomeProduto)) {
                itemEncontrado = Optional.of(item);
            }
        }

        return itemEncontrado;
    }

    public void remover(String nomeProduto) {
        Optional<Item> item = getItemPorNome(nomeProduto);
        item.orElseThrow(() -> new RuntimeException("Não foi possível remover o produto " + nomeProduto + "! Produto não encontrado"));
        item.ifPresent(i -> itens.remove(i));
    }

    public List<Item> getListaItens() {
        return Collections.unmodifiableList(itens);
    }

    public double calcularValorTotal() {
        double total = 0;

        for (Item item : itens) {
            total += item.getValorItem();
        }

        return total;
    }

    @Override
    public String toString() {
        String resultado = "";
        for (Item item : itens) {
            resultado += item.toString() + "\n";
        }

        return resultado;
    }

}
