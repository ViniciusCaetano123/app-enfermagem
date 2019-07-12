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
import org.springframework.validation.BindingResult;

import br.com.enfermagem.model.Comentario;
import br.com.enfermagem.model.Evolucao;

@Repository
public class ComentarioDAO {
	Connection connection;
	 
	@Autowired
	public ComentarioDAO(DataSource dataSource) throws ClassNotFoundException{
		try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void adiciona(Comentario comentario){
		String sql = "insert into comentarios (descricaoComentario, idComentarioPaciente) values (?, ?)";
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, comentario.getDescricaoComentario());
			stmt.setLong(2, comentario.getIdComentarioPaciente());
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public void altera(Comentario comentario){
		String sql = "update comentarios set descricaoComentario=?, idComentarioPaciente=?, where id=?";
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1,comentario.getDescricaoComentario());
			stmt.setLong(2, comentario.getIdComentarioPaciente());
			stmt.setLong(3, comentario.getId());
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Comentario comentario){
		try{
			PreparedStatement stmt = this.connection.prepareStatement
			("delete from comentarios where id = ?");
			stmt.setLong(1, comentario.getId());
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Comentario> lista(){
		try{
			List<Comentario> comentarios = new ArrayList<Comentario>();
			PreparedStatement stmt = this.connection.prepareStatement
			("SELECT * FROM comentarios");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Comentario comentario = new Comentario();
				comentario.setId(rs.getLong("id"));
				if(rs.getDate("dataHora") != null){
					Calendar dataHora = Calendar.getInstance();
					dataHora.setTime(rs.getDate("dataHora"));
					comentario.setDataHora(dataHora);
				}
				comentario.setDescricaoComentario(rs.getString("descricaoComentario"));
				comentario.setIdComentarioPaciente(rs.getLong("idComentarioPaciente"));				
				comentarios.add(comentario);
			}
			rs.close();
			stmt.close();
			return comentarios;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public List<Comentario> listaComentariosCasoClinico(Long idPaciente, Long idCreadorCaso){
		try{
			List<Comentario> comentarios = new ArrayList<Comentario>();
			PreparedStatement stmt = this.connection.prepareStatement
			("SELECT * FROM comentarios ORDER BY dataHora DESC");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				if(rs.getLong("idComentarioPaciente") == idPaciente) {
					Comentario comentario = new Comentario();
					
					comentario.setId(rs.getLong("id"));
					if(rs.getDate("dataHora") != null){
						Calendar dataHora = Calendar.getInstance();
						dataHora.setTime(rs.getDate("dataHora"));
						comentario.setDataHora(dataHora);
					}
					comentario.setDescricaoComentario(rs.getString("descricaoComentario"));
					comentarios.add(comentario);
				}
				
			}
			rs.close();
			stmt.close();
			return comentarios;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public Comentario buscaPorId(Long idComentario){
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from comentarios ");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				if(idComentario == rs.getLong("id"))
				{
					Comentario comentario = new Comentario();
					comentario.setId(rs.getLong("id"));
					comentario.setDescricaoComentario(rs.getString("descricaoComentario"));
					comentario.setIdComentarioPaciente(rs.getLong("idComentarioPaciente"));
					return comentario;
				}
			}
				return null;
			}catch(SQLException e){
				throw new RuntimeException(e);
			}	
	}
}
