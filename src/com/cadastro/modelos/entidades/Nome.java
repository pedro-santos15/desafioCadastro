package com.cadastro.modelos.entidades;

import com.cadastro.excecoes.AusenciaNomeSobrenome;

public class Nome {
    private String nomeCompleto;
    private String nome;
    private String sobrenome;

    public Nome(String nomeCompleto) {
        try {
            if (nomeCompleto.equals("Não informado")){
                this.nomeCompleto = nomeCompleto;
                this.nome = "Não informado";
                this.sobrenome = "Não informado";
            } else if (validacaoNome(nomeCompleto)){
                this.nomeCompleto = nomeCompleto;
                String[] separador = nomeCompleto.split(" ");

                if (separador.length < 2){
                    throw new AusenciaNomeSobrenome("O nome completo deve conter nome e sobrenome.");
                }

                this.nome = separador[0];
                this.sobrenome = separador[1];
            }else {
                throw new AusenciaNomeSobrenome("O nome deve ser composto apenas por letras.");
            }
        } catch (AusenciaNomeSobrenome e){
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
        return nomeCompleto.matches("^[a-zA-Z]+( [a-zA-Z]+)+$");
    }

    @Override
    public String toString() {
        return this.nomeCompleto;
    }
}
