-- Tabelas refrentes a Monstro
create table Monstro ( -- revisar
	nomeMonstro varchar(40),
	introducao text not null, --fazer outra tabela
	foto varchar(120),
	classeArmadura varchar(30) not null,
	pontosVida varchar(20) not null,
	tendencia varchar(20) not null,
	nivel integer not null,
	pontosExperiencia integer not null,
	formaCorporal varchar(20) not null,
	tamanho varchar(20) not null,
	descricaoAcaoLendaria text,
	primary key (nomeMonstro)
);

create table Lore ( -- revisar
	nome varchar(35),
	nomeMonstro varchar(40),
	descricao text not null,
	primary key (nome, nomeMonstro),
	foreign key (nomeMonstro) references Monstro(nomeMonstro)
);

create table TracoEspecialMonstro ( -- revisar
	nome varchar(35),
	nomeMonstro varchar(40),
	descricao text not null,
	primary key (nome, nomeMonstro),
	foreign key (nomeMonstro) references Monstro(nomeMonstro)
);

create table CaracteristicaMonstro ( -- revisar
--texto vermelho, inclui deslocamento
	nome varchar(35),
	nomeMonstro varchar(40),
	descricao text not null,
	primary key (nome, nomeMonstro),
	foreign key (nomeMonstro) references Monstro(nomeMonstro)
);

create table Acao ( -- revisar
	nome varchar(50),
	nomeMonstro varchar(40),
	descricao text not null,
	primary key (nome, nomeMonstro),
	foreign key (nomeMonstro) references Monstro(nomeMonstro)
);

create table AcaoLendaria ( -- revisar
	nome varchar(40),
	nomeMonstro varchar(40),
	descricao text not null,
	primary key (nome, nomeMonstro),
	foreign key (nomeMonstro) references Monstro(nomeMonstro)
);

create table MonstroHabilidade ( -- ok
	nomeMonstro varchar(40),
	nomeHabilidade varchar(15),
	valor integer not null,
	primary key (nomeMonstro, nomeHabilidade),
	foreign key (nomeMonstro) references Monstro (nomeMonstro),
	foreign key (valor) references Habilidade (valor)
);

-- Tabelas referentes a Classe

create table ClasseMagia ( -- revisar
	nomeClasse varchar(20),
	nomeMagia varchar(35),
	primary key (nomeClasse, nomeMagia),
	foreign key (nomeClasse) references Classe (nomeClasse),
	foreign key (nomeMagia) references Magia (nomeMagia)
);

create table ClassePericia ( -- revisar
	nomeClasse varchar(20),
	nomePericia varchar(30),
	primary key (nomeClasse, nomePericia),
	foreign key (nomeClasse) references Classe(nomeClasse),
	foreign key (nomePericia) references Pericia(nomePericia)
);


-- Tabelas de Antecedente
create table Antecedente (
	nomeAntecedente varchar(30),
	primary key (nomeAntecedente)
);

create table AntecedentePericia (
	nomeAntecedente varchar(30),
	nomePericia varchar(30),
	primary key (nomeAntecedente, nomePericia),
	foreign key (nomeAntecedente) references Antecedente (nomeAntecedente),
	foreign key (nomePericia) references Pericia (nomePericia)
);


-- Tabelas referentes a informações do Mundo e Campanhas
create table Campanha ( -- ok
	nomeCampanha varchar(100),
	descricao text,
	mapaAtual integer,
	primary key (nomeCampanha)
);

create table Mapa ( -- ok
	codigoMapa serial,
	nomeCampanha text not null,
	mapa text not null,
	primary key (codigoMapa),
	foreign key (nomeCampanha) references Campanha (nomeCampanha)
);

create table Anotacao ( -- ok
	codigoAnotacao serial,
	nomeCampanha varchar(100) not null,
	anotacao text,
	primary key (codigoAnotacao),
	foreign key (nomeCampanha) references Campanha (nomeCampanha)
);

create table Lider ( -- ok
	codigoLider serial,
    nomeLider varchar(50) not null,
    descricao text,
    nomeCampanha varchar(100) not null,
    primary key (codigoLider),
    foreign key (nomeCampanha) references Campanha (nomeCampanha)
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

create table LiderCidade ( -- ok
	codigoCidade integer,
	codigoLider integer,
	primary key (codigoCidade, codigoLider),
	foreign key (codigoCidade) references Cidade (codigoCidade),
	foreign key (codigoLider) references Lider (codigoLider)
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

create table LiderFaccao ( -- ok
	codigoFaccao integer,
	codigoLider integer,
	primary key (codigoFaccao, codigoLider),
	foreign key (codigoFaccao) references Faccao (codigoFaccao),
	foreign key (codigoLider) references Lider (codigoLider)
);

create table Deus ( -- ok
	codigoDeus serial,
	nomeDeus varchar(50) not null,
	mitologia varchar(30) not null,
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

create table Plano ( -- ok
	nomePlano varchar(50),
	descricao text, 
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
create table Mundo ( -- ok
	nomeCampanha varchar(100),
	nomePlano varchar(50),
	primary key (nomeCampanha, nomePlano),
	foreign key (nomeCampanha) references Campanha (nomeCampanha),
	foreign key (nomePlano) references Plano (nomePlano)
);

-- Tabelas referentes a Personagem
create table Personagem ( -- ok
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
	classeArmadura integer,
	--Atts adicionados como text
	caracteristicaAdicional text,
	vinculo text,
	defeito text,
	ideal text,
	tracoPersonalidade text,
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

/*
create table PersonagemCaracteristicaAdicional ( -- revisar
	codigoPersonagem integer,
	caracteristicaAdicional text not null,
	primary key (codigoPersonagem),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem)
);
create table PersonagemVinculo ( -- revisar
	codigoPersonagem integer,
	vinculo text not null,
	primary key (codigoPersonagem),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem)
);
create table PersonagemDefeito ( -- revisar
	codigoPersonagem integer,
	defeito text not null,
	primary key (codigoPersonagem),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem)
);
create table PersonagemIdeal ( -- revisar
	codigoPersonagem integer,
	ideal text not null,
	primary key (codigoPersonagem),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem)
);
create table PersonagemTracoPersonalidade (  -- revisar
	codigoPersonagem integer,
	tracoPersonalidade text not null,
	primary key (codigoPersonagem),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem)
);
*/

create table PontosExperienciaNivel ( -- revisar
	pontosExperiencia integer,
	nivel integer not null,
	primary key (pontosExperiencia)
);

create table PersonagemTalento ( -- revisar
	codigoPersonagem integer,
	nomeTalento varchar(30),
	primary key (codigoPersonagem, nomeTalento),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem),
	foreign key (nomeTalento) references Talento (nomeTalento)
);

create table PersonagemItem ( -- revisar
	codigoPersonagem integer,
	nomeItem varchar(30),
	quantidade integer,
	equipado boolean,
	primary key (codigoPersonagem, nomeItem),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem),
	foreign key (nomeItem) references Item (nomeItem)
);

create table PersonagemPericia ( -- revisar
	codigoPersonagem integer,
	nomePericia varchar(30),
	modificador integer not null,
	primary key (codigoPersonagem, nomePericia),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem),
	foreign key (nomePericia) references Pericia (nomePericia)
);

create table PersonagemMagia ( -- revisar
	codigoPersonagem integer, -- personagem deve possuir nivel maior ou igual que a magia exige
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