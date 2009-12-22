CREATE TABLE tb_agenda (
  age_id serial NOT NULL,
  age_titulo character varying(50),
  age_descricao character varying(200),
  age_ativado boolean NOT NULL,

  CONSTRAINT tb_agenda_pk PRIMARY KEY (age_id)
) 