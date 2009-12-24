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
	
	PreparedStatement statementInserir = Conexao.getInstance().getPreparedStatement("INSERT INTO tb_contato(con_nome,con_endereco,con_id) VALUES (?,?,?)");
	PreparedStatement statementAtualizar = Conexao.getInstance().getPreparedStatement("UPDATE tb_contato set (con_nome=?,con_endereco=?) WHERE con_id=?");
	//PreparedStatement statementRecuperar = Conexao.getInstance().getPreparedStatement("SELECT con_nome,con_telefone,con_email,con_endereco FROM tb_contato WHERE con_id=?");
	PreparedStatement statementRecuperarTodos = Conexao.getInstance().getPreparedStatement("SELECT con_nome,con_telefone,con_email,con_endereco,con_id FROM tb_contato");
	PreparedStatement statementInserirTelefone = Conexao.getInstance().getPreparedStatement("INSERT INTO tb_telefone(con_oid,con_telefone) VALUES(?,?)");
	PreparedStatement statementInserirEmail = Conexao.getInstance().getPreparedStatement("INSERT INTO tb_email(con_oid,con_email) VALUES(?,?)");
	PreparedStatement statementAtualizarTelefone = Conexao.getInstance().getPreparedStatement("UPDATE tb_contato set (con_telefone=?) WHERE con_id=?");
	PreparedStatement statementAtualizarEmail = Conexao.getInstance().getPreparedStatement("UPDATE tb_contato set (con_email=?) WHERE con_id=?");
	PreparedStatement statementRecuperarTelefones = Conexao.getInstance().getPreparedStatement("SELECT con_telefone FROM tb_telefone WHERE con_id=?");
	PreparedStatement statementRecuperarEmails = Conexao.getInstance().getPreparedStatement("SELECT con_email FROM tb_email WHERE con_id=?");
	PreparedStatement statementOid = Conexao.getInstance().getPreparedStatement("SELECT con_id FROM tb_contato WHERE con_id = MAX(con_id)");
	
	
	public void atualizarContato(Contato contato){
			
		if(contato.getOid()== 0){
			try{					
				this.statementInserir.setString(1,contato.getNome());
				inserirTelefone(contato);
				inserirEmail(contato);
				this.statementInserir.setString(2,contato.getEndereco());
				this.statementInserir.setInt(3,novoOid());
				this.statementInserir.execute();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		else{
			try{	
				this.statementAtualizar.setString(1,contato.getNome());		
				this.statementAtualizar.setString(2,contato.getEndereco());
				this.statementAtualizar.setInt(3,contato.getOid());
				this.statementAtualizar.execute();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	/*public Contato listarContato(Contato contato){
		try{
			this.statementRecuperar.setInt(1,contato.getOid());
			ResultSet rs = statementRecuperar.executeQuery();
			
			while(rs.next()){
				contato.setNome(rs.getString("con_nome"));
				contato.setTelefone(recuperarTelefonesContato());
				contato.setEmail(recuperarEmailsContato());	
				contato.setEndereco(rs.getString("endereco"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return contato;
	}*/
	
	public List<Contato> listarTodos(){
		
		List<Contato> contatos = new ArrayList<Contato>();
		
		try{
			ResultSet rs = statementRecuperarTodos.executeQuery();
			int id;
			while(rs.next()){
				id = rs.getInt("con_id");
				Contato contato = new Contato();
				contato.setNome(rs.getString("nome"));
				contato.setTelefone(recuperarTelefonesContato(id));
				contato.setEmail(recuperarEmailsContato(id));
				contato.setEndereco(rs.getString("endereco"));
				contatos.add(contato);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return contatos;
	}
	
	public void inserirTelefone(Contato contato){
		try {
			
			ResultSet rs = statementInserirTelefone.executeQuery();
			String telefone;
			
			for(int i=0;i<contato.getTelefone().size();i++){
				statementInserirTelefone.setInt(1, contato.getOid());
				telefone = contato.getTelefone().get(i);
				statementInserirTelefone.setString(2,telefone);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void inserirEmail(Contato contato){
		try {
			
			ResultSet rs = statementInserirEmail.executeQuery();
			String email;
			
			for(int i=0;i<contato.getEmail().size();i++){
				statementInserirEmail.setInt(1, contato.getOid());
				email = contato.getEmail().get(i);
				statementInserirEmail.setString(2,email);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizarTelefone(Contato contato){
		
	}
	
	public void atualizarEmail(){
		
	}
	
	public List<String> recuperarTelefonesContato(int id){
		List<String> telefones = null;
		
		try {
			statementRecuperarTelefones.setInt(1,id);
			ResultSet rs = statementRecuperarTelefones.executeQuery();
			while(rs.next()){
				telefones.add(rs.getString("con_telefone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return telefones;
	}
	
	public List<String> recuperarEmailsContato(int id){
		List<String> emails = null;
		try {
			statementRecuperarEmails.setInt(1,id);
			ResultSet rs = statementRecuperarEmails.executeQuery();
			while(rs.next()){
				emails.add(rs.getString("con_telefone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emails;
	}
	
	public int novoOid(){
		
		int id=0;
		
		try {
			ResultSet rs = statementOid.executeQuery();
			id = rs.getInt("con_id");
			id++;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
}