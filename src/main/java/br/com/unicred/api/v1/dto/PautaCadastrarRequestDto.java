package br.com.unicred.api.v1.dto;

import br.com.unicred.config.Constantes;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

import static br.com.unicred.config.Constantes.ApiDoc.API_DOC_DESCRICAO_DA_PAUTA;
import static br.com.unicred.config.Constantes.Mensagens.MSG_O_CAMPO_NOME_E_OBRIGATORIO;

@Data
@Builder
public class PautaCadastrarRequestDto {
    @ApiModelProperty(value = Constantes.ApiDoc.API_DOC_NOME_DA_PAUTA, required = true)
    @NotBlank(message = MSG_O_CAMPO_NOME_E_OBRIGATORIO)
    private String nome;
    @ApiModelProperty(value = API_DOC_DESCRICAO_DA_PAUTA)
    private String descricao;
}
