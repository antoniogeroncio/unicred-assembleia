package br.com.unicred.api.v1.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class VotoCadastrarResponseDto {
    @ApiModelProperty(value = "Data e hora da Voto")
    private LocalDateTime data;
}
