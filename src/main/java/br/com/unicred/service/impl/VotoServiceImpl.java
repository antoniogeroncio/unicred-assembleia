package br.com.unicred.service.impl;

import br.com.unicred.api.v1.controller.errors.exception.ValidacaoException;
import br.com.unicred.domain.*;
import br.com.unicred.domain.vo.VotacaoResultado;
import br.com.unicred.repository.client.AssociadoClient;
import br.com.unicred.repository.client.dto.AssociadoConsultarElegibilidadeResponseDto;
import br.com.unicred.repository.client.dto.tipo.StatusElegibidadeTipo;
import br.com.unicred.repository.jpa.AssociadoRepository;
import br.com.unicred.repository.jpa.PautaRepository;
import br.com.unicred.repository.jpa.VotoRepository;
import br.com.unicred.service.VotoService;
import feign.FeignException.NotFound;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static br.com.unicred.config.Constantes.Mensagens.*;
import static java.time.LocalDateTime.now;

@Slf4j
@Service
@RequiredArgsConstructor
public class VotoServiceImpl implements VotoService {

    private final VotoRepository votoRepository;
    private final PautaRepository pautaRepository;
    private final AssociadoRepository associadoRepository;
    private final AssociadoClient associadoClient;

    @Override
    public VotacaoResultado obterResultado(Long idPauta) {
        Optional<Pauta> pauta = pautaRepository.findById(idPauta);
        validarSePautaExiste(pauta);
        return votoRepository.getVotacaoResultado(idPauta);
    }

    @Override
    public Voto cadastrar(Voto voto) {
        Optional<Pauta> pauta = pautaRepository.findById(voto.getId().getIdPauta());
        validarSePautaExiste(pauta);
        validarSeSessaoExiste(pauta.get().getSessao());
        validarSeAssociadoExiste(voto.getId().getCpfAssociado());
        validarElegibidadeAssociado(voto.getId().getCpfAssociado());
        validarSeSessaoDaPautaEstaAberta(pauta.get().getSessao());
        validarSeAssociadoJaVotouNaPauta(voto.getId());
        return votoRepository.save(voto);
    }

    private void validarElegibidadeAssociado(String cpfAssociado) {
        AssociadoConsultarElegibilidadeResponseDto elegibilidade = consultarElegibilidadeAssociado(cpfAssociado);
        if(isAssociadoNaoElegivel(elegibilidade))
            throw new ValidacaoException(MSG_O_ASSOCIADO_NAO_ELEGIVEL);
    }

    private AssociadoConsultarElegibilidadeResponseDto consultarElegibilidadeAssociado(String cpfAssociado) {
        AssociadoConsultarElegibilidadeResponseDto elegibilidade = null;
        try {
            elegibilidade = associadoClient.consultarElegibilidade(cpfAssociado);
        } catch (NotFound ex){
            log.error(ex.getMessage(), ex);
            throw new ValidacaoException(MSG_O_ASSOCIADO_CPF_INVALIDO);
        }
        return elegibilidade;
    }

    private boolean isAssociadoNaoElegivel(AssociadoConsultarElegibilidadeResponseDto elegibilidade) {
        return elegibilidade.getStatus().equals(StatusElegibidadeTipo.UNABLE_TO_VOTE);
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

    private void validarSeSessaoExiste(Sessao sessao) {
        if (sessao == null)
            throw new ValidacaoException(MSG_A_SESSAO_PAUTA_N_ABERTA_NAO_EXISTE);
    }
}
