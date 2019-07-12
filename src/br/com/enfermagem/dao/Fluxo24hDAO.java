package br.com.enfermagem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.enfermagem.model.Fluxo24h;

@Repository
public class Fluxo24hDAO {
	Connection connection;
	
	@Autowired
	public Fluxo24hDAO(DataSource dataSource) throws ClassNotFoundException{
		try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void adiciona(Fluxo24h fluxo24h){
		String sql = "insert into fluxo24hs (cod , pa , fc , fr , tax , dor , sat , pvc , hgt , administrados , eliminados , observacoes , idFluxo24hPaciente) " +
					"values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, fluxo24h.getCod());
			stmt.setString(2, fluxo24h.getPa());
			stmt.setString(3, fluxo24h.getFc());
			stmt.setString(4, fluxo24h.getFr());
			stmt.setString(5, fluxo24h.getTax());
			stmt.setString(6, fluxo24h.getDor());
			stmt.setString(7, fluxo24h.getSat());
			stmt.setString(8, fluxo24h.getPvc());
			stmt.setString(9, fluxo24h.getHgt());
			stmt.setString(10, fluxo24h.getAdministrados());
			stmt.setString(11, fluxo24h.getEliminados());
			stmt.setString(12, fluxo24h.getObservacoes());
			stmt.setLong(13, fluxo24h.getIdFluxo24hPaciente());
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
/*	
	public List<Fluxo24h> lista(){
		try{
			List<Fluxo24h> fluxo24hs = new ArrayList<Fluxo24h>();
			PreparedStatement stmt = this.connection.prepareStatement
			("SELECT * FROM fluxo24hs");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Fluxo24h fluxo24h = new Fluxo24h();
				
				fluxo24h.setId(rs.getLong("id"));
				fluxo24h.setCod(rs.getLong("cod"));
				fluxo24h.setPa(rs.getString("pa"));
				fluxo24h.setFc(rs.getString("fc"));
				fluxo24h.setFr(rs.getString("fr"));
				fluxo24h.setTax(rs.getString("tax"));
				fluxo24h.setDor(rs.getString("dor"));
				fluxo24h.setSat(rs.getString("sat"));
				fluxo24h.setPvc(rs.getString("Pvc"));
				fluxo24h.setHgt(rs.getString("hgt"));
				fluxo24h.setAdministrados(rs.getString("administrados"));
				fluxo24h.setEliminados(rs.getString("eliminados"));
				fluxo24h.setObservacoes(rs.getString("observacoes"));
				fluxo24h.setIdFluxo24hPaciente(rs.getLong("idFluxo24hPaciente"));
				if(rs.getDate("dataHora") != null){
					Calendar dataHora = Calendar.getInstance();
					dataHora.setTime(rs.getDate("dataHora"));
					fluxo24h.setDataHora(dataHora);
				}
				fluxo24hs.add(fluxo24h);
			}
			rs.close();
			stmt.close();
			return fluxo24hs;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
*/
	public void remove(Fluxo24h fluxo24h){
		try{
			PreparedStatement stmt = this.connection.prepareStatement
			("delete from fluxo24hs where id = ?");
			
			stmt.setLong(1, fluxo24h.getId());
			stmt.execute();
			stmt.close();

			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Fluxo24h> buscaPorIdFluxo24hPaciente(long idPaciente){
		
		try{
			List<Fluxo24h> fluxos24h = new ArrayList<Fluxo24h>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from fluxo24hs fluxo where fluxo.idFluxo24hPaciente = "+ idPaciente +" ORDER BY dataHora DESC");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{

				if(idPaciente == rs.getLong("idFluxo24hPaciente"))
				{
					Fluxo24h fluxo24h = new Fluxo24h();

					fluxo24h.setId(rs.getLong("id"));
					fluxo24h.setCod(rs.getLong("cod"));
					fluxo24h.setPa(rs.getString("pa"));
					fluxo24h.setFc(rs.getString("fc"));
					fluxo24h.setFr(rs.getString("fr"));
					fluxo24h.setTax(rs.getString("tax"));
					fluxo24h.setDor(rs.getString("dor"));
					fluxo24h.setSat(rs.getString("sat"));
					fluxo24h.setPvc(rs.getString("pvc"));
					fluxo24h.setHgt(rs.getString("hgt"));
					fluxo24h.setAdministrados(rs.getString("administrados"));
					fluxo24h.setEliminados(rs.getString("eliminados"));
					fluxo24h.setObservacoes(rs.getString("observacoes"));
					fluxo24h.setIdFluxo24hPaciente(rs.getLong("idFluxo24hPaciente"));
					if(rs.getTimestamp("dataHora") != null){
						Calendar dataHora = Calendar.getInstance();
						dataHora.setTime(rs.getTimestamp("dataHora"));
						fluxo24h.setDataHora(dataHora);
					}
					fluxos24h.add(fluxo24h);
				}
			}
				rs.close();
				stmt.close();
				return fluxos24h;
			}catch(SQLException e){
				throw new RuntimeException(e);
			}	
	}
	
	public Fluxo24h buscaPorId(Long id){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from fluxo24hs");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{

				if(id == rs.getLong("id"))
				{
					Fluxo24h fluxo24h = new Fluxo24h();

					fluxo24h.setId(rs.getLong("id"));
					fluxo24h.setCod(rs.getLong("cod"));
					fluxo24h.setPa(rs.getString("pa"));
					fluxo24h.setFc(rs.getString("fc"));
					fluxo24h.setFr(rs.getString("fr"));
					fluxo24h.setTax(rs.getString("tax"));
					fluxo24h.setDor(rs.getString("dor"));
					fluxo24h.setSat(rs.getString("sat"));
					fluxo24h.setPvc(rs.getString("pvc"));
					fluxo24h.setHgt(rs.getString("hgt"));
					fluxo24h.setAdministrados(rs.getString("administrados"));
					fluxo24h.setEliminados(rs.getString("eliminados"));
					fluxo24h.setObservacoes(rs.getString("observacoes"));
					fluxo24h.setIdFluxo24hPaciente(rs.getLong("idFluxo24hPaciente"));
					
					return fluxo24h;
				}
			}
				return null;
			}catch(SQLException e){
				throw new RuntimeException(e);
			}	
	}
	
	public void altera(Fluxo24h fluxo24h){
		String sql = "update fluxo24hs set  cod=? , pa=? , fc=? , fr=? , tax=? , dor=? , sat=? , pvc=? , hgt=? , administrados=? , eliminados=? , observacoes=? , idFluxo24hPaciente=? where id=?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setLong(1, fluxo24h.getCod());
			stmt.setString(2, fluxo24h.getPa());
			stmt.setString(3, fluxo24h.getFc());
			stmt.setString(4, fluxo24h.getFr());
			stmt.setString(5, fluxo24h.getTax());
			stmt.setString(6, fluxo24h.getDor());
			stmt.setString(7, fluxo24h.getSat());
			stmt.setString(8, fluxo24h.getPvc());
			stmt.setString(9, fluxo24h.getHgt());
			stmt.setString(10, fluxo24h.getAdministrados());
			stmt.setString(11, fluxo24h.getEliminados());
			stmt.setString(12, fluxo24h.getObservacoes());
			stmt.setLong(13, fluxo24h.getIdFluxo24hPaciente());		
			stmt.setLong(14, fluxo24h.getId());
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
}
