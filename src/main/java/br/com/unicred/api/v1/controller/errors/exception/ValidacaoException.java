package br.com.unicred.api.v1.controller.errors.exception;

public class ValidacaoException extends RuntimeException{
    public ValidacaoException(String mensagem) {
        super(mensagem);
    }
}
