/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.model;

import java.time.LocalDate;

/**
 *
 * @author Felipe
 */
public class Pedido {
    private String estado;
    private int codPedido;
    private LocalDate dataValidade;
    private LocalDate data;
    private CarrinhoDeCompra carrinho;
    
    public Pedido(CarrinhoDeCompra carrinho, LocalDate data, int codigo){
        setCodPedido(codigo);
        setEstado("Em Aberto");
        setData(data);
        setCarrinho(carrinho);
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    private void setCarrinho(CarrinhoDeCompra carrinho) {
        this.carrinho = carrinho;
    }

    public String getEstado() {
        return estado;
    }

    public int getCodPedido() {
        return codPedido;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public LocalDate getData() {
        return data;
    }

    public CarrinhoDeCompra getCarrinho() {
        return carrinho;
    }
           
        
}
