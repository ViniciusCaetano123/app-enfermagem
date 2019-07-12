package br.com.enfermagem.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.enfermagem.model.Paciente;

@Repository
public class PacienteDAO {
	Connection connection;
	
	@Autowired
	public PacienteDAO(DataSource dataSource) throws ClassNotFoundException{
		try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void adiciona(Paciente paciente){
		String sql = "insert into pacientes (idPacienteCaso , idPacienteUsuario) " +
					"values (?, ?)";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, paciente.getIdPacienteCaso());
			stmt.setLong(2, paciente.getIdPacienteUsuario());
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public List<Paciente> lista(){
		try{
			List<Paciente> pacientes = new ArrayList<Paciente>();
			PreparedStatement stmt = this.connection.prepareStatement
			("SELECT * FROM pacientes ORDER BY dataHora DESC");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				Paciente paciente = new Paciente();
				
				paciente.setId(rs.getLong("id"));
				paciente.setIdPacienteCaso(rs.getLong("idPacienteCaso"));
				paciente.setIdPacienteUsuario(rs.getLong("idPacienteUsuario"));
				
				if(rs.getDate("dataHora") != null){
					Calendar dataHora = Calendar.getInstance();
					dataHora.setTime(rs.getDate("dataHora"));
					paciente.setDataHora(dataHora);
				}
				
				pacientes.add(paciente);
			}
			rs.close();
			stmt.close();
			return pacientes;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public List<Paciente> listaPacientesCaso(Long idCaso) {
		try {
			
			List<Paciente> listaPacientes = new ArrayList<Paciente>();
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM pacientes paciente WHERE paciente.idPacienteCaso = "+ idCaso +" ORDER BY dataHora DESC");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				listaPacientes.add(resultSetPaciente(rs));
			}
			
			rs.close();
			stmt.close();
			return listaPacientes;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
public Paciente buscaPorId(Long id){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from pacientes");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{

				if(id == rs.getLong("id"))
				{
					Paciente paciente = new Paciente();

					paciente.setId(rs.getLong("id"));
					paciente.setInformante(rs.getString("informante"));
					paciente.setSexo(rs.getLong("sexo"));		
					if(rs.getDate("dataNascimento") != null){
						Calendar dataNascimento = Calendar.getInstance();
						dataNascimento.setTime(rs.getDate("dataNascimento"));
						paciente.setDataNascimento(dataNascimento);
					}
					paciente.setQuantidadeFilhos(rs.getLong("quantidadeFilhos"));
					paciente.setEstadoCivil(rs.getLong("estadoCivil"));
					paciente.setProfissao(rs.getString("profissao"));
					paciente.setEndereco(rs.getString("endereco"));
					paciente.setNaturalidade(rs.getString("naturalidade"));
					paciente.setMotivoInternacao(rs.getString("motivoInternacao"));
					paciente.setDiagnosticoMedico(rs.getString("diagnosticoMedico"));
					paciente.setHistoricoDoencaAtual(rs.getString("historicoDoencaAtual"));
					paciente.setDoencasGraveCronica(rs.getString("doencasGraveCronica"));
					paciente.setDoenca(rs.getLong("doenca"));
					paciente.setDoencaObs(rs.getString("doencaObs"));
					paciente.setMedicamentoUsoDomiciliar(rs.getString("medicamentoUsoDomiciliar"));
					paciente.setAlergiasMedicamentos(rs.getString("alergiasMedicamentos"));
					paciente.setAlergiasAlimentar(rs.getString("alergiasAlimentar"));
					paciente.setAlergiasOutras(rs.getString("alergiasOutras"));
					paciente.setDoencasInfancia(rs.getString("doencasInfancia"));
					paciente.setTratamentosAnteriores(rs.getString("tratamentosAnteriores"));
					paciente.setInternacoesAnteriores(rs.getString("internacoesAnteriores"));
					paciente.setCirurgias(rs.getString("cirurgias"));
					paciente.setHistoricoObstetricaGesta(rs.getLong("historicoObstetricaGesta"));
					paciente.setHistoricoObstetricaPara(rs.getLong("historicoObstetricaPara"));
					paciente.setHistoricoObstetricaAborto(rs.getLong("historicoObstetricaAborto"));
					paciente.setHistoricoFamiliar(rs.getString("historicoFamiliar"));
					paciente.setFumante(rs.getLong("fumante"));
					paciente.setFumanteObs(rs.getString("fumanteObs"));
					paciente.setUsoAlcool(rs.getLong("usoAlcool"));
					paciente.setUsoAlcoolObs(rs.getString("usoAlcoolObs"));
					paciente.setUsoDrogas(rs.getLong("usoDrogas"));
					paciente.setUsoDrogasObs(rs.getString("usoDrogasObs"));
					paciente.setHistoricoCancer(rs.getLong("historicoCancer"));
					paciente.setHistoricoCancerObs(rs.getString("historicoCancerObs"));
					paciente.setCondicaoMoradia(rs.getLong("condicaoMoradia"));
					paciente.setCondicaoMoradiaSaneamentoBasico(rs.getLong("condicaoMoradiaSaneamentoBasico"));	
					paciente.setCondicaoMoradiaObs(rs.getString("condicaoMoradiaObs"));
					paciente.setSaneamentoBasico(rs.getLong("saneamentoBasico"));
					paciente.setSaneamentoBasicoObs(rs.getString("saneamentoBasicoObs"));
					paciente.setAtividadeFisica(rs.getLong("atividadeFisica"));
					paciente.setAtividadeFisicaQtde(rs.getLong("atividadeFisicaQtde"));
					paciente.setAtividadeFisicaObs(rs.getString("atividadeFisicaObs"));
					paciente.setAtividadeFisicaVezesTipo(rs.getString("atividadeFisicaVezesTipo"));
					paciente.setSonoRepouso(rs.getLong("sonoRepouso"));
					paciente.setSonoRepousoHrs(rs.getLong("sonoRepousoHrs"));
					paciente.setSonoRepousoHrsObs(rs.getString("sonoRepousoHrsObs"));
					paciente.setHabitosHigieneBanho(rs.getString("habitosHigieneBanho"));
					paciente.setHabitosHigieneBucal(rs.getString("HabitosHigieneBucal"));
					paciente.setFrutasVerduras(rs.getLong("frutasVerduras"));
					paciente.setCarneVermelha(rs.getLong("carneVermelha"));
					paciente.setPeixe(rs.getLong("peixe"));
					paciente.setFrangoSuco(rs.getLong("frangoSuco"));
					paciente.setAgua(rs.getLong("agua"));
					paciente.setCafe(rs.getLong("cafe"));
					paciente.setLeite(rs.getLong("leite"));
					paciente.setFritura(rs.getLong("fritura"));
					paciente.setComeQuantasVezesDia(rs.getLong("comeQuantasVezesDia"));
					paciente.setComeQuantasVezesDiaObs(rs.getString("comeQuantasVezesDiaObs"));
					paciente.setHabitosAlimentares(rs.getLong("habitosAlimentares"));
					paciente.setHabitosAlimentaresVezesDiaObs(rs.getString("habitosAlimentaresVezesDiaObs"));
					paciente.setEquilibrioEmocional(rs.getString("equilibrioEmocional"));
					paciente.setEliminacoesUrinarias(rs.getLong("eliminacoesUrinarias"));
					paciente.setEliminacoesUrinariasObs(rs.getString("eliminacoesUrinariasObs"));
					paciente.setEliminacoesUrinariasNormais(rs.getLong("eliminacoesUrinariasNormais"));
					paciente.setEliminacoesUrinariasAlteracoes(rs.getString("eliminacoesUrinariasAlteracoes"));
					paciente.setEliminacoesIntestinais(rs.getLong("eliminacoesIntestinais"));
					paciente.setEliminacoesIntestinaisObs(rs.getString("eliminacoesIntestinaisObs"));
					paciente.setAtividadeSexual(rs.getLong("atividadeSexual"));
					paciente.setProblemaSaude(rs.getLong("problemaSaude"));
					paciente.setProblemaSaudeObs(rs.getString("problemaSaudeObs"));
					paciente.setConhecimentoProblemaSaude(rs.getLong("conhecimentoProblemaSaude"));
					paciente.setConhecimentoProblemaSaudeObs(rs.getString("conhecimentoProblemaSaudeObs"));
					paciente.setEstadoNutricional(rs.getLong("estadoNutricional"));
					paciente.setPeso(rs.getFloat("peso")); 
					paciente.setAltura(rs.getFloat("altura"));
					paciente.setSinaisVitaisDor(rs.getLong("sinaisVitaisDor"));
					paciente.setSinaisVitaisDorObs(rs.getString("sinaisVitaisDorObs"));
					paciente.setSinaisVitaisFR(rs.getFloat("sinaisVitaisFR"));
					paciente.setSinaisVitaisFCPULSO(rs.getFloat("sinaisVitaisFCPULSO"));
					paciente.setSinaisVitaisSAT(rs.getFloat("sinaisVitaisSAT"));
					paciente.setSinaisVitaisPA(rs.getFloat("sinaisVitaisPA"));
					paciente.setSinaisVitaisTemp(rs.getFloat("sinaisVitaisTemp"));
					paciente.setIdPacienteCaso(rs.getLong("idPacienteCaso"));
					paciente.setIdPacienteUsuario(rs.getLong("idPacienteUsuario"));

					return paciente;
				}
			}
				return null;
			}catch(SQLException e){
				throw new RuntimeException(e);
			}	
	}
	
	public Paciente resultSetPaciente(ResultSet rs) throws SQLException {
		Paciente paciente = new Paciente();

		paciente.setId(rs.getLong("id"));
		paciente.setInformante(rs.getString("informante"));
		paciente.setSexo(rs.getLong("sexo"));		
		if(rs.getDate("dataNascimento") != null){
			Calendar dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(rs.getDate("dataNascimento"));
			paciente.setDataNascimento(dataNascimento);
		}
		paciente.setQuantidadeFilhos(rs.getLong("quantidadeFilhos"));
		paciente.setEstadoCivil(rs.getLong("estadoCivil"));
		paciente.setProfissao(rs.getString("profissao"));
		paciente.setEndereco(rs.getString("endereco"));
		paciente.setNaturalidade(rs.getString("naturalidade"));
		paciente.setMotivoInternacao(rs.getString("motivoInternacao"));
		paciente.setDiagnosticoMedico(rs.getString("diagnosticoMedico"));
		paciente.setHistoricoDoencaAtual(rs.getString("historicoDoencaAtual"));
		paciente.setDoencasGraveCronica(rs.getString("doencasGraveCronica"));
		paciente.setDoenca(rs.getLong("doenca"));
		paciente.setDoencaObs(rs.getString("doencaObs"));
		paciente.setMedicamentoUsoDomiciliar(rs.getString("medicamentoUsoDomiciliar"));
		paciente.setAlergiasMedicamentos(rs.getString("alergiasMedicamentos"));
		paciente.setAlergiasAlimentar(rs.getString("alergiasAlimentar"));
		paciente.setAlergiasOutras(rs.getString("alergiasOutras"));
		paciente.setDoencasInfancia(rs.getString("doencasInfancia"));
		paciente.setTratamentosAnteriores(rs.getString("tratamentosAnteriores"));
		paciente.setInternacoesAnteriores(rs.getString("internacoesAnteriores"));
		paciente.setCirurgias(rs.getString("cirurgias"));
		paciente.setHistoricoObstetricaGesta(rs.getLong("historicoObstetricaGesta"));
		paciente.setHistoricoObstetricaPara(rs.getLong("historicoObstetricaPara"));
		paciente.setHistoricoObstetricaAborto(rs.getLong("historicoObstetricaAborto"));
		paciente.setHistoricoFamiliar(rs.getString("historicoFamiliar"));
		paciente.setFumante(rs.getLong("fumante"));
		paciente.setFumanteObs(rs.getString("fumanteObs"));
		paciente.setUsoAlcool(rs.getLong("usoAlcool"));
		paciente.setUsoAlcoolObs(rs.getString("usoAlcoolObs"));
		paciente.setUsoDrogas(rs.getLong("usoDrogas"));
		paciente.setUsoDrogasObs(rs.getString("usoDrogasObs"));
		paciente.setHistoricoCancer(rs.getLong("historicoCancer"));
		paciente.setHistoricoCancerObs(rs.getString("historicoCancerObs"));
		paciente.setCondicaoMoradia(rs.getLong("condicaoMoradia"));
		paciente.setCondicaoMoradiaSaneamentoBasico(rs.getLong("condicaoMoradiaSaneamentoBasico"));	
		paciente.setCondicaoMoradiaObs(rs.getString("condicaoMoradiaObs"));
		paciente.setSaneamentoBasico(rs.getLong("saneamentoBasico"));
		paciente.setSaneamentoBasicoObs(rs.getString("saneamentoBasicoObs"));
		paciente.setAtividadeFisica(rs.getLong("atividadeFisica"));
		paciente.setAtividadeFisicaQtde(rs.getLong("atividadeFisicaQtde"));
		paciente.setAtividadeFisicaObs(rs.getString("atividadeFisicaObs"));
		paciente.setAtividadeFisicaVezesTipo(rs.getString("atividadeFisicaVezesTipo"));
		paciente.setSonoRepouso(rs.getLong("sonoRepouso"));
		paciente.setSonoRepousoHrs(rs.getLong("sonoRepousoHrs"));
		paciente.setSonoRepousoHrsObs(rs.getString("sonoRepousoHrsObs"));
		paciente.setHabitosHigieneBanho(rs.getString("habitosHigieneBanho"));
		paciente.setHabitosHigieneBucal(rs.getString("HabitosHigieneBucal"));
		paciente.setFrutasVerduras(rs.getLong("frutasVerduras"));
		paciente.setCarneVermelha(rs.getLong("carneVermelha"));
		paciente.setPeixe(rs.getLong("peixe"));
		paciente.setFrangoSuco(rs.getLong("frangoSuco"));
		paciente.setAgua(rs.getLong("agua"));
		paciente.setCafe(rs.getLong("cafe"));
		paciente.setLeite(rs.getLong("leite"));
		paciente.setFritura(rs.getLong("fritura"));
		paciente.setComeQuantasVezesDia(rs.getLong("comeQuantasVezesDia"));
		paciente.setComeQuantasVezesDiaObs(rs.getString("comeQuantasVezesDiaObs"));
		paciente.setHabitosAlimentares(rs.getLong("habitosAlimentares"));
		paciente.setHabitosAlimentaresVezesDiaObs(rs.getString("habitosAlimentaresVezesDiaObs"));
		paciente.setEquilibrioEmocional(rs.getString("equilibrioEmocional"));
		paciente.setEliminacoesUrinarias(rs.getLong("eliminacoesUrinarias"));
		paciente.setEliminacoesUrinariasObs(rs.getString("eliminacoesUrinariasObs"));
		paciente.setEliminacoesUrinariasNormais(rs.getLong("eliminacoesUrinariasNormais"));
		paciente.setEliminacoesUrinariasAlteracoes(rs.getString("eliminacoesUrinariasAlteracoes"));
		paciente.setEliminacoesIntestinais(rs.getLong("eliminacoesIntestinais"));
		paciente.setEliminacoesIntestinaisObs(rs.getString("eliminacoesIntestinaisObs"));
		paciente.setAtividadeSexual(rs.getLong("atividadeSexual"));
		paciente.setProblemaSaude(rs.getLong("problemaSaude"));
		paciente.setProblemaSaudeObs(rs.getString("problemaSaudeObs"));
		paciente.setConhecimentoProblemaSaude(rs.getLong("conhecimentoProblemaSaude"));
		paciente.setConhecimentoProblemaSaudeObs(rs.getString("conhecimentoProblemaSaudeObs"));
		paciente.setEstadoNutricional(rs.getLong("estadoNutricional"));
		paciente.setPeso(rs.getFloat("peso")); 
		paciente.setAltura(rs.getFloat("altura"));
		paciente.setSinaisVitaisDor(rs.getLong("sinaisVitaisDor"));
		paciente.setSinaisVitaisDorObs(rs.getString("sinaisVitaisDorObs"));
		paciente.setSinaisVitaisFR(rs.getFloat("sinaisVitaisFR"));
		paciente.setSinaisVitaisFCPULSO(rs.getFloat("sinaisVitaisFCPULSO"));
		paciente.setSinaisVitaisSAT(rs.getFloat("sinaisVitaisSAT"));
		paciente.setSinaisVitaisPA(rs.getFloat("sinaisVitaisPA"));
		paciente.setSinaisVitaisTemp(rs.getFloat("sinaisVitaisTemp"));
		paciente.setIdPacienteCaso(rs.getLong("idPacienteCaso"));
		paciente.setIdPacienteUsuario(rs.getLong("idPacienteUsuario"));

		return paciente;
	}
	
	public void altera(Paciente paciente){
		
		String sql = "update pacientes set "
				+ "informante=?, "
				+ "sexo=?, "
				+ "dataNascimento=?, "
				+ "quantidadeFilhos=?, "
				+ "estadoCivil=?, "
				+ "profissao=?, "
				+ "endereco=?, "
				+ "naturalidade=?, "
				+ "motivoInternacao=?, "
				+ "diagnosticoMedico=?, "
				+ "historicoDoencaAtual=?, "
				+ "doencasGraveCronica=?, "
				+ "doenca=?, "
				+ "doencaObs=?, "
				+ "medicamentoUsoDomiciliar=?, "
				+ "alergiasMedicamentos=?, "
				+ "alergiasAlimentar=?, "
				+ "alergiasOutras=?, "
				+ "doencasInfancia=?, "
				+ "tratamentosAnteriores=?, "
				+ "internacoesAnteriores=?, "
				+ "cirurgias=?, "
				+ "historicoObstetricaGesta=?, "
				+ "historicoObstetricaPara=?, "
				+ "historicoObstetricaAborto=?, "
				+ "historicoFamiliar=?,"
				+ "fumante=?, "
				+ "fumanteObs=?, "
				+ "usoAlcool=?, "
				+ "usoAlcoolObs=?, "
				+ "usoDrogas=?, "
				+ "usoDrogasObs=?, "
				+ "historicoCancer=?, "
				+ "historicoCancerObs=?, "
				+ "condicaoMoradia=?, "
				+ "condicaoMoradiaSaneamentoBasico=?, "
				+ "condicaoMoradiaObs=?, "
				+ "saneamentoBasico=?, "
				+ "saneamentoBasicoObs=?, "
				+ "atividadeFisica=?, "
				+ "atividadeFisicaQtde=?, "
				+ "atividadeFisicaObs=?, "
				+ "atividadeFisicaVezesTipo=?, "
				+ "sonoRepouso=?, "
				+ "sonoRepousoHrs=?, "
				+ "sonoRepousoHrsObs=?, "
				+ "habitosHigieneBanho=?, "
				+ "habitosHigieneBucal=?, "
				+ "frutasVerduras=?, "
				+ "carneVermelha=?, "
				+ "peixe=?, "
				+ "frangoSuco=?, "
				+ "agua=?, "
				+ "cafe=?, "
				+ "leite=?, "
				+ "fritura=?, "
				+ "comeQuantasVezesDia=?, "
				+ "comeQuantasVezesDiaObs=?, "
				+ "habitosAlimentares=?, "
				+ "habitosAlimentaresVezesDiaObs=?, "
				+ "equilibrioEmocional=?, "
				+ "eliminacoesUrinarias=?, 	"
				+ "eliminacoesUrinariasObs=?, "
				+ "eliminacoesUrinariasNormais=?, 	"
				+ "eliminacoesUrinariasAlteracoes=?, "
				+ "eliminacoesIntestinais=?, "
				+ "eliminacoesIntestinaisObs=?, "
				+ "atividadeSexual=?, "
				+ "problemaSaude=?, "
				+ "problemaSaudeObs=?, "
				+ "conhecimentoProblemaSaude=?, "
				+ "conhecimentoProblemaSaudeObs=?, "
				+ "estadoNutricional=?, "
				+ "peso=?, "
				+ "altura=?, "
				+ "sinaisVitaisDor=?, "
				+ "sinaisVitaisDorObs=?, "
				+ "sinaisVitaisFR=?, "
				+ "sinaisVitaisFCPULSO=?, "
				+ "sinaisVitaisSAT=?, "
				+ "sinaisVitaisPA=?, "
				+ "sinaisVitaisTemp=? "
				
				+ "where id=? ";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
					
			stmt.setString(1, paciente.getInformante());
			stmt.setLong(2, paciente.getSexo());
			if(paciente.getDataNascimento() != null)
			{
				stmt.setDate(3, new Date(paciente.getDataNascimento().getTimeInMillis()));
			}
			else
			{
				stmt.setDate(3, null);
			}
			stmt.setLong(4, paciente.getQuantidadeFilhos());
			stmt.setLong(5, paciente.getEstadoCivil());
			stmt.setString(6, paciente.getProfissao());
			stmt.setString(7, paciente.getEndereco());
			stmt.setString(8, paciente.getNaturalidade());
			stmt.setString(9, paciente.getMotivoInternacao());
			stmt.setString(10, paciente.getDiagnosticoMedico());
			stmt.setString(11, paciente.getHistoricoDoencaAtual());
			
			stmt.setString(12, paciente.getDoencasGraveCronica());
			
			stmt.setLong(13, paciente.getDoenca());
			stmt.setString(14, paciente.getDoencaObs());
			stmt.setString(15, paciente.getMedicamentoUsoDomiciliar());
			stmt.setString(16, paciente.getAlergiasMedicamentos());
			stmt.setString(17, paciente.getAlergiasAlimentar());
			stmt.setString(18, paciente.getAlergiasOutras());
			stmt.setString(19, paciente.getDoencasInfancia());
			stmt.setString(20, paciente.getTratamentosAnteriores());
			stmt.setString(21, paciente.getInternacoesAnteriores());
			stmt.setString(22, paciente.getCirurgias());
			stmt.setLong(23, paciente.getHistoricoObstetricaGesta());
			stmt.setLong(24, paciente.getHistoricoObstetricaPara());
			stmt.setLong(25, paciente.getHistoricoObstetricaAborto());
			stmt.setString(26, paciente.getHistoricoFamiliar());
			stmt.setLong(27, paciente.getFumante());
			stmt.setString(28, paciente.getFumanteObs());
			stmt.setLong(29, paciente.getUsoAlcool());
			stmt.setString(30, paciente.getUsoAlcoolObs());
			stmt.setLong(31, paciente.getUsoDrogas());
			stmt.setString(32, paciente.getUsoDrogasObs());
			stmt.setLong(33, paciente.getHistoricoCancer());
			stmt.setString(34, paciente.getHistoricoCancerObs());
			stmt.setLong(35, paciente.getCondicaoMoradia());
			
			stmt.setLong(36, paciente.getCondicaoMoradiaSaneamentoBasico());
			
			stmt.setString(37, paciente.getCondicaoMoradiaObs());
			stmt.setLong(38, paciente.getSaneamentoBasico());
			stmt.setString(39, paciente.getSaneamentoBasicoObs());
			stmt.setLong(40, paciente.getAtividadeFisica());
			stmt.setLong(41, paciente.getAtividadeFisicaQtde());
			stmt.setString(42, paciente.getAtividadeFisicaObs());
			
			stmt.setString(43, paciente.getAtividadeFisicaVezesTipo());
			
			stmt.setLong(44, paciente.getSonoRepouso());
			stmt.setLong(45, paciente.getSonoRepousoHrs());
			stmt.setString(46, paciente.getSonoRepousoHrsObs());
			stmt.setString(47, paciente.getHabitosHigieneBanho());
			stmt.setString(48, paciente.getHabitosHigieneBucal());
			stmt.setLong(49, paciente.getFrutasVerduras());
			stmt.setLong(50, paciente.getCarneVermelha());
			stmt.setLong(51, paciente.getPeixe());
			stmt.setLong(52, paciente.getFrangoSuco());
			stmt.setLong(53, paciente.getAgua());
			stmt.setLong(54, paciente.getCafe());
			stmt.setLong(55, paciente.getLeite());
			stmt.setLong(56, paciente.getFritura());
			stmt.setLong(57, paciente.getComeQuantasVezesDia());
			stmt.setString(58, paciente.getComeQuantasVezesDiaObs());
			
			stmt.setLong(59, paciente.getHabitosAlimentares());
			stmt.setString(60, paciente.getHabitosAlimentaresVezesDiaObs());
			
			stmt.setString(61, paciente.getEquilibrioEmocional());
			stmt.setLong(62, paciente.getEliminacoesUrinarias());
			stmt.setString(63, paciente.getEliminacoesUrinariasObs());
			
			stmt.setLong(64, paciente.getEliminacoesUrinariasNormais());
			stmt.setString(65, paciente.getEliminacoesUrinariasAlteracoes());
			stmt.setLong(66, paciente.getEliminacoesIntestinais());
			stmt.setString(67, paciente.getEliminacoesIntestinaisObs());
			stmt.setLong(68, paciente.getAtividadeSexual());
			stmt.setLong(69, paciente.getProblemaSaude());
			stmt.setString(70, paciente.getProblemaSaudeObs());
			
			stmt.setLong(71, paciente.getConhecimentoProblemaSaude());
			stmt.setString(72, paciente.getConhecimentoProblemaSaudeObs());
			stmt.setLong(73, paciente.getEstadoNutricional());
			stmt.setFloat(74, paciente.getPeso());
			stmt.setFloat(75, paciente.getAltura());
			stmt.setLong(76, paciente.getSinaisVitaisDor());
			stmt.setString(77, paciente.getSinaisVitaisDorObs());
			stmt.setFloat(78, paciente.getSinaisVitaisFR());
			stmt.setFloat(79, paciente.getSinaisVitaisFCPULSO());
			stmt.setFloat(80, paciente.getSinaisVitaisSAT());
			stmt.setFloat(81, paciente.getSinaisVitaisPA());
			stmt.setFloat(82, paciente.getSinaisVitaisTemp());
			stmt.setLong(83, paciente.getId());
			
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void remove(Paciente paciente){
		try{
			PreparedStatement stmt = this.connection.prepareStatement
			("delete from pacientes where id = ?");
			
			stmt.setLong(1, paciente.getId());
			
			stmt.execute();
			stmt.close();

			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

}