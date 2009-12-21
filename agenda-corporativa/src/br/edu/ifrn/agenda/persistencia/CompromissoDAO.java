package br.edu.ifrn.agenda.persistencia;


import br.edu.ifrn.agenda.beans.Agenda;
import br.edu.ifrn.agenda.beans.Compromisso;
import br.edu.ifrn.agenda.beans.HorarioCom;
import br.edu.ifrn.agenda.beans.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CompromissoDAO {

	private Conexao conn = Conexao.getInstance();
	
	public CompromissoDAO() throws Exception {
        try {
            

        } catch (Exception e) {
            throw new Exception("Erro: " +
                    "\n" + e.getMessage());
        }
    }
	
	
	public void salvar(Compromisso comp) throws Exception {
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        
        
        try {
        String SQL = "INSERT INTO tb_compromisso (usu_id, age_id, com_titulo, com_local, com_descricao, com_ativo) " +
                    "values (?, ?, ?, ?, ?, ?)";
            ps = conn.getPreparedStatement(SQL);
            ps.setInt(1, comp.getProprietario().getOid());
            ps.setInt(2, comp.getAgenda().getOid());
            ps.setString(3, comp.getTitulo());
            ps.setString(4, comp.getLocal());
            ps.setString(5, comp.getDescricao());
            ps.setBoolean(6, comp.isAtivo());
            ps.executeUpdate();
           
            
         for(HorarioCom horario : comp.getDatas()){   
        String SQL2 = "INSERT INTO tb_compromisso_data (com_id, dat_datainicio, dat_datafim, com_ativo) " +
            "values (?, ?, ?, ?)"; 
            ps2 = conn.getPreparedStatement(SQL2);
            ps2.setInt(1, comp.getOid());
            ps2.setTimestamp(2, new Timestamp(horario.getDataInicio().getTime()));
            ps2.setTimestamp(3, new Timestamp(horario.getDataFim().getTime()));            
            ps2.setBoolean(4, comp.isAtivo());
            ps2.executeUpdate();
            
         }
         
         //for(Usuario participantes : comp.getParticipantes()){   
            
                 
             // }
         
        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados " + sqle);
        }
        
	}
	
	public List<Compromisso> listarTodosCompromissos() throws Exception{
        PreparedStatement ps = null ;
        PreparedStatement ps2 = null ;
        PreparedStatement ps3 = null;
        
        List<Compromisso> compromissos = new ArrayList<Compromisso>();
            String SQL = "select * from tb_compromisso";
            
        try {
            ps = conn.getPreparedStatement(SQL);
            ResultSet rs = ps.executeQuery(SQL);
            
            
            while (rs.next()){
                Compromisso comp = new Compromisso();
                comp.setProprietario(Usuario.buscarPorID(rs.getInt("usu_id")));
                comp.setAgenda(Agenda.buscarPorID(rs.getInt("age_id")));
                comp.setTitulo(rs.getString("com_titulo"));
                comp.setLocal(rs.getString("com_local"));
                comp.setDescricao(rs.getString("com_descricao"));
                comp.setAtivo(rs.getBoolean("com_ativo"));
                                
                List<HorarioCom> horarios = new ArrayList<HorarioCom>();                                                
                
                SQL = "select * from tb_compromisso_data where dat_id = ? ;";
                ps2 = conn.getPreparedStatement(SQL);
                ps2.setInt(1, comp.getOid());
                                
                ResultSet rs2 = ps2.executeQuery(SQL);
                
                while (rs2.next()){
                	HorarioCom horario = new HorarioCom();
                	horario.setOid(rs2.getInt("dat_id"));
                	horario.setDataInicio(rs2.getTimestamp("dat_datainicio"));
                	horario.setDataFim(rs2.getTimestamp("dat_datafim"));
                	comp.setAtivo(rs.getBoolean("dat_ativo"));    
                	horarios.add(horario);
                
                }                
                comp.setDatas(horarios);
                
                List<Usuario> participantes = new ArrayList<Usuario>();
                
                SQL = "select * from tb_usuario where usu_id = ? ;";
                ps3 = conn.getPreparedStatement(SQL);
                ps3.setInt(1, comp.getOid());
                
                ResultSet rs3 = ps3.executeQuery(SQL);
                
                while (rs3.next()){
                	Usuario participante = new Usuario();
                //participante.
                // Falta metodos da tabela usuario
                
                    
                	participantes.add(participante);
                
                }                
                comp.setParticipantes(participantes);               
                
                compromissos.add(comp);
            
            }
        } catch (SQLException ex) {
          throw new Exception("Erro ao pegar os dados " + ex);
        } 
        return compromissos;
    }
	
	public List<Compromisso> buscarCompromissosPorData(Date data) throws Exception{
        PreparedStatement ps = null ;
        PreparedStatement ps2 = null ;
        PreparedStatement ps3 = null;
        
        List<Compromisso> compromissos = new ArrayList<Compromisso>();
            String SQL = "select * from tb_compromisso where dat_datainicio = ?;";
            
        try {
            ps = conn.getPreparedStatement(SQL);
            ps.setDate(1, (java.sql.Date) data);            
            ResultSet rs = ps.executeQuery(SQL);
            
            
            while (rs.next()){
                Compromisso comp = new Compromisso();
                comp.setProprietario(Usuario.buscarPorID(rs.getInt("usu_id")));
                comp.setAgenda(Agenda.buscarPorID(rs.getInt("age_id")));
                comp.setTitulo(rs.getString("com_titulo"));
                comp.setLocal(rs.getString("com_local"));
                comp.setDescricao(rs.getString("com_descricao"));
                comp.setAtivo(rs.getBoolean("com_ativo"));
                                
                List<HorarioCom> horarios = new ArrayList<HorarioCom>();                                                
                
                SQL = "select * from tb_compromisso_data where dat_id = ? ;";
                ps2 = conn.getPreparedStatement(SQL);
                ps2.setInt(1, comp.getOid());
                                
                ResultSet rs2 = ps2.executeQuery(SQL);
                
                while (rs2.next()){
                	HorarioCom horario = new HorarioCom();
                	horario.setOid(rs2.getInt("dat_id"));
                	horario.setDataInicio(rs2.getTimestamp("dat_datainicio"));
                	horario.setDataFim(rs2.getTimestamp("dat_datafim"));
                	comp.setAtivo(rs.getBoolean("dat_ativo"));    
                	horarios.add(horario);
                
                }                
                comp.setDatas(horarios);
                
                List<Usuario> participantes = new ArrayList<Usuario>();
                
                SQL = "select * from tb_usuario where usu_id = ? ;";
                ps3 = conn.getPreparedStatement(SQL);
                ps3.setInt(1, comp.getOid());
                
                ResultSet rs3 = ps3.executeQuery(SQL);
                
                while (rs3.next()){
                	Usuario participante = new Usuario();
                //participante.
                // Falta metodos da tabela usuario
                
                    
                	participantes.add(participante);
                
                }                
                comp.setParticipantes(participantes);               
                
                compromissos.add(comp);
            
            }
        } catch (SQLException ex) {
          throw new Exception("Erro ao pegar os dados " + ex);
        } 
        return compromissos;
    }
	
	
	public List<Compromisso> buscarCompromissosPorId(int id) throws Exception{
        PreparedStatement ps = null ;
        PreparedStatement ps2 = null ;
        PreparedStatement ps3 = null;
        
        List<Compromisso> compromissos = new ArrayList<Compromisso>();
            String SQL = "select * from tb_compromisso where com_oid = ?;";
            
        try {
            ps = conn.getPreparedStatement(SQL);
            ps.setInt(1, id);            
            ResultSet rs = ps.executeQuery(SQL);
            
            
            while (rs.next()){
                Compromisso comp = new Compromisso();
                comp.setProprietario(Usuario.buscarPorID(rs.getInt("usu_id")));
                comp.setAgenda(Agenda.buscarPorID(rs.getInt("age_id")));
                comp.setTitulo(rs.getString("com_titulo"));
                comp.setLocal(rs.getString("com_local"));
                comp.setDescricao(rs.getString("com_descricao"));
                comp.setAtivo(rs.getBoolean("com_ativo"));
                                
                List<HorarioCom> horarios = new ArrayList<HorarioCom>();                                                
                
                SQL = "select * from tb_compromisso_data where dat_id = ? ;";
                ps2 = conn.getPreparedStatement(SQL);
                ps2.setInt(1, comp.getOid());
                                
                ResultSet rs2 = ps2.executeQuery(SQL);
                
                while (rs2.next()){
                	HorarioCom horario = new HorarioCom();
                	horario.setOid(rs2.getInt("dat_id"));
                	horario.setDataInicio(rs2.getTimestamp("dat_datainicio"));
                	horario.setDataFim(rs2.getTimestamp("dat_datafim"));
                	comp.setAtivo(rs.getBoolean("dat_ativo"));    
                	horarios.add(horario);
                
                }                
                comp.setDatas(horarios);
                
                List<Usuario> participantes = new ArrayList<Usuario>();
                
                SQL = "select * from tb_usuario where usu_id = ? ;";
                ps3 = conn.getPreparedStatement(SQL);
                ps3.setInt(1, comp.getOid());
                
                ResultSet rs3 = ps3.executeQuery(SQL);
                
                while (rs3.next()){
                	Usuario participante = new Usuario();
                //participante.
                // Falta metodos da tabela usuario
                
                    
                	participantes.add(participante);
                
                }                
                comp.setParticipantes(participantes);               
                
                compromissos.add(comp);
            
            }
        } catch (SQLException ex) {
          throw new Exception("Erro ao pegar os dados " + ex);
        } 
        return compromissos;
    }
	
	
	public List<Compromisso> buscarCompromissosPorTitulo(String titulo) throws Exception{
        PreparedStatement ps = null ;
        PreparedStatement ps2 = null ;
        PreparedStatement ps3 = null;
        
        List<Compromisso> compromissos = new ArrayList<Compromisso>();
            String SQL = "select * from tb_compromisso where com_titulo like ?;";
            
        try {
            ps = conn.getPreparedStatement(SQL);
            ps.setString(1, titulo+"%");            
            ResultSet rs = ps.executeQuery(SQL);
            
            
            while (rs.next()){
                Compromisso comp = new Compromisso();
                comp.setProprietario(Usuario.buscarPorID(rs.getInt("usu_id")));
                comp.setAgenda(Agenda.buscarPorID(rs.getInt("age_id")));
                comp.setTitulo(rs.getString("com_titulo"));
                comp.setLocal(rs.getString("com_local"));
                comp.setDescricao(rs.getString("com_descricao"));
                comp.setAtivo(rs.getBoolean("com_ativo"));
                                
                List<HorarioCom> horarios = new ArrayList<HorarioCom>();                                                
                
                SQL = "select * from tb_compromisso_data where dat_id = ? ;";
                ps2 = conn.getPreparedStatement(SQL);
                ps2.setInt(1, comp.getOid());
                                
                ResultSet rs2 = ps2.executeQuery(SQL);
                
                while (rs2.next()){
                	HorarioCom horario = new HorarioCom();
                	horario.setOid(rs2.getInt("dat_id"));
                	horario.setDataInicio(rs2.getTimestamp("dat_datainicio"));
                	horario.setDataFim(rs2.getTimestamp("dat_datafim"));
                	comp.setAtivo(rs.getBoolean("dat_ativo"));    
                	horarios.add(horario);
                
                }                
                comp.setDatas(horarios);
                
                List<Usuario> participantes = new ArrayList<Usuario>();
                
                SQL = "select * from tb_usuario where usu_id = ? ;";
                ps3 = conn.getPreparedStatement(SQL);
                ps3.setInt(1, comp.getOid());
                
                ResultSet rs3 = ps3.executeQuery(SQL);
                
                while (rs3.next()){
                	Usuario participante = new Usuario();
                //participante.
                // Falta metodos da tabela usuario
                
                    
                	participantes.add(participante);
                
                }                
                comp.setParticipantes(participantes);               
                
                compromissos.add(comp);
            
            }
        } catch (SQLException ex) {
          throw new Exception("Erro ao pegar os dados " + ex);
        } 
        return compromissos;
    }
	
	public int updateCompromisso(Compromisso comp) throws Exception{
		PreparedStatement ps = null ;
		PreparedStatement ps2 = null ;
        PreparedStatement ps3 = null;
        
	    String SQL = "UPDATE INTO tb_compromisso usu_id = ?, age_id = ?, com_titulo = ?, com_local = ?, com_descricao = ?, com_ativo = ? " +
	                    "where com_id = ?;";	    
	    int rows = 0;
	    try {
	         ps = conn.getPreparedStatement(SQL);
	         ps.setInt(1, comp.getProprietario().getOid());
	         ps.setInt(2, comp.getAgenda().getOid());
	         ps.setString(3, comp.getTitulo());
	         ps.setString(4, comp.getLocal());
	         ps.setString(5, comp.getDescricao());
	         ps.setBoolean(6, comp.isAtivo());
	         ps.executeUpdate();
	           
	            
	    for(HorarioCom horario : comp.getDatas()){   
	        String SQL2 = "UPDATE INTO tb_compromisso_data com_id = ?, dat_datainicio = ?, dat_datafim = ?, com_ativo = ? " +
	        		"where com_id = ?;) "; 
	        
	        ps2 = conn.getPreparedStatement(SQL2);
	        ps2.setInt(1, comp.getOid());
	        ps2.setTimestamp(2, new Timestamp(horario.getDataInicio().getTime()));
	        ps2.setTimestamp(3, new Timestamp(horario.getDataFim().getTime()));            
	        ps2.setBoolean(4, comp.isAtivo());
	        ps2.executeUpdate();
	            
	         }
	        } catch (SQLException sqle) {
	            throw new Exception("Erro ao inserir dados " + sqle);
	        }
	        
	    //for(Usuario participantes: comp.getParticipantes()){
	    	
	    //}
	        
	   return rows;     
		
	}
	
	
}
	
	