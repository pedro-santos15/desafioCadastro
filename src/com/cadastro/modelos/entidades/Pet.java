package com.cadastro.modelos.entidades;

import com.cadastro.excecoes.AusenciaNomeSobrenome;
import com.cadastro.modelos.enums.Sexo;
import com.cadastro.modelos.enums.Tipo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pet {
    private Nome nome;
    private Tipo tipo;
    private Sexo sexo;
    private Endereco endereco;
    private double idade;
    private double peso;
    private String raca;

    private static List<Pet> pets = new ArrayList<>();

    public Pet() {
    }

    public Pet(Nome nome, Tipo tipo, Sexo sexo, Endereco endereco, double idade, double peso, String raca) {
        this.nome = nome;
        this.tipo = tipo;
        this.sexo = sexo;
        this.endereco = endereco;
        this.idade = idade;
        this.peso = peso;
        this.raca = raca;
        pets.add(this);
    }

    public Nome getNome() {
        return nome;
    }

    public void setNome(Nome nome) {
        this.nome = nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public double getIdade() {
        return idade;
    }

    public void setIdade(double idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public static List<Pet> getPets() {
        return pets;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "nome=" + nome +
                ", tipo=" + tipo +
                ", sexo=" + sexo +
                ", endereco=" + endereco +
                ", idade=" + idade +
                ", peso=" + peso +
                ", raca='" + raca + '\'' +
                '}';
    }
}
