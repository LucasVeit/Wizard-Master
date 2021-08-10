create table Plano ( -- ok
	nomePlano varchar(50),
	descricao text, --not null, retirado
	corCortina varchar(20),
	corPoco varchar(20),
	primary key (nomePlano)
);

create table Regra ( -- ok
	nomeRegra varchar(50),
	nomePlano varchar(50),
	descricao text not null,
	primary key (nomeRegra, nomePlano),
	foreign key (nomePlano) references Plano (nomePlano)	
);

create table Magia ( -- ok
	nomeMagia varchar(35),
	tipo varchar(25) not null,
	nivel integer not null,
	descricao text not null,
	duracao varchar(20), -- not null,
	componentes varchar(15), -- not null,
	alcance varchar(20), -- not null,
	tempoConjuracao varchar(20), -- not null,
	primary key (nomeMagia)
);

create table Cidade ( -- ok
	codigoCidade serial,
	nomeCidade varchar(50) not null,
	nomeCampanha varchar(100) not null,
	comercio varchar(50) not null,
	clima varchar(30) not null,
	vegetacao varchar(30) not null,
	populacao integer not null,
	formaGoverno varchar(20) not null,
	descricao text,
	primary key (codigoCidade),
	foreign key (nomeCampanha) references Campanha (nomeCampanha)	
);

create table Deus ( -- ok
	codigoDeus serial,
	nomeDeus varchar(50) not null,
	dominio varchar(100) not null,
	tendencia varchar(20) not null,
	simbolo varchar(100) not null,
	descricao text,
	primary key (codigoDeus)
);

create table PanteaoCampanha ( -- ok
	nomeCampanha varchar(100),
	codigoDeus integer,
	primary key (nomeCampanha, codigoDeus),
	foreign key (nomeCampanha) references Campanha (nomeCampanha),
	foreign key (codigoDeus) references Deus (codigoDeus)
);

create table Lider ( -- ok
	codigoLider serial,
	nomeLider varchar(50) not null,
	descricao text,
	primary key (codigoLider)
);

create table Faccao ( -- ok
	codigoFaccao serial,
	nomeFaccao varchar(30) not null,
	nomeCampanha varchar(100) not null,
	formaGoverno varchar(20) not null,
	descricao text,
	primary key (codigoFaccao),
	foreign key (nomeCampanha) references Campanha (nomeCampanha)	
);

create table LiderCidade ( -- ok
	codigoCidade integer,
	codigoLider integer,
	primary key (codigoCidade, codigoLider),
	foreign key (codigoCidade) references Cidade (codigoCidade),
	foreign key (codigoLider) references Lider (codigoLider)
);

create table LiderFaccao ( -- ok
	codigoFaccao integer,
	codigoLider integer,
	primary key (codigoFaccao, codigoLider),
	foreign key (codigoFaccao) references Faccao (codigoFaccao),
	foreign key (codigoLider) references Lider (codigoLider)
);

create table Antecedente ( -- ok
	nomeAntecedente varchar(30),
	descricao text not null,
	primary key (nomeAntecedente)
);

create table AntecedentePericia ( -- ok
	nomeAntecedente varchar(30),
	nomePericia varchar(30),
	primary key (nomeAntecedente, nomePericia),
	foreign key (nomeAntecedente) references Antecedente (nomeAntecedente),
	foreign key (nomePericia) references Pericia (nomePericia)
);

create table AntecedenteProficienciaFerramenta ( -- ok
	nomeAntecedente varchar(30),
	proficienciaFerramentas varchar(25),
	primary key (nomeAntecedente, proficienciaFerramentas),
	foreign key (nomeAntecedente) references Antecedente (nomeAntecedente)
);

create table AntecedenteIdioma ( -- ok
	nomeAntecedente varchar(30),
	nomeIdioma varchar(25),
	primary key (nomeAntecedente, nomeIdioma),
	foreign key (nomeAntecedente) references Antecedente (nomeAntecedente)
);

create table CaracteristicaAntecedente ( -- ok
	nomeCaracteristica varchar(30),
	nomeAntecedente varchar(30),
	descricao text not null,
	primary key (nomeCaracteristica, nomeAntecedente),
	foreign key (nomeAntecedente) references Antecedente (nomeAntecedente)
);

create table AntecedenteItem ( -- ok
	nomeAntecedente varchar(30),
	nomeItem varchar(35),
	primary key (nomeAntecedente, nomeItem),
	foreign key (nomeAntecedente) references Antecedente (nomeAntecedente),
	foreign key (nomeItem) references Item (nomeItem)
);
