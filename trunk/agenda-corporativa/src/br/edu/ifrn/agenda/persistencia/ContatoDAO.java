package br.edu.ifrn.agenda.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.edu.ifrn.agenda.beans.Contato;

public class ContatoDAO{
	public static ContatoDAO instance = new ContatoDAO();
	
	public static ContatoDAO getInstance(){
		return ContatoDAO.instance;
	}
	
	PreparedStatement statementInserir = Conexao.getInstance().getPreparedStatement("INSERT INTO contato(nome,telefone,email,endereco) VALUES (?,?,?,?)");
	PreparedStatement statementAtualizar = Conexao.getInstance().getPreparedStatement("UPDATE contato set (nome=?,telefone=?,email=?,endereco=?) WHERE con_id=?");
	PreparedStatement statementRecuperar = Conexao.getInstance().getPreparedStatement("SELECT nome,telefone,email,endereco FROM contato WHERE nome=?");
	PreparedStatement statementRecuperarTodos = Conexao.getInstance().getPreparedStatement("SELECT nome,telefone,email,endereco FROM contato");
	
	/*public void InserirContato(Contato contato){
		try{	
			this.statementInserir.setString(1,contato.getNome());
			this.statementInserir.setString(2,contato.getTelefone());
			this.statementInserir.setString(3,contato.getEmail());
			this.statementInserir.setString(4,contato.getEndereco());
			this.statementInserir.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}*/
	
	public void atualizarContato(Contato contato){
		if(contato.getOid()== 0){
			try{	
				this.statementInserir.setString(1,contato.getNome());
				this.statementInserir.setString(2,contato.getTelefone());
				this.statementInserir.setString(3,contato.getEmail());
				this.statementInserir.setString(4,contato.getEndereco());
				this.statementInserir.execute();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		else{
			try{	
				this.statementAtualizar.setString(1,contato.getNome());
				this.statementAtualizar.setString(2,contato.getTelefone());
				this.statementAtualizar.setString(3,contato.getEmail());
				this.statementAtualizar.setString(4,contato.getEndereco());
				this.statementAtualizar.execute();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	public Contato listarContato(Contato contato){
		try{
			this.statementRecuperar.setString(1,contato.getNome());
			ResultSet rs = statementRecuperar.executeQuery();
			
			while(rs.next()){
				contato.setNome(rs.getString("nome"));
				contato.setTelefone(rs.getString("telefone"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return contato;
	}
	
	public List listarTodos(){
		
		List<Contato> contatos = new ArrayList<Contato>();
		
		try{
			ResultSet rs = statementRecuperar.executeQuery();
			
			while(rs.next()){
				Contato contato = new Contato();
				contato.setNome(rs.getString("nome"));
				contato.setTelefone(rs.getString("telefone"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				contatos.add(contato);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return contatos;
	}
}