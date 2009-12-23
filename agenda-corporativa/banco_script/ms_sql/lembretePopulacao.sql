//Se o Script de Criação de minora der errado tenta esse aqui de baixo (leves alterações) 
//incluindo também população

/*CREATE TABLE tb_agenda(
	age_id int IDENTITY(1,1) PRIMARY KEY NOT NULL,
	age_titulo varchar(50) NULL,
	age_descricao varchar(200) NULL,
	age_ativo bit NULL
);


CREATE TABLE tb_agenda_usuario (
	age_usu_id int IDENTITY(1,1) PRIMARY KEY NOT NULL,
	age_id int NOT NULL,
	usu_id int NOT NULL,

	CONSTRAINT FK_tb_adenda_usuario_age
		FOREIGN KEY (age_id)
		REFERENCES tb_agenda (age_id),
	CONSTRAINT FK_tb_agenda_usuario_usu
		FOREIGN KEY (usu_id)
		REFERENCES tb_agenda_usuario (age_usu_id)
);


INSERT INTO tb_agenda (age_titulo, age_descricao, age_ativo)
	VALUES ('DIETINF', 'Diretoria de Educacao e Tecnologia da Informacao', 1);
INSERT INTO tb_agenda (age_titulo, age_descricao, age_ativo)
	VALUES ('Festas', 'Agenda de festas', 1);
INSERT INTO tb_agenda (age_titulo, age_descricao, age_ativo)
	VALUES ('Compromissos', 'Agenda de compromissos', 1);
	
	*/

INSERT INTO tb_lembrete (age_id,lem_titulo,lem_corpo,lem_ativo) VALUES (1,'Medicamento','Tomar Medicamente Previsto',1)

INSERT INTO tb_lembretes_datas(lem_id,lem_dat_data) VALUES (1,'2009-12-24 06:00:00')
INSERT INTO tb_lembretes_datas(lem_id,lem_dat_data) VALUES (1,'2009-12-24 12:00:00')
INSERT INTO tb_lembretes_datas(lem_id,lem_dat_data) VALUES (1,'2009-12-24 18:00:00')


INSERT INTO tb_lembrete (age_id,lem_titulo,lem_corpo,lem_ativo) VALUES (1,'Aviso','Avisar superior sobre recado da esposa',1)


INSERT INTO tb_lembretes_datas(lem_id,lem_dat_data) VALUES (2,'2009-12-24 14:00:00')


INSERT INTO tb_lembrete (age_id,lem_titulo,lem_corpo,lem_ativo) VALUES (1,'Natal','Lembrar do nascimento do menino Jesus',1)

INSERT INTO tb_lembretes_datas(lem_id,lem_dat_data) VALUES (3,'2009-12-25 00:00:00')

/*Sem imaginação para popular mais , bastava os dois primeiros para verificar todas as possibilidades*/