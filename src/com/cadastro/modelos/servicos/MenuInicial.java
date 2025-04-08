package com.cadastro.modelos.servicos;
import com.cadastro.modelos.entidades.Pet;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class MenuInicial {
    private int escolha;

    public int getEscolha() {
        return escolha;
    }

    public void exibirMenu() {
        System.out.println("1. Cadastrar um novo pet");
        System.out.println("2. Alterar os dados do pet cadastrado");
        System.out.println("3. Deletar um pet cadastrado");
        System.out.println("4. Listar todos os pets cadastrados");
        System.out.println("5. Listar pets por algum critério(idade, nome, raça)");
        System.out.println("0. Sair");
    }

    public void escolhaMenu(File file) {
        Scanner sc = new Scanner(System.in);
        BuscaPet buscaPet = new BuscaPet();


        exibirMenu();
        System.out.println("\nQual opção você deseja?");
        this.escolha = sc.nextInt();
        sc.nextLine();

        try {
            while (getEscolha() != 0){

                switch (getEscolha()) {
                    case 1:
                        CadastrarPet cadastro = new CadastrarPet();
                        cadastro.cadastroPet(file,sc);
                        break;
                    case 2:
                        AlterarDadosPet alterar = new AlterarDadosPet();
                        alterar.alterarDados();
                        break;
                    case 3:
                        DeletarPet deletar = new DeletarPet();
                        deletar.deletar();
                        break;
                    case 4:
                        Pet.exibirPets();
                        break;
                    case 5:
                        buscaPet.buscar();
                        break;
                    default:
                        System.out.println("Opção inválida, atentar-se ao menu!");
                        exibirMenu();
                }

                System.out.println("\n");
                exibirMenu();
                System.out.println("\nQual opção você deseja?");
                this.escolha = sc.nextInt();
                sc.nextLine();
            }
        } catch (RuntimeException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        } finally {
            System.out.println("Programa finalizado.");
            sc.close();
        }
    }
}






