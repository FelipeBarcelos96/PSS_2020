/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.business;

import br.ufes.model.CarrinhoDeCompra;
import br.ufes.model.Pedido;
import java.time.LocalDate;
import java.util.Random;

/**
 *
 * @author Felps
 */
public class FinalizarCarrinhoBusiness {
    
    public FinalizarCarrinhoBusiness(){
        
    }
    
    public Pedido fechar(CarrinhoDeCompra carrinhoDeCompra){
        Random random = new Random();
        
        carrinhoDeCompra.getCliente().addPontuacao(carrinhoDeCompra.getValorDesconto()*0.02);
        
        return new Pedido(carrinhoDeCompra, LocalDate.now(), random.nextInt(9999));
    }
}
