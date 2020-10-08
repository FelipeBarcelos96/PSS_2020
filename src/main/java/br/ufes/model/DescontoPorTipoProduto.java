package br.ufes.model;

public class DescontoPorTipoProduto extends Desconto {

    private Item item;

    public DescontoPorTipoProduto(Item item) {
        this.item = item;
        this.setDescricao("Desconto Produto: " + item.getProduto().getNome());
    }

    @Override
    public void calcularValor() {
        MapTipoDesconto descontoTipo = new MapTipoDesconto();
        String tipo = item.getProduto().getTipo();
        Double porcentagem = descontoTipo.buscarDescontoPorTipo(tipo);

        if (porcentagem == null) {
            this.valor = 0;
        } else {
            this.valor = item.getValorItem() * porcentagem;
        }
    }
}
