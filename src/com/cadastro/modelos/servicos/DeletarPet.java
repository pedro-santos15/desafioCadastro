package com.cadastro.modelos.servicos;

import com.cadastro.modelos.entidades.Pet;

import java.util.Objects;
import java.util.Scanner;

public class DeletarPet {

    public void deletar(){
        Scanner sc = new Scanner(System.in);
        BuscaPet buscaPet = new BuscaPet();
        buscaPet.buscar();

        System.out.println("Qual pet você deseja deletar?");
        int selecao = sc.nextInt();
        sc.nextLine();

        while (selecao > buscaPet.getResultadoBuscador().length || selecao < 0){
            System.out.println("Numero de seleção inválido, favor selecionar novamente");

            int i = 1;
            for (Pet pet : buscaPet.getResultadoBuscador()) {
                System.out.println(i + " - " + pet);
                i++;
            }

            System.out.println("Qual pet você deseja deletar?");
            selecao = sc.nextInt();
            sc.nextLine();
        }


        System.out.println("Digite SIM para confirmar a exclusão do pet e NÃO para cancelar a operação");
        String resposta = sc.nextLine();

        boolean entradaValida = false;

        //Abaixo foi apenas acatado a sugestão da IDE de transformar if-else para switch case.

        while (!entradaValida){
            switch (resposta) {
                case "SIM" -> {
                    Pet.getPets().remove(buscaPet.getResultadoBuscador()[selecao - 1]);
                    entradaValida = true;
                }
                case "NÃO", "NAO" -> {
                    System.out.println("Operação cancelada!");
                    entradaValida = true;
                }
                default -> {
                    System.out.println("Favor digitar uma opção valida!");
                    System.out.println("Digite SIM para confirmar a exclusão do pet e NÃO para cancelar a operação");
                    resposta = sc.nextLine();
                }

            }
        }



        System.out.println("Lista atualizada de pets: ");
        Pet.exibirPets();

    }
}
