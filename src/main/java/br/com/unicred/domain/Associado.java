package br.com.unicred.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(schema = "ass_assembleia", name = "ass_associado")
@NoArgsConstructor
@AllArgsConstructor
public class Associado {
    @Id
    @Column(name = "cpf", nullable = false)
    @EqualsAndHashCode.Include
    private String cpf;
    @Column(name = "nome", nullable = false)
    private String nome;
}
