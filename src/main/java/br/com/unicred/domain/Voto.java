package br.com.unicred.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import static java.util.Optional.ofNullable;

@Data
@Builder
@EqualsAndHashCode
@Entity
@Table(schema = "ass_assembleia", name = "ass_voto")
@NoArgsConstructor
@AllArgsConstructor
public class Voto {
    @EmbeddedId
    private VotoId id;
    @Column(name = "voto", nullable = false)
    private boolean voto;
    @Column(name = "data", nullable = false)
    private LocalDateTime data;
    @ManyToOne
    @JoinColumn(name = "associado_cpf", insertable = false, updatable = false)
    private Associado associado;
    @ManyToOne
    @JoinColumn(name = "sessao_pauta_id", insertable = false, updatable = false)
    private Sessao sessao;
}
