package br.com.unicred.repository;

import br.com.unicred.domain.Voto;
import br.com.unicred.domain.VotoId;
import br.com.unicred.domain.vo.VotacaoResultado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import static br.com.unicred.config.Constantes.Querys.QUERY_OBTER_RESULTADO_POR_ID_PAUTA;

@Repository
public interface VotoRepository extends JpaRepository<Voto, VotoId> {
    @Query(QUERY_OBTER_RESULTADO_POR_ID_PAUTA)
    VotacaoResultado getVotacaoResultado(Long idPauta);
}
