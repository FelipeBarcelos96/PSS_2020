package br.ufes.model;

import java.util.ArrayList;

public class ColecaoItem {
    private final ArrayList<Item> itens;

    public ColecaoItem() {
        itens = new ArrayList<>();
    }
    
    public void add(Produto produto, double quantidade){
        if (quantidade <= 0)
            throw new RuntimeException("A quantidade não pode ser nula ou negativa");
        
        if (this.buscarItem(produto.getNome()) != null) {
            throw new RuntimeException("Produto já existe! Remova-o ou altere a quantidade");
        }
        
        itens.add(new Item(produto, quantidade));
    }
    
    public Item buscarItem(String nomeProduto){
        for(Item item : itens)
            if(item.getProduto().getNome().equalsIgnoreCase(nomeProduto))
                return item;
        
        return null;
    }
    
    public void removerItem(String nomeProduto){
        Item item = buscarItem(nomeProduto);
        
        if (item == null)
            throw new RuntimeException("Não foi possível remover o produto "+nomeProduto+"! Produto não encontrado");

        itens.remove(item);
    }
    
    public ArrayList<Item> getItens(){
        return itens;
    }
    
    
}
