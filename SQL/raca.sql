create table Raca(
	nome varchar(30),
	caminhoImagem varchar(150),
	descricao text not null,
	deslocamento integer not null,
	idadeAdulto integer not null,
	idadeExpectativaVida integer not null, 
	forca integer not null, 
	destreza integer not null, 
	constituicao integer not null, 
	sabedoria integer not null, 
	inteligencia integer not null,
	carisma integer not null,
	primary key(nomeRaca)
);

create table CaracteristicaRaca(
	nomeCaracteristica varchar(50),
	nomeRaca varchar(30),
	descricao text not null,
	primary key(nomeRaca, nomeCaracteristica),
	foreign key (nomeRaca) references Raca(nomeRaca)
);

create table TracoEspecialRaca(
	nomeTraco varchar(50),
	nomeRaca varchar(30),
	descricao text not null,
	primary key(nomeRaca, nomeTraco),
	foreign key (nomeRaca) references Raca(nomeRaca)
);

create table SubRaca(
	nomeSubRaca varchar(50),
	nomeRaca varchar(30),
	descricao text not null,
	deslocamento integer not null,
	forca integer not null, 
	destreza integer not null, 
	constituicao integer not null, 
	sabedoria integer not null, 
	inteligencia integer not null,
	carisma integer not null,
	primary key(nomeRaca, nomeSubRaca),
	foreign key (nomeRaca) references Raca(nomeRaca)
);

create table TracoEspecialSubRaca(
	nomeTraco varchar(50),
	nomeSubRaca varchar(50),
	descricao text not null,
	primary key(nomeSubRaca, nomeTraco),
	foreign key (nomeSubRaca) references SubRaca(nomeSubRaca)
);