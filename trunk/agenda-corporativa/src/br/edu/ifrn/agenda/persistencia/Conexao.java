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

	private static Conexao singleton = new Conexao();
	
	private Connection connection;
	private DataSource source;
	private String driver = "org.postgresql.Driver";
	private String url = "jdbc:postgresql://localhost:5432/agenda";
	private String usuario = "postgres";
	private String senha = "postgres";
	
	public static Conexao getInstance() {
		return Conexao.singleton;
	}
	
	private Conexao() {
		super();
		init();
	}
	
	public void initEnvironment(String driver, String url, String usuario, String senha) {
		this.driver = driver;
		this.url = url;
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public void initDriver() {
		try {
			Class.forName(this.driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void init() {
		try {
			Context contextInitial = new InitialContext();
			Context context = (Context)contextInitial.lookup("java:comp/env");
			source = (DataSource)context.lookup("jdbc/agendaDataSource");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet executeQueryStatement(String comando) {
		openConnection();
		try {
			Statement statement = connection.createStatement();
			return statement.executeQuery(comando);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int executeUpdateStatement(String comando) {
		openConnection();
		try {
			Statement statement = connection.createStatement();
			return statement.executeUpdate(comando);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public PreparedStatement getPreparedStatement(String comando) {
		openConnection();
		try {
			return connection.prepareStatement(comando);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void openConnection() {
		try {
			if (source != null) {
				this.connection = source.getConnection();
			} else {
				this.connection = DriverManager.getConnection(this.url, this.usuario, this.senha);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Conexao conexao = new Conexao();
		
		try {
			ResultSet result = conexao.getPreparedStatement("SELECT * FROM usuario;").executeQuery();
			while (result.next()) 
				System.out.println("Email: " + result.getString("email"));
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}