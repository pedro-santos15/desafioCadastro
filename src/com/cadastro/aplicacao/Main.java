package com.cadastro.aplicacao;

import com.cadastro.modelos.entidades.Pet;
import com.cadastro.modelos.servicos.ManipulacaoArquivos;
import com.cadastro.modelos.servicos.MenuInicial;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ManipulacaoArquivos arquivos = new ManipulacaoArquivos();

        File file = new File("C:\\Users\\pedrohsilva\\Projetos\\desafioCadastro\\formulario.txt");
        arquivos.leitorArquivo(file);

        MenuInicial menu = new MenuInicial();
        menu.exibirMenu();
        menu.escolhaMenu(file);

        System.out.println(Pet.getPets());

    }
}
