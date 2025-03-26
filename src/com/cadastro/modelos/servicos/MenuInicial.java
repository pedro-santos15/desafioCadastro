package com.cadastro.modelos.servicos;
import com.cadastro.excecoes.AusenciaNomeSobrenome;
import com.cadastro.excecoes.IdadeExcecao;
import com.cadastro.excecoes.PesoExcecao;
import com.cadastro.modelos.entidades.Endereco;
import com.cadastro.modelos.entidades.Nome;
import com.cadastro.modelos.entidades.Pet;
import com.cadastro.modelos.enums.Sexo;
import com.cadastro.modelos.enums.Tipo;

import java.io.*;
import java.util.Scanner;

public class MenuInicial {
    private int escolha;

    public int getEscolha() {
        return escolha;
    }

    public void exibirMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Cadastrar um novo pet");
        System.out.println("2. Alterar os dados do pet cadastrado");
        System.out.println("3. Deletar um pet cadastrado");
        System.out.println("4. Listar todos os pets cadastrados");
        System.out.println("5. Listar pets por algum critério(idade, nome, raça)");
        System.out.println("6. Sair");
        System.out.println("\n Qual opção você deseja?");
        this.escolha = sc.nextInt();

    }

    public void escolhaMenu(File file) {
        switch (getEscolha()) {
            case 1:
                cadastroPet(file);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            default:
                System.out.println("Opção inválida, atentar-se ao menu!");
                exibirMenu();
                escolhaMenu(file);
        }
    }

    public void cadastroPet(File file) {
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

            for (int i = 0; ((s = br.readLine()) != null); i++) {
                System.out.println(s);
                respostas[i] = sc.nextLine();
            }


            final Nome nome;
            if (respostas[0].isEmpty()) {
                nome = new Nome("Não informado");
            } else if (respostas[0].contains(" ")) {
                nome = new Nome(respostas[0]);
            } else {
                throw new AusenciaNomeSobrenome("O nome deve possuir somente letras e deve constar Nome e Sobrenome");
            }


            Tipo tipo;
            if (respostas[1].equalsIgnoreCase("Cachorro")) {
                tipo = Tipo.CACHORRO;
            } else {
                tipo = Tipo.GATO;
            }

            Sexo sexo;
            if (respostas[2].equalsIgnoreCase("Macho")) {
                sexo = Sexo.MACHO;
            } else {
                sexo = Sexo.FEMEA;
            }


            final Endereco endereco;
            if (respostas[4].isEmpty()){
                endereco = new Endereco(respostas[3], "Não informado", respostas[5]);
            } else {
                endereco = new Endereco(respostas[3], respostas[4],respostas[5]);
            }

            final String idade;
            if (respostas[6].isEmpty()){
                idade = "Não informado";
            } else if (respostas[6].matches("[0-9]") && Double.parseDouble(respostas[6]) <= 20) {
                idade = respostas[6];
            } else {
                throw new IdadeExcecao("Deve se ser informados apenas números e até no maximo 20 anos");
            }

            final String peso;
            if (respostas[7].isEmpty()){
                peso = "Não informado";
            } else if (respostas[7].matches("[0-9]") &&
            Double.parseDouble(respostas[7]) <= 60 && Double.parseDouble(respostas[7]) >= 0.5) {
                peso = respostas[7];
            } else {
                throw new PesoExcecao("Deve se ser informados apenas números e no mínimo 0.5 kg e máximo de 60 kg");
            }

            final String raca;
            if (respostas[8].isEmpty()){
                raca = "Não informado";
            } else {
                raca = respostas[8];
            }
            br.close();
            sc.close();

            Pet pet = new Pet(nome, tipo, sexo, endereco, idade, peso, raca);
        } catch (IOException | AusenciaNomeSobrenome | IdadeExcecao | PesoExcecao e) {
            System.out.println(e.getMessage());
        }
    }
}






