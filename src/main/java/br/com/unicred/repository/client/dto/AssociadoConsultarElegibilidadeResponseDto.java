package br.com.unicred.repository.client.dto;

import br.com.unicred.repository.client.dto.tipo.StatusElegibidadeTipo;
import lombok.Data;

@Data
public class AssociadoConsultarElegibilidadeResponseDto {
    private StatusElegibidadeTipo status;
}
