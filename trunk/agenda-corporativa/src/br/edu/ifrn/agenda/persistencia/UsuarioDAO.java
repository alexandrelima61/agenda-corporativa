package br.edu.ifrn.agenda.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifrn.agenda.beans.Usuario;

public class UsuarioDAO {

	private static UsuarioDAO singleton = new UsuarioDAO();
	
	public static UsuarioDAO getInstance() {
		return singleton;
	}
	
	public UsuarioDAO() {
		super();
	}
	
	public Usuario buscarPorID(int oid) {
		String sql = "SELECT usu_nome, usu_login, usu_ativo FROM tb_usuario WHERE (usu_id=?);";
		PreparedStatement statement = Conexao.getInstance().getPreparedStatement(sql);
		
		try {
			statement.setInt(1, oid);
			ResultSet data = statement.executeQuery();
			if ( data.next() ) {
				Usuario usuario = new Usuario();
				usuario.setOid(oid);
				usuario.setApelido( data.getString("usu_login") );
				usuario.setAtivado( data.getBoolean("usu_ativo") );
				usuario.setNome( data.getString("usu_nome") );
				
				return usuario;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public ArrayList<Usuario> buscarPorNome(String nome) {
		String sql = "SELECT usu_id, usu_nome, usu_login, usu_ativo FROM tb_usuario WHERE (usu_nome like ?);";
		PreparedStatement statement = Conexao.getInstance().getPreparedStatement(sql);
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			statement.setString(1, nome+"%");
			ResultSet data = statement.executeQuery();
			while ( data.next() ) {
				Usuario usuario = new Usuario();
				usuario.setOid(data.getInt("usu_id"));
				usuario.setApelido( data.getString("usu_login") );
				usuario.setAtivado( data.getBoolean("usu_ativo") );
				usuario.setNome( data.getString("usu_nome") );
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
	
	
	public List<Usuario> buscarTodos() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "SELECT usu_oid, usu_nome, usu_login FROM tb_usuario WHERE (usu_ativo = ?);";
		PreparedStatement statement = Conexao.getInstance().getPreparedStatement(sql);
		
		try {
			statement.setBoolean(1, true);
			ResultSet data = statement.executeQuery();
			while ( data.next() ) {
				Usuario usuario = new Usuario();
				usuario.setApelido( data.getString("usu_login") );
				usuario.setAtivado( true );
				usuario.setNome( data.getString("usu_nome") );
				usuario.setOid( data.getInt("usu_id") );

				usuarios.add(usuario);
			}
			return usuarios;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public List<Usuario> buscarTodosMesmo() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "SELECT usu_oid, usu_nome, usu_login, usu_ativo FROM tb_usuario;";
		PreparedStatement statement = Conexao.getInstance().getPreparedStatement(sql);
		
		try {
			statement.setBoolean(1, true);
			ResultSet data = statement.executeQuery();
			while ( data.next() ) {
				Usuario usuario = new Usuario();
				usuario.setApelido( data.getString("usu_login") );
				usuario.setAtivado( data.getBoolean("usu_ativo") );
				usuario.setNome( data.getString("usu_nome") );
				usuario.setOid( data.getInt("usu_id") );

				usuarios.add(usuario);
			}
			return usuarios;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public Usuario autenticar(String apelido, String senha) {
		String sql = "SELECT usu_oid, usu_nome FROM tb_usuario WHERE (usu_login=? AND usu_senha=? AND usu_ativo = ?);";
		PreparedStatement statement = Conexao.getInstance().getPreparedStatement(sql);
		
		try {
			statement.setString(1, apelido);
			statement.setString(2, senha);
			statement.setBoolean(3, true);
			ResultSet data = statement.executeQuery();
			if ( data.next() ) {
				Usuario usuario = new Usuario();
				usuario.setApelido( apelido );
				usuario.setAtivado( true );
				usuario.setNome( data.getString("usu_nome") );
				usuario.setOid( data.getInt("usu_id") );
				
				return usuario;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void inserir(Usuario usuario) {
		// TODO Auto-generated method stub
	}
	
	public void salvar(Usuario usuario) {
		// TODO Auto-generated method stub
	}
	
	public void excluir(Usuario usuario) {
		// TODO Auto-generated method stub
	}
	
}
