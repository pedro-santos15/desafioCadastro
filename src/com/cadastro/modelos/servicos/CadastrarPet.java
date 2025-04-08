package com.cadastro.modelos.servicos;

import com.cadastro.excecoes.AusenciaNomeSobrenome;
import com.cadastro.excecoes.IdadeExcecao;
import com.cadastro.excecoes.PesoExcecao;
import com.cadastro.modelos.entidades.Pet;

import java.io.*;
import java.util.Scanner;

public class CadastrarPet extends Pet {

    private final String[] respostas = new String[9];

    public void cadastroPet(File file, Scanner sc) {
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não foi encontrado");
        }
        BufferedReader br = new BufferedReader(fr);
        String s;

        try {

            for (int i = 0; ((s = br.readLine()) != null); i++) {
                System.out.println(s);
                respostas[i] = sc.nextLine();
            }

            validarNome(respostas[0]);
            validarTipo(respostas[1]);
            validarSexo(respostas[2]);
            validarEndereco(respostas[3], respostas[4], respostas[5]);
            validarIdade(respostas[6]);
            validarPeso(respostas[7]);
            validarRaca(respostas[8]);

            br.close();


            Pet pet = new Pet(getNome(), getTipo(), getSexo(), getEndereco(), getIdade(), getPeso(), getRaca());

            ManipulacaoArquivos arquivos = new ManipulacaoArquivos();
            arquivos.escritorArquivos(pet);
        } catch (IOException | AusenciaNomeSobrenome | IdadeExcecao | PesoExcecao e) {
            System.out.println(e.getMessage());
        }
    }
}
