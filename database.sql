create table Raca (
	nomeRaca varchar(30),
	descricao text not null,
	idadeAdulto integer not null,
	tendencia varchar(20) not null,
	idadeExpectativaVida integer  not null, 
	tamanho varchar(50) not null, 
	forca integer not null, 
	destreza integer not null, 
	constituicao integer not null, 
	sabedoria integer not null, 
	inteligencia integer not null,
	carisma integer not null,
	primary key(nomeRaca)
);