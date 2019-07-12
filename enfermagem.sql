--
-- Database: `simulador`
--

CREATE DATABASE `silulador`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `casos`
--

CREATE TABLE `casos` (
  `id` bigint(20) NOT NULL,
  `dataHora` timestamp NOT NULL,
  `identificacao` varchar(250) NOT NULL,
  `code` varchar(5),
  `idCasoUsuario` bigint(20) NOT NULL
);

--
-- Acionadores `casos`
--
DELIMITER $$
CREATE TRIGGER `geraCode` BEFORE INSERT ON `casos`
 FOR EACH ROW SET NEW.code = UPPER(MD5(NOW()))
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `comentarios`
--

CREATE TABLE `comentarios` (
  `id` bigint(20) NOT NULL,
  `dataHora` timestamp NOT NULL,
  `comentario` text NOT NULL,
  `idComentarioPaciente` bigint(20) NOT NULL
);

-- --------------------------------------------------------

--
-- Estrutura da tabela `evolucoes`
--

CREATE TABLE `evolucoes` (
  `id` bigint(20) NOT NULL,
  `dataHora` timestamp NOT NULL,
  `descricaoSubjetivo` text NOT NULL,
  `descricaoObjetivo` text NOT NULL,
  `descricaoImpressao` text NOT NULL,
  `descricaoConduta` text NOT NULL,
  `descricaoCondigodiagnostico` text NOT NULL,
  `idEvolucaoPaciente` bigint(20) NOT NULL
);



-- --------------------------------------------------------

--
-- Estrutura da tabela `fluxo24hs`
--

CREATE TABLE `fluxo24hs` (
  `id` bigint(20) NOT NULL,
  `dataHora` timestamp NOT NULL,
  `cod` bigint(20) NOT NULL,
  `pa` char(10) NOT NULL,
  `fc` char(10) NOT NULL,
  `fr` char(10) NOT NULL,
  `tax` char(10) NOT NULL,
  `dor` char(10) NOT NULL,
  `sat` char(10) NOT NULL,
  `pvc` char(10) NOT NULL,
  `hgt` char(10) NOT NULL,
  `administrados` text NOT NULL,
  `eliminados` text NOT NULL,
  `observacoes` text NOT NULL,
  `idFluxo24hPaciente` bigint(20) NOT NULL
);


--
-- Estrutura da tabela `pacientes`
--

CREATE TABLE `pacientes` (
  `id` bigint(20) NOT NULL,
  `dataHora` timestamp NOT NULL,
  `informante` varchar(100) NULL,
  `sexo` bigint(5) NULL,
  `dataNascimento` date NULL,
  `quantidadeFilhos` bigint(5) NULL,
  `estadoCivil` bigint(5) NULL,
  `profissao` varchar(20) NULL,
  `endereco` varchar(200) NULL,
  `naturalidade` varchar(100) NULL,
  `motivoInternacao` text,
  `diagnosticoMedico` text,
  `historicoDoencaAtual` text,
  `doencasGraveCronica` text,
  `doenca` bigint(20) NULL,
  `doencaObs` text,
  `medicamentoUsoDomiciliar` text,
  `alergiasMedicamentos` text,
  `alergiasAlimentar` text,
  `alergiasOutras` text,
  `doencasInfancia` text,
  `tratamentosAnteriores` text,
  `internacoesAnteriores` text,
  `cirurgias` text,
  `historicoObstetricaGesta` bigint(5) NULL,
  `historicoObstetricaPara` bigint(5) NULL,
  `historicoObstetricaAborto` bigint(5) NULL,
  `historicoFamiliar` text,
  `fumante` bigint(5) NULL,
  `fumanteObs` text,
  `usoAlcool` bigint(5) NULL,
  `usoAlcoolObs` text,
  `usoDrogas` bigint(5) NULL,
  `usoDrogasObs` text,
  `historicoCancer` bigint(5) NULL,
  `historicoCancerObs` text,
  `condicaoMoradia` bigint(5) NULL,
  `condicaoMoradiaSaneamentoBasico` bigint(5) NULL,
  `condicaoMoradiaObs` text,
  `saneamentoBasico` bigint(20) NULL,
  `saneamentoBasicoObs` text,
  `atividadeFisica` bigint(5) NULL,
  `atividadeFisicaQtde` bigint(5) NULL,
  `atividadeFisicaObs` text,
  `atividadeFisicaVezesTipo` text,
  `sonoRepouso` bigint(5) NULL,
  `sonoRepousoHrs` bigint(5) NULL,
  `sonoRepousoHrsObs` text,
  `habitosHigieneBanho` text,
  `habitosHigieneBucal` text,
  `frutasVerduras` bigint(20) NULL,
  `carneVermelha` bigint(20) NULL,
  `peixe` bigint(20) NULL,
  `frangoSuco` bigint(20) NULL,
  `agua` bigint(20) NULL,
  `cafe` bigint(20) NULL,
  `leite` bigint(20) NULL,
  `fritura` bigint(20) NULL,
  `comeQuantasVezesDia` bigint(5) NULL,
  `comeQuantasVezesDiaObs` text,
  `habitosAlimentares` bigint(5) NULL,
  `habitosAlimentaresVezesDiaObs` text,
  `equilibrioEmocional` text,
  `eliminacoesUrinarias` bigint(5) NULL,
  `eliminacoesUrinariasObs` text ,
  `eliminacoesUrinariasNormais` bigint(5) NULL,
  `eliminacoesUrinariasAlteracoes` text,
  `eliminacoesIntestinais` bigint(5) NULL,
  `eliminacoesIntestinaisObs` text,
  `atividadeSexual` bigint(5) NULL,
  `problemaSaude` bigint(20) NULL,
  `problemaSaudeObs` text,
  `conhecimentoProblemaSaude` bigint(5) NULL,
  `conhecimentoProblemaSaudeObs` text,
  `estadoNutricional` bigint(5) NULL,
  `peso` float(10,2) NULL,
  `altura` float(10,2) NULL,
  `sinaisVitaisDor` bigint(5) NULL,
  `sinaisVitaisDorObs` text,
  `sinaisVitaisFR` float(10,2) NULL,
  `sinaisVitaisFCPULSO` float(10,2) NULL,
  `sinaisVitaisSAT` float(10,2) NULL,
  `sinaisVitaisPA` float(10,2) NULL,
  `sinaisVitaisTemp` float(10,2) NULL,
  `idPacienteCaso` bigint(20) NOT NULL,
  `idPacienteUsuario` bigint(20) NOT NULL
);


--
-- Estrutura da tabela `quadropacientes`
--

CREATE TABLE `quadropacientes` (
  `id` bigint(20) NOT NULL,
  `dataHora` timestamp NOT NULL,
  `descricao` text NOT NULL,
  `idQuadropacienteCaso` bigint(20) NOT NULL
);


--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `id` bigint(20) NOT NULL,
  `dataHora` timestamp NOT NULL,
  `nome` text NOT NULL,
  `login` varchar(50) NOT NULL,
  `senha` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL
);


--
-- Indexes for table `casos`
--
ALTER TABLE `casos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fkCasosUsuarios` (`idCasoUsuario`);

--
-- Indexes for table `comentarios`
--
ALTER TABLE `comentarios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fkComentariosPacientes` (`idComentarioPaciente`);

--
-- Indexes for table `evolucoes`
--
ALTER TABLE `evolucoes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fkEvolucoesPacientes` (`idEvolucaoPaciente`);

--
-- Indexes for table `fluxo24hs`
--
ALTER TABLE `fluxo24hs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fkFluxo24hsPacientes` (`idFluxo24hPaciente`);

--
-- Indexes for table `pacientes`
--
ALTER TABLE `pacientes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fkPacientesCasos` (`idPacienteCaso`),
  ADD KEY `fkPacientesUsuarios` (`idPacienteUsuario`);

--
-- Indexes for table `quadropacientes`
--
ALTER TABLE `quadropacientes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fkQuadropacientesCasos` (`idQuadropacienteCaso`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `casos`
--
ALTER TABLE `casos`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `comentarios`
--
ALTER TABLE `comentarios`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `evolucoes`
--
ALTER TABLE `evolucoes`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `fluxo24hs`
--
ALTER TABLE `fluxo24hs`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pacientes`
--
ALTER TABLE `pacientes`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `quadropacientes`
--
ALTER TABLE `quadropacientes`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;



--
-- Limitadores para a tabela `casos`
--
ALTER TABLE `casos`
  ADD CONSTRAINT `fkCasosUsuarios` FOREIGN KEY (`idCasoUsuario`) REFERENCES `usuarios` (`id`);

--
-- Limitadores para a tabela `comentarios`
--
ALTER TABLE `comentarios`
  ADD CONSTRAINT `fkComentariosPacientes` FOREIGN KEY (`idComentarioPaciente`) REFERENCES `pacientes` (`id`);

--
-- Limitadores para a tabela `evolucoes`
--
ALTER TABLE `evolucoes`
  ADD CONSTRAINT `fkEvolucoesPacientes` FOREIGN KEY (`idEvolucaoPaciente`) REFERENCES `pacientes` (`id`);

--
-- Limitadores para a tabela `fluxo24hs`
--
ALTER TABLE `fluxo24hs`
  ADD CONSTRAINT `fkFluxo24hsPacientes` FOREIGN KEY (`idFluxo24hPaciente`) REFERENCES `pacientes` (`id`);

--
-- Limitadores para a tabela `pacientes`
--
ALTER TABLE `pacientes`
  ADD CONSTRAINT `fkPacientesCasos` FOREIGN KEY (`idPacienteCaso`) REFERENCES `casos` (`id`),
  ADD CONSTRAINT `fkPacientesUsuarios` FOREIGN KEY (`idPacienteUsuario`) REFERENCES `usuarios` (`id`);

--
-- Limitadores para a tabela `quadropacientes`
--
ALTER TABLE `quadropacientes`
  ADD CONSTRAINT `fkQuadropacientesCasos` FOREIGN KEY (`idQuadropacienteCaso`) REFERENCES `casos` (`id`);

COMMIT;
