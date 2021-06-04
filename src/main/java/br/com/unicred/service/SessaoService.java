package br.com.unicred.service;

import br.com.unicred.domain.Sessao;

public interface SessaoService {
    Sessao abrir(Sessao sessao, Long tempo);
}
