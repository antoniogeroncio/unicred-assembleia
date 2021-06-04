package br.com.unicred.api.v1.adapter.impl;

import br.com.unicred.api.v1.adapter.VotoAdapter;
import br.com.unicred.api.v1.adapter.converter.VotoCadastrarResponseDtoConverter;
import br.com.unicred.api.v1.adapter.converter.VotoConverter;
import br.com.unicred.api.v1.adapter.converter.VotoResultadoResponseDtoConverter;
import br.com.unicred.api.v1.dto.VotoCadastrarRequestDto;
import br.com.unicred.api.v1.dto.VotoCadastrarResponseDto;
import br.com.unicred.api.v1.dto.VotoResultadoResponseDto;
import br.com.unicred.domain.Voto;
import br.com.unicred.domain.vo.VotacaoResultado;
import br.com.unicred.service.VotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VotoAdapterImpl implements VotoAdapter {

    private final VotoService service;

    @Override
    public VotoCadastrarResponseDto cadastrar(VotoCadastrarRequestDto request) {
        Voto voto = service.cadastrar(VotoConverter.converter(request));
        return VotoCadastrarResponseDtoConverter.converter(voto);
    }

    @Override
    public VotoResultadoResponseDto obterResultado(Long idPauta) {
        VotacaoResultado votacaoResultado = service.obterResultado(idPauta);
        return VotoResultadoResponseDtoConverter.converter(votacaoResultado);
    }
}
