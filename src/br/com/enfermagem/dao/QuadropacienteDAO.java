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

import br.com.enfermagem.model.Quadropaciente;

@Repository
public class QuadropacienteDAO {
	Connection connection;
	
	@Autowired
	public QuadropacienteDAO(DataSource dataSource) throws ClassNotFoundException{
		try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void adiciona(Quadropaciente quadropaciente){
		String sql = "insert into quadropacientes (descricao , idQuadropacienteCaso) " +
					"values (?, ?)";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, quadropaciente.getDescricao());
			stmt.setLong(2, quadropaciente.getIdQuadropacienteCaso());
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	/*
	public List<Quadropaciente> lista(){
		try{
			List<Quadropaciente> quadropacientes = new ArrayList<Quadropaciente>();
			PreparedStatement stmt = this.connection.prepareStatement
			("SELECT * FROM quadropacientes");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Quadropaciente quadropaciente = new Quadropaciente();
				
				quadropaciente.setId(rs.getLong("id"));
				quadropaciente.setDescricao(rs.getString("descricao"));
				quadropaciente.setIdQuadropacienteCaso(rs.getLong("idQuadropacienteCaso"));
				//if(rs.getTime("dataHora") != null){
					Calendar dataHora = Calendar.getInstance();
					dataHora.setTime(rs.getDate("dataHora"));
					quadropaciente.setDataHora(dataHora);
				//}
				quadropacientes.add(quadropaciente);
			}
			rs.close();
			stmt.close();
			return quadropacientes;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	*/
	
	public List<Quadropaciente> selecionaPorId(Long id){
		try{
			List<Quadropaciente> quadropacientes = new ArrayList<Quadropaciente>();
			PreparedStatement stmt = this.connection.prepareStatement
			("SELECT * FROM quadropacientes where idQuadropacienteCaso = " + id + " ORDER BY dataHora DESC");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Quadropaciente quadropaciente = new Quadropaciente();
				
				quadropaciente.setId(rs.getLong("id"));
				quadropaciente.setDescricao(rs.getString("descricao"));
				quadropaciente.setIdQuadropacienteCaso(rs.getLong("idQuadropacienteCaso"));
				if(rs.getTimestamp("dataHora") != null){
					Calendar dataHora = Calendar.getInstance();
					dataHora.setTime(rs.getTimestamp("dataHora"));
					quadropaciente.setDataHora(dataHora);
				}
				
				quadropacientes.add(quadropaciente);
			}
			rs.close();
			stmt.close();
			return quadropacientes;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public void remove(Quadropaciente quadropaciente){
		try{
			PreparedStatement stmt = this.connection.prepareStatement
			("delete from quadropacientes where id = ?");
			
			stmt.setLong(1, quadropaciente.getId());
			stmt.execute();
			stmt.close();

			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Quadropaciente buscaPorId(Long id){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from quadropacientes where id = " + id );
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				if(id == rs.getLong("id"))
				{
					Quadropaciente quadropaciente = new Quadropaciente();

					quadropaciente.setId(rs.getLong("id"));
					quadropaciente.setDescricao(rs.getString("descricao"));
					quadropaciente.setIdQuadropacienteCaso(rs.getLong("idQuadropacienteCaso"));
					
					return quadropaciente;
				}
			}
				return null;
			}catch(SQLException e){
				throw new RuntimeException(e);
			}	
	}
	
	

	
	
	public void altera(Quadropaciente quadropaciente){
		String sql = "update quadropacientes set descricao=? where id=?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, quadropaciente.getDescricao());
			stmt.setLong(2, quadropaciente.getId());
				
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
}
