package br.com.unicred.service.impl;

import br.com.unicred.api.v1.controller.errors.exception.ValidacaoException;
import br.com.unicred.domain.Sessao;
import br.com.unicred.repository.PautaRepository;
import br.com.unicred.repository.SessaoRepository;
import br.com.unicred.service.SessaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static br.com.unicred.config.Constantes.Mensagens.MSG_A_PAUTA_JA_POSSUI_SESSAO;
import static br.com.unicred.config.Constantes.Mensagens.MSG_A_PAUTA_NAO_EXISTE;
import static java.time.LocalDateTime.now;
import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class SessaoServiceImpl implements SessaoService {

    private final SessaoRepository sessaoRepository;
    private final PautaRepository pautaRepository;

    @Value("${sessao.tempo-padrao}")
    private Long tempoPadrao;

    @Override
    public Sessao abrir(Sessao sessao, Long tempo) {
        validarSePautaJaPossuiSessao(sessao.getId());
        validarSePautaExiste(sessao.getId());
        configurarTempoSessao(sessao, tempo);
        return sessaoRepository.save(sessao);
    }

    private void validarSePautaExiste(Long idPauta) {
        Boolean naoExistePauta = !pautaRepository.existsById(idPauta);
        if(naoExistePauta)
            throw new ValidacaoException(MSG_A_PAUTA_NAO_EXISTE);
    }

    private void validarSePautaJaPossuiSessao(Long idPauta) {
        Boolean existeSessao = sessaoRepository.existsById(idPauta);
        if(existeSessao)
            throw new ValidacaoException(MSG_A_PAUTA_JA_POSSUI_SESSAO);
    }

    private void configurarTempoSessao(Sessao sessao, Long tempo) {
        sessao.setDataFinalizacao(now().plusMinutes(ofNullable(tempo).orElse(tempoPadrao)));
    }
}
