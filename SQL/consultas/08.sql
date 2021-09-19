--Relatório de campanhas
select foo2.nomeCampanha, descricao, foo2.count as "Qtde. de cidades", foo2.min as "Cidade com menor população",
foo2.max as "Cidade com maior população", round(foo2.avg,2) as "Média de população das cidades", foo3.count as "Qtde. de Líderes"
from Campanha join (
	select nomeCampanha, count(nomeCidade), min(populacao), max(populacao), avg(populacao)
	from Cidade	
	group by nomeCampanha
) as foo2 on foo2.nomeCampanha = Campanha.nomeCampanha
join(
	select nomeCampanha, count(nomeLider)
	from Lider
	group by nomeCampanha
) as foo3 on foo3.nomeCampanha = Campanha.nomeCampanha;