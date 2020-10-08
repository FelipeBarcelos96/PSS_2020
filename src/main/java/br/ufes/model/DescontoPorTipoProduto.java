package br.ufes.model;

public class DescontoPorTipoProduto extends Desconto {

    private Item item;

    public DescontoPorTipoProduto(Item item) {
        this.item = item;
        this.setDescricao("Desconto Produto: " + item.getProduto().getNome());
    }

    @Override
    public void calcular() {
        MapTipoDesconto descontoTipo = new MapTipoDesconto();
        String tipo = item.getProduto().getTipo();
        Double porcentagemDoTipo = descontoTipo.buscarDescontoPorTipo(tipo);

        if (porcentagemDoTipo == null) {
            this.valorDesconto = 0;
        }else {
            this.porcentagem = porcentagemDoTipo;
            this.valorOrigem = item.getValorItem();
            this.valorDesconto = valorOrigem * (porcentagem/100);
        }
    }
}
