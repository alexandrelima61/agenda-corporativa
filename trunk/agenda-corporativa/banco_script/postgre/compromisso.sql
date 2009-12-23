CREATE TABLE tb_compromisso (
    com_id serial NOT NULL,
    usu_id integer,
    age_id integer,
    com_titulo character varying(50),
    com_local character varying(50),
    com_descricao character varying(200),
    com_ativo boolean NOT NULL,
    
    CONSTRAINT tb_compromisso_pk 
	PRIMARY KEY (com_id),
    CONSTRAINT tb_compromisso_usu_fk 
	FOREIGN KEY (usu_id)
        REFERENCES tb_usuario (usu_id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT tb_compromisso_age_fk 
	FOREIGN KEY (age_id)
        REFERENCES tb_agenda (age_id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
);


CREATE TABLE tb_compromisso_data (
    com_dat_id serial NOT NULL,
    com_id integer,
    com_dat_datainicio date,
    com_dat_datafim date,
    com_dat_ativo boolean,

    CONSTRAINT tb_compromisso_data_pk 
	PRIMARY KEY (com_dat_id),
    CONSTRAINT tb_compromisso_data_com_fk 
	FOREIGN KEY (com_id)
        REFERENCES tb_compromisso (com_id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
);


CREATE TABLE tb_compromisso_participantes(
	com_par_id serial NOT NULL,
	com_id integer NOT NULL,
	usu_id integer NOT NULL,
	
	CONSTRAINT tb_compromisso_participantes_pk 
		PRIMARY KEY (com_par_id),
	CONSTRAINT tb_compromisso_participantes_com_fk 
		FOREIGN KEY (com_id)
		REFERENCES tb_compromisso (com_id)
		MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT tb_compromisso_participantes_usu_fk 
		FOREIGN KEY (usu_id)
		REFERENCES tb_usuario (usu_id)
		MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
);