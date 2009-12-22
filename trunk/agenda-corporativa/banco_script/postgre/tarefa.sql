CREATE TABLE tb_tarefa (
  tar_id serial NOT NULL,
  age_id serial NOT NULL,
  tar_titulo character varying(70),
  tar_data timestamp,
  tar_local character varying(40),
  tar_prioridade integer,
  tar_descricao character varying(250),
  tar_estado integer,
  tar_ativado boolean NOT NULL,
  
  CONSTRAINT tb_tarefa_pk PRIMARY KEY (tar_id),
  FOREIGN KEY(age_id) REFERENCES tb_agenda(age_id)
);