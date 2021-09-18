create table Habilidade (
	valor integer CHECK (valor>=1 AND valor<=30),
	valorModificador integer not null CHECK (valorModificador>=-5 AND valorModificador<=10),
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
	preRequisito text DEFAULT 'Não há pré requisitos para este talento',
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

--Tabelas de Monstro
create table Monstro (
	nomeMonstro varchar(40),
	descricao text not null,
	foto varchar(120) DEFAULT 'monstro_padrao.jpg',
	classeArmadura integer not null,
	pontosVidaBase integer not null,
	tendencia varchar(30) not null,
	nivel numeric(6,3) not null,
	pontosExperiencia integer not null,
	formaCorporal varchar(30) not null,
	tamanho varchar(30) not null,
	deslocamentoBase numeric(3, 1) not null,
	primary key (nomeMonstro)
);

create table CaracteristicaMonstro (
--texto vermelho, não inclui deslocamento
	nome varchar(35),
	nomeMonstro varchar(40),
	descricao text not null,
	primary key (nome, nomeMonstro),
	foreign key (nomeMonstro) references Monstro(nomeMonstro)
);

create table MonstroHabilidade (
	nomeMonstro varchar(40),
	nomeHabilidade varchar(15),
	valor integer not null CHECK (valor>=1 AND valor<=30),
	primary key (nomeMonstro, nomeHabilidade),
	foreign key (nomeMonstro) references Monstro (nomeMonstro),
	foreign key (valor) references Habilidade (valor)
);

-- Tabelas de Raça
create table Raca (
	nomeRaca varchar(50),
	caminhoImagem varchar(150) DEFAULT 'raca_padrao.jpg',
	descricao text not null,
	primary key(nomeRaca)
);

create table SubRaca (
	nomeSubRaca varchar(60),
	nomeRaca varchar(50),
	descricao text,
	deslocamento numeric(5, 2) not null,
	idadeAdulto integer not null,
	idadeExpectativaVida integer not null, 
	tamanho varchar(30) not null,
	tendencia text not null,
	forca integer not null, 
	destreza integer not null, 
	constituicao integer not null, 
	sabedoria integer not null, 
	inteligencia integer not null,
	carisma integer not null,
	primary key (nomeSubRaca, nomeRaca),
	foreign key (nomeRaca) references Raca(nomeRaca)
);

-- Tabelas de Item 
create table Item (
	nomeItem text,
	descricao text DEFAULT 'Este item é tão misterioso que nem nossos magos mais sábios fazem ideia do que se trata.',
	categoria text not null,
	custo integer not null,
	moeda char(2) not null,
	peso numeric(7,2) not null,
	primary key (nomeItem)
);

create table Arma (
	nomeItem text,
	tipo varchar(50) not null,
	dano varchar(30) not null,
	primary key (nomeItem),
	foreign key (nomeItem) references Item (nomeItem)
);

create table PropriedadeArma (
	nomePropriedade varchar(30),
	descricao text not null,
	primary key (nomePropriedade)
);

create table ArmaPropriedadeArma (
	nomeItem text,
	nomePropriedade varchar(30),
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
	tipo varchar(30),
	equipar integer not null,
	desequipar integer not null,
	medida varchar(7) not null,
	primary key (tipo)
);

create table ArmaduraEscudo (
	nomeItem text,
	classeArmadura integer not null,
	modificadorDes boolean not null,
	maxModificador integer,
	forcaNecessaria integer not null,
	tipo varchar(30) not null,
	furtividade boolean not null,
	primary key (nomeItem),
	foreign key (nomeItem) references Item(nomeItem),
	foreign key (tipo) references Tempo(tipo)
);

create table ItemMagico (
	nomeItem text,
	tipo varchar(30) not null,
	raridade varchar(30) not null,
	requisito text DEFAULT 'Não há nenhum requisito para ser usado',
	primary key (nomeItem),
	foreign key (nomeItem) references Item (nomeItem)
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

--Tabelas de Classe
create table Classe (
	nomeClasse varchar(30),
	descricao text,
	habilidadePrimaria varchar(15) not null,
	habilidadeSecundaria varchar(15),
	habilidadeSecundariaOpcional boolean DEFAULT FALSE,
	testeResistenciaPrimario varchar(15) not null,
	testeResistenciaSecundario varchar(15) not null,
	dadoVida integer not null,
	modificadorVida varchar(15) not null,
	progressaoPadraoVida integer not null,
	primary key (nomeClasse)
);

create table Arquetipo( 
	nomeArquetipo varchar(30),
	nomeClasse varchar(30),
	primary key (nomeArquetipo, nomeClasse),
	foreign key (nomeClasse) references Classe(nomeClasse)
);

create table Atributo (
	nivel integer,
	nomeClasse varchar(30),
	bonusProficiencia integer not null,
	primary key (nivel, nomeClasse),
	foreign key (nomeClasse) references Classe (nomeClasse)
);

create table EspacoMagia (
    numeroTabela integer,
    linhaTabela integer,
    nivelMagia1 integer,
    nivelMagia2 integer,
    nivelMagia3 integer,
    nivelMagia4 integer,
    nivelMagia5 integer,
    nivelMagia6 integer,
    nivelMagia7 integer,
    nivelMagia8 integer,
    nivelMagia9 integer,
    primary key (numeroTabela, linhaTabela)
);

create table ClasseEspacoMagia(
    nomeClasse varchar(30),
    nivel integer,
    numeroTabela integer,
    linhaTabela integer,
    primary key(nomeClasse, nivel, numeroTabela, linhaTabela),
    foreign key (nomeClasse, nivel) references Atributo (nomeClasse, nivel),
    foreign key (numeroTabela, linhaTabela) references EspacoMagia (numeroTabela, linhaTabela)
);

create table Barbaro (
	nomeClasse varchar(30),
	nivel integer,
	danoFuria integer not null,
	furias integer not null,
	primary key (nomeClasse, nivel),
	foreign key (nomeClasse, nivel) references Atributo (nomeClasse, nivel)
);

create table Bardo (
	nomeClasse varchar(30),
	nivel integer,
	truquesConhecidos integer not null,
	magiasConhecidas integer not null,
	primary key (nomeClasse, nivel),
	foreign key (nomeClasse, nivel) references Atributo (nomeClasse, nivel)
);

create table Bruxo (
	nomeClasse varchar(30),
	nivel integer,
	truquesConhecidos integer not null,
	magiasConhecidas integer not null,
	nivelMagia integer not null,
	espacosMagia integer not null,
	invocacoesConhecidas integer not null,
	primary key (nomeClasse, nivel),
	foreign key (nomeClasse, nivel) references Atributo (nomeClasse, nivel)
);

create table ClerigoDruidaMago (
	nomeClasse varchar(30),
	nivel integer,
	truquesConhecidos integer not null,
	primary key (nomeClasse, nivel),
	foreign key (nomeClasse, nivel) references Atributo (nomeClasse, nivel)
);

create table Feiticeiro (
	nomeClasse varchar(30),
	nivel integer,
	pontosFeiticaria integer not null,
	truquesConhecidos integer not null,
	magiasConhecidas integer not null,
	primary key (nomeClasse, nivel),
	foreign key (nomeClasse, nivel) references Atributo (nomeClasse, nivel)
);

create table Ladino (
	nomeClasse varchar(30),
	nivel integer,
	quantidadeDadosAtaqueFurtivo integer not null,
	grandezaDadoAtaqueFurtivo integer not null,
	primary key (nomeClasse, nivel),
	foreign key (nomeClasse, nivel) references Atributo (nomeClasse, nivel)
);

create table Monge (
	nomeClasse varchar(30),
	nivel integer,
	deslocamentoSemArmadura numeric(2, 1) not null,
	quantidadeDadosArtesMarciais integer not null,
	grandezaDadoArtesMarciais integer not null,
	pontosChi integer not null,
	primary key (nomeClasse, nivel),
	foreign key (nomeClasse, nivel) references Atributo (nomeClasse, nivel)
);

create table Patrulheiro (
	nomeClasse varchar(30),
	nivel integer,
	magiasConhecidas integer not null,
	primary key (nomeClasse, nivel),
	foreign key (nomeClasse, nivel) references Atributo (nomeClasse, nivel)
);

create table ClasseMagia (
	nomeClasse varchar(30),
	nomeMagia varchar(35),
	primary key (nomeClasse, nomeMagia),
	foreign key (nomeClasse) references Classe (nomeClasse),
	foreign key (nomeMagia) references Magia (nomeMagia)
);

create table ClassePericia (
	nomeClasse varchar(30),
	nomePericia varchar(30),
	primary key (nomeClasse, nomePericia),
	foreign key (nomeClasse) references Classe (nomeClasse),
	foreign key (nomePericia) references Pericia (nomePericia)

);

-- Tabelas de Campanha
create table Campanha (
	nomeCampanha varchar(100),
	descricao text DEFAULT 'Os aventureiros se esqueceram de incluir um bom bardo na caravana, portanto os acontecimentos dessa aventura foram esquecidos há muito tempo',
	primary key (nomeCampanha)
);

create table Lider (
	codigoLider serial,
    nomeLider varchar(50) not null,
    descricao text,
    nomeCampanha varchar(100) not null,
    constraint liderCampanha UNIQUE (nomeLider, nomeCampanha),
    primary key (codigoLider),
    foreign key (nomeCampanha) references Campanha (nomeCampanha)
);

create table Cidade (
	codigoCidade serial,
	nomeCidade varchar(50) not null,
	nomeCampanha varchar(100) not null,
	comercio varchar(50) not null,
	clima varchar(30) not null,
	vegetacao varchar(30) not null,
	populacao integer not null,
	formaGoverno varchar(30) not null,
	descricao text,
    constraint cidadeCampanha UNIQUE (nomeCidade, nomeCampanha),
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
	populacao integer not null,
	formaGoverno varchar(30) not null,
	descricao text,
    constraint faccaoCampanha UNIQUE (nomeFaccao, nomeCampanha),
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
	tendencia varchar(30) not null,
	simbolo varchar(100) not null,
	descricao text DEFAULT 'Segundo nossos sábios, ou essa entidade foi esquecida há muito tempo ou é é conhecida mais a fundo apenas por um seleto grupo de adoradores',
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
	corCortina varchar(30),
	corPoco varchar(30),
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

-- Tabelas de Personagem
create table Aparencia (
	codigoAparencia serial,
	nomePersonagem varchar(30),
	altura numeric(7, 2),
	peso numeric(7, 2),
	foto varchar(150) DEFAULT 'player_padrao.jpg',
	corOlhos varchar(30),
	idade integer,
	corPele varchar(30),
	corCabelo varchar(30),
	primary key (codigoAparencia)
);

create table Personagem (
	codigoPersonagem serial, 
	nomeJogador varchar(30) not null,
	nomeCampanha varchar(100) not null,
	personagemRaca varchar(30) not null,
	personagemClasse varchar(30) not null,
	codigoDeus integer,
	codigoAparencia integer,
	arquetipo varchar(30),
	nomeAntecedente varchar(30),
	tendencia varchar(30) not null,
	percepcaoPassiva integer not null,
	numeroInspiracao integer DEFAULT 0,
	pontosVidaAtual integer,
	pontosVidaTotal integer,
	pontosExperiencia integer DEFAULT 0,
	capacidadeCarga integer,
	cobre integer,
	prata integer,
	ouro integer,
	platina integer,
	electro integer,
	classeArmadura integer,
	deslocamento numeric(3, 1),
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
	codigoPersonagem integer,
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

--Trigger
create or replace function atualiza_armadura() 
    returns trigger 
    as 
$$
begin
    update Personagem 
    set classeArmadura = (
    	select COALESCE(SUM(foo.classeArmadura),0)
    	from PersonagemItem join (
    			select ArmaduraEscudo.nomeItem as nomeItem, ArmaduraEscudo.classeArmadura as classeArmadura
    			from Item join ArmaduraEscudo on Item.nomeItem = ArmaduraEscudo.nomeItem
    		)as foo on PersonagemItem.nomeItem = foo.nomeItem
    	where PersonagemItem.equipado = TRUE AND PersonagemItem.codigoPersonagem = NEW.codigoPersonagem
    	)
    where codigoPersonagem = NEW.codigoPersonagem;
    return new;
end;
$$ language plpgsql;


create trigger atualizar_classe_de_armadura 
    after insert or update or delete on PersonagemItem
    for each row
    	execute procedure atualiza_armadura();