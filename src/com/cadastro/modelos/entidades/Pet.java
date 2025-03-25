package com.cadastro.modelos.entidades;

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

    public void adicionarPet(File file){
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não foi encontrado");
        }
        BufferedReader br = new BufferedReader(fr);
        String s = null;

        try {
            Scanner sc = new Scanner(System.in);
            String[] respostas = new String[9];

            for (int i = 0; i <= 9; i++) {
                while((s = br.readLine()) != null){

                    System.out.println(s);
                    respostas[i] = sc.nextLine();
                }
            }
            Nome nome = new Nome(respostas[0]);
            Tipo tipo = Tipo.valueOf(respostas[1]);
            Sexo sexo = Sexo.valueOf(respostas[2]);
            Endereco endereco = new Endereco(respostas[3], Integer.valueOf(respostas[4]), respostas[5]);
            int idade = Integer.valueOf(respostas[6]);
            int peso = Integer.valueOf(respostas[7]);
            String raca = respostas[8];

            Pet pet = new Pet(nome, tipo, sexo,endereco, idade, peso, raca);

            br.close();
            sc.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
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
