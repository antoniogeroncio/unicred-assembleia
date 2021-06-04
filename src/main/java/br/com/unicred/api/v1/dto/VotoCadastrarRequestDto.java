package br.com.unicred.api.v1.dto;

import br.com.unicred.config.Constantes;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static br.com.unicred.config.Constantes.ApiDoc.*;
import static br.com.unicred.config.Constantes.Mensagens.*;

@Data
public class VotoCadastrarRequestDto {
    @ApiModelProperty(value = API_DOC_CPF_ASSOC_DA_PAUTA, required = true)
    @NotBlank(message = MSG_O_CAMPO_CPF_ASSOC_E_OBRIGATORIO)
    private String cpfAssociado;
    @ApiModelProperty(value = API_DOC_ID_DA_PAUTA, required = true)
    @NotNull(message = MSG_O_CAMPO_ID_PAUTA_E_OBRIGATORIO)
    private Long idPauta;
    @ApiModelProperty(value = API_DOC_VOTO_ASSOC_DA_PAUTA, required = true)
    @NotNull(message = MSG_O_CAMPO_VOTO_ASSOC_E_OBRIGATORIO)
    private boolean voto;
}
