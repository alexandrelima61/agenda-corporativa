CREATE TABLE [dbo].[tb_Contato](
	[nome] [varchar](60) NOT NULL,
	[telefone] [varchar](50) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[endereco] [varchar](100) NOT NULL,
	[con_id] [int] NOT NULL,
	[ativo] [bit] NOT NULL,
 CONSTRAINT [PK_Contato] PRIMARY KEY CLUSTERED 
(
	[con_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON