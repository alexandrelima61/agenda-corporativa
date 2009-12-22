package br.edu.ifrn.agenda.persistencia;

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
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Usuario> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Usuario autenticar(String apelido, String senha) {
		// TODO Auto-generated method stub
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
