package com.cadastro.excecoes;

public class IdadeExcecao extends RuntimeException {
  private String mensagem;

  public IdadeExcecao(String mensagem) {
    this.mensagem = mensagem;
  }

  @Override
  public String getMessage() {
    return this.mensagem;
  }
}
