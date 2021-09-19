--Calcula o IMC de cada um dos personagens
select nomeJogador, ROUND("IMC",2)
from Personagem join
	(select codigoAparencia, peso/power(altura,2) as "IMC"
	from Aparencia
	order by "IMC") as foo
	on Personagem.codigoAparencia = foo.codigoAparencia;