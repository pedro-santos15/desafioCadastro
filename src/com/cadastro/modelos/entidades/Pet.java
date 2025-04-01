package com.cadastro.modelos.entidades;

import com.cadastro.excecoes.AusenciaNomeSobrenome;
import com.cadastro.excecoes.IdadeExcecao;
import com.cadastro.excecoes.PesoExcecao;
import com.cadastro.modelos.enums.Sexo;
import com.cadastro.modelos.enums.Tipo;
import com.cadastro.modelos.servicos.ManipulacaoArquivos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pet {
    private Nome nome;
    private Tipo tipo;
    private Sexo sexo;
    private Endereco endereco;
    private String idade;
    private String peso;
    private String raca;

    private final String[] respostas = new String[9];
    private static final List<Pet> pets = new ArrayList<>();

    public Pet() {
    }

    public Pet(Nome nome, Tipo tipo, Sexo sexo, Endereco endereco, String idade, String peso, String raca) {
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

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
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

    public void cadastroPet(File file) {
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não foi encontrado");
        }
        BufferedReader br = new BufferedReader(fr);
        String s;

        try {
            Scanner sc = new Scanner(System.in);

            for (int i = 0; ((s = br.readLine()) != null); i++) {
                System.out.println(s);
                respostas[i] = sc.nextLine();
            }

            validarNome();
            validarTipo();
            validarSexo();
            validarEndereco();
            validarIdade();
            validarPeso();
            validarRaca();

            br.close();
            sc.close();

            Pet pet = new Pet(nome, tipo, sexo, endereco, idade, peso, raca);

            ManipulacaoArquivos arquivos = new ManipulacaoArquivos();
            arquivos.escritorArquivos(pet);
        } catch (IOException | AusenciaNomeSobrenome | IdadeExcecao | PesoExcecao e) {
            System.out.println(e.getMessage());
        }
    }

    public void validarNome(){
        if (respostas[0].isEmpty()) {
            this.nome = new Nome("Não informado");
        } else if (respostas[0].contains(" ")) {
            this.nome = new Nome(respostas[0]);
        } else {
            throw new AusenciaNomeSobrenome("O nome deve possuir somente letras e deve constar Nome e Sobrenome");
        }
    }

    public void validarTipo(){
        if (respostas[1].equalsIgnoreCase("Cachorro")) {
            this.tipo = Tipo.CACHORRO;
        } else {
            this.tipo = Tipo.GATO;
        }
    }

    public void validarSexo(){
        if (respostas[2].equalsIgnoreCase("Macho")) {
            this.sexo = Sexo.MACHO;
        } else {
            this.sexo = Sexo.FEMEA;
        }
    }

    public void validarEndereco(){
        if (respostas[4].isEmpty()){
            this.endereco = new Endereco(respostas[3], "Não informado", respostas[5]);
        } else {
            this.endereco = new Endereco(respostas[3], respostas[4],respostas[5]);
        }
    }

    public void validarIdade(){
        if (respostas[6].isEmpty()){
            this.idade = "Não informado";
        } else if (respostas[6].matches("^[0-9]{1,2}(\\.[0-9]{1,2})?$") && Double.parseDouble(respostas[6]) <= 20) {
            this.idade = respostas[6];
        } else {
            throw new IdadeExcecao("Deve se ser informados apenas números e até no maximo 20 anos");
        }
    }

    public void validarPeso(){
        if (respostas[7].isEmpty()){
            this.peso = "Não informado";
        } else if (respostas[7].matches("^[0-9]{1,2}(\\.[0-9]{1,2})?$") &&
                Double.parseDouble(respostas[7]) <= 60 && Double.parseDouble(respostas[7]) >= 0.5) {
            this.peso = respostas[7];
        } else {
            throw new PesoExcecao("Deve se ser informados apenas números e no mínimo 0.5 kg e máximo de 60 kg");
        }
    }

    public void validarRaca(){
        if (respostas[8].isEmpty()){
            this.raca = "Não informado";
        } else {
            this.raca = respostas[8];
        }
    }


    @Override
    public String toString() {
        return nome + " - "
                + tipo
                + " - "
                + sexo
                + " - "
                + endereco
                + " - "
                + idade
                + " anos - "
                + peso
                + "kg - "
                + raca;
    }
}
