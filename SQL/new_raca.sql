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


--------------------------------------------------------------------------------------------------------------------------------


create table Item (
	nomeItem text,
	descricao text not null,
	categoria text not null, -- ex: arma, montaria e tal
	tipo text not null, --
	raridade text not null,
	custo integer not null,
	moeda char(2) not null,
	peso numeric(7,2) not null,

	primary key (nomeItem)
);

create table Arma (
	nomeItem text,
	tipo varchar(50) not null,
	dano varchar(20) not null,
	primary key (nomeItem),
	foreign key (nomeItem) references Item (nomeItem)
);

create table PropriedadeArma (
	nomeItem text,
	nomePropriedade varchar(20),
	descricao text not null
	primary key (nomeItem, propriedade),
	foreign key (nomeItem) references Arma (nomeItem)
);

create table Montaria (
	nomeItem text,
	deslocamento numeric(7, 2) not null,
	capacidadeCarga numeric(7, 2) not null,
	primary key (nomeItem),
	foreign key (nomeItem) references Item(nomeItem)
);
create table Tempo (
	tipo varchar(20),
	equipar integer not null,
	desequipar integer not null,
	primary key (tipo)
);

create table ArmaduraEscudo (
	nomeItem text,
	classeArmadura integer not null,
	modificadorDes boolean not null, --se possui modificador de des
	maxModificador integer, --valor maximo do modificador de des
	forcaNecessaria integer not null,
	tipo varchar(20) not null,
	furtividade boolean not null,
	primary key (nomeItem),
	foreign key (nomeItem) references Item(nomeItem),
	foreign key (tipo) references Tempo(tipo)
);

create table ItemMagico ( -- FALTA ESSE
	nomeItem text,
	tipo varchar(20) not null,
	primary key (nomeItem),
	foreign key (nomeItem) references Item (nomeItem)
);

create table Efeito (
	nomeItem text,
	nomeEfeito varchar(40),
	descricao text not null,
	primary key (nomeItem, nomeEfeito),
	foreign key (nomeItem) references ItemMagico (nomeItem)
);
