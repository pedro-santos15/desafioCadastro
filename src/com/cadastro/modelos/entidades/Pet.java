package com.cadastro.modelos.entidades;

import com.cadastro.modelos.enums.Sexo;

public class Pet {
    private String nome;
    private Sexo sexo;
    private Endereco endereco;
    private double idade;
    private double peso;
    private String raca;

    public Pet(String nome, Sexo sexo, Endereco endereco, double idade, double peso, String raca) {
        this.nome = nome;
        this.sexo = sexo;
        this.endereco = endereco;
        this.idade = idade;
        this.peso = peso;
        this.raca = raca;
    }
}
