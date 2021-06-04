package br.com.unicred.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Builder
@Entity
@Table(schema = "ass_assembleia", name = "ass_sessao")
@NoArgsConstructor
@AllArgsConstructor
public class Sessao {
    @Id
    @Column(name = "pauta_id")
    private Long id;
    @Column(name = "data_abertura", nullable = false)
    private LocalDateTime dataAbertura;
    @Column(name = "data_finalizacao", nullable = false)
    private LocalDateTime dataFinalizacao;
    @OneToOne
    @JoinColumn(name = "pauta_id", insertable = false, updatable = false)
    private Pauta pauta;
}
