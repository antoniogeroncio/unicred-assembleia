package br.com.unicred.api.v1.adapter.converter;

import br.com.unicred.api.v1.dto.VotoCadastrarResponseDto;
import br.com.unicred.domain.Voto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VotoCadastrarResponseDtoConverter {
    public static VotoCadastrarResponseDto converter(Voto voto) {
        return VotoCadastrarResponseDto.builder()
                .data(voto.getData())
                .build();
    }
}
