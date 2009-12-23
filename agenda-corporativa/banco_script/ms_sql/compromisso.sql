CREATE TABLE tb_compromisso(
	com_id int IDENTITY(1,1) primary key NOT NULL,
	usu_id int NOT NULL,
	age_id int NOT NULL,
	com_titulo varchar(50) NULL,
	com_local varchar(50) NULL,
	com_descricao varchar(200) NULL,
	com_ativo bit NOT NULL,
	
	CONSTRAINT fk_com_usu_id 
		FOREIGN KEY (usu_id)
    		REFERENCES tb_usuario(usu_id),
	CONSTRAINT fk_com_age_id 
		FOREIGN KEY (age_id)
    		REFERENCES tb_agenda(age_id)
);


CREATE TABLE tb_compromisso_data(
	com_dat_id int IDENTITY(1,1) primary key NOT NULL,
	com_id int NOT NULL,
	com_dat_datainicio Datetime NULL,
	com_dat_datafim Datetime NULL,
	com_dat_ativo bit NULL,
	
	CONSTRAINT fk_dat_com 
		FOREIGN KEY (com_id)
    		REFERENCES tb_compromisso(com_id)
);

    
CREATE TABLE tb_compromisso_participantes(
	com_par_id int IDENTITY(1,1) primary key NOT NULL,
	com_id int NOT NULL,
	usu_id int NOT NULL,
	
	CONSTRAINT tb_compromisso_participantes_com_fk 
		FOREIGN KEY (com_id)
		REFERENCES tb_compromisso (com_id),
	CONSTRAINT tb_compromisso_participantes_usu_fk 
		FOREIGN KEY (usu_id)
		REFERENCES tb_usuario (usu_id) 
);