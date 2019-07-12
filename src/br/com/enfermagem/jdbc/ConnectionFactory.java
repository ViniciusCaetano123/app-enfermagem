package br.com.enfermagem.jdbc;

import java.sql.*;
public class ConnectionFactory {
	
	public Connection getConnection() throws ClassNotFoundException{
		
		Class.forName("com.mysql.jdbc.Driver");
        try {
        	return DriverManager.getConnection("jdbc:mysql://184.107.94.187/simulador", "simulador", "simulador$123456");
        }catch(SQLException e){
        	System.out.println("Erro de conexao");
			throw new RuntimeException(e+"\nNAO FOI POSSIVEL CONECTAR NO BANCO DE DADOS");
		}
	}
}
