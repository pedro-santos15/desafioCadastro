package com.cadastro.aplicacao;


import com.cadastro.modelos.entidades.Nome;
import com.cadastro.modelos.servicos.MenuInicial;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        // PASSO 1
        File file = new File("C:\\Users\\pedrohsilva\\Projetos\\formulario.txt");
        Scanner leitura = new Scanner(file);

        while(leitura.hasNextLine()){
            System.out.println(leitura.nextLine());
        }

        leitura.close();

        //PASSO 2
        MenuInicial menu = new MenuInicial();
        menu.exibirMenu();
        menu.escolhaMenu();


    }
}
