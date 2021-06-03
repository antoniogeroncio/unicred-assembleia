package br.com.unicred.api.v1.adapter;

import br.com.unicred.api.v1.dto.PautaCadastrarRequestDto;
import br.com.unicred.api.v1.dto.PautaCadastrarResponseDto;

public interface PautaAdapter {
    PautaCadastrarResponseDto cadastrar(PautaCadastrarRequestDto request);
}
