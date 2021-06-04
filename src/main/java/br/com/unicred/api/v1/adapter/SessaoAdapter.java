package br.com.unicred.api.v1.adapter;

import br.com.unicred.api.v1.dto.SessaoAbrirRequestDto;
import br.com.unicred.api.v1.dto.SessaoAbrirResponseDto;

public interface SessaoAdapter {
    SessaoAbrirResponseDto abrir(SessaoAbrirRequestDto request);
}
