package br.com.unicred.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Builder
@Entity
@Table(schema = "ass_assembleia", name = "ass_sessao")
@NoArgsConstructor
@AllArgsConstructor
public class Sessao {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pauta_id")
    private Pauta pauta;
    @Column(name = "data_abertura", nullable = false)
    private LocalDateTime dataAbertura;
    @Column(name = "data_finalizacao", nullable = false)
    private LocalDateTime dataFinalizacao;
}
