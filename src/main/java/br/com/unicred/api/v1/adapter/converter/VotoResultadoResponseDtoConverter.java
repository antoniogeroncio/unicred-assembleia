package br.com.unicred.api.v1.adapter.converter;

import br.com.unicred.api.v1.dto.VotoResultadoResponseDto;
import br.com.unicred.domain.vo.VotacaoResultado;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VotoResultadoResponseDtoConverter {
    public static VotoResultadoResponseDto converter(VotacaoResultado votacaoResultado) {
        return VotoResultadoResponseDto.builder()
                .nomePauta(votacaoResultado.getNomePauta())
                .votosNao(votacaoResultado.getVotosNao())
                .votosSim(votacaoResultado.getVotosSim())
                .build();
    }
}
