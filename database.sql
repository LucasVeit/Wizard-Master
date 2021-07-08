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

