--Quais monstros cada jogador pe mais rápido e quais seus pontos de vida e nivel de monstro
select foo4.nomeJogador as "Jogador", foo4.nomePersonagem as "Personagem", foo4.deslocamento as "Com deslocamento", foo4.pontosVidaAtual as "e vida",
foo3.nomeMonstro as "Mais rápido que", foo3.deslocamentoBase as "Com deslocamento", foo3.pontosVidaBase as ", vida", foo3.nivel as "e nivel"
from
	(	(select nomeJogador, pontosVidaAtual, codigoAparencia, deslocamento
		from Personagem) as foo
	join
		(select codigoAparencia, nomePersonagem
		from Aparencia) as foo2
	on foo.codigoAparencia = foo2.codigoAparencia) as foo4
join
	(select nomeMonstro, nivel, pontosVidaBase, deslocamentoBase
	from Monstro) as foo3
on foo3.deslocamentoBase < foo4.deslocamento
order by foo4.nomeJogador