package br.com.fiap.aula03.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "T_GRAVADORA")
@SequenceGenerator(name = "gravadora", sequenceName = "SQ_T_GRAVADORA", allocationSize = 1)
public class Gravadora {

    @Id
    @Column(name = "cd_gravadora")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gravadora")
    private int codigo;
    private String nome;
    private boolean internacional;
    private double faturamento;
    private LocalDate dataAbertura;

    public Gravadora() {
    }

    public Gravadora(int codigo, String nome, boolean internacional, double faturamento) {
        this.codigo = codigo;
        this.nome = nome;
        this.internacional = internacional;
        this.faturamento = faturamento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isInternacional() {
        return internacional;
    }

    public void setInternacional(boolean internacional) {
        this.internacional = internacional;
    }

    public double getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(double faturamento) {
        this.faturamento = faturamento;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
}
