package br.ufes.model;

import java.util.HashMap;
import java.util.Map;

public class MapTipoDesconto {

    // Map<tipo, porcentagem>
    private Map<String, Double> descontoTipo;

    public MapTipoDesconto() {
        descontoTipo = new HashMap<>();
        descontoTipo.put("tipo1", 8.0);
        descontoTipo.put("tipo2", 10.0);
        descontoTipo.put("tipo3", 5.0);
        descontoTipo.put("tipo4", 12.0);
        descontoTipo.put("tipo5", 7.0);
    }

    public double buscarDescontoPorTipo(String tipo) {
        return descontoTipo.get(tipo);
    }

}
