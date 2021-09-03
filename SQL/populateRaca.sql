insert into Raca (nomeRaca, caminhoImagem, descricao)
	values
	("Anão", "endereço lá", "Reinos ricos de antiga grandeza, salões esculpidos nas raízes das montanhas, o eco de picaretas e martelos nas minas profundas e nas forjas ardentes, um compromisso com o clã e a tradição, e um ódio impetuoso contra goblins e orcs – essas linhas comuns unem todos os anões.");

insert into Subraca(nomeSubRaca, nomeRaca, descricao, deslocamento, idadeAdulto, idadeExpectativaVida, tamanho, tendencia, forca, destreza, constituicao, sabedoria, inteligencia, carisma)
	values
	("Comum", "Anão", null, 7.5, 50, 350, "Médio", "A maioria dos anões é leal, pois acreditam firmemente nos benefícios de uma sociedade bem organizada. Eles tendem para o bem, com um forte senso de honestidade e uma crença de que todos merecem compartilhar os benefícios de uma ordem social justa", 0, 0, 2, 0, 0, 0),
	("Anão da Colina", "Anão", "Como um anão da colina, você tem sentidos aguçados, maior intuição e notável resiliência. Os anões dourados de Faerûn, que vivem em seu poderoso reino ao sul do continente, são anões da colina, assim como os exilados Neidar e os depreciáveis Klar de Krynn, no cenário de Dragonlance.", 7.5, 50, 350, "Médio", "A maioria dos anões é leal, pois acreditam firmemente nos benefícios de uma sociedade bem organizada. Eles tendem para o bem, com um forte senso de honestidade e uma crença de que todos merecem compartilhar os benefícios de uma ordem social justa", 0, 0, 2, 1, 0, 0);
