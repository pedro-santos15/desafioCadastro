package com.cadastro.modelos.servicos;
import com.cadastro.excecoes.AusenciaNomeSobrenome;
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

    public void exibirMenu(){
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
    public void escolhaMenu(File file){
        switch (getEscolha()){
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

    public void cadastroPet(File file){
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


            Nome nome = null;
            if (respostas[0].contains(" ")){
                nome = new Nome(respostas[0]);
            } else {
                throw new AusenciaNomeSobrenome("É necessário que o nome possua nome e sobrenome");
            }

            Tipo tipo;
            if (respostas[1].equalsIgnoreCase("Cachorro")){
                tipo = Tipo.CACHORRO;
            } else {
                tipo = Tipo.GATO;
            }

            Sexo sexo;
            if (respostas[2].equalsIgnoreCase("Macho")){
                sexo = Sexo.MACHO;
            } else {
                sexo = Sexo.FEMEA;
            }

            Endereco endereco = new Endereco(respostas[3], Integer.parseInt(respostas[4]), respostas[5]);
            int idade = Integer.parseInt(respostas[6]);
            int peso = Integer.parseInt(respostas[7]);
            String raca = respostas[8];

            br.close();
            sc.close();

            Pet pet = new Pet(nome, tipo, sexo, endereco, idade, peso, raca);
        } catch (IOException | AusenciaNomeSobrenome e) {
            System.out.println(e.getMessage());
        }
    }

}




