package com.cadastro.modelos.entidades;

import com.cadastro.excecoes.AusenciaNomeSobrenome;
import com.cadastro.excecoes.IdadeExcecao;
import com.cadastro.excecoes.PesoExcecao;
import com.cadastro.modelos.enums.Sexo;
import com.cadastro.modelos.enums.Tipo;
import com.cadastro.modelos.servicos.ManipulacaoArquivos;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.*;

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

    public Sexo getSexo() {
        return sexo;
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

            validarNome(respostas[0]);
            validarTipo(respostas[1]);
            validarSexo(respostas[2]);
            validarEndereco(respostas[3], respostas[4], respostas[5]);
            validarIdade(respostas[6]);
            validarPeso(respostas[7]);
            validarRaca(respostas[8]);

            br.close();
            sc.close();

            Pet pet = new Pet(nome, tipo, sexo, endereco, idade, peso, raca);

            ManipulacaoArquivos arquivos = new ManipulacaoArquivos();
            arquivos.escritorArquivos(pet);
        } catch (IOException | AusenciaNomeSobrenome | IdadeExcecao | PesoExcecao e) {
            System.out.println(e.getMessage());
        }
    }

    public void validarNome(@NotNull String s){
        if (s.isEmpty()) {
            this.nome = new Nome("Não informado");
        } else if (s.contains(" ")) {
            this.nome = new Nome(s);
        } else {
            throw new AusenciaNomeSobrenome("O nome deve possuir somente letras e deve constar Nome e Sobrenome");
        }
    }

    public void validarTipo(@NotNull String s){
        if (s.equalsIgnoreCase("Cachorro")) {
            this.tipo = Tipo.CACHORRO;
        } else {
            this.tipo = Tipo.GATO;
        }
    }

    public void validarSexo(String s){
        if (s.equalsIgnoreCase("Macho")) {
            this.sexo = Sexo.MACHO;
        } else {
            this.sexo = Sexo.FEMEA;
        }
    }

    public void validarEndereco(String rua, String numero, String cidade){
        if (numero.isEmpty()){
            this.endereco = new Endereco(rua, "Não informado", cidade);
        } else {
            this.endereco = new Endereco(rua, numero, cidade);
        }
    }

    public void validarIdade(String s){
        if (s.isEmpty()){
            this.idade = "Não informado";
        } else if (s.matches("^[0-9]{1,2}(\\.[0-9]{1,2})?$") && Double.parseDouble(s) <= 20) {
            this.idade = s;
        } else {
            throw new IdadeExcecao("Deve se ser informados apenas números e até no maximo 20 anos");
        }
    }

    public void validarPeso(String s){
        if (s.isEmpty()){
            this.peso = "Não informado";
        } else if (s.matches("^[0-9]{1,2}(\\.[0-9]{1,2})?$") &&
                Double.parseDouble(s) <= 60 && Double.parseDouble(s) >= 0.5) {
            this.peso = s;
        } else {
            throw new PesoExcecao("Deve se ser informados apenas números e no mínimo 0.5 kg e máximo de 60 kg");
        }
    }

    public void validarRaca(String s){
        if (s.isEmpty()){
            this.raca = "Não informado";
        } else {
            this.raca = s;
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
