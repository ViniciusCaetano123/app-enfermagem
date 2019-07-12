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

import br.com.enfermagem.model.Evolucao;

@Repository
public class EvolucaoDAO {
	Connection connection;
	
	@Autowired
	public EvolucaoDAO(DataSource dataSource) throws ClassNotFoundException{
		try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void adiciona(Evolucao evolucao){
		String sql = "insert into evolucoes (descricaoSubjetivo , descricaoObjetivo , descricaoImpressao , descricaoConduta , descricaoCondigodiagnostico, idEvolucaoPaciente) " +
					" values (?, ?, ?, ?, ?, ?)";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, evolucao.getDescricaoSubjetivo());
			stmt.setString(2, evolucao.getDescricaoObjetivo());
			stmt.setString(3, evolucao.getDescricaoImpressao());
			stmt.setString(4, evolucao.getDescricaoConduta());
			stmt.setString(5, evolucao.getDescricaoCondigodiagnostico());
			stmt.setLong(6, evolucao.getIdEvolucaoPaciente());
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public List<Evolucao> lista(){
		try{
			List<Evolucao> evolucoes = new ArrayList<Evolucao>();
			PreparedStatement stmt = this.connection.prepareStatement
			("SELECT * FROM evolucoes ORDER BY dataHora DESC");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Evolucao evolucao = new Evolucao();
				
				evolucao.setId(rs.getLong("id"));
				evolucao.setDescricaoSubjetivo(rs.getString("descricaoSubjetivo"));
				evolucao.setDescricaoObjetivo(rs.getString("descricaoObjetivo"));
				evolucao.setDescricaoImpressao(rs.getString("descricaoImpressao"));
				evolucao.setDescricaoConduta(rs.getString("descricaoConduta"));
				evolucao.setDescricaoCondigodiagnostico(rs.getString("descricaoCondigodiagnostico"));
				evolucao.setIdEvolucaoPaciente(rs.getLong("idEvolucaoPaciente"));
				if(rs.getTimestamp("dataHora") != null){
					Calendar dataHora = Calendar.getInstance();
					dataHora.setTime(rs.getTimestamp("dataHora"));
					evolucao.setDataHora(dataHora);
				}
				evolucoes.add(evolucao);
			}
			rs.close();
			stmt.close();
			return evolucoes;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public List<Evolucao> listaEvolucoesPaciente(long idPaciente){
		try{
			List<Evolucao> evolucoes = new ArrayList<Evolucao>();
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM evolucoes evolucao where evolucao.idEvolucaoPaciente = "+ idPaciente +" ORDER BY dataHora DESC");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Evolucao evolucao = new Evolucao();
				evolucao.setId(rs.getLong("id"));
				evolucao.setDescricaoSubjetivo(rs.getString("descricaoSubjetivo"));
				evolucao.setDescricaoObjetivo(rs.getString("descricaoObjetivo"));
				evolucao.setDescricaoImpressao(rs.getString("descricaoImpressao"));
				evolucao.setDescricaoConduta(rs.getString("descricaoConduta"));
				evolucao.setDescricaoCondigodiagnostico(rs.getString("descricaoCondigodiagnostico"));
				evolucao.setIdEvolucaoPaciente(rs.getLong("idEvolucaoPaciente"));
				if(rs.getTimestamp("dataHora") != null){
					Calendar dataHora = Calendar.getInstance();
					dataHora.setTime(rs.getTimestamp("dataHora"));
					evolucao.setDataHora(dataHora);
				}
				evolucoes.add(evolucao);
			}
			rs.close();
			stmt.close();
			return evolucoes;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public void remove(Evolucao evolucao){
		try{
			PreparedStatement stmt = this.connection.prepareStatement
			("delete from evolucoes where id = ?");
			
			stmt.setLong(1, evolucao.getId());
			stmt.execute();
			stmt.close();

			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Evolucao buscaPorId(Long id){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from evolucoes");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{

				if(id == rs.getLong("id"))
				{
					Evolucao evolucao = new Evolucao();

					evolucao.setId(rs.getLong("id"));
					evolucao.setDescricaoSubjetivo(rs.getString("descricaoSubjetivo"));
					evolucao.setDescricaoObjetivo(rs.getString("descricaoObjetivo"));
					evolucao.setDescricaoImpressao(rs.getString("descricaoImpressao"));
					evolucao.setDescricaoConduta(rs.getString("descricaoConduta"));
					evolucao.setDescricaoCondigodiagnostico(rs.getString("descricaoCondigodiagnostico"));
					evolucao.setIdEvolucaoPaciente(rs.getLong("idEvolucaoPaciente"));
					
					return evolucao;
				}
			}
				return null;
			}catch(SQLException e){
				throw new RuntimeException(e);
			}	
	}
	
	
	public void altera(Evolucao evolucao){
		String sql = "update evolucoes set descricaoSubjetivo=?, descricaoObjetivo=?, descricaoImpressao=? , descricaoConduta=?, descricaoCondigodiagnostico=? where id=?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, evolucao.getDescricaoSubjetivo());
			stmt.setString(2, evolucao.getDescricaoObjetivo());
			stmt.setString(3, evolucao.getDescricaoImpressao());
			stmt.setString(4, evolucao.getDescricaoConduta());
			stmt.setString(5, evolucao.getDescricaoCondigodiagnostico());
			stmt.setLong(6, evolucao.getId());
				
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
}
