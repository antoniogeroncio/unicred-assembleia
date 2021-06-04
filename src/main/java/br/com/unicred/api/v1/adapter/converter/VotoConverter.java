package br.com.unicred.api.v1.adapter.converter;

import br.com.unicred.api.v1.dto.VotoCadastrarRequestDto;
import br.com.unicred.domain.Voto;
import br.com.unicred.domain.VotoId;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static java.time.LocalDateTime.now;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VotoConverter {
    public static Voto converter(VotoCadastrarRequestDto request) {
        return Voto.builder()
                .id(VotoId.builder()
                        .cpfAssociado(request.getCpfAssociado())
                        .idPauta(request.getIdPauta())
                        .build())
                .voto(request.isVoto())
                .data(now())
                .build();
    }
}
