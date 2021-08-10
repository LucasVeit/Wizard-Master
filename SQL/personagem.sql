create table Personagem (
	codigoPersonagem serial,
	nomeJogador varchar(30) not null,--
	nomeCampanha varchar(100) not null,--
	nomePersonagem varchar(30),--
	personagemRaca varchar(30) not null,--
	personagemClasse varchar(20) not null,--
	arquetipo varchar(30),--
	nomeAntecedente varchar(30),--
	coordenadaX integer,--
	coordenadaY integer,--
	tendencia varchar(20) not null,--
	percepcaoPassiva integer not null,--
	numeroInspiracao integer, --
	pontosVidaAtual integer,--
	pontosExperiencia integer,--
	capacidadeCarga integer,--
	cobre integer,--
	prata integer,--
	ouro integer,--
	platina integer,--
	electro integer,--
	codigoDeus integer,--
	codigoAparencia integer, --
	classeArmadura integer, --
	primary key (codigoPersonagem),
	foreign key (nomeCampanha) references Campanha (nomeCampanha),
	foreign key (personagemRaca) references Raca (nomeRaca),
	foreign key (personagemClasse) references Classe (nomeClasse),
	foreign key (nomeAntecedente) references Antecedente (nomeAntecedente),
	foreign key (codigoDeus) references Deus (codigoDeus),
	foreign key (codigoAparencia) references Aparencia (codigoAparencia)
);

create table Aparencia ( -- ok
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

create table PersonagemCaracteristicaAdicional ( -- ok
	codigoPersonagem integer,
	caracteristicaAdicional text not null,
	primary key (codigoPersonagem),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem)
);

create table PersonagemVinculo ( -- ok
	codigoPersonagem integer,
	vinculo text not null,
	primary key (codigoPersonagem),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem)
);

create table PersonagemDefeito ( -- ok
	codigoPersonagem integer,
	defeito text not null,
	primary key (codigoPersonagem),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem)
);

create table PersonagemIdeal ( -- ok
	codigoPersonagem integer,
	ideal text not null,
	primary key (codigoPersonagem),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem)
);

create table PersonagemTracoPersonalidade ( -- ok
	codigoPersonagem integer,
	tracoPersonalidade text not null,
	primary key (codigoPersonagem),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem)
);

create table PontosExperienciaNivel ( -- ok
	pontosExperiencia integer,
	nivel integer not null,
	primary key (pontosExperiencia)
);

create table PersonagemTalento ( -- ok
	codigoPersonagem integer,
	nomeTalento varchar(30),
	primary key (codigoPersonagem, nomeTalento),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem),
	foreign key (nomeTalento) references Talento (nomeTalento)
);

create table Talento ( -- ok
	nomeTalento varchar(40),
	preRequisito varchar(100),
	descricao text not null,
	primary key (nomeTalento)
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

create table PersonagemPericia ( -- ok
	codigoPersonagem integer,
	nomePericia varchar(30),
	modificador integer not null,
	primary key (codigoPersonagem, nomePericia),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem),
	foreign key (nomePericia) references Pericia (nomePericia)
);

create table PersonagemMagia ( -- ok
	codigoPersonagem integer,
	nomeMagia varchar(30),
	primary key (codigoPersonagem, nomeMagia),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem),
	foreign key (nomeMagia) references Magia (nomeMagia)
);

create table PersonagemHabilidade ( -- ok
	codigoPersonagem integer,
	nomeHabilidade varchar(15),
	valor integer not null,
	primary key (codigoPersonagem, nomeHabilidade),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem),
	foreign key (valor) references Habilidade (valor)
);
