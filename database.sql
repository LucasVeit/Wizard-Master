create table Raca (
	nomeRaca varchar(30),
	descricao text not null,
	idadeAdulto integer not null,
	tendencia varchar(20) not null,
	idadeExpectativaVida integer  not null, 
	tamanho varchar(50) not null, 
	forca integer not null, 
	destreza integer not null, 
	constituicao integer not null, 
	sabedoria integer not null, 
	inteligencia integer not null,
	carisma integer not null,
	primary key(nomeRaca)
);

create table DeslocamentoRaca (
	nomeRaca varchar(30),
	nomeDeslocamento varchar(25),
	valor integer not null,
	primary key(nomeRaca, nomeDeslocamento)
);

create table IdiomaRaca (
	nomeRaca varchar(30),
	nomeIdioma varchar(25),
	primary key (nomeRaca, nomeIdioma),
	foreign key (nomeRaca) references Raca(nomeRaca)
);

create table TracoEspecialRaca (
	nome varchar(30),
	nomeRaca varchar(30),
	descricao text not null,
	primary key (nome, nomeRaca),
	foreign key (nomeRaca) references Raca (nomeRaca)
);

create table Monstro (
	nomeMonstro varchar(40),
	descricao text not null,
	foto varchar(120),
	classeArmadura varchar(30) not null,
	pontosVida varchar(20) not null,
	tendencia varchar(20) not null,
	nivel integer not null,
	pontosExperiencia integer not null,
	formaCorporal varchar(20) not null,
	tamanho varchar(20) not null,
	descricaoAcaoLendaria text not null,
	primary key (nomeMonstro)
);

create table DeslocamentoMonstro (
	nomeMonstro varchar(40),
	nomeDeslocamento varchar(25),
	valor integer not null,
	primary key (nomeMonstro, nomeDeslocamento),
	foreign key (nomeMonstro) references Monstro(nomeMonstro)
);

create table IdiomaMonstro (
	nomeMonstro varchar(40),
	nomeIdioma varchar(25) not null,
	primary key (nomeMonstro),
	foreign key (nomeMonstro) references Monstro(nomeMonstro)
);

create table SentidoMonstro (
	nomeMonstro varchar(40),
	nomeSentido varchar(40),
	descricao varchar(100) not null,
	primary key (nomeMonstro, nomeSentido),
	foreign key (nomeMonstro) references Monstro(nomeMonstro)
);

create table TracoEspecialMonstro (
	nome varchar(30),
	nomeMonstro varchar(40),
	descricao text not null,
	primary key (nome, nomeMonstro),
	foreign key (nomeMonstro) references Monstro(nomeMonstro)
);

create table CaracteristicaMonstro (
	nome varchar(35),
	nomeMonstro varchar(40),
	descricao text not null,
	primary key (nome, nomeMonstro),
	foreign key (nomeMonstro) references Monstro(nomeMonstro)
);

create table Acao (
	nome varchar(50),
	nomeMonstro varchar(40),
	descricao text not null,
	primary key (nome, nomeMonstro),
	foreign key (nomeMonstro) references Monstro(nomeMonstro)
);

create table AcaoLendaria (
	nome varchar(40),
	nomeMonstro varchar(40),
	descricao text not null,
	primary key (nome, nomeMonstro),
	foreign key (nomeMonstro) references Monstro(nomeMonstro)
);

create table Classe (
	nomeClasse varchar(20),
	descricao text not null,
	pontosVidaInicial varchar(50) not null,
	progressaoVida varchar(50) not null,
	primary key (nomeClasse)
);

create table Proficiencia (
	nomeProficiencia varchar(35),
	nomeClasse varchar(20),
	descricao text not null,
	primary key (nomeProficiencia, nomeClasse),
	foreign key (nomeClasse) references Classe (nomeClasse)
);

create table CaracteristicaClasse (
	nomeCaracteristica varchar(60),
	nomeClasse varchar(20),
	nivel integer,
	descricao text not null,
	arquetipo varchar(30),
	primary key (nomeCaracteristica, nomeClasse),
	foreign key (nomeClasse) references Classe (nomeClasse)
);

create table Atributo (
	nivel integer,
	nomeClasse varchar(20),
	bonusProficiencia integer not null,
	primary key (nivel, nomeClasse),
	foreign key (nomeClasse) references Classe (nomeClasse)
);

create table Bruxo (
	nomeClasse varchar(20),
	nivel integer,
	invocacoesConhecidas integer not null,
	nivelMagia integer not null,
	espacosMagia integer not null,
	magiasConhecidas integer not null,
	truquesConhecidos integer not null,
	primary key (nomeClasse, nivel),
	foreign key (nomeClasse, nivel) references Atributo (nomeClasse, nivel)
);

create table Barbaro (
	nomeClasse varchar(20),
	nivel integer,
	danoFuria integer not null,
	furias integer not null,
	primary key (nomeClasse, nivel),
	foreign key (nomeClasse, nivel) references Atributo (nomeClasse, nivel)
);

create table Bardo (
	nomeClasse varchar(20),
	nivel integer,
	truquesConhecidos integer not null,
	magiasConhecidas integer not null,
	primary key (nomeClasse, nivel),
	foreign key (nomeClasse, nivel) references Atributo (nomeClasse, nivel)
);

create table ClerigoDruidaMago (
	nomeClasse varchar(20),
	nivel integer,
	truquesConhecidos integer not null,
	primary key (nomeClasse, nivel),
	foreign key (nomeClasse, nivel) references Atributo (nomeClasse, nivel)
);

create table Feiticeiro (
	nomeClasse varchar(20),
	nivel integer,
	pontosFeiticaria integer not null,
	truquesConhecidos integer not null,
	magiasConhecidas integer not null,
	primary key (nomeClasse, nivel),
	foreign key (nomeClasse, nivel) references Atributo (nomeClasse, nivel)
);

create table Monge (
	nomeClasse varchar(20),
	nivel integer,
	deslocamentoSemArmadura integer not null,
	artesMarciais varchar(5) not null,
	pontosChi integer not null,
	primary key (nomeClasse, nivel),
	foreign key (nomeClasse, nivel) references Atributo (nomeClasse, nivel)
);

create table Ladino (
	nomeClasse varchar(20),
	nivel integer,
	ataqueFurtivo varchar(5) not null,
	primary key (nomeClasse, nivel),
	foreign key (nomeClasse, nivel) references Atributo (nomeClasse, nivel)
);

create table Patrulheiro (
	nomeClasse varchar(20),
	nivel integer,
	magiasConhecidas integer not null,
	primary key (nomeClasse, nivel),
	foreign key (nomeClasse, nivel) references Atributo (nomeClasse, nivel)
);

create table EspacoMagia (
	nomeClasse varchar(20),
	nivel integer,
	nivelMagia integer,
	quantidade integer not null,
	primary key (nomeClasse, nivel, nivelMagia),
	foreign key (nomeClasse, nivel) references Atributo (nomeClasse, nivel)
);

create table Magia (
	nomeMagia varchar(35),
	tipo varchar(25) not null,
	nivel integer not null,
	descricao text not null,
	duracao varchar(20) not null,
	componentes varchar(15) not null,
	alcance varchar(20) not null,
	tempoConjuracao varchar(20) not null,
	primary key (nomeMagia)
);

create table ClasseMagia (
	nomeClasse varchar(20),
	nomeMagia varchar(35),
	primary key (nomeClasse, nomeMagia),
	foreign key (nomeClasse) references Classe (nomeClasse),
	foreign key (nomeMagia) references Magia (nomeMagia)
);

create table Pericia (
	nomePericia varchar(30),
	descricao text not null,
	habilidadeImpacta varchar(15) not null,
	primary key (nomePericia)
);

create table ClassePericia (
	nomeClasse varchar(20),
	nomePericia varchar(30),
	primary key (nomeClasse, nomePericia),
	foreign key (nomeClasse) references Classe(nomeClasse),
	foreign key (nomePericia) references Pericia(nomePericia)
);

create table Item (
	nomeItem varchar(35),
	descricao text not null,
	categoria varchar(20) not null,
	custo integer not null,
	moeda char(2) not null,
	primary key (nomeItem)
);

create table Arma (
	nomeItem varchar(35),
	tipo varchar(50) not null,
	dano varchar(20) not null,
	peso integer not null,
	primary key (nomeItem),
	foreign key (nomeItem) references Item (nomeItem)
);

create table PropriedadeArma (
	nomeItem varchar(35),
	propriedade varchar(20),
	valor integer not null,
	primary key (nomeItem, propriedade),
	foreign key (nomeItem) references Arma (nomeItem)
);

create table Montaria (
	nomeItem varchar(35),
	velocidade integer not null,
	capacidadeCarregar integer not null,
	primary key (nomeItem),
	foreign key (nomeItem) references Item(nomeItem)
);

create table ItemMagico (
	nomeItem varchar(35),
	tipo varchar(20) not null,
	raridade varchar(20) not null,
	primary key (nomeItem),
	foreign key (nomeItem) references Item (nomeItem)
);

create table EquipamentoAventura (
	nomeItem varchar(35),
	peso integer not null,
	primary key (nomeItem),
	foreign key (nomeItem) references Item (nomeItem)
);

create table Tempo (
	tipo varchar(20),
	equipar integer not null,
	desequipar integer not null,
	primary key (tipo)
);

create table ArmaduraEscudo (
	nomeItem varchar(35),
	classeArmadura varchar(25) not null,
	forcaNecessaria integer not null,
	peso integer not null,
	tipo varchar(20) not null,
	furtividade boolean,
	primary key (nomeItem),
	foreign key (nomeItem) references Item(nomeItem),
	foreign key (tipo) references Tempo(tipo)
);

create table Efeito (
	nomeItem varchar(35),
	nomeEfeito varchar(40),
	descricao text not null,
	primary key (nomeItem, nomeEfeito),
	foreign key (nomeItem) references ItemMagico (nomeItem)
);

create table Antecedente (
	nomeAntecedente varchar(30),
	descricao text not null,
	primary key (nomeAntecedente)
);

create table AntecedentePericia (
	nomeAntecedente varchar(30),
	nomePericia varchar(30),
	primary key (nomeAntecedente, nomePericia),
	foreign key (nomeAntecedente) references Antecedente (nomeAntecedente),
	foreign key (nomePericia) references Pericia (nomePericia)
);

create table AntecedenteProficienciaFerramenta (
	nomeAntecedente varchar(30),
	proficienciaFerramentas varchar(25),
	primary key (nomeAntecedente, proficienciaFerramentas),
	foreign key (nomeAntecedente) references Antecedente (nomeAntecedente)
);

create table AntecedenteIdioma (
	nomeAntecedente varchar(30),
	nomeIdioma varchar(25),
	primary key (nomeAntecedente, nomeIdioma),
	foreign key (nomeAntecedente) references Antecedente (nomeAntecedente)
);

create table CaracteristicaAntecedente (
	nomeCaracteristica varchar(30),
	nomeAntecedente varchar(30),
	descricao text not null,
	primary key (nomeCaracteristica, nomeAntecedente),
	foreign key (nomeAntecedente) references Antecedente (nomeAntecedente)
);

create table AntecedenteItem (
	nomeAntecedente varchar(30),
	nomeItem varchar(35),
	primary key (nomeAntecedente, nomeItem),
	foreign key (nomeAntecedente) references Antecedente (nomeAntecedente),
	foreign key (nomeItem) references Item (nomeItem)
);

create table Talento (
	nomeTalento varchar(40),
	preRequisito varchar(100) not null,
	descricao text not null,
	primary key (nomeTalento)
);

create table Plano (
	nomePlano varchar(50),
	descricao text not null,
	corCortina varchar(20),
	corPoco varchar(20),
	primary key (nomePlano)
);

create table Regra (
	nomeRegra varchar(50),
	nomePlano varchar(50),
	descricao text not null,
	primary key (nomeRegra, nomePlano),
	foreign key (nomePlano) references Plano (nomePlano)	
);

create table Campanha (
	nomeCampanha varchar(100),
	descricao text,
	mapaAtual integer,
	primary key (nomeCampanha)
);

create table Mapa (
	codigoMapa serial,
	nomeCampanha varchar(100) not null,
	mapa varchar(150) not null,
	primary key (codigoMapa),
	foreign key (nomeCampanha) references Campanha (nomeCampanha)
);

create table Cidade (
	codigoCidade serial,
	nomeCidade varchar(50) not null,
	nomeCampanha varchar(100) not null,
	comercio varchar(50) not null,
	clima varchar(30) not null,
	vegetacao varchar(30) not null,
	populacao integer not null,
	formaGoverno varchar(20) not null,
	primary key (codigoCidade),
	foreign key (nomeCampanha) references Campanha (nomeCampanha)	
);

create table Lider (
	codigoLider serial,
	nomeLider varchar(50) not null,
	descricao text,
	primary key (codigoLider)
);

create table Faccao (
	codigoFaccao serial,
	nomeFaccao varchar(30) not null,
	nomeCampanha varchar(100) not null,
	formaGoverno varchar(20) not null,
	primary key (codigoFaccao),
	foreign key (nomeCampanha) references Campanha (nomeCampanha)	
);

create table LiderCidade (
	codigoCidade integer,
	codigoLider integer,
	primary key (codigoCidade, codigoLider),
	foreign key (codigoCidade) references Cidade (codigoCidade),
	foreign key (codigoLider) references Lider (codigoLider)
);

create table LiderFaccao (
	codigoFaccao integer,
	codigoLider integer,
	primary key (codigoFaccao, codigoLider),
	foreign key (codigoFaccao) references Faccao (codigoFaccao),
	foreign key (codigoLider) references Lider (codigoLider)
);

create table Deus (
	codigoDeus serial,
	nomeDeus varchar(50) not null,
	dominio varchar(100) not null,
	tendencia varchar(20) not null,
	simbolo varchar(100) not null,
	primary key (codigoDeus)
);

create table Anotacao (
	codigoAnotacao serial,
	nomeCampanha varchar(100) not null,
	anotacao text,
	primary key (codigoAnotacao),
	foreign key (nomeCampanha) references Campanha (nomeCampanha)
);

create table Mundo (
	nomeCampanha varchar(100),
	nomePlano varchar(50),
	primary key (nomeCampanha, nomePlano),
	foreign key (nomeCampanha) references Campanha (nomeCampanha),
	foreign key (nomePlano) references Plano (nomePlano)
);

create table PanteaoCampanha (
	nomeCampanha varchar(100),
	codigoDeus integer,
	primary key (nomeCampanha, codigoDeus),
	foreign key (nomeCampanha) references Campanha (nomeCampanha),
	foreign key (codigoDeus) references Deus (codigoDeus)
);

create table Aparencia (
	codigoAparencia serial,
	altura numeric(7, 2),
	peso numeric(7, 2),
	foto varchar(150),
	corOlhos varchar(20),
	idade integer,
	corPele varchar(20),
	corCabelo varchar(20),
	primary key (codigoAparencia)
);

create table Personagem (
	codigoPersonagem serial,
	nomeJogador varchar(30) not null,
	nomeCampanha varchar(100) not null,
	nomePersonagem varchar(30),
	personagemRaca varchar(30) not null,
	personagemClasse varchar(20) not null,
	arquetipo varchar(30),
	nomeAntecedente varchar(30),
	coordenadaX integer,
	coordenadaY integer,
	tendencia varchar(20) not null,
	percepcaoPassiva integer not null,
	numeroInspiracao integer,
	pontosVidaAtual integer,
	pontosExperiencia integer,
	capacidadeCarga integer,
	cobre integer,
	prata integer,
	ouro integer,
	platina integer,
	electro integer,
	codigoDeus integer,
	codigoAparencia integer,
	primary key (codigoPersonagem),
	foreign key (nomeCampanha) references Campanha (nomeCampanha),
	foreign key (personagemRaca) references Raca (nomeRaca),
	foreign key (personagemClasse) references Classe (nomeClasse),
	foreign key (nomeAntecedente) references Antecedente (nomeAntecedente),
	foreign key (codigoDeus) references Deus (codigoDeus),
	foreign key (codigoAparencia) references Aparencia (codigoAparencia)
);

create table PersonagemCaracteristicaAdicional (
	codigoPersonagem integer,
	caracteristicaAdicional text not null,
	primary key (codigoPersonagem),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem)
);

create table PersonagemVinculo (
	codigoPersonagem integer,
	vinculo text not null,
	primary key (codigoPersonagem),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem)
);

create table PersonagemDefeito (
	codigoPersonagem integer,
	defeito text not null,
	primary key (codigoPersonagem),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem)
);

create table PersonagemIdeal (
	codigoPersonagem integer,
	ideal text not null,
	primary key (codigoPersonagem),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem)
);

create table PersonagemTracoPersonalidade (
	codigoPersonagem integer,
	tracoPersonalidade text not null,
	primary key (codigoPersonagem),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem)
);

create table PontosExperienciaNivel ( -- REVISAR ESSA PARTE, PROCURAR NA INTERNET COMO FAZER PONTOS DE XP E NIVEL EM BD RELACIONAL
	pontosExperiencia integer,
	nivel integer not null,
	primary key (pontosExperiencia)
);

create table PersonagemTalento (
	codigoPersonagem integer,
	nomeTalento varchar(30),
	primary key (codigoPersonagem, nomeTalento),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem),
	foreign key (nomeTalento) references Talento (nomeTalento)
);

create table PersonagemItem (
	codigoPersonagem integer,
	nomeItem varchar(30),
	quantidade integer,
	equipado boolean,
	primary key (codigoPersonagem, nomeItem),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem),
	foreign key (nomeItem) references Item (nomeItem)
);

create table PersonagemPericia (
	codigoPersonagem integer,
	nomePericia varchar(30),
	modificador integer not null,
	primary key (codigoPersonagem, nomePericia),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem),
	foreign key (nomePericia) references Pericia (nomePericia)
);

create table PersonagemMagia (
	codigoPersonagem integer,
	nomeMagia varchar(30),
	primary key (codigoPersonagem, nomeMagia),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem),
	foreign key (nomeMagia) references Magia (nomeMagia)
);

create table Habilidade (
	valor integer,
	valorModificador integer not null,
	primary key (valor)
);

create table MonstroHabilidade (
	nomeMonstro varchar(40),
	nomeHabilidade varchar(15),
	valor integer not null,
	primary key (nomeMonstro, nomeHabilidade),
	foreign key (nomeMonstro) references Monstro (nomeMonstro),
	foreign key (valor) references Habilidade (valor)
);

create table PersonagemHabilidade (
	codigoPersonagem integer,
	nomeHabilidade varchar(15),
	valor integer not null,
	primary key (codigoPersonagem, nomeHabilidade),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem),
	foreign key (valor) references Habilidade (valor)
);