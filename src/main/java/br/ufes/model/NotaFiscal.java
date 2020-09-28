/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.model;

/**
 *
 * @author nandi
 */
public class NotaFiscal {
    private int numeroDaNota;

    public NotaFiscal(int numeroDaNota) {
        this.numeroDaNota = numeroDaNota;
    }
    
    public int getNumeroDaNota() {
        return numeroDaNota;
    }

    public void setNumeroDaNota(int numeroDaNota) {
        this.numeroDaNota = numeroDaNota;
    }
    
    public double calcularICMS(double valor){
        return valor;
    }
}
