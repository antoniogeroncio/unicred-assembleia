package br.com.unicred.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Builder
@EqualsAndHashCode
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class VotoId implements Serializable {
    @Column(name="associado_cpf", nullable=false)
    private String cpfAssociado;
    @Column(name = "sessao_pauta_id", nullable=false)
    private Long idPauta;
}
