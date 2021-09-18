/*
create or replace function check_magia() 
    returns trigger 
    as 
$$
begin
declare contagem integer;
declare max_magias integer;

--Insere em contagem quantas magias do nivel da magia inserida o personagam já possui. É bom mudar o trigger pra before
select count(*)
into contagem
	from PersonagemMagia join Magia
		on PersonagemMagia.nomeMagia = Magia.nomeMagia and 
		new.codigoPersonagem = PersonagemMagia.codigoPersonagem and
		(
			select distinct(nivel)
			from Magia
			where Magia.nomeMagia = new.nomeMagia
		) = Magia.nivel; 

--Insere em max_magias o maximo de magias daquele nivel o personagem pode ter. Não terminada
select
into max_magias
from Personagem join ClasseEspacoMagia
	on ClasseEspacoMagia.nomeClasse = Personagem.personagemClasse and
	ClasseEspacoMagia.nivel = (
		--Retorna Nivel do personagem
		select max(nivel)
		from PontosExperienciaNivel
		where Personagem.pontosExperiencia >= PontosExperienciaNivel.pontosExperiencia
	) and
	Personagem.codigoPersonagem = new.codigoPersonagem;
	
end;
$$ language plpgsql;

create trigger atualizar_magia 
    after insert or update on PersonagemMagia
    for each row
    	execute procedure check_magia();
*/


select numeroTabela, linhaTabela
from Personagem join ClasseEspacoMagia
	on ClasseEspacoMagia.nomeClasse = Personagem.personagemClasse and
	ClasseEspacoMagia.nivel = (
		select max(nivel)
		from PontosExperienciaNivel
		where Personagem.pontosExperiencia >= PontosExperienciaNivel.pontosExperiencia
	) and
	Personagem.codigoPersonagem = 1;
