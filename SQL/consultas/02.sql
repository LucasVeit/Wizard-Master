select nomeMonstro, nivel
from Monstro
where Monstro.nivel = (
	select MAX(nivel) as "avg_party_level"
	from PontosExperienciaNivel join 
		(select SUM(pontosExperiencia) as "avg_party_xp"
		from Personagem
		where nomeCampanha = 'Lorin') as foo
		on PontosExperienciaNivel.pontosExperiencia <= foo.avg_party_xp
	)