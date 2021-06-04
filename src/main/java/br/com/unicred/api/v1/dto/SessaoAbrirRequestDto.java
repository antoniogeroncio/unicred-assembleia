package br.com.unicred.api.v1.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

import static br.com.unicred.config.Constantes.ApiDoc.API_DOC_ID_DA_PAUTA;
import static br.com.unicred.config.Constantes.ApiDoc.API_DOC_TEMPO_DA_SESSAO;
import static br.com.unicred.config.Constantes.Mensagens.MSG_O_CAMPO_ID_PAUTA_E_OBRIGATORIO;

@Data
public class SessaoAbrirRequestDto {
    @ApiModelProperty(value = API_DOC_ID_DA_PAUTA, required = true)
    @NotNull(message = MSG_O_CAMPO_ID_PAUTA_E_OBRIGATORIO)
    private Long idPauta;
    @ApiModelProperty(value = API_DOC_TEMPO_DA_SESSAO)
    private Long tempo = 1L;
}
