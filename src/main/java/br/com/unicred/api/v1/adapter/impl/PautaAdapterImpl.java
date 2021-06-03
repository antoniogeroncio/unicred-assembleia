package br.com.unicred.api.v1.adapter.impl;

import br.com.unicred.api.v1.adapter.PautaAdapter;
import br.com.unicred.api.v1.adapter.converter.PautaCadastrarResponseDtoConverter;
import br.com.unicred.api.v1.adapter.converter.PautaConverter;
import br.com.unicred.api.v1.dto.PautaCadastrarRequestDto;
import br.com.unicred.api.v1.dto.PautaCadastrarResponseDto;
import br.com.unicred.domain.Pauta;
import br.com.unicred.service.PautaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PautaAdapterImpl implements PautaAdapter {

    private final PautaService service;

    @Override
    public PautaCadastrarResponseDto cadastrar(PautaCadastrarRequestDto request) {
        Pauta pauta = service.cadastrar(PautaConverter.converter(request));
        return PautaCadastrarResponseDtoConverter.converter(pauta);
    }
}
