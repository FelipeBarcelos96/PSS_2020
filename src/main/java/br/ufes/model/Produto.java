package br.ufes.model;


public final class Produto {

    private String nome;
    private double valorUnitario;
    private double valorUltimaCompra;
    private String tipo;
    private final Estoque estoque;

    public Produto(String nome, double valorUnitario, double estoque) {
        this.nome = nome;
        setValorUnitario(valorUnitario);
        
        Estoque estoque1 = new Estoque(estoque);
        this.estoque = estoque1;
        
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
        if (nome == null) {
            throw new RuntimeException("Nome inválido: " + nome);
        }
        this.nome = nome;
    }

    public void setValorUnitario(double valorUnitario) {
        if (valorUnitario <= 0) {
            throw new RuntimeException("Valor inválido: " + valorUnitario);
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
