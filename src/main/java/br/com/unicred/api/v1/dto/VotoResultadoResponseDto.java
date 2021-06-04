package br.com.unicred.api.v1.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VotoResultadoResponseDto {
    @ApiModelProperty(value = "Nome da Pauta")
    private String nomePauta;
    @ApiModelProperty(value = "Quantidade de votos sim")
    private Long votosSim;
    @ApiModelProperty(value = "Quantidade de votos não")
    private Long votosNao;
}
