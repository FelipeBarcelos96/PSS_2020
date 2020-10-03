/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.model;

/**
 *
 * @author nandi
 */
public class Endereco {
    
    private String Cidade;
    private String rua;
    private String numero;
    private String UF;

    public Endereco(String Cidade, String rua, String numero, String UF) {
        this.Cidade = Cidade;
        this.rua = rua;
        this.numero = numero;
        this.UF = UF;
    }

    public String getCidade() {
        return Cidade;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getUF() {
        return UF;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }
    
    

}
