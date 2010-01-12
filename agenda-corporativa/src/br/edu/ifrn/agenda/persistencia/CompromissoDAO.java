package br.edu.ifrn.agenda.persistencia;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.ifrn.agenda.beans.Agenda;
import br.edu.ifrn.agenda.beans.Compromisso;
import br.edu.ifrn.agenda.beans.HorarioCompromisso;
import br.edu.ifrn.agenda.beans.Usuario;

public class CompromissoDAO {

	private static CompromissoDAO singleton = new CompromissoDAO();
	

	public static CompromissoDAO getInstance() {
		return CompromissoDAO.singleton;
	}
	
	private Conexao conn = Conexao.getInstance();
		
	
	public void inserir(Compromisso comp) throws Exception {
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        ResultSet rs;
        
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
           
            
            SQL = "SELECT MAX(com_id) as id FROM tb_compromisso";
            rs = ps.executeQuery(SQL);
            comp.setOid(rs.getInt("id"));
            
            
            
         for(HorarioCompromisso horario : comp.getDatas()){   
        String SQL2 = "INSERT INTO tb_compromisso_data (com_id, dat_datainicio, dat_datafim, com_ativo) " +
            "values (?, ?, ?, ?)"; 
            ps2 = conn.getPreparedStatement(SQL2);
            ps2.setInt(1, comp.getOid());
            ps2.setTimestamp(2, new Timestamp(horario.getDataInicio().getTime()));
            ps2.setTimestamp(3, new Timestamp(horario.getDataFim().getTime()));            
            ps2.setBoolean(4, comp.isAtivo());
            ps2.executeUpdate();
            
         }
         
         for(Usuario participantes : comp.getParticipantes()){   
        	 String SQL3 = "INSERT INTO tb_compromisso_participantes (com_id, usu_id) " +
             "values (?, ?)";
        	 ps3 = conn.getPreparedStatement(SQL3);
        	 ps3.setInt(1, comp.getOid());
        	 ps3.setInt(2, participantes.getOid());
        	 ps3.executeUpdate();
                 
        }
         
        } catch (SQLException sqle) {
            throw new Exception("Erro ao inserir dados " + sqle);
        }
        
	}
	
	
	public int alterar(Compromisso comp) throws Exception{
		PreparedStatement ps = null ;
		PreparedStatement ps2 = null ;

        
	    String SQL = "UPDATE SET tb_compromisso usu_id = ?, age_id = ?, com_titulo = ?, com_local = ?, com_descricao = ?, com_ativo = ? " +
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
	           
	            
	   
	        String SQL2 = "UPDATE SET tb_compromisso_data dat_datainicio = ?, dat_datafim = ?, com_ativo = ? " +
	        		"where com_id = ? and dat_datainicio = ? and dat_datafim = ?;"; 
	        
	        ps2 = conn.getPreparedStatement(SQL2);
	       
	        ps2.setTimestamp(1, new Timestamp(comp.getDatas().get(1).getDataInicio().getTime()));
	        ps2.setTimestamp(2, new Timestamp(comp.getDatas().get(1).getDataFim().getTime()));            
	        ps2.setBoolean(3, comp.isAtivo());
	        ps2.setInt(4, comp.getOid());
	        ps2.setTimestamp(5, new Timestamp(comp.getDatas().get(0).getDataInicio().getTime()));
	        ps2.setTimestamp(6, new Timestamp(comp.getDatas().get(0).getDataFim().getTime()));
	        
	        ps2.executeUpdate();
	            

	    
	        } catch (SQLException sqle) {
	            throw new Exception("Erro ao inserir dados " + sqle);
	        }	     
	        
	   return rows;     
		
	}
	
	public int removerParticipante(int idCom, int idPar) {
		 PreparedStatement ps = null;

	        String SQL = "DELETE FROM tb_compromisso_participantes where com_id = ? and usu_id = ?;";
	        ps = conn.getPreparedStatement(SQL);
	        try {
	        	ps.setInt(1, idCom);
				ps.setInt(2, idPar);
				return ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return 0;

	}
	
	
	public int adicionarParticipante(int idCom, int idPart) {
		 PreparedStatement ps = null;

	        String SQL = "INSERT INTO tb_compromisso_participantes (com_id, usu_id) " +
             "values (?, ?)";
	        ps = conn.getPreparedStatement(SQL);
	        try {
				ps.setInt(1, idCom);
				ps.setInt(2, idPart);
				return ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return 0;

	}
	
	
	
	
	
	public List<Compromisso> listarTodos() throws Exception{
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
                comp.setProprietario(UsuarioDAO.getInstance().buscarPorID(rs.getInt("usu_id")));
                comp.setAgenda(Agenda.buscarPorID(rs.getInt("age_id")));
                comp.setTitulo(rs.getString("com_titulo"));
                comp.setLocal(rs.getString("com_local"));
                comp.setDescricao(rs.getString("com_descricao"));
                comp.setAtivo(rs.getBoolean("com_ativo"));
                                
                List<HorarioCompromisso> horarios = new ArrayList<HorarioCompromisso>();                                                
                
                SQL = "select * from tb_compromisso_data where dat_id = ? ;";
                ps2 = conn.getPreparedStatement(SQL);
                ps2.setInt(1, comp.getOid());
                                
                ResultSet rs2 = ps2.executeQuery(SQL);
                
                while (rs2.next()){
                	HorarioCompromisso horario = new HorarioCompromisso();
                	horario.setOid(rs2.getInt("dat_id"));
                	horario.setDataInicio(rs2.getTimestamp("dat_datainicio"));
                	horario.setDataFim(rs2.getTimestamp("dat_datafim"));
                	comp.setAtivo(rs.getBoolean("dat_ativo"));    
                	horarios.add(horario);
                
                }                
                comp.setDatas(horarios);
                
                List<Usuario> participantes = new ArrayList<Usuario>();
                
                SQL = "select * from tb_compromisso_participantes where com_id = ? ;";
                ps3 = conn.getPreparedStatement(SQL);
                ps3.setInt(1, comp.getOid());
                
                ResultSet rs3 = ps3.executeQuery(SQL);
                
                while (rs3.next()){
                	Usuario participante = new Usuario();
                	comp.setOid(rs3.getInt("com_id"));
                	participante.setOid(rs3.getInt("usu_id"));                
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
	
	
	
	
	
	@SuppressWarnings("deprecation")
	public List<Compromisso> buscarPorData(java.util.Date data){
		PreparedStatement ps = null ;
		  List<Compromisso> compromissos = new ArrayList<Compromisso>();
          List<Integer> lista = new ArrayList<Integer>();
		  
		 		  
		  ResultSet rs;
	try {
		
		
		ps = conn.getPreparedStatement("select com_id from tb_compromisso_data where (convert(varchar, com_dat_datainicio, 103)) like ?;");
		  
		 SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		  
		  ps.setString(1, fmt.format(data));            
		  
          rs = ps.executeQuery();
                    
          while (rs.next()){
        	  lista.add(rs.getInt("com_id"));
          }
		  
		  
		} catch (SQLException e) {
			System.out.println("ERRROOOO: "+e.getMessage());
			e.printStackTrace();
		}
		  	
          
	
		rs = null; ps = null;
		PreparedStatement ps2 = null ;
        PreparedStatement ps3 = null;
          	
		try {		
		
		for(Integer i : lista){
			
			

		            ps2 = conn.getPreparedStatement("select * from tb_compromisso where com_id = ?;");
		            ps2.setInt(1, i);            
		            rs = ps2.executeQuery();
		            while (rs.next()){
		                Compromisso comp = new Compromisso();
		               // comp.setProprietario(UsuarioDAO.getInstance().buscarPorID(rs.getInt("usu_id")));
		               // comp.setAgenda(Agenda.buscarPorID(rs.getInt("age_id")));
		                comp.setOid(rs.getInt("com_id"));
		                comp.setTitulo(rs.getString("com_titulo"));
		                comp.setLocal(rs.getString("com_local"));
		                comp.setDescricao(rs.getString("com_descricao"));
		                comp.setAtivo(rs.getBoolean("com_ativo"));
		                                
		                /*List<HorarioCompromisso> horarios = new ArrayList<HorarioCompromisso>();                                                
		                
		                
		                ps2 = conn.getPreparedStatement("select * from tb_compromisso_data where com_id = ? ;");
		                ps2.setInt(1, comp.getOid());
		                                
		                ResultSet rs2 = ps2.executeQuery();
		                
		                while (rs2.next()){
		                	HorarioCompromisso horario = new HorarioCompromisso();
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
		                	comp.setOid(rs3.getInt("com_id"));
		                	participante.setOid(rs3.getInt("usu_id"));            
		                	participantes.add(participante);
		                
		                }                
		                comp.setParticipantes(participantes);*/
		                compromissos.add(comp);
		            
		            }
		     
			
		}
		return compromissos;  	
		
		
		   } catch (SQLException ex) {
	        	System.out.println("Erro ao pegar os dados " + ex.getMessage());
	    } 
		   return null;   
    }
	
	
	public Compromisso buscarPorId(int id){
        PreparedStatement ps = null ;
        PreparedStatement ps2 = null ;
        //PreparedStatement ps3 = null;
        
 

        try {
            ps = conn.getPreparedStatement("select * from tb_compromisso where com_id = ?;");
            ps.setInt(1, id);            
            ResultSet rs = ps.executeQuery();
            Compromisso comp;
            
            while (rs.next()){
                comp = new Compromisso();
                //comp.setProprietario(UsuarioDAO.getInstance().buscarPorID(rs.getInt("usu_id")));
                //comp.setAgenda(Agenda.buscarPorID(rs.getInt("age_id")));
                comp.setOid(id);
                comp.setTitulo(rs.getString("com_titulo"));
                comp.setLocal(rs.getString("com_local"));
                comp.setDescricao(rs.getString("com_descricao"));
                comp.setAtivo(rs.getBoolean("com_ativo"));
                                
                List<HorarioCompromisso> horarios = new ArrayList<HorarioCompromisso>();                                                
                
                
                ps2 = conn.getPreparedStatement("select * from tb_compromisso_data where com_id = ? ;");
                ps2.setInt(1, id);              
                ResultSet rs2 = ps2.executeQuery();
                
                while (rs2.next()){
                	HorarioCompromisso horario = new HorarioCompromisso();
                	horario.setOid(rs2.getInt("com_id"));
                	horario.setDataInicio(rs2.getTimestamp("com_dat_datainicio"));
                	horario.setDataFim(rs2.getTimestamp("com_dat_datafim"));
                	comp.setAtivo(true);    
                	horarios.add(horario);
                
                }                
                comp.setDatas(horarios);
                
                /* List<Usuario> participantes = new ArrayList<Usuario>();
                
           
                ps3 = conn.getPreparedStatement("select * from tb_usuario where usu_id = ? ;");
                ps3.setInt(1, comp.getOid());
                
                ResultSet rs3 = ps3.executeQuery();
                
                while (rs3.next()){
                	Usuario participante = new Usuario();
                	comp.setOid(rs3.getInt("com_id"));
                	participante.setOid(rs3.getInt("usu_id"));                
                	participantes.add(participante);                
                }                
                comp.setParticipantes(participantes);*/ 
                
                return comp;
            }
        } catch (SQLException ex) {
          System.out.println("Erro ao pegar os dados " + ex);
        } 
        return null;
    }
	
	
	public List<Compromisso> buscarPorTitulo(String titulo) throws Exception{
        PreparedStatement ps = null ;
        PreparedStatement ps2 = null ;
        PreparedStatement ps3 = null;
        
        List<Compromisso> compromissos = new ArrayList<Compromisso>();
            String SQL = "select * from tb_compromisso where com_titulo like ?;";
            
        try {
            ps = conn.getPreparedStatement(SQL);
            ps.setString(1, titulo+"%");            
            ResultSet rs = ps.executeQuery();
            
            
            while (rs.next()){
                Compromisso comp = new Compromisso();
                comp.setProprietario(UsuarioDAO.getInstance().buscarPorID(rs.getInt("usu_id")));
                comp.setAgenda(Agenda.buscarPorID(rs.getInt("age_id")));
                comp.setTitulo(rs.getString("com_titulo"));
                comp.setLocal(rs.getString("com_local"));
                comp.setDescricao(rs.getString("com_descricao"));
                comp.setAtivo(rs.getBoolean("com_ativo"));
                                
                List<HorarioCompromisso> horarios = new ArrayList<HorarioCompromisso>();                                                
                
                SQL = "select * from tb_compromisso_data where dat_id = ? ;";
                ps2 = conn.getPreparedStatement(SQL);
                ps2.setInt(1, comp.getOid());
                                
                ResultSet rs2 = ps2.executeQuery();
                
                while (rs2.next()){
                	HorarioCompromisso horario = new HorarioCompromisso();
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
                
                ResultSet rs3 = ps3.executeQuery();
                
                while (rs3.next()){
                	Usuario participante = new Usuario();
                	comp.setOid(rs3.getInt("com_id"));
                	participante.setOid(rs3.getInt("usu_id"));                  
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
	

	
	
}