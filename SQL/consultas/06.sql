--Calcula o IMC de cada um dos personagens
select nomePersonagem, peso/power(altura,2) as "IMC"
from Aparencia
order by "IMC";