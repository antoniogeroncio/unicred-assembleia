package br.com.unicred.service;

import br.com.unicred.domain.Voto;
import br.com.unicred.domain.vo.VotacaoResultado;

public interface VotoService {
    Voto cadastrar(Voto voto);
    VotacaoResultado obterResultado(Long idPauta);
}
