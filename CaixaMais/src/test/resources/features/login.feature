# language: pt

Funcionalidade: Logar no app da Caixa

	@CenarioPrincipalLogin 	@SmokeTestLogin
	Esquema do Cenário: Acessar a home do app da Caixa
		Dado que um usuário esteja na tela de login do app
		E busca veiculo <veiculo>
		E o cliente pessoa <tipo> informa o <usuario> e a <senha> para o login
		Então exibirá a tela inicial do app

		Exemplos:
		| tipo			| usuario				| Senha					| Veiculo		|
		| Fisica		| paulo					|	 123					| Carro			|
