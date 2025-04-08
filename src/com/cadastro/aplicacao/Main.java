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

        File file = new File("formulario.txt");

        MenuInicial menu = new MenuInicial();

        menu.escolhaMenu(file);

    }
}
