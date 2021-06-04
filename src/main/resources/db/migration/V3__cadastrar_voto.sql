CREATE TABLE ass_assembleia.ass_associado (
	cpf varchar(11) NOT NULL,
	nome varchar(100) NOT NULL,
	CONSTRAINT ass_associado_pk PRIMARY KEY (cpf)
);
CREATE INDEX ass_associado_cpf_idx ON ass_assembleia.ass_associado USING btree (cpf);

INSERT INTO ass_assembleia.ass_associado(cpf, nome)
VALUES('08085977443', 'Antonio Geroncio dos Santos Filho');

INSERT INTO ass_assembleia.ass_associado(cpf, nome)
VALUES('08085977442', 'Associado com cpf invalido');

CREATE TABLE ass_assembleia.ass_voto (
	associado_cpf varchar(11) NOT NULL,
	sessao_pauta_id int8 NOT NULL,
    voto bool NOT NULL,
    data timestamp(0) NOT NULL,
	CONSTRAINT ass_voto_pk PRIMARY KEY (associado_cpf, sessao_pauta_id),
	CONSTRAINT ass_voto_associado_fk FOREIGN KEY (associado_cpf) REFERENCES ass_assembleia.ass_associado(cpf),
	CONSTRAINT ass_voto_sessao_fk FOREIGN KEY (sessao_pauta_id) REFERENCES ass_assembleia.ass_sessao(pauta_id)
);