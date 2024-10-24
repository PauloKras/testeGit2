# language: pt

Funcionalidade: Logar no app

	@CenarioPrincipalLogin
	Esquema do Cenário: Acessar a home do app
		Dado que um usuário abra o app
		E busca veiculo <nome>	

		Exemplos:
		| nome			| tipo				| categoria				|
		| Carro			| sw					|	urbano					|

