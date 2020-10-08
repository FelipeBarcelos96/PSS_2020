package br.ufes.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ColecaoDesconto {

    private final ArrayList<Desconto> descontos;

    public ColecaoDesconto() {
        descontos = new ArrayList<>();
    }

    public void add(Desconto desconto) {
        if (!buscarDescontoPorDescricao(desconto.getDescricao()).isEmpty()) {
            throw new RuntimeException("O desconto:  '" + desconto.getDescricao()+ "' já foi aplicado!");
        }

        descontos.add(desconto);
    }
    
    public void remover(String descricao) {
        Optional<Desconto> desconto = buscarDescontoPorDescricao(descricao);
        desconto.orElseThrow(() -> new RuntimeException("Não foi possível remover o desconto '" + descricao + "'! Desconto não encontrado"));
        desconto.ifPresent(i -> descontos.remove(i));
    }


    public Optional<Desconto> buscarDescontoPorDescricao(String descricao){
        Optional<Desconto> descontoEncontrado = Optional.empty();
        
        for(Desconto desconto : descontos) {
            if (desconto.getDescricao().equalsIgnoreCase(descricao)) {
                descontoEncontrado = Optional.of(desconto);
            }
        }
        
        return descontoEncontrado;
    }
    
    public double calcularTotalDesconto() {
        double total = 0;

        for (Desconto d : descontos) {
            total += d.getValor();
        }

        return total;
    }

    public List<Desconto> getListaDescontos() {
        return Collections.unmodifiableList(descontos);
    }

    @Override
    public String toString() {
        String resultado = "";
        for (Desconto desconto : descontos) {
            resultado += desconto.toString() + "\n";
        }

        return resultado;
    }
}