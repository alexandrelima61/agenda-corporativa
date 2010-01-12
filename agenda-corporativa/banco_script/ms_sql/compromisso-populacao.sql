Insert into tb_compromisso (usu_id, age_id, com_titulo, com_local, com_descricao, com_ativo) values(1, 2, 'Reuni�o DATINF', 'IFRN', 'Calend�rio 2010', 'true');
Insert into tb_compromisso (usu_id, age_id, com_titulo, com_local, com_descricao, com_ativo) values(3, 1, 'Festa Fim de Ano', 'Hotel', 'Reveillon', 'true');
Insert into tb_compromisso (usu_id, age_id, com_titulo, com_local, com_descricao, com_ativo) values(4, 1, 'Reuni�o escolar', 'CEI', 'Reajustes de mensalidade', 'true');
Insert into tb_compromisso (usu_id, age_id, com_titulo, com_local, com_descricao, com_ativo) values(1, 2, 'Provas finais', 'Lab 10', 'Marcar data', 'true');

Insert into tb_compromisso_data (com_id, com_dat_datainicio, com_dat_datafim, com_dat_ativo) values(1, '2010-01-01 08:00:00.000', '2010-01-01 12:00:00.000', 'true');
Insert into tb_compromisso_data (com_id, com_dat_datainicio, com_dat_datafim, com_dat_ativo) values(1, '2010-01-01 08:00:00.000', '2010-01-01 12:00:00.000', 'true');
Insert into tb_compromisso_data (com_id, com_dat_datainicio, com_dat_datafim, com_dat_ativo) values(2, '2010-01-31 22:00:00.000', '2010-01-31 23:00:00.000', 'true');
Insert into tb_compromisso_data (com_id, com_dat_datainicio, com_dat_datafim, com_dat_ativo) values(3, '2010-01-20 14:00:00.000', '2010-01-20 16:00:00.000', 'true');
Insert into tb_compromisso_data (com_id, com_dat_datainicio, com_dat_datafim, com_dat_ativo) values(4, '2010-01-01 14:00:00.000', '2010-01-01 16:00:00.000', 'true');

Insert into tb_compromisso_participantes (com_id, usu_id) values(1, 2);
Insert into tb_compromisso_participantes (com_id, usu_id) values(1, 3);
Insert into tb_compromisso_participantes (com_id, usu_id) values(1, 4);
Insert into tb_compromisso_participantes (com_id, usu_id) values(2, 4);
Insert into tb_compromisso_participantes (com_id, usu_id) values(2, 3);
