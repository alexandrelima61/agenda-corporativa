CREATE TABLE [dbo].[tb_datas](
	[lem_id] [int] NOT NULL,
	[data] [datetime] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  ForeignKey [FK_tb_datas_tb_lembrete]    Script Date: 12/17/2009 17:23:14 ******/
ALTER TABLE [dbo].[tb_datas]  WITH CHECK ADD  CONSTRAINT [FK_tb_datas_tb_lembrete] FOREIGN KEY([lem_id])
REFERENCES [dbo].[tb_lembrete] ([lem_id])
GO
ALTER TABLE [dbo].[tb_datas] CHECK CONSTRAINT [FK_tb_datas_tb_lembrete]