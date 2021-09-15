insert into Campanha (nomeCampanha,	descricao, mapaAtual) values
	('Lorin', 'Campanha que eu mestrei sábado à noite durante o rolê só por diversão', (select codigoMapa from Mapa where mapa = 'lorin.jpg'));

insert into Cidade (nomeCidade, nomeCampanha,	comercio, clima, vegetacao,	populacao, formaGoverno, descricao) values
	('Ardat', 'Lorin', 'Inexistente', 'Quente', 'Praia', 50, 'Monarquia', 'Ilhota pouco habitada. Muitas lendas existem sobre esse lugar, mas porém é lar de muitas criaturas há muito tempo esquecidas pelo homem.'),
	('Castor', 'Lorin', 'Inexistente', 'Quente', 'Praia', 70, 'Monarquia', 'Vilarejo formada em volta de uma caverna de minério de prata.'),
	('Pollug', 'Lorin', 'Subdesenvolvido', 'Árido', 'Planície', 200, 'Monarquia', 'Vilarejo formada em volta de uma caverna de minério de ouro.'),
	('Vöcklaheim', 'Lorin', 'Decadente', 'Quente', 'Praia',100 , 'Monarquia', 'Pequena vila de pescadores e esconderijo de piratas.'),
	('Zhyzhynsk', 'Lorin', 'Subdesenvolvido', 'Quente', 'Praia', 250, 'Monarquia', 'Última cidade a ser tomada pelo o atual rainha, a população ainda nutre ódio pela atual monarquia, existem rumores de uma resistência rebelde estar se formando por lá.'),
	('Regenskirck', 'Lorin', 'Subdesenvolvido', 'Tropical', 'Úmido', 300, 'Monarquia', 'Vila formada em volta do monumento do lendário pescador do lago verde.'),
	('Hya Alari', 'Lorin', 'Inexistente', 'Pântano', 'Úmido', 40, 'Monarquia', 'Pântano habitado por criaturas perigosas e alguns foragidos que não querem ser incomodados.'),
	('Eyrr', 'Lorin', 'Desenvolvido', 'Quente', 'Praia', 1000, 'Monarquia', 'Antiga capital. Após a invasão do nova rainha a maior parte da população imigrou para Oclesh.'),
	('Lyros', 'Lorin', 'Médio', 'Quente', 'Praia', 900, 'Monarquia', 'Segundo os demais habitantes de Lorin, Lyros é a cidade mais alegre do planeta, ninguém sabe o porquê.'),
	('Toasoalii', 'Lorin', 'Desenvolvido', 'Tropical', 'Úmido', 1200, 'Monarquia', 'Cidade altamente militarizada. É utilizada para treinar os guerreiros do reino.'),
	('Oclesh', 'Lorin', 'Avançado', 'Quente', 'Desértico', 5000, 'Monarquia', 'Capital da cidade, repleta por casas e castelos de areia mágica que são tão fortes quanto aço. Ninguém sabe o motivo da areia desta região ser assim, mas como isso era fato deste antes do nascimento dos antepassados de todos os cidadãos, ninguém quentiona nem busca conhecer a origem desta areia.'),
	('Carteia', 'Lorin', 'Baixo', 'Tropical', 'Úmido', 150, 'Monarquia', 'Cidade cercada por uma magia de nevasca lançada por um mago poderoso há muito tempo atrás. A fonte da nevasca parece vir do cume da montanha central porém ninguém teve coragem de chegar até lá ainda.'),
	('Chordata', 'Lorin', 'Inexistente', 'Quente', 'Praia', 6, 'Monarquia', 'Ilha habitada por uma família de cinco pessoas que imaginam ser os únicos a morarem naquela ilha... Mal sabem quem os faz companhia.'),
	('Viirim', 'Lorin', 'Inexistente', 'Quente', 'Praia', 400, 'Monarquia', 'Cidade que se desenvolveu um pouco mais do que deveria e por isso não tem uma arquitetura muito bem definida. Esse crescimento espontâneo se deve ao fato de ela servir como rota entre a capital e a porção de terra maior onde alguns malucos da capital vão para se aventurar');

insert into Lider (nomeLider, descricao, nomeCampanha) values
	('Areqwa', 'Filha mais nova do grande conquistador Théros, com o exército que ganhou de seu pai quando completou 17 anos, conquistou toda a extensão de Lorin cinco anos atrás em apenas dois meses. Odiada por muitos e bajulada por qualquer um que deseje seguir qualquer carreira política nas terras dominadas por ela.', 'Lorin'),
	('Ninel', 'Criado por um casal de camponeses que foram assassinados durante a invasão de Zhyzhynsk, nutriu tamanho ódio pela rainha que foi capaz de organizar e chefiar vários homens e mulheres repletos de ódio pelo governo para derrubálo de qualquer maneira. Ninguém sabe ao certo sua aparência ou seu paradeiro atual, mas todos sabem que onde quer que esteja ele está tramando algum plano perfeito para a derrubada do governo.', 'Lorin');

insert into Faccao (nomeFaccao, nomeCampanha, populacao, formaGoverno, descricao) values
	('Rebeldes de Zhyzhynsk', 'Lorin', 150, 'Democracia', 'Os Rebeldes de Zhyzhyns surgiram após a mesma ser tomada pela nova governante de Lorin. Seus membros operam nas sombras e recrutando qualquer um que seja revoltado o bastante contra o atual governo. Seu objetivo é apenas um: a derrubada da rainha por qualquer meio e a instauração de uma democracia no arquipélado de Lorin. Seguem fielmente os pensamentos descritos nos pergaminhos do antigo herói da ilha, Faustor.');

insert into LiderFaccao (codigoFaccao, codigoLider) values
	((select codigoFaccao from Faccao where nomeFaccao = 'Rebeldes de Zhyzhynsk'),(select codigoLider from Lider where nomeLider = 'Ninel'));

insert into LiderCidade (codigoCidade, codigoLider) values
	((select codigoCidade from Cidade where nomeCidade = 'Ardat'),(select codigoLider from Lider where nomeLider = 'Areqwa')),
	((select codigoCidade from Cidade where nomeCidade = 'Castor'),(select codigoLider from Lider where nomeLider = 'Areqwa')),
	((select codigoCidade from Cidade where nomeCidade = 'Pollug'),(select codigoLider from Lider where nomeLider = 'Areqwa')),
	((select codigoCidade from Cidade where nomeCidade = 'Vöcklaheim'),(select codigoLider from Lider where nomeLider = 'Areqwa')),
	((select codigoCidade from Cidade where nomeCidade = 'Zhyzhynsk'),(select codigoLider from Lider where nomeLider = 'Areqwa')),
	((select codigoCidade from Cidade where nomeCidade = 'Regenskirck'),(select codigoLider from Lider where nomeLider = 'Areqwa')),
	((select codigoCidade from Cidade where nomeCidade = 'Hya Alari'),(select codigoLider from Lider where nomeLider = 'Areqwa')),
	((select codigoCidade from Cidade where nomeCidade = 'Eyrr'),(select codigoLider from Lider where nomeLider = 'Areqwa')),
	((select codigoCidade from Cidade where nomeCidade = 'Lyros'),(select codigoLider from Lider where nomeLider = 'Areqwa')),
	((select codigoCidade from Cidade where nomeCidade = 'Toasoalii'),(select codigoLider from Lider where nomeLider = 'Areqwa')),
	((select codigoCidade from Cidade where nomeCidade = 'Oclesh'),(select codigoLider from Lider where nomeLider = 'Areqwa')),
	((select codigoCidade from Cidade where nomeCidade = 'Carteia'),(select codigoLider from Lider where nomeLider = 'Areqwa')),
	((select codigoCidade from Cidade where nomeCidade = 'Chordata'),(select codigoLider from Lider where nomeLider = 'Areqwa')),
	((select codigoCidade from Cidade where nomeCidade = 'Viirim'),(select codigoLider from Lider where nomeLider = 'Areqwa'));

insert into Mapa (nomeCampanha,	mapa) values
	('Lorin', 'lorin.jpg'),
	('Lorin', 'climbUpMountain.jpg'),
	('Lorin', 'hallOfSacredSpells.jpg');

insert into Anotacao (nomeCampanha, anotacao) values
	('Lorin', 'Podem haver mais comunidades e vilas espalhadas pelo mapa que não são classificadas como cidades pelo mapa político de Lorin'),
	('Lorin', 'É de conhecimento popular que quanto mais a oeste do arquipélago, mais elevado é o perigo que os aventureiros correm');