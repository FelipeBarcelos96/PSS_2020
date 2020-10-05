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
    private FormaPagamento formaPagamento;
    
    public Pedido(CarrinhoDeCompra carrinho, LocalDate data, int codigo){
        setCodPedido(codigo);
        setEstado("Em Aberto");
        setData(data);
        setCarrinho(carrinho);
        this.formaPagamento = null;
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

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    @Override
    public String toString() {
        return " Pedido de Número: " + Integer.toString(this.codPedido) + " , Estado: " + this.getEstado() + ", Data de Validade: " + this.getDataValidade().toString() + ", Data do Pedido: " + this.getData().toString() + ", Forma de Pagamento: " + this.getFormaPagamento().toString() + "/n Carrinho: " + this.getCarrinho().toString();
    }
         
}
