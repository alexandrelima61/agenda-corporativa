package br.edu.ifrn.agenda.persistencia;

import br.edu.ifrn.agenda.beans.Agenda;
//import br.com.agenda.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AgendaDAO{

	
// conn deve ser substituido por Conexao	
    private Connection conn;

  
    public AgendaDAO() throws Exception {
        try {
            //this.conn = ConnectionFactory.getConnection();

        } catch (Exception e) {
            throw new Exception("Erro: " +
                    "\n" + e.getMessage());
        }
    }


    public void salvar(Agenda categoria) throws Exception {
        PreparedStatement ps = null;
        
        if (categoria == null) {
            throw new Exception("O valor passado não pode ser nulo");
        }

        try {
            String SQL = "INSERT INTO tb_agenda (age_titulo, age_descricao, age_ativado) " +
                    "values (?, ?, ?)";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, categoria.getTitulo());
            ps.setString(2, categoria.getDescricao());
            ps.setBoolean(3, categoria.isAtivado());

            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados " + sqle);
        }
    }

    public List<Agenda> listarTodasAgendas() throws Exception{
        PreparedStatement ps = null ;
        List<Agenda> agendas = new ArrayList<Agenda>();
            String SQL = "select * from tb_agenda";
        try {
            ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery(SQL);
            
            while (rs.next()){
                Agenda a = new Agenda();
                a.setOid(rs.getInt("age_id"));
                a.setTitulo(rs.getString("age_titulo"));
                a.setDescricao(rs.getString("age_descricao"));
                a.setAtivado(rs.getBoolean("age_ativado"));
                agendas.add(a);
            }
        } catch (SQLException ex) {
          throw new Exception("Erro ao pegar os dados " + ex);
        } 
        return agendas;
    }

    public void excluir(Agenda agenda) throws Exception {

                PreparedStatement ps = null ;
                try{
                    String SQL = "DELETE from tb_agenda where age_id = ?";
                    ps = conn.prepareStatement(SQL);
                    ps.setInt(1, agenda.getOid());
                    ps.executeUpdate();
                } catch(Exception ex){
                    throw new Exception("Erro ao deletar os dados " + ex);
                }
    }

    public void editarAgenda(Agenda agenda) throws Exception {
        PreparedStatement ps = null ;
                try{
                    String SQL = "UPDATE tb_agenda SET age_titulo = ?, age_descricao = ?," +
                            "age_ativado = ? WHERE age_id = ?";
                    ps = conn.prepareStatement(SQL);
                    ps.setString(1, agenda.getTitulo());
                    ps.setString(2, agenda.getDescricao());
                    ps.setBoolean(3, agenda.isAtivado());
                    ps.setInt(4, agenda.getOid());
                    ps.executeUpdate();
                } catch (SQLException ex){
                    throw new Exception("Erro ao editar os dados " + ex);
                }
    }


}