/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.model;

/**
 *
 * @author Felipe e Nandi
 */
public class NotaFiscal {
    private int numeroNota;
    private double valorICMS;
    private Pedido pedido;
    private double valorTotal;
    
    public NotaFiscal(int numeroDaNota , Pedido pedido) {
        setNumeroNota(numeroNota);
        setPedido(pedido);
    }     
    
    public int getNumeroNota() {
        return numeroNota;
    }

    private void setNumeroNota(int numeroDaNota) {
        this.numeroNota = numeroDaNota;
    }

    public Pedido getPedido() {
        return pedido;
    }

    private void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public double getValorICMS() {
        return valorICMS;
    }

    public void setValorICMS(double valorICMS) {
        this.valorICMS = valorICMS;
    }   

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    @Override
    public String toString() {
        return "Nota Fiscal Número: " + Integer.toString(this.getNumeroNota()) +
                " \nValor Total: R$" + Double.toString(this.getValorTotal()) +
                ", Valor ICMS: R$" + Double.toString(this.getValorICMS()) +
                "\n " + this.getPedido().toString();
    }
    
}
