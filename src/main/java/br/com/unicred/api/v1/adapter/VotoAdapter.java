package br.com.unicred.api.v1.adapter;

import br.com.unicred.api.v1.dto.VotoCadastrarRequestDto;
import br.com.unicred.api.v1.dto.VotoCadastrarResponseDto;
import br.com.unicred.api.v1.dto.VotoResultadoResponseDto;

public interface VotoAdapter {
    VotoCadastrarResponseDto cadastrar(VotoCadastrarRequestDto request);
    VotoResultadoResponseDto obterResultado(Long idPauta);
}
