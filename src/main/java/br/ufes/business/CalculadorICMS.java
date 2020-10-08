/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.business;

import br.ufes.model.NotaFiscal;

/**
 *
 * @author Felps
 */
public class CalculadorICMS {

    public CalculadorICMS() {

    }

    public void calcularICMS(NotaFiscal nota, double aliquota) {
        nota.setValorICMS(nota.getPedido().getCarrinho().getValorFinal() * (aliquota / 100));
        nota.setValorTotal(nota.getPedido().getCarrinho().getValorFinal() + nota.getValorICMS());
    }
}
