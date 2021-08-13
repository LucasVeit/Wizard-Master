create table Monstro (
	nomeMonstro varchar(40),
	introducao text not null, --fazer outra tabela
	foto varchar(120),
	classeArmadura varchar(30) not null,
	pontosVida varchar(20) not null,
	tendencia varchar(20) not null,
	nivel numeric(6,3) not null,
	pontosExperiencia integer not null,
	formaCorporal varchar(20) not null,
	tamanho varchar(20) not null,
	descricaoAcaoLendaria text,
	primary key (nomeMonstro)
);

create table Lore (
	nome varchar(35),
	nomeMonstro varchar(40),
	descricao text not null,
	primary key (nome, nomeMonstro),
	foreign key (nomeMonstro) references Monstro(nomeMonstro)
);

create table TracoEspecialMonstro (
	nome varchar(35),
	nomeMonstro varchar(40),
	descricao text not null,
	primary key (nome, nomeMonstro),
	foreign key (nomeMonstro) references Monstro(nomeMonstro)
);

create table CaracteristicaMonstro (
--texto vermelho, inclui deslocamento
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