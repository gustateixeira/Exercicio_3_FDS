package com.bcopstein.ex1biblioeca;

public class Usuario {
    private int codigo;
    private String nome;
    private int anoNas;
    private int codEmp;

    public Usuario(int codigo, String nome, int anoNas, int codEmp) {
        this.codigo = codigo;
        this.nome = nome;
        this.anoNas = anoNas;
        this.codEmp = codEmp;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoNas() {
        return anoNas;
    }

    public int getCodEmp() {
        return codEmp;
    }

    @Override
    public String toString() {
        return "Usuario [codigo=" + codigo + ", nome=" + nome + ", ano de Nascimento=" + anoNas + ", Codigo de Emprestimo=" + codEmp + "]";
    }

}