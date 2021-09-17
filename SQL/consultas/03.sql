select tamanho, sum(cnt)
from (
	select tamanho, count(*) as cnt
	from Subraca
	group by tamanho
	union
	select tamanho, count(*) as cnt
	from Monstro
	group by tamanho
	) as foo
group by tamanho