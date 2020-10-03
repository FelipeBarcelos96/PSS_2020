package br.ufes;

import br.ufes.model.Cliente;
import br.ufes.model.CarrinhoDeCompra;
import br.ufes.model.Endereco;
import br.ufes.model.Produto;
import java.time.LocalDate;

/**
 *
 * @author Clayton, adaptado da solução de Pedro Henrique Robadel
 */
public class Principal {

    public static void main(String[] args) {

        try {
            Endereco endereco1 = new Endereco("Cidade dos Homens","rua A","666","MG");
            Cliente cliente1 = new Cliente("Fulano","123.123.123-81 ", LocalDate.now(),endereco1);

            Produto produto1 = new Produto("Caneta", 3.50, 8);

            CarrinhoDeCompra carrinho1 = new CarrinhoDeCompra(cliente1,
                    produto1, 5,
                    LocalDate.now()
            );

            carrinho1.addItem(new Produto("Folha Papel A4", 0.05, 10), 10);

            System.out.println(carrinho1);

        } catch (RuntimeException rte) {
            System.err.println("Falha: " + rte.getMessage());

        }

    }

}
