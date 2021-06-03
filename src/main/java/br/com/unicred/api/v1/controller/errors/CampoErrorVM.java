package br.com.unicred.api.v1.controller.errors;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class CampoErrorVM implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String objetoNome;
    private final String campo;
    private final String mensagem;
}
