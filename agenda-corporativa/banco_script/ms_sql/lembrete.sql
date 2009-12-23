CREATE TABLE tb_lembrete (
  lem_id int IDENTITY(1,1) primary key NOT NULL,
  lem_titulo varchar(50),
  lem_corpo varchar(150),
  lem_ativo bit NOT NULL,
);


CREATE TABLE tb_lembretes_datas (
  lem_id int NOT NULL,
  lem_dat_data Datetime NOT NULL,

  CONSTRAINT tb_lembretes_datas_lem_fk 
	FOREIGN KEY (lem_id)
  	REFERENCES tb_lembrete (lem_id)
);