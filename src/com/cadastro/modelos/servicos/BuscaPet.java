package com.cadastro.modelos.servicos;

import com.cadastro.modelos.entidades.Pet;
import com.cadastro.modelos.enums.Sexo;
import com.cadastro.modelos.enums.Tipo;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BuscaPet {


    public void buscar(){
        Map<String, String> criterios = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual é o tipo do animal? (Cachorro/Gato)");
        Tipo tipo = Tipo.valueOf(sc.nextLine());

        criterios.put("tipo", String.valueOf(tipo).toUpperCase());
        System.out.println();

        exibirMenu();
        String chave = sc.nextLine();
        System.out.println("Insira a pesquisa:");
        String valor = sc.nextLine();
        criterios.put(chave, valor);

        Predicate<Pet> filtroFinal = pet -> true;

        for (Map.Entry<String, String> criterio : criterios.entrySet()) {

            Predicate<Pet> filtroAtual = pet -> true;

            switch (chave.toLowerCase()){
                case "nome":
                    filtroAtual = pet -> pet.getNome().getNomeCompleto().contains(valor);
                    break;
                case "sexo":
                    filtroAtual = pet -> pet.getSexo().equals(Sexo.valueOf(valor));
                    break;
                case "idade":
                    filtroAtual = pet -> pet.getIdade().equals(valor);
                    break;
                case "peso":
                    filtroAtual = pet -> pet.getPeso().equals(valor);
                    break;
                case "raça":
                    filtroAtual = pet -> pet.getRaca().equals(valor);
                    break;
                case "endereço":
                    filtroAtual = pet -> pet.getEndereco().getCidade().contains(valor)
                            || pet.getEndereco().getNumero().contains(valor)
                            || pet.getEndereco().getRua().contains(valor);
                    break;
            }

            filtroFinal = filtroFinal.and(filtroAtual);
        }
        List<Pet> resultadoBusca = Pet.getPets().stream().filter(filtroFinal).collect(Collectors.toList());
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
