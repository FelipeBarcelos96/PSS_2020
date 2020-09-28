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
public class DescontoAniversario implements Desconto{
    
    private double valor;
    
    public DescontoAniversario(double valor) {
        this.valor = valor;
    }
    
    
    
    @Override
    public double getValor(){
        return 0;
        
    }
    

    @Override
    public boolean calculaRegra() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
