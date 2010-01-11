package br.edu.ifrn.agenda.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Conexao {

	
	
	private Connection connection;
	//private DataSource source;
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String url = "jdbc:sqlserver://localhost:1433;databaseName=agenda";
	private String usuario = "sa";
	private String senha = "senha";
	
	private static Conexao singleton = new Conexao();
	
	public static Conexao getInstance() {
		return Conexao.singleton;
	}

	private Conexao() {
		super();
		this.init(driver, url, usuario, senha );
	}
	
	public void init(String driver, String url, String usuario, String senha) {
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(url, usuario, senha);
		} catch (ClassNotFoundException e) {
			System.out.println("Classe nao encontrada!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error no SQL!");
			e.printStackTrace();
		}
	}

	
	public void initEnvironment(String driver, String url, String usuario, String senha) {
		this.driver = driver;
		this.url = url;
		this.usuario = usuario;
		this.senha = senha;
	}
	
	private void initDriver() throws ClassNotFoundException {
		Class.forName(this.driver);
	}
	
	/*private void initDatasource() throws NamingException {
		Context contextInitial = new InitialContext();
		Context context = (Context)contextInitial.lookup("java:comp/env");
		source = (DataSource)context.lookup("jdbc/agendaDataSource");
	}*/
	
	/*public void init() {
		try {
			initDatasource();
		} catch (NamingException excNaming) {
			try {
				initDriver();
			} catch (ClassNotFoundException exClassNotFound) {
				// FIXME deve lancar uma excecao da aplicacao
				exClassNotFound.printStackTrace();
			}
		}
	}*/
	
	public ResultSet executeQueryStatement(String comando) {
		//openConnection();
		try {
			Statement statement = connection.createStatement();
			return statement.executeQuery(comando);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int executeUpdateStatement(String comando) {
		//openConnection();
		try {
			Statement statement = connection.createStatement();
			return statement.executeUpdate(comando);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public PreparedStatement getPreparedStatement(String comando) {
		//openConnection();
		try {
			return connection.prepareStatement(comando);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*private void openConnection() {
		try {
			if (source != null) {
				this.connection = source.getConnection();
			} else {
				this.connection = DriverManager.getConnection(this.url, this.usuario, this.senha);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
	
	/*public static void main(String[] args) {
		Conexao conexao = new Conexao();
		
		try {
			ResultSet result = conexao.getPreparedStatement("SELECT * FROM usuario;").executeQuery();
			while (result.next()) 
				System.out.println("Email: " + result.getString("email"));
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}*/
}
