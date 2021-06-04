package br.com.unicred.repository;

import br.com.unicred.domain.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessaoRepository extends JpaRepository<Sessao, Long> {
    Boolean existsByPautaId(Long idPauta);
}
