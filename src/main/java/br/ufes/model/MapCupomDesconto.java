package br.ufes.model;

import java.util.HashMap;
import java.util.Map;

public class MapCupomDesconto {

    // Map<codigo, porcentagem>
    private Map<String, Double> cupons;

    public MapCupomDesconto() {
        cupons = new HashMap<>();
        cupons.put("DESC10", 10.0);
        cupons.put("DESC15", 15.0);
        cupons.put("DESC05", 5.0);
    }

    public double buscarDescontoCupom(String codigo) {
        return cupons.get(codigo);
    }
}
