package com.cadastro.aplicacao;


import com.cadastro.modelos.entidades.Nome;
import com.cadastro.modelos.entidades.Pet;
import com.cadastro.modelos.servicos.ManipulacaoArquivos;
import com.cadastro.modelos.servicos.MenuInicial;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        ManipulacaoArquivos arquivos = new ManipulacaoArquivos();

        // PASSO 1
        File file = new File("C:\\Users\\pedrohsilva\\Projetos\\desafioCadastro\\formulario.txt");
        arquivos.leitorArquivo(file);

        //PASSO 2
        MenuInicial menu = new MenuInicial();
        menu.exibirMenu();
        menu.escolhaMenu(file);

        //PASSO 3
        System.out.println(Pet.getPets());

    }
}
