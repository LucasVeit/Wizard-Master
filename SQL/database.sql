
create table Classe (-- ok
	nomeClasse varchar(20),
	descricao text not null,
	pontosVidaInicial varchar(50) not null,
	progressaoVida varchar(50) not null,
	primary key (nomeClasse)
);

create table Proficiencia (-- ok
	nomeProficiencia varchar(35),
	nomeClasse varchar(20),
	descricao text not null,
	primary key (nomeProficiencia, nomeClasse),
	foreign key (nomeClasse) references Classe (nomeClasse)
);

create table CaracteristicaClasse (-- ok
	nomeCaracteristica varchar(60),
	nomeClasse varchar(20),
	nivel integer,
	descricao text not null,
	arquetipo varchar(30),
	primary key (nomeCaracteristica, nomeClasse),
	foreign key (nomeClasse) references Classe (nomeClasse)
);

create table Atributo (-- ok
	nivel integer,
	nomeClasse varchar(20),
	bonusProficiencia integer not null,
	primary key (nivel, nomeClasse),
	foreign key (nomeClasse) references Classe (nomeClasse)
);

create table Bruxo (-- ok
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

create table Barbaro (-- ok
	nomeClasse varchar(20),
	nivel integer,
	danoFuria integer not null,
	furias integer not null,
	primary key (nomeClasse, nivel),
	foreign key (nomeClasse, nivel) references Atributo (nomeClasse, nivel)
);

create table Bardo (-- ok
	nomeClasse varchar(20),
	nivel integer,
	truquesConhecidos integer not null,
	magiasConhecidas integer not null,
	primary key (nomeClasse, nivel),
	foreign key (nomeClasse, nivel) references Atributo (nomeClasse, nivel)
);

create table ClerigoDruidaMago (-- ok
	nomeClasse varchar(20),
	nivel integer,
	truquesConhecidos integer not null,
	primary key (nomeClasse, nivel),
	foreign key (nomeClasse, nivel) references Atributo (nomeClasse, nivel)
);

create table Feiticeiro (-- ok
	nomeClasse varchar(20),
	nivel integer,
	pontosFeiticaria integer not null,
	truquesConhecidos integer not null,
	magiasConhecidas integer not null,
	primary key (nomeClasse, nivel),
	foreign key (nomeClasse, nivel) references Atributo (nomeClasse, nivel)
);

create table Monge (-- ok
	nomeClasse varchar(20),
	nivel integer,
	deslocamentoSemArmadura integer not null,
	artesMarciais varchar(5) not null,
	pontosChi integer not null,
	primary key (nomeClasse, nivel),
	foreign key (nomeClasse, nivel) references Atributo (nomeClasse, nivel)
);

create table Ladino (-- ok
	nomeClasse varchar(20),
	nivel integer,
	ataqueFurtivo varchar(5) not null,
	primary key (nomeClasse, nivel),
	foreign key (nomeClasse, nivel) references Atributo (nomeClasse, nivel)
);

create table Patrulheiro (-- ok
	nomeClasse varchar(20),
	nivel integer,
	magiasConhecidas integer not null,
	primary key (nomeClasse, nivel),
	foreign key (nomeClasse, nivel) references Atributo (nomeClasse, nivel)
);

create table EspacoMagia (-- ok
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