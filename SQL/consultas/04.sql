select categoria, ROUND(AVG(custo),2)
from(
		(select categoria, custo
		from item
		where moeda = 'pc')
	union
		(select categoria, custo * 10
		from item
		where moeda = 'ps')
	union
		(select categoria, custo * 100
		from item
		where moeda = 'po')
	union
		(select categoria, custo * 1000
		from item
		where moeda = 'pp')
	union
		(select categoria, custo * 10000
		from item
		where moeda = 'pe')
	) as foo
group by categoria