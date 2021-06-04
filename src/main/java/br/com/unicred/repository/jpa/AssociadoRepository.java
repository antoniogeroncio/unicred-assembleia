package br.com.unicred.repository.jpa;

import br.com.unicred.domain.Associado;
import br.com.unicred.domain.Voto;
import br.com.unicred.domain.VotoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, String> {
}
