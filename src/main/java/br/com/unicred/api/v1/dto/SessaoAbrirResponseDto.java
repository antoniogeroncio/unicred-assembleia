package br.com.unicred.api.v1.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SessaoAbrirResponseDto {
    @ApiModelProperty(value = "ID da Pauta")
    private Long id;
    @ApiModelProperty(value = "Data e hora da finalização da Sessão")
    private LocalDateTime finalizacao;
}
