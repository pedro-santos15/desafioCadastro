package com.cadastro.modelos.servicos;

import com.cadastro.excecoes.AusenciaNomeSobrenome;
import com.cadastro.excecoes.IdadeExcecao;
import com.cadastro.excecoes.PesoExcecao;

import java.util.Scanner;

public class AlterarDadosPet {

    public void alterarDados(){
        Scanner sc = new Scanner(System.in);
        BuscaPet buscaPet = new BuscaPet();

        buscaPet.buscar();

        //possivelmente vou usar um do-while para aparecer o menu de buscas até o usuário
        //buscar corretamente.

        System.out.println("Qual pet você deseja editar?");
        int selecao = sc.nextInt();
        sc.nextLine();

        if (selecao > buscaPet.getResultadoBuscador().length || selecao < 0){
            System.out.println("Número selecionado inválido! Favor buscar novamente o pet");
            alterarDados();
        }

        String resposta = "sim";
        String valor;
        String chave;

        try {
            while (resposta.equalsIgnoreCase("sim") || resposta.equalsIgnoreCase("s")){
                exibirMenuAlteracao();
                chave = sc.nextLine();

                switch (chave.toLowerCase()){
                    case "nome":
                        System.out.println("Digite o novo nome");
                        valor = sc.nextLine();
                        buscaPet.getResultadoBuscador()[selecao - 1].validarNome(valor);
                        System.out.println("Deseja atualizar mais algum dado? ");
                        resposta = sc.nextLine();
                        break;
                    case "idade":
                        System.out.println("Digite a idade nova");
                        valor = sc.nextLine();
                        buscaPet.getResultadoBuscador()[selecao - 1].validarIdade(valor);
                        System.out.println("Deseja atualizar mais algum dado? ");
                        resposta = sc.nextLine();
                        break;
                    case "peso":
                        System.out.println("Digite o peso novo");
                        valor = sc.nextLine();
                        buscaPet.getResultadoBuscador()[selecao - 1].validarIdade(valor);
                        System.out.println("Deseja atualizar mais algum dado? ");
                        resposta = sc.nextLine();
                        break;
                    case "raça":
                        System.out.println("Digite a raça nova");
                        valor = sc.nextLine();
                        buscaPet.getResultadoBuscador()[selecao - 1].validarRaca(valor);
                        System.out.println("Deseja atualizar mais algum dado? ");
                        resposta = sc.nextLine();
                        break;
                    case "endereço":
                        System.out.print("Digite a rua: ");
                        String rua = sc.nextLine();
                        System.out.print("Digite o numero: ");
                        String numero = sc.nextLine();
                        System.out.print("Digite a cidade: ");
                        String cidade = sc.nextLine();

                        buscaPet.getResultadoBuscador()[selecao - 1].validarEndereco(rua, numero, cidade);
                        System.out.println("Deseja atualizar mais algum dado? ");
                        resposta = sc.nextLine();
                        break;
                    default:
                        System.out.println("Favor digitar uma entrada válida \n");
                        break;

                }

                System.out.println("Dados atualizados");
                System.out.println(buscaPet.getResultadoBuscador()[selecao - 1]);

            }
        } catch (AusenciaNomeSobrenome | IdadeExcecao | PesoExcecao e){
            System.out.println(e.getMessage());
        }

    }

    public void exibirMenuAlteracao(){
        System.out.println("Nome ou sobrenome");
        System.out.println("Idade");
        System.out.println("Peso");
        System.out.println("Raça");
        System.out.println("Endereço");
        System.out.println("Qual dado você gostaria de atualizar?");
    }
}
