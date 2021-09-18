insert into Personagem (nomeJogador, nomeCampanha, personagemSubRaca, personagemClasse, 	codigoDeus,	codigoAparencia, arquetipo,	nomeAntecedente, coordenadaX, coordenadaY, tendencia, percepcaoPassiva,	numeroInspiracao, pontosVidaAtual, pontosVidaTotal,	pontosExperiencia, capacidadeCarga,	cobre, prata, ouro, platina, electro, classeArmadura, deslocamento, caracteristicaAdicional, vinculo, defeito, ideal, tracoPersonalidade) values 
	('Igor', 'Lorin', 'Elfo', 'Bardo', 1, NULL, NULL, NULL, NULL, NULL, 'NB', 3, 1,20,	20,	300, 6, 5, 4, 6, 3, 4, 10, 2, NULL, NULL, NULL, NULL, NULL),
	('Lucas', 'Lorin', 'Elfo', 'Mago', 1, NULL, NULL, NULL, NULL, NULL, 'NB', 3, 1, 7,	21,	4500, 6, 5, 4, 6, 3, 4, 10, 13, NULL, NULL, NULL, NULL, NULL);


insert into Aparencia (nomePersonagem, altura, peso, corOlhos, idade, corPele, corCabelo) values 
('Sassa', 1.80, 65, 'verde', 21, 'branca', 'castanho'),
('Spalshz', 1.85, 70, 'castanho', 23, 'branca', 'preto');

insert into PersonagemHabilidade (codigoPersonagem,	nomeHabilidade,	valor) values
	(1, 'Força', 12),
	(1, 'Destreza', 14),
	(1, 'Constituição', 16),
	(1, 'Inteligência', 10),
	(1, 'Sabedoria', 13),
	(1, 'Carisma', 15),
	(2, 'Força', 7),
	(2, 'Destreza', 12),
	(2, 'Constituição', 10),
	(2, 'Inteligência', 18),
	(2, 'Sabedoria', 12),
	(2, 'Carisma', 13);
	
/*
insert into PersonagemItem (
	codigoPersonagem,
	nomeItem,
	quantidade,
	equipado
) values (
	1,
	'Armadura Pesada Placas',
	2,
	TRUE
);

insert into PersonagemMagia(codigoPersonagem,nomeMagia) values 
(1,'Acalmar Emoções'),
(1,'Ampliar Plantas'),
(1,'Cativar');
*/