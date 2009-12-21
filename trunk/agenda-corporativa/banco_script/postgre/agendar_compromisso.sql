CREATE TABLE tb_compromisso (
    com_id serial NOT NULL,
    com_titulo character varying(50),
    com_local character varying(50),
    com_descricao character varying(200),
    com_ativo boolean,
    usu_id integer,
    age_id integer,
    CONSTRAINT pk_com_id PRIMARY KEY (com_id)
    CONSTRAINT fk FOREING KEY (age_id)
        REFERENCES tb_agenda (age_id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE tb_compromisso_data (
    dat_id serial NOT NULL,
    com_id integer,
    dat_datainicio date,
    dat_datafim date,
    dat_ativo boolean,

    CONSTRAINT pk_com_id PRIMARY KEY (com_id)
    CONSTRAINT fk_dat_com_id FOREING KEY (com_id)
        REFERENCES tb_compromisso (com_id) MATCH SIMPLE

        ON UPDATE NO ACTION ON DELETE NO ACTION
);