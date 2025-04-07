package com.cadastro.modelos.servicos;
import com.cadastro.modelos.entidades.Pet;

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
        BuscaPet buscaPet = new BuscaPet();

        switch (getEscolha()) {
            case 1:
                Pet pet = new Pet();
                pet.cadastroPet(file);
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
                break;
            case 5:
                buscaPet.buscar();
                break;
            case 6:
                break;
            default:
                System.out.println("Opção inválida, atentar-se ao menu!");
                exibirMenu();
                escolhaMenu(file);
        }
    }
}






