insert into Monstro(nomeMonstro, introducao, foto, classeArmadura, pontosVida, tendencia, nivel, pontosExperiencia, formaCorporal, tamanho, descricaoAcaoLendaria) values
('Inumano', 'A palavra “inumano” significava “pessoa” nos dias de outrora, mas o nome agora se refere a mortos-vivos malignos que foram mortais guiados por desejos obscuros e grande vaidade. Quando a morte silencia o coração de uma criatura assim e sufoca sua suspiro de vida, seu espírito suplica para o lorde demônio Orcus ou a alguma deus vil do submundo por adiamento: morte-vida em troca de uma guerra eterna contra os vivos. <br />Se um poder obscuro ouvir esse chamado, é concedida ao espírito a morte-vida na qual ele pode perseguir sua própria agenda maligna. Os inumanos possuem as memórias e objetivos do seus antigo eu vivo. Eles irão atender ao chamado de qualquer que seja a entidade trevosa que os transformou em mortos-vivos, fazendo juramentos para acalmar seu novo senhor, enquanto mantem sua autonomia. Nunca se cansando, um inumano pode perseguir seus objetivos sem descanso e sem distração.', NULL, '14 (couro batido)', '45 (6d8 + 18)', 'neutro e mau', 3.0, 700, 'Morto-vivo', 'Médio', NULL),
('Guinchador', 'Um guinchador é um cogumelo do tamanho de um humano que emite guinchos agudos para afastar as criaturas que os perturbam. Outras criaturas usam esses fungos como um alarme para sinalizar a aproximação de presas e várias raças inteligentes do Subterrâneo cultivam guinchadores nos arredores de suas comunidades para desencorajar intrusos.', NULL, '5', '13 (3d8)', 'imparcial', 0.0, 10, 'Planta', 'Média', NULL),
('Flumph', 'Os misteriosos flumphs vagam pelo Subterrâneo, impulsionados pelo ar pelos jatos cujo som lhes deu seu nome. Um flumph brilha levemente, refletindo seu humor pela sua cor. Rosa claro significa feliz, azul escuro é tristeza, verde expressa curiosidade e carmesim é raiva.', NULL, '12', '7 (2d6)', 'leal e bom', 0.125, 25, 'Aberração', 'Pequena', NULL),
('Abolete', 'Antes da chegada dos deuses, os aboletes espreitavam nos oceanos primordiais e em lagos subterrâneos. Eles chegaram com suas mentes e tomaram controle das formas de vida florescentes do reino mortal, fazendo dessas criaturas seus escravos. Sua dominação os torna similares a deuses. Então, os verdadeiros deuses apareceram, esmagando o império abolete e libertando seus escravos. Os aboletes nunca esqueceram.', NULL, '17 (armadura natural)', '135 (18d10 + 36)', 'leal e mau', 10.0, 5900, 'Aberração', 'Grande', 'O abolete pode realizar 3 ações lendárias, escolhidas dentre as opções abaixo. Apenas uma ação lendária pode ser usada por vez e apenas no final do turno de outra criatura. O abolete recupera as ações lendárias gastas no começo do turno dele.');

insert into Lore(nome, nomeMonstro, descricao) values
('Devoradores de Vida', 'Inumano', 'Nem morto nem vivo, um inumano existe em um estado transitório entre um mundo e o próximo. A centelha luminosa que ele possuía em vida se foi, e em seu lugar ficou um desejo de consumir a centelha de todas as coisas vivas. Quando um inumano ataca, essa essência brilha como brasas brancas em seus olhos negros, e o toque frio do inumano pode drenar a centelha através da carne, roupas e armaduras.'),
('Sombra da Cripta', 'Inumano', 'Os inumanos fugiram do mundo durante o dia, se afastando da luz do sol, a qual eles detestam. Eles recuam para as covas, criptas e tumbas onde habitam. Seus covis são locais desolados e silenciosos, cercados por plantas mortas, visivelmente enegrecido e evitado por pássaros e bestas.<br /> Os humanoides mortos por um inumano se erguem como zumbis sob seu controle. Motivados por uma fome por almas vivas e levados pelo mesmo desejo de poder que os despertaram como mortos-vivos, alguns inumanos servem como tropas de choque para líderes malignos, incluindo aparições. Como soldados, eles são capazes de planejar, mas raramente o fazem, contando com sua fome de destruição para sobrepujar qualquer criatura que fique em seu caminho.'),
('Natureza Morta-Viva', 'Inumano', 'Um inumano não precisa respirar, comer, beber ou dormir.'),
('Inteligentes e Sábios', 'Flumph', 'Os flumphs se comunicam telepaticamente. Apesar de se parecerem com águas-vivas, os flumphs são seres racionais de grande inteligência e sabedoria, possuindo conhecimentos avançados de religião, filosofia, matemática e incontáveis outros assuntos.<br /> Os flumphs são sensíveis aos estados emocionais das criaturas próximas. Se os pensamentos de uma criatura sugerirem bondade, ele seguirá a criatura. Quando encontrar criaturas que exalem maldade, o flumph fugirá.'),
('Sifôes Psiônicos', 'Flumph', 'Os flumphs se alimentam da energia mental de criaturas psiônicas através de sifões, e eles podem ser encontrados espreitando próximo de comunidades de devoradores de mentes, aboletes, githyanki e githzerai. Como parasitas passivos, eles pegam apenas a energia mental que precisam, e a maioria das criaturas não sentem qualquer perda ou desconforto de tal alimentação.<br /> Consumir energia psiônica revela os pensamentos e emoções das criaturas das quais os flumphs se alimentam. Já que tantas dessas criaturas são malignas, os flumphs são expostos a pensamentos, emoções e anseios que adoecem sua natureza pura. Quando os flumphs encontram aventureiros de coração bom, eles avidamente compartilhas os segredos obscuros que aprenderam na esperança de se livrar da sua fonte de energia maligna, mesmo que fazer isso signifique que precisarão buscar novas fontes de nutrição.'),
('Sociedade Flumph', 'Flumph', 'Os flumphs vivem em grupos complexos e organizados chamados claustros, nos quais cada flumph tem um lugar e propósito. Esses grupos harmoniosos não precisam de líderes, já que todos os flumphs contribuem do jeito que podem.'),
('Memórias Eternas', 'Abolete', 'Os aboletes possuem memórias impecáveis. Eles passam seus conhecimentos e experiências de geração em geração. Então, a injuria da derrota deles pelos deuses permanece perfeitamente preservada em suas mentes.<br /> A mente dos aboletes são preciosos conhecimentos antigos, relembrando de momentos da pré-história com perfeita clareza. Eles tramaram pacientemente e intrincadamente através das eras. Poucas criaturas podem conceber a extensão dos planos de um abolete.'),
('Deuses no Lago', 'Abolete', 'Os aboletes habitam ambientes aquáticos, incluindo abismos oceânicos, lagos profundos e o Plano Elemental da Água. Nesses domínios e nas terras adjacentes, os aboletes são como deuses, demandando veneração e obediência dos seus subordinados. Quando eles consomem outras criaturas, os aboletes adicionam o conhecimento e as experiências de suas prezas às suas memórias eternas.<br /> Os aboletes usam seus poderes telepáticos para ler a mente de  riaturas e descobrir seus desejos. Um abolete usa esse conhecimento para ganhar a lealdade da criatura, prometendo satisfazer tais necessidades em troca de obediência. Dentro do seu covil, o abolete pode, posteriormente, usar seus poderes para enganar os sentidos, fornecendo às criaturas, como seus seguidores, a ilusão das recompensas prometidas.'),
('Inimigos dos Deuses', 'Abolete', 'A queda do poder dos aboletes está escrita com total claramente em suas memórias impecáveis, pois os aboletes nunca morrem de verdade. Se o corpo de um abolete for destruído, seu espírito retorna para o Plano Elemental da Água, onde um novo corpo se funde a ele ao longo de dias ou meses.<br /> Em última análise, os aboletes sonham em destituir os deuses e recuperar o controle sobre o mundo. Os aboletes tiveram incalculáveis eras para tramar e preparar seus planos para uma perfeita execução.'),
('O Covil do Abolete', 'Abolete', 'O covil de um abolete em lagos subterrâneos ou nas profundezas rochosas do oceano, frequentemente é cercado pelas ruínas de uma antiga cidade abolete caída. Um abolete passa a maior parte de sua existência submerso, emergindo ocasionalmente para lidar com visitantes ou adoradores dementes.'),
('Ações de Covil', 'Abolete', 'Quando estiver lutando dentro de seu covil, um abolete pode invocar a magia ambiente para realizar ações de covil. No valor de iniciativa 20 (quebrando toda a sequência de iniciativa), o abolete realiza uma ação de covil fazendo um dos efeitos a seguir:<br /> 
- O abolete conjura força fantasmagórica (nenhum componente é necessário) em qualquer quantidade de criaturas que ele possa ver, a até 18 metros dele. Enquanto mantiver a concentração nesse efeito, o abolete não pode realizar outras ações de covil. Se um alvo for bem sucedido no teste de resistência ou se o efeito terminar para ele, o alvo ficará imune a ação de covil força fantasmagórica do abolete pelas próximas 24 horas, apesar de tal criatura poder escolher ser afetada.<br /> 
- Poças de água a até 27 metros do abolete formam marés agarradoras. Qualquer criatura no solo a até 6 metros de tais poças deve ser bem sucedida num teste de resistência de Força CD 14, ou será puxada 6 metros para dentro da água e ficará caída. O abolete não pode usar essa ação de covil novamente até ter usado uma ação diferente.<br /> 
- A água no covil do abolete magicamente se transforma um condutor para a ira da criatura. O abolete pode afetar qualquer número de criaturas dentro da água que ele possa ver a até 27 metros dele. Um alvo deve ser bem sucedido num teste de resistência de Sabedoria CD 14 ou sofrerá 7 (2d6) de dano psíquico. O abolete não pode usar essa ação de covil novamente até ter usado uma ação diferente.'),
('Efeitos Regionais', 'Abolete', 'A região contendo o covil de um abolete é deformada pela presença da criatura, o que cria um ou mais dos seguintes efeitos:<br /> 
- Superfícies subterrâneas a até 1,5 quilômetro do covil de um abolete fica viscosa e úmida se torna terreno difícil.
- Fontes de água a até 1,5 quilômetro do covil ficam sobrenaturalmente poluídas. Os inimigos do abolete que beberem dessa água vomitarão dentro de minutos.
- Com uma ação, o abolete pode criar uma imagem ilusória de si mesmo a até 1,5 quilômetro do seu covil. A cópia pode aparecer em qualquer lugar que o abolete já tenha visto anteriormente ou em qualquer lugar que uma criatura enfeitiçada pelo abolete possa ver atualmente. Uma vez criada, a imagem dura enquanto o abolete mantiver a concentração, como se ele estivesse se concentrando em uma magia. Apesar da imagem ser intangível, ela se parece, emite sons e se move como o abolete. O abolete pode sentir, falar e usar telepatia da posição da imagem como se estivesse presente nessa posição. Se a imagem sofrer qualquer dano, ela desaparece. Se o abolete morrer, os primeiros dois efeitos desvanecem dentro de 3d10 dias.');

insert into TracoEspecialMonstro(nome, nomeMonstro, descricao) values
('Sensibilidade à Luz Solar', 'Inumano', 'Enquanto estiver sob luz solar, o inumano tem desvantagem nas jogadas de ataque, assim como em testes de Sabedoria (Percepção) relacionados a visão.'),
('Aparência Falsa', 'Guinchador', 'Enquanto o guinchador permanecer imóvel, ele é indistinguível de um fungo comum.'),
('Deficiência Caído', 'Flumph', 'Se o flumph for derrubado, role um dado. Se o resultado for ímpar, o flumph cai de cabeça para baixo e fica incapacitado. No final de cada um dos seus turnos, o flumph pode realizar um teste de resistência de Destreza CD 10, se desvirando e terminando a condição de incapacitado, caso obtenha sucesso.'),
('Manto Telepático', 'Flumph', 'O flumph é imune a qualquer efeito que possa sentir suas emoções ou ler seus pensamentos, assim como magias de adivinhação.'),
('Telepatia Avançada', 'Flumph', 'O flumph pode perceber o conteúdo de qualquer comunicação telepática usada a até 18 metros dele, e ele não pode ser surpreendido por criaturas que tenham qualquer forma de telepatia.'),
('Anfíbio', 'Abolete', 'O abolete pode respirar ar e água.'),
('Anfíbio.', 'Abolete', 'Quando estiver submerso, o abolete fica envolto por um muco transformador. Uma criatura que toque o abolete ou que atinja ele com um ataque corpo-a-corpo estando a até 1,5 metro dele deve ser bem sucedida num teste de resistência de Constituição CD 14. Se fracassar, a criatura fica adoecida por 1d4 horas. A criatura adoecida só pode respirar sob a água.'),
('Sondagem Telepática', 'Abolete', 'Se uma criatura se comunicar telepaticamente com o abolete, o abolete descobre os maiores desejos da criatura se o abolete puder vê-la.');

insert into CaracteristicaMonstro(nome, nomeMonstro, descricao) values
('Deslocamento', 'Inumano', '9 m'),
('Perícias', 'Inumano', 'Furtividade +4, Percepção +3'),
('Resistência a Dano', 'Inumano', 'necrótico; concussão, cortante e perfurante de armas não-mágicas que não sejam de prata'),
('Imunidade a Dano', 'Inumano', 'veneno'),
('Imunidade a Condição', 'Inumano', 'envenenado, exausto'),
('Sentidos', 'Inumano', 'visão no escuro 18 m, Percepção passiva 13'),
('Idiomas', 'Inumano', 'os idiomas que conhecia em vida'),
('Deslocamento', 'Guinchador', '0 m'),
('Imunidade a Condição', 'Guinchador', 'amedrontado, cego, surdo'),
('Sentidos', 'Guinchador', 'percepção às cegas 9 m (cego além desse raio),
Percepção passiva 6'),
('Idiomas', 'Guinchador', '-'),
('Perícias', 'Flumph', 'Arcanismo +4, História +4, Religião +4'),
('Vulnerabilidade a Dano', 'Flumph', 'psíquico'),
('Sentidos', 'Flumph', 'visão no escuro 18 m, Percepção passiva 12'),
('Idiomas', 'Flumph', 'compreende Subcomum mas não pode falar, telepatia 18 m'),
('Deslocamento', 'Flumph', '1,5 m, voo 9 m'),
('Deslocamento', 'Abolete', '3 m, natação 12 m'),
('Testes de Resistência', 'Abolete', 'Con +6, Int +8, Sab +6'),
('Perícias', 'Abolete', 'História +12, Percepção +10'),
('Sentidos', 'Abolete', 'visão no escuro 36 m, Percepção passiva 20'),
('Idiomas', 'Abolete', 'Dialeto Subterrâneo, telepatia 36 m');
	
insert into Acao(nome, nomeMonstro, descricao) values
('Ataques Múltiplos', 'Inumano', 'O inumano realiza dois ataques com espada longa ou dois ataques com arco longo. Ele pode usar seu Drenar Vida no lugar de um ataque de espada longa.'),
('Drenar Vida', 'Inumano', 'Ataque Corpo-a-Corpo com Magia: +4 para atingir, alcance 1,5 m, uma criatura. Acerto: 5 (1d6 + 2) de dano necrótico. O alvo deve ser bem sucedido num teste de resistência de Constituição CD 13 ou seu máximo de pontos de vida será reduzido em um valor igual ao dano sofrido. Essa redução dura até o alvo terminar um descanso longo. O alvo morre se esse efeito reduzir seu máximo de pontos de vida a 0. Um humanoide morto por esse ataque, se ergue 24 horas depois como um zumbi sob controle do inumano, a não ser que o humanoide seja trazido de volta à vida ou seu corpo seja destruído. O inumano pode ter até doze zumbis sob seu controle ao mesmo tempo.'),
('Espada Longa', 'Inumano', 'Ataque Corpo-a-Corpo com Arma: +4 para atingir, alcance 1,5 m, um alvo. Acerto: 6 (1d8 + 2) de dano cortante, ou 7 (1d10 + 2) de dano cortante se usada com as duas mãos.'),
('Arco Longo', 'Inumano', 'Ataque à Distância com Arma: +4 para atingir, distância 45/180 m, um alvo. Acerto: 6 (1d8 + 2) de dano perfurante.'),
('Guincho', 'Guinchador', 'Quando luz plena ou uma criatura está a até 9 metros de um guinchador, ele emite um guincho audível a até 90 metros dele. O guinchador continua a guinchar até a perturbação se afastar do seu alcance e por mais 1d4 turnos do guinchador depois disso.'),
('Gavinhas', 'Flumph', 'Ataque Corpo-a-Corpo com Arma: +4 para atingir, alcance 1,5 m, uma criatura. Acerto: 4 (1d4 + 2) de dano perfurante mais 2 (1d4) de dano de ácido. No final de cada um dos seus turnos, o alvo deve ser bem sucedido num teste de resistência de Constituição CD 10, sofrendo 2 (1d4) de dano de ácido se fracassar ou terminando o ácido recorrente se obtiver sucesso. Uma magia restauração menor conjurada no alvo também termina o dano de ácido recorrente.'),
('Rajada Fedorenta (1/Dia)', 'Flumph', 'Cada criatura num cone de 4,5 metros originado do flumph, deve ser bem sucedida num teste de resistência de Destreza CD 10 ou será coberta por um líquido mal cheiroso. Uma criatura coberta exala um fedor terrível por 1d4 horas. Ela fica envenenada enquanto o fedor durar e outras criaturas ficam envenenadas enquanto estiverem a 1,5 metro da criatura coberta. Uma criatura pode remover o fedor sobre si usando um descanso curto para se banhar em água, álcool ou vinagre.'),
('Ataques Múltiplos', 'Abolete', 'O abolete realiza três ataques de tentáculos.'),
('Cauda', 'Abolete', 'Ataque Corpo-a-Corpo com Arma: +0 para atingir, alcance 3 m, um alvo. Acerto: 15 (3d6 + 5) de dano de concussão.'),
('Escravizar (3/Dia)', 'Abolete', 'O abolete afeta uma criatura que ele possa ver a até 9 metros dele. O alvo deve ser bem sucedido num teste de resistência de Sabedoria CD 14, ou ficará magicamente enfeitiçado pelo abolete até que ele morra ou esteja em um plano de existência diferente do alvo. O alvo enfeitiçado está sob o controle do abolete e não pode realizar reações e, o abolete e o alvo, podem se comunicar telepaticamente um com o outro a qualquer distância.<br > Sempre que o alvo enfeitiçado sofrer dano, ele pode repetir o teste de resistência. Se for bem sucedido, o efeito termina. Não mais de uma vez a cada 24 horas, o alvo também pode repetir o teste de resistência quando ele estiver a pelo menos 1,5 quilômetro de distância do abolete.'),
('Tentáculo', 'Abolete', 'Ataque Corpo-a-Corpo com Arma: +9 para atingir, alcance 3 m, um alvo. Acerto: 12 (2d6 + 5) de dano de concussão. Se o alvo for uma criatura, ele deve ser bem sucedido num teste de resistência de Constituição CD 14 ou ficará adoecido. A doença não causa nenhum efeito por 1 minuto e pode ser removida por qualquer magia que cure doenças. Após 1 minuto, a pele da criatura adoecida se torna translucida e viscosa, a criatura não pode recuperar pontos de vida a não ser que esteja submersa e a doença só pode ser removida por cura completa ou por outra mágica de curar doenças de 6° nível ou superior. Quando a criatura estiver fora de um corpo de água, ela sofre 6 (1d12) de dano de ácido a cada 10 minutos, a menos que a pele dela seja umedecida antes de 10 minutos se passarem.');

insert into AcaoLendaria(nome, nomeMonstro, descricao) values
('Chicotear com a Cauda', 'Abolete', 'O abolete realiza um ataque de cauda.'),
('Detectar', 'Abolete', 'O abolete realiza um teste de Sabedoria (Percepção).'),
('Dreno Psíquico (Custa 2 Ações)', 'Abolete', 'Uma criatura enfeitiçada pelo abolete sofre 10 (3d6) de dano psíquico e o abolete recupera uma quantidade de pontos de vida igual ao dano sofrido pela criatura.');

insert into Habilidade(valor, valorModificador) values
(1, -5), (2, -4), (3, -4), (4, -3), (5, -3), (6, -2), (7, -2), (8, -1), (9, -1), (10, 0), (11, 0), (12, 1), (13, 1), (14, 2), (15, 2), (16, 3), (17, 3), (18, 4), (19, 4), (20, 5), (21, 5), (22, 6), (23, 6), (24, 7), (25, 7), (26, 8), (27, 8), (28, 9), (29, 9),(30, 10);

insert into MonstroHabilidade(nomeMonstro, nomeHabilidade, valor) values
('Inumano', 'Força', 15),
('Inumano', 'Destreza', 14),
('Inumano', 'Constituição', 16),
('Inumano', 'Inteligência', 10),
('Inumano', 'Sabedoria', 13),
('Inumano', 'Carisma', 15),
('Guinchador', 'Força', 1),
('Guinchador', 'Destreza', 1),
('Guinchador', 'Constituição', 10),
('Guinchador', 'Inteligência', 1),
('Guinchador', 'Sabedoria', 3),
('Guinchador', 'Carisma', 1),
('Flumph', 'Força', 6),
('Flumph', 'Destreza', 15),
('Flumph', 'Constituição', 10),
('Flumph', 'Inteligência', 14),
('Flumph', 'Sabedoria', 14),
('Flumph', 'Carisma', 11),
('Abolete', 'Força', 21),
('Abolete', 'Destreza', 9),
('Abolete', 'Constituição', 15),
('Abolete', 'Inteligência', 18),
('Abolete', 'Sabedoria', 15),
('Abolete', 'Carisma', 18);