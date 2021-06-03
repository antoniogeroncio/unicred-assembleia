package br.com.unicred.repository;

import br.com.unicred.domain.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PautaRepository extends JpaRepository<Pauta, Long> {
}
