package br.com.enfermagem.model;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Paciente {
	
	private long id;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataHora;
	private String informante;
	private long sexo;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataNascimento;
	private long quantidadeFilhos;
	private long estadoCivil;
	private String profissao;
	private String endereco;
	private String naturalidade;
	private String motivoInternacao;
	private String diagnosticoMedico;
	private String historicoDoencaAtual;
	private String doencasGraveCronica;
	private long doenca;
	private String doencaObs;
	private String medicamentoUsoDomiciliar;
	private String alergiasMedicamentos;
	private String alergiasAlimentar;
	private String alergiasOutras;
	private String doencasInfancia;
	private String tratamentosAnteriores;
	private String internacoesAnteriores;
	private String cirurgias;
	private long historicoObstetricaGesta;
	private long historicoObstetricaPara;
	private long historicoObstetricaAborto;
	private String historicoFamiliar;
	private long fumante;
	private String fumanteObs;
	private long usoAlcool;
	private String usoAlcoolObs;
	private long usoDrogas;
	private String usoDrogasObs;
	private long historicoCancer;
	private String historicoCancerObs;
	private long condicaoMoradia;
	private long condicaoMoradiaSaneamentoBasico;
	private String condicaoMoradiaObs;
	private long saneamentoBasico;
	private String saneamentoBasicoObs;
	private long atividadeFisica;
	private long atividadeFisicaQtde;
	private String atividadeFisicaObs;
	private String atividadeFisicaVezesTipo;
	private long sonoRepouso;
	private long sonoRepousoHrs;
	private String sonoRepousoHrsObs;
	private String habitosHigieneBanho;
	private String habitosHigieneBucal;
	private long frutasVerduras;
	private long carneVermelha;
	private long peixe;
	private long frangoSuco;
	private long agua;
	private long cafe;
	private long leite;
	private long fritura;
	private long comeQuantasVezesDia;
	private String comeQuantasVezesDiaObs;
	
	private long habitosAlimentares;
	private String habitosAlimentaresVezesDiaObs;
	
	private String equilibrioEmocional;
	private long eliminacoesUrinarias;
	private String eliminacoesUrinariasObs;
	
	private long eliminacoesUrinariasNormais;
	private String eliminacoesUrinariasAlteracoes;
	private long eliminacoesIntestinais;
	private String eliminacoesIntestinaisObs;
	private long atividadeSexual;
	private long problemaSaude;
	private String problemaSaudeObs;
	
	private long conhecimentoProblemaSaude;
	private String conhecimentoProblemaSaudeObs;
	private long estadoNutricional;
	private float peso;
	private float altura;
	private long sinaisVitaisDor;
	private String sinaisVitaisDorObs;
	private float sinaisVitaisFR;
	private float sinaisVitaisFCPULSO;
	private float sinaisVitaisSAT;
	private float sinaisVitaisPA;
	private float sinaisVitaisTemp;
	
	private long idPacienteCaso;
	private long idPacienteUsuario;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Calendar getDataHora() {
		return dataHora;
	}
	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}
	public String getInformante() {
		return informante;
	}
	public void setInformante(String informante) {
		this.informante = informante;
	}
	public Long getSexo() {
		return sexo;
	}
	public void setSexo(Long sexo) {
		this.sexo = sexo;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Long getQuantidadeFilhos() {
		return quantidadeFilhos;
	}
	public void setQuantidadeFilhos(Long quantidadeFilhos) {
		this.quantidadeFilhos = quantidadeFilhos;
	}
	public Long getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(Long estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNaturalidade() {
		return naturalidade;
	}
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	public String getMotivoInternacao() {
		return motivoInternacao;
	}
	public void setMotivoInternacao(String motivoInternacao) {
		this.motivoInternacao = motivoInternacao;
	}
	public String getDiagnosticoMedico() {
		return diagnosticoMedico;
	}
	public void setDiagnosticoMedico(String diagnosticoMedico) {
		this.diagnosticoMedico = diagnosticoMedico;
	}
	public String getHistoricoDoencaAtual() {
		return historicoDoencaAtual;
	}
	public void setHistoricoDoencaAtual(String historicoDoencaAtual) {
		this.historicoDoencaAtual = historicoDoencaAtual;
	}
	public String getDoencasGraveCronica() {
		return doencasGraveCronica;
	}
	public void setDoencasGraveCronica(String doencasGraveCronica) {
		this.doencasGraveCronica = doencasGraveCronica;
	}
	public long getDoenca() {
		return doenca;
	}
	public void setDoenca(long doenca) {
		this.doenca = doenca;
	}
	public String getDoencaObs() {
		return doencaObs;
	}
	public void setDoencaObs(String doencaObs) {
		this.doencaObs = doencaObs;
	}
	public String getMedicamentoUsoDomiciliar() {
		return medicamentoUsoDomiciliar;
	}
	public void setMedicamentoUsoDomiciliar(String medicamentoUsoDomiciliar) {
		this.medicamentoUsoDomiciliar = medicamentoUsoDomiciliar;
	}
	public String getAlergiasMedicamentos() {
		return alergiasMedicamentos;
	}
	public void setAlergiasMedicamentos(String alergiasMedicamentos) {
		this.alergiasMedicamentos = alergiasMedicamentos;
	}
	public String getAlergiasAlimentar() {
		return alergiasAlimentar;
	}
	public void setAlergiasAlimentar(String alergiasAlimentar) {
		this.alergiasAlimentar = alergiasAlimentar;
	}
	public String getAlergiasOutras() {
		return alergiasOutras;
	}
	public void setAlergiasOutras(String alergiasOutras) {
		this.alergiasOutras = alergiasOutras;
	}
	public String getDoencasInfancia() {
		return doencasInfancia;
	}
	public void setDoencasInfancia(String doencasInfancia) {
		this.doencasInfancia = doencasInfancia;
	}
	public String getTratamentosAnteriores() {
		return tratamentosAnteriores;
	}
	public void setTratamentosAnteriores(String tratamentosAnteriores) {
		this.tratamentosAnteriores = tratamentosAnteriores;
	}
	public String getInternacoesAnteriores() {
		return internacoesAnteriores;
	}
	public void setInternacoesAnteriores(String internacoesAnteriores) {
		this.internacoesAnteriores = internacoesAnteriores;
	}
	public String getCirurgias() {
		return cirurgias;
	}
	public void setCirurgias(String cirurgias) {
		this.cirurgias = cirurgias;
	}
	public Long getHistoricoObstetricaGesta() {
		return historicoObstetricaGesta;
	}
	public void setHistoricoObstetricaGesta(Long historicoObstetricaGesta) {
		this.historicoObstetricaGesta = historicoObstetricaGesta;
	}
	public Long getHistoricoObstetricaPara() {
		return historicoObstetricaPara;
	}
	public void setHistoricoObstetricaPara(Long historicoObstetricaPara) {
		this.historicoObstetricaPara = historicoObstetricaPara;
	}
	public Long getHistoricoObstetricaAborto() {
		return historicoObstetricaAborto;
	}
	public void setHistoricoObstetricaAborto(Long historicoObstetricaAborto) {
		this.historicoObstetricaAborto = historicoObstetricaAborto;
	}
	public String getHistoricoFamiliar() {
		return historicoFamiliar;
	}
	public void setHistoricoFamiliar(String historicoFamiliar) {
		this.historicoFamiliar = historicoFamiliar;
	}
	public Long getFumante() {
		return fumante;
	}
	public void setFumante(Long fumante) {
		this.fumante = fumante;
	}
	public String getFumanteObs() {
		return fumanteObs;
	}
	public void setFumanteObs(String fumanteObs) {
		this.fumanteObs = fumanteObs;
	}
	public Long getUsoAlcool() {
		return usoAlcool;
	}
	public void setUsoAlcool(Long usoAlcool) {
		this.usoAlcool = usoAlcool;
	}
	public String getUsoAlcoolObs() {
		return usoAlcoolObs;
	}
	public void setUsoAlcoolObs(String usoAlcoolObs) {
		this.usoAlcoolObs = usoAlcoolObs;
	}
	public Long getUsoDrogas() {
		return usoDrogas;
	}
	public void setUsoDrogas(Long usoDrogas) {
		this.usoDrogas = usoDrogas;
	}
	public String getUsoDrogasObs() {
		return usoDrogasObs;
	}
	public void setUsoDrogasObs(String usoDrogasObs) {
		this.usoDrogasObs = usoDrogasObs;
	}
	public Long getHistoricoCancer() {
		return historicoCancer;
	}
	public void setHistoricoCancer(Long historicoCancer) {
		this.historicoCancer = historicoCancer;
	}
	public String getHistoricoCancerObs() {
		return historicoCancerObs;
	}
	public void setHistoricoCancerObs(String historicoCancerObs) {
		this.historicoCancerObs = historicoCancerObs;
	}
	public Long getCondicaoMoradia() {
		return condicaoMoradia;
	}
	public void setCondicaoMoradia(Long condicaoMoradia) {
		this.condicaoMoradia = condicaoMoradia;
	}
	public Long getCondicaoMoradiaSaneamentoBasico() {
		return condicaoMoradiaSaneamentoBasico;
	}
	public void setCondicaoMoradiaSaneamentoBasico(Long condicaoMoradiaSaneamentoBasico) {
		this.condicaoMoradiaSaneamentoBasico = condicaoMoradiaSaneamentoBasico;
	}
	public String getCondicaoMoradiaObs() {
		return condicaoMoradiaObs;
	}
	public void setCondicaoMoradiaObs(String condicaoMoradiaObs) {
		this.condicaoMoradiaObs = condicaoMoradiaObs;
	}
	public long getSaneamentoBasico() {
		return saneamentoBasico;
	}
	public void setSaneamentoBasico(long saneamentoBasico) {
		this.saneamentoBasico = saneamentoBasico;
	}
	public String getSaneamentoBasicoObs() {
		return saneamentoBasicoObs;
	}
	public void setSaneamentoBasicoObs(String saneamentoBasicoObs) {
		this.saneamentoBasicoObs = saneamentoBasicoObs;
	}
	public Long getAtividadeFisica() {
		return atividadeFisica;
	}
	public void setAtividadeFisica(Long atividadeFisica) {
		this.atividadeFisica = atividadeFisica;
	}
	public long getAtividadeFisicaQtde() {
		return atividadeFisicaQtde;
	}
	public void setAtividadeFisicaQtde(long atividadeFisicaQtde) {
		this.atividadeFisicaQtde = atividadeFisicaQtde;
	}
	public String getAtividadeFisicaObs() {
		return atividadeFisicaObs;
	}
	public void setAtividadeFisicaObs(String atividadeFisicaObs) {
		this.atividadeFisicaObs = atividadeFisicaObs;
	}
	public String getAtividadeFisicaVezesTipo() {
		return atividadeFisicaVezesTipo;
	}
	public void setAtividadeFisicaVezesTipo(String atividadeFisicaVezesTipo) {
		this.atividadeFisicaVezesTipo = atividadeFisicaVezesTipo;
	}
	public Long getSonoRepouso() {
		return sonoRepouso;
	}
	public void setSonoRepouso(Long sonoRepouso) {
		this.sonoRepouso = sonoRepouso;
	}
	public long getSonoRepousoHrs() {
		return sonoRepousoHrs;
	}
	public void setSonoRepousoHrs(long sonoRepousoHrs) {
		this.sonoRepousoHrs = sonoRepousoHrs;
	}
	public String getSonoRepousoHrsObs() {
		return sonoRepousoHrsObs;
	}
	public void setSonoRepousoHrsObs(String sonoRepousoHrsObs) {
		this.sonoRepousoHrsObs = sonoRepousoHrsObs;
	}
	public String getHabitosHigieneBanho() {
		return habitosHigieneBanho;
	}
	public void setHabitosHigieneBanho(String habitosHigieneBanho) {
		this.habitosHigieneBanho = habitosHigieneBanho;
	}
	public String getHabitosHigieneBucal() {
		return habitosHigieneBucal;
	}
	public void setHabitosHigieneBucal(String habitosHigieneBucal) {
		this.habitosHigieneBucal = habitosHigieneBucal;
	}
	public long getFrutasVerduras() {
		return frutasVerduras;
	}
	public void setFrutasVerduras(long frutasVerduras) {
		this.frutasVerduras = frutasVerduras;
	}
	public long getCarneVermelha() {
		return carneVermelha;
	}
	public void setCarneVermelha(long carneVermelha) {
		this.carneVermelha = carneVermelha;
	}
	public long getPeixe() {
		return peixe;
	}
	public void setPeixe(long peixe) {
		this.peixe = peixe;
	}
	public long getFrangoSuco() {
		return frangoSuco;
	}
	public void setFrangoSuco(long frangoSuco) {
		this.frangoSuco = frangoSuco;
	}
	public long getAgua() {
		return agua;
	}
	public void setAgua(long agua) {
		this.agua = agua;
	}
	public long getCafe() {
		return cafe;
	}
	public void setCafe(long cafe) {
		this.cafe = cafe;
	}
	public long getLeite() {
		return leite;
	}
	public void setLeite(long leite) {
		this.leite = leite;
	}
	public long getFritura() {
		return fritura;
	}
	public void setFritura(long fritura) {
		this.fritura = fritura;
	}
	public long getComeQuantasVezesDia() {
		return comeQuantasVezesDia;
	}
	public void setComeQuantasVezesDia(long comeQuantasVezesDia) {
		this.comeQuantasVezesDia = comeQuantasVezesDia;
	}
	public String getComeQuantasVezesDiaObs() {
		return comeQuantasVezesDiaObs;
	}
	public void setComeQuantasVezesDiaObs(String comeQuantasVezesDiaObs) {
		this.comeQuantasVezesDiaObs = comeQuantasVezesDiaObs;
	}
	public Long getHabitosAlimentares() {
		return habitosAlimentares;
	}
	public void setHabitosAlimentares(Long habitosAlimentares) {
		this.habitosAlimentares = habitosAlimentares;
	}
	public String getHabitosAlimentaresVezesDiaObs() {
		return habitosAlimentaresVezesDiaObs;
	}
	public void setHabitosAlimentaresVezesDiaObs(String habitosAlimentaresVezesDiaObs) {
		this.habitosAlimentaresVezesDiaObs = habitosAlimentaresVezesDiaObs;
	}
	public String getEquilibrioEmocional() {
		return equilibrioEmocional;
	}
	public void setEquilibrioEmocional(String equilibrioEmocional) {
		this.equilibrioEmocional = equilibrioEmocional;
	}
	public long getEliminacoesUrinarias() {
		return eliminacoesUrinarias;
	}
	public void setEliminacoesUrinarias(long eliminacoesUrinarias) {
		this.eliminacoesUrinarias = eliminacoesUrinarias;
	}
	public String getEliminacoesUrinariasObs() {
		return eliminacoesUrinariasObs;
	}
	public void setEliminacoesUrinariasObs(String eliminacoesUrinariasObs) {
		this.eliminacoesUrinariasObs = eliminacoesUrinariasObs;
	}
	public Long getEliminacoesUrinariasNormais() {
		return eliminacoesUrinariasNormais;
	}
	public void setEliminacoesUrinariasNormais(Long eliminacoesUrinariasNormais) {
		this.eliminacoesUrinariasNormais = eliminacoesUrinariasNormais;
	}
	public String getEliminacoesUrinariasAlteracoes() {
		return eliminacoesUrinariasAlteracoes;
	}
	public void setEliminacoesUrinariasAlteracoes(String eliminacoesUrinariasAlteracoes) {
		this.eliminacoesUrinariasAlteracoes = eliminacoesUrinariasAlteracoes;
	}
	public Long getEliminacoesIntestinais() {
		return eliminacoesIntestinais;
	}
	public void setEliminacoesIntestinais(Long eliminacoesIntestinais) {
		this.eliminacoesIntestinais = eliminacoesIntestinais;
	}
	public String getEliminacoesIntestinaisObs() {
		return eliminacoesIntestinaisObs;
	}
	public void setEliminacoesIntestinaisObs(String eliminacoesIntestinaisObs) {
		this.eliminacoesIntestinaisObs = eliminacoesIntestinaisObs;
	}
	public Long getAtividadeSexual() {
		return atividadeSexual;
	}
	public void setAtividadeSexual(Long atividadeSexual) {
		this.atividadeSexual = atividadeSexual;
	}
	public long getProblemaSaude() {
		return problemaSaude;
	}
	public void setProblemaSaude(long problemaSaude) {
		this.problemaSaude = problemaSaude;
	}
	public String getProblemaSaudeObs() {
		return problemaSaudeObs;
	}
	public void setProblemaSaudeObs(String problemaSaudeObs) {
		this.problemaSaudeObs = problemaSaudeObs;
	}
	public Long getConhecimentoProblemaSaude() {
		return conhecimentoProblemaSaude;
	}
	public void setConhecimentoProblemaSaude(Long conhecimentoProblemaSaude) {
		this.conhecimentoProblemaSaude = conhecimentoProblemaSaude;
	}
	public String getConhecimentoProblemaSaudeObs() {
		return conhecimentoProblemaSaudeObs;
	}
	public void setConhecimentoProblemaSaudeObs(String conhecimentoProblemaSaudeObs) {
		this.conhecimentoProblemaSaudeObs = conhecimentoProblemaSaudeObs;
	}
	public Long getEstadoNutricional() {
		return estadoNutricional;
	}
	public void setEstadoNutricional(Long estadoNutricional) {
		this.estadoNutricional = estadoNutricional;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public Long getSinaisVitaisDor() {
		return sinaisVitaisDor;
	}
	public void setSinaisVitaisDor(Long sinaisVitaisDor) {
		this.sinaisVitaisDor = sinaisVitaisDor;
	}
	public String getSinaisVitaisDorObs() {
		return sinaisVitaisDorObs;
	}
	public void setSinaisVitaisDorObs(String sinaisVitaisDorObs) {
		this.sinaisVitaisDorObs = sinaisVitaisDorObs;
	}
	public float getSinaisVitaisFR() {
		return sinaisVitaisFR;
	}
	public void setSinaisVitaisFR(float sinaisVitaisFR) {
		this.sinaisVitaisFR = sinaisVitaisFR;
	}
	public float getSinaisVitaisFCPULSO() {
		return sinaisVitaisFCPULSO;
	}
	public void setSinaisVitaisFCPULSO(float sinaisVitaisFCPULSO) {
		this.sinaisVitaisFCPULSO = sinaisVitaisFCPULSO;
	}
	public float getSinaisVitaisSAT() {
		return sinaisVitaisSAT;
	}
	public void setSinaisVitaisSAT(float sinaisVitaisSAT) {
		this.sinaisVitaisSAT = sinaisVitaisSAT;
	}
	public float getSinaisVitaisPA() {
		return sinaisVitaisPA;
	}
	public void setSinaisVitaisPA(float sinaisVitaisPA) {
		this.sinaisVitaisPA = sinaisVitaisPA;
	}	
	public float getSinaisVitaisTemp() {
		return sinaisVitaisTemp;
	}
	public void setSinaisVitaisTemp(float sinaisVitaisTemp) {
		this.sinaisVitaisTemp = sinaisVitaisTemp;
	}
	public Long getIdPacienteCaso() {
		return idPacienteCaso;
	}
	public void setIdPacienteCaso(Long idPacienteCaso) {
		this.idPacienteCaso = idPacienteCaso;
	}
	public Long getIdPacienteUsuario() {
		return idPacienteUsuario;
	}
	public void setIdPacienteUsuario(Long idPacienteUsuario) {
		this.idPacienteUsuario = idPacienteUsuario;
	}
	
}