package br.com.unicred.api.v1.adapter.converter;

import br.com.unicred.api.v1.dto.PautaCadastrarResponseDto;
import br.com.unicred.domain.Pauta;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PautaCadastrarResponseDtoConverter {
    public static PautaCadastrarResponseDto converter(Pauta pauta) {
        return PautaCadastrarResponseDto.builder()
                .id(pauta.getId())
                .build();
    }
}
