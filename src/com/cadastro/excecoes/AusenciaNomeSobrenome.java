package com.cadastro.excecoes;

public class AusenciaNomeSobrenome extends RuntimeException {
    private String mensagem;

    public AusenciaNomeSobrenome(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
