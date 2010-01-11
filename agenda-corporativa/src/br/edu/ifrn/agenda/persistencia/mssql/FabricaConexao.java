package br.edu.ifrn.agenda.persistencia.mssql;

import br.edu.ifrn.agenda.persistencia.Conexao;

public class FabricaConexao {

	private final static String driver = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
	private final static String url = "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=agenda";

	public static Conexao construir() {
		return construir("sa", "senha");
	}
		
	public static Conexao construir(String login, String senha) {
		Conexao conexao = Conexao.getInstance();//Conexao.createInstance();
		conexao.initEnvironment(driver, url, login, senha);
		return conexao;
	}

}
