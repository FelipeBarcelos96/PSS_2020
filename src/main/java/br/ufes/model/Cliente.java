package br.ufes.model;

import java.text.DecimalFormat;
import java.time.LocalDate;

public final class Cliente {

    private String nome;
    private String CNPJOuCPF;
    private double pontuacao;
    private LocalDate dataNascimento;
    private Endereco endereco;

    public Cliente(String nome, String CNPJOuCPF, LocalDate dataNascimento, Endereco endereco) {
        this.nome = nome;
        setCNPJOuCPF(CNPJOuCPF);
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        setPontuacao(0);
    }

    
    
    private void setNome(String nome) {
        this.nome = nome;
    }

    private void setCNPJOuCPF(String CNPJOuCPF) {
        this.CNPJOuCPF = CNPJOuCPF;
    }

    private void setPontuacao(double pontuacao) {
        this.pontuacao = pontuacao;
    }

    private void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public String getNome() {
        return nome;
    }

    public String getCNPJOuCPF() {
        return CNPJOuCPF;
    }

    public double getPontuacao() {
        return pontuacao;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void addPontuacao(double pontuacao)
    {
        this.pontuacao += pontuacao;
    }
    
    public void removerPontuacao(double pontuacao)
    {
        this.pontuacao -= pontuacao;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return "Cliente: " + this.getNome() + ", CNPJ/CPF: " + this.getCNPJOuCPF() +
                " Pontuação: "+ df.format(this.getPontuacao()) +
                "\nEndereço: "+ this.getEndereco().toString();
    }

}
