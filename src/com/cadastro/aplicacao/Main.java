package com.cadastro.aplicacao;

import com.cadastro.modelos.entidades.Endereco;
import com.cadastro.modelos.entidades.Nome;
import com.cadastro.modelos.entidades.Pet;
import com.cadastro.modelos.enums.Sexo;
import com.cadastro.modelos.enums.Tipo;
import com.cadastro.modelos.servicos.ManipulacaoArquivos;
import com.cadastro.modelos.servicos.MenuInicial;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ManipulacaoArquivos arquivos = new ManipulacaoArquivos();

        File file = new File("C:\\Pechak\\MeusProjetos\\desafioCadastro\\formulario.txt");
        //arquivos.leitorArquivo(file);

        MenuInicial menu = new MenuInicial();

        Endereco endereco = new Endereco("Tabajaras", "361", "Curitiba");
        Tipo tipo = Tipo.CACHORRO;
        Sexo sexo = Sexo.MACHO;

        Pet pet1 = new Pet(new Nome("Pedro Henrique"), tipo, sexo, endereco, "10", "10", "Salsicha");
        Pet pet2 = new Pet(new Nome("Bananilson Farofa"), tipo, sexo, endereco, "10", "10", "Salsicha");
        Pet pet3 = new Pet(new Nome("Sasuke Uchiha"), tipo, sexo, endereco, "10", "10", "Salsicha");

        menu.exibirMenu();
        menu.escolhaMenu(file);

        //System.out.println(Pet.getPets());

    }
}
