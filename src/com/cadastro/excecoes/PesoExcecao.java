package com.cadastro.excecoes;

public class PesoExcecao extends RuntimeException {
    private String mensagem;

    public PesoExcecao(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
