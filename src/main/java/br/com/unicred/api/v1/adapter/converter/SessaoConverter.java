package br.com.unicred.api.v1.adapter.converter;

import br.com.unicred.api.v1.dto.SessaoAbrirRequestDto;
import br.com.unicred.domain.Pauta;
import br.com.unicred.domain.Sessao;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static java.time.LocalDateTime.now;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SessaoConverter {
    public static Sessao converter(SessaoAbrirRequestDto request) {
        return Sessao.builder()
                .id(request.getIdPauta())
                .dataAbertura(now())
                .build();
    }
}
