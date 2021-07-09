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
	nomeDesclocamento varchar(25),
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
	foreign key (nomeRaca) references (nomeRaca)
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
	primary key (nomeMonstro),
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
	primary key nomeMonstro,
	foreign key nomeMonstro references Monstro(nomeMonstro)
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
	primary key (nomeClasse),
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
	foreign key (nomeClasse, nivel) references Atributo (nivel, nomeClasse)
);

create table Barbaro (
	nomeClasse varchar(20),
	nivel integer,
	danoFuria integer not null,
	furias integer not null,
	primary key (nomeClasse, nivel),
	foreign key (nomeClasse, nivel) references Atributo (nivel, nomeClasse)
);

create table Bardo (
	nomeClasse varchar(20),
	nivel integer,
	truquesConhecidos integer not null,
	magiasConhecidas integer not null,
	primary key (nomeClasse, nivel),
	foreign key (nomeClasse, nivel) references Atributo (nivel, nomeClasse)
);

create table ClerigoDruidaMago (
	nomeClasse varchar(20),
	nivel integer,
	truquesConhecidos integer not null,
	primary key (nomeClasse, nivel),
	foreign key (nomeClasse, nivel) references Atributo (nivel, nomeClasse)
);

create table Feiticeiro (
	nomeClasse varchar(20),
	nivel integer,
	pontosFeiticaria integer not null,
	truquesConhecidos integer not null,
	magiasConhecidas integer not null,
	primary key (nomeClasse, nivel),
	foreign key (nomeClasse, nivel) references Atributo (nivel, nomeClasse)	
);

create table Monge (
	nomeClasse varchar(20),
	nivel integer,
	deslocamentoSemArmadura integer not null,
	artesMarciais varchar(5) not null,
	pontosChi integer not null,
	primary key (nomeClasse, nivel),
	foreign key (nomeClasse, nivel) references Atributo (nivel, nomeClasse)
);

create table Ladino (
	nomeClasse varchar(20),
	nivel integer,
	ataqueFurtivo varchar(5) not null,
	primary key (nomeClasse, nivel),
	foreign key (nomeClasse, nivel) references Atributo (nivel, nomeClasse)
);

create table Patrulheiro (
	nomeClasse varchar(20),
	nivel integer,
	magiasConhecidas integer not null,
	primary key (nomeClasse, nivel),
	foreign key (nomeClasse, nivel) references Atributo (nivel, nomeClasse)
);

create table EspacoMagia (
	nomeClasse varchar(20),
	nivel integer,
	nivelMagia integer,
	quantidade integer not null,
	primary key (nomeClasse, nivel, nivelMagia),
	foreign key (nomeClasse, nivel) references Atributo (nivel, nomeClasse)
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
	primary key (nomeMagia),
);

create table ClasseMagia (
	nomeClasse varchar(20),
	nomeMagia varchar(35),
	primary key (nomeClasse, nomeMagia)
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
	foreign key nomeClasse references Classe(nomeClasse),
	foreign key nomePericia references Pericia(nomePericia)
);

create table Item (
	nomeItem varchar(35),
	descricao text not null,
	categoria varchar(20) not null,
	custo integer not null,
	moeda varchar(2) not null,
	primary key (nomeItem)
);

create table Arma (
	nomeItem varchar(35),
	tipo varchar(50) not null,
	dano varchar(20) not null,
	peso integer not null,
	primery key (nomeItem),
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
	capacidadeCarregar not null,
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
	primary key (nomeAntecedente, nomePericia).
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
