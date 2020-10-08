package br.ufes.model;

import java.util.HashMap;
import java.util.Map;

public class MapCupomDesconto {

    // Map<codigo, porcentagem>
    private Map<String, Double> cupons;

    public MapCupomDesconto() {
        cupons = new HashMap<>();
        cupons.put("DESC10", 0.1);
        cupons.put("DESC15", 0.15);
        cupons.put("DESC05", 0.05);
    }

    public double buscarDescontoCupom(String codigo) {
        return cupons.get(codigo);
    }
}
