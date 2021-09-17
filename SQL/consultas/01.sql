--Média de vida atual e de vida maxima de todos os personagens daquela campanha que esta ocorrendo, neste caso a campanha é "Lorin"

select ROUND(AVG(pontosVidaAtual), 2) as "avg_curr_life", ROUND(AVG(pontosVidaTotal), 2) as "avg_max_life"
from Personagem
where nomeCampanha = 'Lorin'