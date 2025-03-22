package com.cadastro.modelos.servicos;

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
    public void escolhaMenu(){
        switch (getEscolha()){
            case 1:
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
                escolhaMenu();
        }
    }



}




