package br.com.enfermagem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.enfermagem.jdbc.ConnectionFactory;
import br.com.enfermagem.model.Usuario;

public class LoginDAO {
	
	Connection connection;
	
	public LoginDAO() throws ClassNotFoundException{
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public boolean existeUsuario(Usuario usuario){
		
			String sql = "select * from usuarios where email LIKE BINARY ? and senha LIKE MD5(?)";
			
			try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getSenha());
			
			ResultSet rs = stmt.executeQuery();
			
			stmt.execute();
			
			if(rs.next())
			{
				stmt.close();
				return true;
			}
			else
			{
				stmt.close();
				return false;
			}
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
}
