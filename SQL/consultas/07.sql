select foo.nomeJogador as "Jogador", foo2.nomeMonstro as "Mais forte que", foo2.nomeHabilidade as "Em"
from (select codigoPersonagem, nomeJogador
	from Personagem) as foo
join
	(select PersonagemHabilidade.codigoPersonagem, MonstroHabilidade.nomeMonstro, PersonagemHabilidade.nomeHabilidade
	from PersonagemHabilidade join MonstroHabilidade
	on PersonagemHabilidade.nomeHabilidade = MonstroHabilidade.nomeHabilidade and
	PersonagemHabilidade.valor > MonstroHabilidade.valor) as foo2
on foo.codigoPersonagem = foo2.codigoPersonagem
order by "Jogador", "Mais forte que", "Em"