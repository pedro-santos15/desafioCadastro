package com.cadastro.modelos.servicos;

import com.cadastro.modelos.entidades.Pet;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BuscaPet {


    public void buscar(){
        Map<String, String> criterios = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        Predicate<Pet> filtroFinal = null;

        boolean testeTipo = false;
        while (!testeTipo){
            System.out.println("Qual é o tipo do animal? (Cachorro/Gato)");
            String tipo = sc.nextLine();

            if (tipo.equalsIgnoreCase("Cachorro") || tipo.equalsIgnoreCase("Gato")){
                criterios.put("tipo", tipo);
                filtroFinal = pet -> pet.getTipo().name().equalsIgnoreCase(tipo);
                testeTipo = true;
            } else {
                System.out.println("Este não é um tipo valido\n");
            }
        }

        boolean entradaValida = false;
        System.out.println();

        for (Map.Entry<String, String> criterio : criterios.entrySet()) {

            Predicate<Pet> filtroAtual = pet -> true;

            while (!entradaValida){
                exibirMenu();
                String chave = sc.nextLine();
                String valor;
                switch (chave.toLowerCase()){
                    case "nome":
                        System.out.println("Insira a pesquisa:");
                        valor = sc.nextLine();
                        criterios.put(chave, valor);
                        filtroAtual = pet -> pet.getNome().getNomeCompleto().contains(valor)
                                || pet.getNome().getNomeCompleto().equalsIgnoreCase(valor)
                                || pet.getNome().getNome().equalsIgnoreCase(valor)
                                || pet.getNome().getSobrenome().equalsIgnoreCase(valor);
                        entradaValida = true;
                        break;
                    case "sexo":
                        System.out.println("Insira a pesquisa:");
                        valor = sc.nextLine();
                        criterios.put(chave, valor);
                        filtroAtual = pet -> pet.getSexo().name().equalsIgnoreCase(valor);
                        entradaValida = true;
                        break;
                    case "idade":
                        System.out.println("Insira a pesquisa:");
                        valor = sc.nextLine();
                        criterios.put(chave, valor);
                        filtroAtual = pet -> pet.getIdade().equals(valor);
                        entradaValida = true;
                        break;
                    case "peso":
                        System.out.println("Insira a pesquisa:");
                        valor = sc.nextLine();
                        criterios.put(chave, valor);
                        filtroAtual = pet -> pet.getPeso().equals(valor);
                        entradaValida = true;
                        break;
                    case "raça":
                        System.out.println("Insira a pesquisa:");
                        valor = sc.nextLine();
                        criterios.put(chave, valor);
                        filtroAtual = pet -> pet.getRaca().equals(valor);
                        entradaValida = true;
                        break;
                    case "endereço":
                        System.out.println("Insira a pesquisa:");
                        valor = sc.nextLine();
                        criterios.put(chave, valor);
                        filtroAtual = pet -> pet.getEndereco().getCidade().contains(valor)
                                || pet.getEndereco().getNumero().contains(valor)
                                || pet.getEndereco().getRua().contains(valor);
                        entradaValida = true;
                        break;
                    default:
                        System.out.println("Favor digitar uma entrada válida \n");
                        break;
                }
            }
            filtroFinal = filtroFinal.and(filtroAtual);
        }



        List<Pet> resultadoBusca = Pet.getPets().stream().filter(filtroFinal).collect(Collectors.toList());

        if (resultadoBusca.isEmpty()){
            System.out.println("Não foram encontrados resultados com base nos parâmetros");
        }

        for (Pet pet : resultadoBusca) {
            System.out.println(pet);
        }

    }

    public void exibirMenu(){
        System.out.println("Nome ou sobrenome");
        System.out.println("Sexo");
        System.out.println("Idade");
        System.out.println("Peso");
        System.out.println("Raça");
        System.out.println("Endereço");
        System.out.println("Qual critério você gostaria de utilizar?");
    }

}
