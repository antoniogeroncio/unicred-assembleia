package br.com.unicred.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VotacaoResultado {
    private String nomePauta;
    private Long votosSim;
    private Long votosNao;
}
