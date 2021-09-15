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

create table ItemMagico (
	nomeItem text,
	tipo varchar(20) not null,
	primary key (nomeItem),
	foreign key (nomeItem) references Item (nomeItem)
);

create table AtributoEspecialItemMagico (
	nomeItem text,
	nomeAtributo varchar(50),
	descricao text not null,
	primary key (nomeItem, nomeAtributo),
	foreign key (nomeItem) references ItemMagico (nomeItem)
);

create table Efeito (
	nomeItem text,
	nomeEfeito varchar(40),
	descricao text not null,
	primary key (nomeItem, nomeEfeito),
	foreign key (nomeItem) references ItemMagico (nomeItem)
);
