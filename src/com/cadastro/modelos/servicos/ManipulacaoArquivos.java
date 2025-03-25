package com.cadastro.modelos.servicos;

import java.io.*;

public class ManipulacaoArquivos {

    public void leitorArquivo(File file){
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não foi encontrado");
        }
        BufferedReader br = new BufferedReader(fr);
        String s = null;

        try {
            while((s = br.readLine()) != null){
                System.out.println(s);
            }

            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
