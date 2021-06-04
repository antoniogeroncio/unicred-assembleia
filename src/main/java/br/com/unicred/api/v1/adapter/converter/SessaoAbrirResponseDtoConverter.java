package br.com.unicred.api.v1.adapter.converter;

import br.com.unicred.api.v1.dto.SessaoAbrirResponseDto;
import br.com.unicred.domain.Sessao;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SessaoAbrirResponseDtoConverter {
    public static SessaoAbrirResponseDto converter(Sessao sessao) {
        return SessaoAbrirResponseDto.builder()
                .id(sessao.getId())
                .finalizacao(sessao.getDataFinalizacao())
                .build();
    }
}
