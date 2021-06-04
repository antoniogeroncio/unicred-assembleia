package br.com.unicred.service.impl;

import br.com.unicred.api.v1.controller.errors.exception.ValidacaoException;
import br.com.unicred.domain.*;
import br.com.unicred.domain.vo.VotacaoResultado;
import br.com.unicred.repository.AssociadoRepository;
import br.com.unicred.repository.PautaRepository;
import br.com.unicred.repository.VotoRepository;
import br.com.unicred.service.VotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static br.com.unicred.config.Constantes.Mensagens.*;
import static java.time.LocalDateTime.now;

@Service
@RequiredArgsConstructor
public class VotoServiceImpl implements VotoService {

    private final VotoRepository votoRepository;
    private final PautaRepository pautaRepository;
    private final AssociadoRepository associadoRepository;

    @Override
    public Voto cadastrar(Voto voto) {
        Optional<Pauta> pauta = pautaRepository.findById(voto.getId().getIdPauta());
        validarSePautaExiste(pauta);
        validarSeAssociadoExiste(voto.getId().getCpfAssociado());
        validarSeSessaoDaPautaEstaAberta(pauta.get().getSessao());
        validarSeAssociadoJaVotouNaPauta(voto.getId());
        return votoRepository.save(voto);
    }

    @Override
    public VotacaoResultado obterResultado(Long idPauta) {
        return votoRepository.getVotacaoResultado(idPauta);
    }

    private void validarSeAssociadoJaVotouNaPauta(VotoId id) {
        Boolean existeVoto = votoRepository.existsById(id);
        if(existeVoto)
            throw new ValidacaoException(MSG_O_ASSOCIADO_JA_VOTO_PAUTA);
    }

    private void validarSeSessaoDaPautaEstaAberta(Sessao sessao) {
        if(sessao.getDataFinalizacao().isBefore(now()))
            throw new ValidacaoException(MSG_A_SESSAO_JA_FOI_FINALIZADA);
    }

    private void validarSeAssociadoExiste(String cpfAssociado) {
        Optional<Associado> associado = associadoRepository.findById(cpfAssociado);
        if (!associado.isPresent())
            throw new ValidacaoException(MSG_O_ASSOCIADO_NAO_EXISTE);
    }

    private void validarSePautaExiste(Optional<Pauta> pauta) {
        if (!pauta.isPresent())
            throw new ValidacaoException(MSG_A_PAUTA_NAO_EXISTE);
    }
}
