public class ContatoDAO{
	public static ContatoDAO instance = new ContatoDao();
	
	public static Contato DAO getInstance(){
		return UsuarioDAO.instance;
	}
	
	PreparedStatement statementInserir = conexao.getInstance().getPreparedStament("INSERT INTO contato(nome,telefone,email,endereco) VALUES (?,?,?,?)");
	PreparedStatement statementAtualizar = conexao.getInstance().getPreparedStament("UPDATE contato set (nome=?,telefone=?,email=?,endereco=?) WHERE con_id=?");
	PreparedStatement statementRecuperar = conexao.getInstance().getPreparedStatement("SELECT nome,telefone,email,endereco FROM contato WHERE nome=?");
	PreparedStatement statementRecuperarTodos = conexao.getInstance().getPreparedStatement("SELECT nome,telefone,email,endereco FROM contato");
	
	public void InserirContato(Contato contato){
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
	
	public void AtualizarContato(Contato contato){
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
	public Contato buscarContato(Contato contato){
		try{
			this.statementRecuperar.setString(1,getNome());
			ResultSet rs = statementRecuperar.execute();
			
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
	
	public List buscarTodos(){
		try{
			List<Contato> contatos = new ArrayList<Contato>;
			ResultSet rs = statementRecuperar.execute();
			
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
		return contato;
	}
}