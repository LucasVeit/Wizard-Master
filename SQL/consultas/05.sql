select nomeLider as "Lider", sum(populacao) as "Populacao"
from Lider join (
	select codigoLider, populacao
	from LiderCidade join (
		select codigoCidade, populacao
		from Cidade
		) as foo
		on LiderCidade.codigoCidade = foo.codigoCidade
	) as foo2
	on foo2.codigoLider = Lider.codigoLider
	group by nomeLider
	
union

select nomeLider as "Lider", sum(populacao) as "Populacao"
from Lider join (
	select codigoLider, populacao
	from LiderFaccao join (
		select codigoFaccao, populacao
		from Faccao
		) as foo
		on LiderFaccao.codigoFaccao = foo.codigoFaccao
	) as foo2
	on foo2.codigoLider = Lider.codigoLider
	group by nomeLider