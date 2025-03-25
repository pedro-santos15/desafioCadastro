package com.cadastro.modelos.entidades;

import com.cadastro.excecoes.AusenciaNomeSobrenome;

public class Nome {
    private String nomeCompleto;
    private String nome;
    private String sobrenome;

    public Nome(String nomeCompleto) {
        try {
            if (validacaoNome(nomeCompleto)){
                this.nomeCompleto = nomeCompleto;
            }
        }catch (AusenciaNomeSobrenome e) {
            System.out.println(e.getMessage());
        }
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public boolean validacaoNome(String nomeCompleto){
            if (nomeCompleto.contains(" ")){
                String[] separador = nomeCompleto.split(" ");
                this.nome = separador[0];
                this.sobrenome = separador[1];
            } else {
                throw  new AusenciaNomeSobrenome("É necessário que seja informado um nome e sobrenome");
            }
        return nomeCompleto.matches("[a-zA-Z]");
    }
}
