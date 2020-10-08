package br.ufes.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ColecaoDesconto {

    private final ArrayList<Desconto> descontos;

    public ColecaoDesconto() {
        descontos = new ArrayList<>();
    }

    public void add(Desconto desconto) {
        if (desconto.getValor() > 0) {
            descontos.add(desconto);
        }
    }

    public Desconto buscar(String descricao) {
        for (Desconto d : descontos) {
            if (d.getDescricao().equalsIgnoreCase(descricao)) {
                return d;
            }
        }

        return null;
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

}
