--Listagem de líderes e quantas pessoas cada um governa
select foo5.nomeLider as "Lider", sum(populacao) as "Populacao"
from (
	select nomeLider, populacao
	from Lider join (
		select codigoLider, populacao
		from LiderCidade join (
			select codigoCidade, populacao
			from Cidade
			) as foo
			on LiderCidade.codigoCidade = foo.codigoCidade
		) as foo2
		on foo2.codigoLider = Lider.codigoLider

	union

	select nomeLider, populacao
	from Lider join (
		select codigoLider, populacao
		from LiderFaccao join (
			select codigoFaccao, populacao
			from Faccao
			) as foo3
			on LiderFaccao.codigoFaccao = foo3.codigoFaccao
		) as foo4
		on foo4.codigoLider = Lider.codigoLider
) as foo5
group by "Lider"