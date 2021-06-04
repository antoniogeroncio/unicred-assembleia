package br.com.unicred.api.v1.adapter.impl;

import br.com.unicred.api.v1.adapter.SessaoAdapter;
import br.com.unicred.api.v1.adapter.converter.SessaoAbrirResponseDtoConverter;
import br.com.unicred.api.v1.adapter.converter.SessaoConverter;
import br.com.unicred.api.v1.dto.SessaoAbrirRequestDto;
import br.com.unicred.api.v1.dto.SessaoAbrirResponseDto;
import br.com.unicred.domain.Sessao;
import br.com.unicred.service.SessaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SessaoAdapterImpl implements SessaoAdapter {

    private final SessaoService service;

    @Override
    public SessaoAbrirResponseDto abrir(SessaoAbrirRequestDto request) {
        Sessao sessao = service.abrir(SessaoConverter.converter(request), request.getTempo());
        return SessaoAbrirResponseDtoConverter.converter(sessao);
    }
}
