package com.cadastro.modelos.servicos;

import com.cadastro.modelos.entidades.Pet;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    public void escritorArquivos(Pet pet){
        FileWriter fw;
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");

        String nomeArquivo = formatter.format(agora) + pet.getNome().getNome().toUpperCase()
                + pet.getNome().getSobrenome().toUpperCase() + ".txt";

        try {
            File file = new File(nomeArquivo);
            fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            String[] respostas = new String[7];
            respostas[0] = pet.getNome().getNomeCompleto();
            respostas[1] = pet.getTipo().toString();
            respostas[2] = pet.getSexo().toString();
            respostas[3] = pet.getEndereco().getRua() + ", " + pet.getEndereco().getNumero()
                    + ", " + pet.getEndereco().getCidade();
            respostas[4] = pet.getIdade() + " anos";
            respostas[5] = pet.getPeso() + "kg";
            respostas[6] = pet.getRaca();

            for (int i = 1; i <= respostas.length; i++) {
                bw.write((i) + " - " + respostas[i - 1] + "\n");
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
