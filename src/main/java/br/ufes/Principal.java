package br.ufes;

import br.ufes.business.AplicarDescontoAniversarioBusiness;
import br.ufes.business.AplicarDescontoCupomBusiness;
import br.ufes.business.AplicarDescontoPorTipoProdutoBusiness;
import br.ufes.business.CalculadorICMS;
import br.ufes.business.FinalizarCarrinhoBusiness;
import br.ufes.business.GerarNotaFiscal;
import br.ufes.business.ImpressaoNotaFiscalBusiness;
import br.ufes.business.ImpressaoNotaFiscalJSON;
import br.ufes.business.ImpressaoNotaFiscalPDF;
import br.ufes.business.RealizarPagamento;
import br.ufes.model.Cliente;
import br.ufes.model.CarrinhoDeCompra;
import br.ufes.model.Endereco;
import br.ufes.model.NotaFiscal;
import br.ufes.model.PagamentoDebito;
import br.ufes.model.Pedido;
import br.ufes.model.Produto;
import java.time.LocalDate;

/**
 *
 * @author Clayton, adaptado da solução de Pedro Henrique Robadel
 */
public class Principal {

    public static void main(String[] args) {

        try {
            Endereco endereco1 = new Endereco("Cidade dos Homens", "rua A", "666", "MG");
            Cliente cliente1 = new Cliente("Fulano", "123.123.123-81 ", LocalDate.now(), endereco1);
            

            Produto produto1 = new Produto("Caneta", "tipo1", 3.50, 10);
            Produto produto2 = new Produto("blusa", "tipo3", 3.50, 10);
            Produto produto3 = new Produto("copo", "semtipo", 4.75, 10);

            CarrinhoDeCompra carrinho1 = new CarrinhoDeCompra(cliente1, produto1, 5);

            try {
                carrinho1.getColecaoItens().add(produto1, 1);
            } catch (RuntimeException re) {
                System.out.println(re.getMessage());
            }
            
            AplicarDescontoCupomBusiness descontoCupom1 = new AplicarDescontoCupomBusiness("DESC10", carrinho1);
            AplicarDescontoCupomBusiness descontoCupom2 = new AplicarDescontoCupomBusiness("XYZ", carrinho1);
            
            AplicarDescontoAniversarioBusiness descontoAniversario = new AplicarDescontoAniversarioBusiness(carrinho1);
            AplicarDescontoPorTipoProdutoBusiness descontoProduto = new AplicarDescontoPorTipoProdutoBusiness(carrinho1);
            
            try {
                descontoCupom1.aplicar();
                descontoAniversario.aplicar();
                descontoProduto.aplicar();
                descontoCupom2.aplicar();
            } catch (RuntimeException re) {
                System.out.println(re.getMessage());
            }

            FinalizarCarrinhoBusiness finalizar = new FinalizarCarrinhoBusiness();
            Pedido pedido1 = finalizar.fechar(carrinho1);

            RealizarPagamento pagamento = new RealizarPagamento(pedido1, new PagamentoDebito(1234));
            pagamento.pagar();

            GerarNotaFiscal geradorNota = new GerarNotaFiscal(pedido1);
            NotaFiscal nota = geradorNota.gerar();

            CalculadorICMS calculadorICMS = new CalculadorICMS();
            calculadorICMS.calcularICMS(nota, 6.42);

            ImpressaoNotaFiscalBusiness impressaoJson = new ImpressaoNotaFiscalJSON();
            impressaoJson.imprimir(nota);

            ImpressaoNotaFiscalBusiness impressaoPdf = new ImpressaoNotaFiscalPDF();
            impressaoPdf.imprimir(nota);

            System.out.println(nota.toString());

        } catch (RuntimeException rte) {
            System.err.println("Falha: " + rte.getMessage());
        }

    }

}
