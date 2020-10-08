package br.ufes.model;

import java.util.HashMap;
import java.util.Map;

public class MapTipoDesconto {

    // Map<tipo, porcentagem>
    private Map<String, Double> descontoTipo;

    public MapTipoDesconto() {
        descontoTipo = new HashMap<>();
        descontoTipo.put("tipo1", 0.08);
        descontoTipo.put("tipo2", 0.10);
        descontoTipo.put("tipo3", 0.05);
        descontoTipo.put("tipo4", 0.12);
        descontoTipo.put("tipo5", 0.07);
    }

    public double buscarDescontoPorTipo(String tipo) {
        return descontoTipo.get(tipo);
    }

}
