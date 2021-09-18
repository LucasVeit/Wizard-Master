select foo.nomeCampanha, descricao, foo.count as "Anotacoes", foo2.count as "Qtde. de cidades", foo2.min as "Cidade com menor população",
foo2.max as "Cidade com maior população", round(foo2.avg,2) as "Média de população das cidades", foo3.count as "Qtde. de Líderes",
foo4.count as "Qtde. de mapas cadastrados"
from Campanha join (
	select nomeCampanha, count(anotacao)
	from Anotacao
	group by nomeCampanha
	) as foo on foo.nomeCampanha = Campanha.nomeCampanha
join (
	select nomeCampanha, count(nomeCidade), min(populacao), max(populacao), avg(populacao)
	from Cidade	
	group by nomeCampanha
) as foo2 on foo2.nomeCampanha = Campanha.nomeCampanha
join(
	select nomeCampanha, count(nomeLider)
	from Lider
	group by nomeCampanha
) as foo3 on foo3.nomeCampanha = Campanha.nomeCampanha
join (
	select nomeCampanha, count(mapa)
	from Mapa
	group by nomeCampanha
) as foo4 on foo4.nomeCampanha = Campanha.nomeCampanha