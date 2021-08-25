create table Habilidade (
	valor integer,
	valorModificador integer not null,
	primary key (valor)
);

create table Magia (
	nomeMagia varchar(35),
	tipo text not null,
	nivel integer not null,
	descricao text not null,
	duracao text not null,
	componentes text not null,
	alcance text not null,
	tempoConjuracao text not null,
	primary key (nomeMagia)
);

create table Pericia (
	nomePericia varchar(30),
	descricao text not null,
	habilidadeImpacta varchar(15) not null,
	primary key (nomePericia)
);

create table Talento (
	nomeTalento varchar(40),
	preRequisito text,
	descricao text not null,
	primary key (nomeTalento)
);

create table BonusTalento (
	codigoBonusTalento serial, 
	nomeTalento varchar(40) not null,
	descricao text not null,
	primary key (codigoBonusTalento),
	foreign key (nomeTalento) references Talento(nomeTalento)

);


-- Tabelas referentes a Raca
create table Raca (
	nomeRaca varchar(30),
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
	primary key (nomeRaca)
);

create table CaracteristicaRaca(
	nomeCaracteristica varchar(50),
	nomeRaca varchar(30),
	descricao text not null,
	primary key(nomeCaracteristica, nomeRaca),
	foreign key (nomeRaca) references Raca(nomeRaca)
);

create table TracoEspecialRaca(
	nomeTraco varchar(50),
	nomeRaca varchar(30),
	descricao text not null,
	primary key (nomeTraco, nomeRaca),
	foreign key (nomeRaca) references Raca (nomeRaca)
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
	primary key (nomeSubRaca, nomeRaca),
	foreign key (nomeRaca) references Raca (nomeRaca)
);

create table TracoEspecialSubRaca(
	nomeTraco varchar(50),
	nomeSubRaca varchar(50),
	nomeRaca varchar(30),
	descricao text not null,
	primary key (nomeTraco, nomeSubRaca, nomeRaca),
	foreign key (nomeSubRaca, nomeRaca) references SubRaca (nomeSubRaca, nomeRaca)
);

-- Tabelas refrentes a Monstro
create table Monstro (
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

create table MonstroHabilidade (
	nomeMonstro varchar(40),
	nomeHabilidade varchar(15),
	valor integer not null,
	primary key (nomeMonstro, nomeHabilidade),
	foreign key (nomeMonstro) references Monstro (nomeMonstro),
	foreign key (valor) references Habilidade (valor)
);

-- Tabelas referentes a Classe


create table ClasseMagia (
	nomeClasse varchar(20),
	nomeMagia varchar(35),
	primary key (nomeClasse, nomeMagia),
	foreign key (nomeClasse) references Classe (nomeClasse),
	foreign key (nomeMagia) references Magia (nomeMagia)
);

create table ClassePericia (
	nomeClasse varchar(20),
	nomePericia varchar(30),
	primary key (nomeClasse, nomePericia),
	foreign key (nomeClasse) references Classe(nomeClasse),
	foreign key (nomePericia) references Pericia(nomePericia)
);

-- Tabelas referentes a Item 
create table Item (
	nomeItem text,
	descricao text,
	categoria text not null, -- ex: arma, montaria e tal
	custo integer not null,
	moeda char(2) not null,
	peso numeric(7,2) not null,
	primary key (nomeItem)
);
-- To-do : criar constraint que as tabelas de itens tem que ter a categoria
create table Arma (
	nomeItem text,
	tipo varchar(50) not null,
	dano varchar(20) not null,
	primary key (nomeItem),
	foreign key (nomeItem) references Item (nomeItem)
);

create table PropriedadeArma (
	nomePropriedade varchar(20),
	descricao text not null,
	primary key (nomePropriedade)
);

create table ArmaPropriedadeArma (
	nomeItem text,
	nomePropriedade varchar(20),
	descricao text,
	primary key (nomeItem, nomePropriedade),
	foreign key (nomeItem) references Arma (nomeItem),
	foreign key (nomePropriedade) references PropriedadeArma (nomePropriedade)
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
	medida varchar(7) not null,
	primary key (tipo)
);

create table ArmaduraEscudo (
	nomeItem text,
	classeArmadura integer not null,
	modificadorDes boolean not null, --se possui modificador de des
	maxModificador integer, --valor maximo do modificador de des
	forcaNecessaria integer not null,
	tipo varchar(20) not null,
	furtividade boolean not null, -- caso true, o atributo possui desvantagem
	primary key (nomeItem),
	foreign key (nomeItem) references Item(nomeItem),
	foreign key (tipo) references Tempo(tipo)
);

create table ItemMagico (
	nomeItem text,
	tipo varchar(30) not null,
	raridade varchar(20) not null,
	requisito text,
	primary key (nomeItem),
	foreign key (nomeItem) references Item (nomeItem)
);

-- Tabelas referentes a Antecedente
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
create table Campanha (
	nomeCampanha varchar(100),
	descricao text,
	mapaAtual integer,
	primary key (nomeCampanha)
);

create table Mapa (
	codigoMapa serial,
	nomeCampanha text not null,
	mapa text not null,
	primary key (codigoMapa),
	foreign key (nomeCampanha) references Campanha (nomeCampanha)
);

create table Anotacao (
	codigoAnotacao serial,
	nomeCampanha varchar(100) not null,
	anotacao text,
	primary key (codigoAnotacao),
	foreign key (nomeCampanha) references Campanha (nomeCampanha)
);

create table Lider (
	codigoLider serial,
	nomeLider varchar(50) not null,
	descricao text,
	primary key (codigoLider)
);

create table Cidade (
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

create table LiderCidade (
	codigoCidade integer,
	codigoLider integer,
	primary key (codigoCidade, codigoLider),
	foreign key (codigoCidade) references Cidade (codigoCidade),
	foreign key (codigoLider) references Lider (codigoLider)
);

create table Faccao (
	codigoFaccao serial,
	nomeFaccao varchar(30) not null,
	nomeCampanha varchar(100) not null,
	formaGoverno varchar(20) not null,
	descricao text,
	primary key (codigoFaccao),
	foreign key (nomeCampanha) references Campanha (nomeCampanha)	
);

create table LiderFaccao (
	codigoFaccao integer,
	codigoLider integer,
	primary key (codigoFaccao, codigoLider),
	foreign key (codigoFaccao) references Faccao (codigoFaccao),
	foreign key (codigoLider) references Lider (codigoLider)
);

create table Deus (
	codigoDeus serial,
	nomeDeus varchar(50) not null,
	mitologia varchar(30) not null,
	dominio varchar(100) not null,
	tendencia varchar(20) not null,
	simbolo varchar(100) not null,
	descricao text,
	primary key (codigoDeus)
);

create table PanteaoCampanha (
	nomeCampanha varchar(100),
	codigoDeus integer,
	primary key (nomeCampanha, codigoDeus),
	foreign key (nomeCampanha) references Campanha (nomeCampanha),
	foreign key (codigoDeus) references Deus (codigoDeus)
);

create table Plano (
	nomePlano varchar(50),
	descricao text, 
	corCortina varchar(20),
	corPoco varchar(20),
	primary key (nomePlano)
);

create table Regra (
	nomeRegra varchar(50),
	nomePlano varchar(50),
	descricao text not null,
	primary key (nomeRegra, nomePlano),
	foreign key (nomePlano) references Plano (nomePlano)	
);
create table Mundo (
	nomeCampanha varchar(100),
	nomePlano varchar(50),
	primary key (nomeCampanha, nomePlano),
	foreign key (nomeCampanha) references Campanha (nomeCampanha),
	foreign key (nomePlano) references Plano (nomePlano)
);

-- Tabelas referentes a Personagem
create table Personagem (
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

create table Aparencia (
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
create table PersonagemCaracteristicaAdicional (
	codigoPersonagem integer,
	caracteristicaAdicional text not null,
	primary key (codigoPersonagem),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem)
);


create table PersonagemVinculo (
	codigoPersonagem integer,
	vinculo text not null,
	primary key (codigoPersonagem),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem)
);

create table PersonagemDefeito (
	codigoPersonagem integer,
	defeito text not null,
	primary key (codigoPersonagem),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem)
);

create table PersonagemIdeal (
	codigoPersonagem integer,
	ideal text not null,
	primary key (codigoPersonagem),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem)
);

create table PersonagemTracoPersonalidade ( 
	codigoPersonagem integer,
	tracoPersonalidade text not null,
	primary key (codigoPersonagem),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem)
);
*/

create table PontosExperienciaNivel (
	pontosExperiencia integer,
	nivel integer not null,
	primary key (pontosExperiencia)
);

create table PersonagemTalento ( 
	codigoPersonagem integer,
	nomeTalento varchar(30),
	primary key (codigoPersonagem, nomeTalento),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem),
	foreign key (nomeTalento) references Talento (nomeTalento)
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

create table PersonagemPericia (
	codigoPersonagem integer,
	nomePericia varchar(30),
	modificador integer not null,
	primary key (codigoPersonagem, nomePericia),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem),
	foreign key (nomePericia) references Pericia (nomePericia)
);

create table PersonagemMagia (
	codigoPersonagem integer, -- personagem deve possuir nivel maior ou igual que a magia exige
	nomeMagia varchar(30),
	primary key (codigoPersonagem, nomeMagia),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem),
	foreign key (nomeMagia) references Magia (nomeMagia)
);

create table PersonagemHabilidade (
	codigoPersonagem integer,
	nomeHabilidade varchar(15),
	valor integer not null,
	primary key (codigoPersonagem, nomeHabilidade),
	foreign key (codigoPersonagem) references Personagem (codigoPersonagem),
	foreign key (valor) references Habilidade (valor)
);
