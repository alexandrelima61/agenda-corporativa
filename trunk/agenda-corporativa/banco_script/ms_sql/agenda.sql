CREATE TABLE [dbo].[tb_agenda](
	[age_id] [int] IDENTITY(1,1) NOT NULL,
	[age_titulo] [varchar](50) NULL,
	[age_descricao] [varchar](200) NULL,
	[age_ativado] [bit] NULL,
 CONSTRAINT [PK_tb_agenda] PRIMARY KEY CLUSTERED 
(