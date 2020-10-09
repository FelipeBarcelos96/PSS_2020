package br.ufes.model;

public final class Produto {

    private String nome;
    private double valorUnitario;
    private double valorUltimaCompra;
    private String tipo;
    private final Estoque estoque;

    public Produto(String nome, String tipo, double valorUnitario, double quantidadeEstoque) {
        this.nome = nome;
        this.tipo = tipo;
        setValorUnitario(valorUnitario);

        Estoque estoque = new Estoque(quantidadeEstoque);
        this.estoque = estoque;

    }

    public String getNome() {
        return nome;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public double getValorUltimaCompra() {
        return valorUltimaCompra;
    }

    public void setNome(String nome) {
        if (nome == null || nome == "") {
            throw new RuntimeException("Nome inválido! O nome não pode ser vazio ou nulo.");
        }
        this.nome = nome;
    }

    public void setValorUnitario(double valorUnitario) {
        if (valorUnitario <= 0) {
            throw new RuntimeException("Valor inválido! O valor não pode ser nulo ou negativo.");
        }
        this.valorUltimaCompra = this.valorUnitario;
        this.valorUnitario = valorUnitario;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Produto: " + nome
                + ", valor unitario: R$" + valorUnitario
                + ", valor da ultima compra: R$" + valorUltimaCompra;
    }

}
