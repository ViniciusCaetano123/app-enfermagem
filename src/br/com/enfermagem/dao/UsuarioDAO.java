package br.com.enfermagem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.enfermagem.model.Usuario;

@Repository
public class UsuarioDAO {
	Connection connection;
	
	@Autowired
	public UsuarioDAO(DataSource dataSource) throws ClassNotFoundException{
		try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public String gerarSenha(String email,Usuario usuario) {
		   String[] carct ={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

		    String senhaAleatorio="";
		    
		    
		    for (int x=0; x<8; x++){
		        int j = (int) (Math.random()*carct.length);
		        senhaAleatorio += carct[j];
		        
		}
		  
		    usuario.setSenha(senhaAleatorio);
		   
		    String sql = "update usuarios set senha=MD5(?) where email=?";
		    
		    try {
		    	
		    	PreparedStatement stmt = this.connection.prepareStatement(sql);
	        	stmt.setString(1, usuario.getSenha());
	        	stmt.setString(2, usuario.getEmail());
		    	
	        	stmt.execute();
				stmt.close();
				return usuario.getSenha();
				
			}catch(SQLException e){
				throw new RuntimeException(e);
			}
	}

	

	public boolean enviarEmail(String email,Usuario usuario) throws SQLException {		
		Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                         protected PasswordAuthentication getPasswordAuthentication() 
                         {
                               return new PasswordAuthentication("enfermagemfapa@gmail.com", "enfermagem@12345678");
                         }
                    });
       
        session.setDebug(true);
        try {        	
          
        	String senhaNova = gerarSenha(email, usuario);
		        	
              Message message = new MimeMessage(session);
              message.setFrom(new InternetAddress("seuemail@gmail.com")); //Remetente
              Address[] toUser = InternetAddress //Destinatario(s)
                      .parse(email);  

           message.setRecipients(Message.RecipientType.TO, toUser);
           message.setSubject("APP - Enfermagem");//Assunto
           message.setText("Sua senha nova :"+senhaNova);
          
           Transport.send(message);

           System.out.println("Feito!!!");
           return true;
        } catch (MessagingException e) {        
        	throw new RuntimeException(e);         	
        }	
        
	}
	
	public void adiciona(Usuario usuario){
		String sql = "insert into usuarios (nome ,senha, email,login) " +
					"values (?,MD5(?), ?,?)";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());			
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, usuario.getEmail());
			stmt.setString(4, usuario.getLogin());
			
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public List<Usuario> lista(){
		try{
			List<Usuario> usuarios = new ArrayList<Usuario>();
			PreparedStatement stmt = this.connection.prepareStatement
			("SELECT * FROM usuarios");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				
					Usuario usuario = new Usuario();
					
					usuario.setId(rs.getLong("id"));
					usuario.setNome(rs.getString("nome"));				
					usuario.setEmail(rs.getString("email"));
					if(rs.getDate("dataHora") != null){
						Calendar dataHora = Calendar.getInstance();
						dataHora.setTime(rs.getDate("dataHora"));
						usuario.setDataHora(dataHora);
					}
					usuarios.add(usuario);
				
			}
			rs.close();
			stmt.close();
			
			return usuarios;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public void remove(Usuario usuario){
		try{
			PreparedStatement stmt = this.connection.prepareStatement
			("delete from usuarios where id = ?");
			
			stmt.setLong(1, usuario.getId());
			stmt.execute();
			stmt.close();

			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}	
	
	public Usuario buscaPorId(Long id){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from usuarios");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{

				if(id == rs.getLong("id"))
				{
					Usuario usuario = new Usuario();

					usuario.setId(rs.getLong("id"));
					usuario.setNome(rs.getString("nome"));				
					usuario.setEmail(rs.getString("email"));
					
					return usuario;
				}
			}
				return null;
			}catch(SQLException e){
				throw new RuntimeException(e);
			}
	}	
	
	
	public void altera(Usuario usuario){
		String sql = "update usuarios set nome=?, senha=MD5(?), email=? where id=?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, usuario.getNome());			
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, usuario.getEmail());
			stmt.setLong(4, usuario.getId());
			
				
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
}
