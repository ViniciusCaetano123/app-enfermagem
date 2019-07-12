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

import br.com.enfermagem.model.Caso;

@Repository
public class CasoDAO {
	Connection connection;

	@Autowired
	public CasoDAO(DataSource dataSource) throws ClassNotFoundException {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void adiciona(Caso caso) {
		String sql = "insert into casos (identificacao , idCasoUsuario) values (?, ?)";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, caso.getIdentificacao());
			stmt.setLong(2, caso.getIdCasoUsuario());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Caso> lista() {
		try {
			List<Caso> casos = new ArrayList<Caso>();
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM casos ORDER BY dataHora DESC");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Caso caso = new Caso();

				caso.setId(rs.getLong("id"));
				caso.setIdentificacao(rs.getString("identificacao"));
				caso.setCode(rs.getString("code"));
				caso.setIdCasoUsuario(rs.getLong("idCasoUsuario"));
				if (rs.getDate("dataHora") != null) {
					Calendar dataHora = Calendar.getInstance();
					dataHora.setTime(rs.getDate("dataHora"));
					caso.setDataHora(dataHora);
				}
				casos.add(caso);
			}
			rs.close();
			stmt.close();
			return casos;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Caso caso) {
		try {
			PreparedStatement stmt = this.connection.prepareStatement("delete from casos where id = ?");

			stmt.setLong(1, caso.getId());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void copiaPorId(Caso caso) {
		try {
			PreparedStatement stmt = this.connection.prepareStatement("call copiaCaso(?)");

			stmt.setLong(1, caso.getId());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	

	public Caso buscaPorId(Long id) {

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from casos");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				if (id == rs.getLong("id")) {
					Caso caso = new Caso();

					caso.setId(rs.getLong("id"));
					caso.setIdentificacao(rs.getString("identificacao"));
					caso.setCode(rs.getString("code"));
					caso.setIdCasoUsuario(rs.getLong("idCasoUsuario"));

					return caso;
				}
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Caso buscaPorCode(String code) {

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from casos where code = ?");
			stmt.setString(1, code);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Caso caso = new Caso();
				
				caso.setId(rs.getLong("id"));
				caso.setIdentificacao(rs.getString("identificacao"));
				caso.setCode(rs.getString("code"));
				caso.setIdCasoUsuario(rs.getLong("idCasoUsuario"));

				return caso;
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Caso caso) {
		String sql = "update casos set identificacao=? where id=?";

		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, caso.getIdentificacao());
			stmt.setLong(2, caso.getId());
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
