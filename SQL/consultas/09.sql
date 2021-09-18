--Relatório de espaços de magia para cada nivel das classes
select nomeClasse as "Classe", nivel as "Nível", nivelMagia1 as "Magias de nível 1", nivelMagia2 as "Magias de nível 2", nivelMagia3 as "Magias de nível 3",
nivelMagia4 as "Magias de nível 4", nivelMagia5 as "Magias de nível 5", nivelMagia6 as "Magias de nível 6", nivelMagia7 as "Magias de nível 8",
nivelMagia8 as "Magias de nível 8", nivelMagia9 as "Magias de nível 9"
from ClasseEspacoMagia join EspacoMagia
	on ClasseEspacoMagia.numeroTabela = EspacoMagia.numeroTabela and ClasseEspacoMagia.linhaTabela = EspacoMagia.linhaTabela;