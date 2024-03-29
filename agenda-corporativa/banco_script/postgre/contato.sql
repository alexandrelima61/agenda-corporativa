CREATE TABLE tb_contato (
	con_id serial not null,
	con_nome character varying(60),
	con_telefone character varying(50),
	con_email character varying(50),
	con_endereco character varying(100),
	con_ativo boolean NOT NULL,

	CONSTRAINT tb_contato_pk 
		PRIMARY KEY (con_id)
);

CREATE TABLE tb_agenda_contato (
	age_con_id serial not null,
	con_id integer not null,
	age_id integer not null,

	CONSTRAINT tb_agenda_contato_pk 
		PRIMARY KEY (age_con_id),
	CONSTRAINT tb_agenda_contato_age_fk 
		FOREIGN KEY (age_id)
		REFERENCES tb_agenda (age_id)
		MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT tb_agenda_contato_con_fk 
		FOREIGN KEY (con_id)
		REFERENCES tb_contato (con_id)
		MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
);