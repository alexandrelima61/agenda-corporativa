package br.edu.ifrn.agenda.persistencia.postgres;

import br.edu.ifrn.agenda.persistencia.Conexao;

public abstract class FabricaConexao {

	private final static String driver = "org.postgresql.Driver";
	private final static String url = "jdbc:postgresql://localhost:5432/agenda";

	public static Conexao construir() {
		return construir("postgres", "postgres");
	}
		
	public static Conexao construir(String login, String senha) {
		Conexao conexao = Conexao.getInstance();
		conexao.initEnvironment(driver, url, login, senha);
		return conexao;
	}
	
}
