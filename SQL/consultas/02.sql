--Seleciona monstros de nivel similar ao nivel total do grupo
select nomeMonstro, nivel
from Monstro
where Monstro.nivel = (
	select MAX(nivel) as "Nivel do grupo"
	from PontosExperienciaNivel join 
		(select SUM(pontosExperiencia)
		from Personagem
		where nomeCampanha = 'Lorin') as foo
		on PontosExperienciaNivel.pontosExperiencia <= foo.sum
	)