package br.com.unicred.api.v1.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PautaCadastrarResponseDto {
    @ApiModelProperty(value = "ID da Pauta")
    private Long id;
}
