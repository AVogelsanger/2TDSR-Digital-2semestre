package br.com.fiap.aula01.model;

public class Restaurante {

    private String nome;
    private String endereco;
    private double faturamento;

    public Restaurante() {

    }

    public Restaurante(String nome, String endereco, double faturamento) {
        this.nome = nome;
        this.endereco = endereco;
        this.faturamento = faturamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(double faturamento) {
        this.faturamento = faturamento;
    }
}
