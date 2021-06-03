package br.com.unicred.api.v1.adapter.converter;

import br.com.unicred.api.v1.dto.PautaCadastrarRequestDto;
import br.com.unicred.domain.Pauta;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PautaConverter {
    public static Pauta converter(PautaCadastrarRequestDto request) {
        return Pauta.builder()
                .nome(request.getNome())
                .descricao(request.getDescricao())
                .build();
    }
}
