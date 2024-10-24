# language: pt

Funcionalidade: Logar no app do cliente o usuário deve poder acessar o sistema com seu usuário e senha

@LogarNoApp
Esquema do Cenário: Login no aplicativo do Shopping
	Dado um cliente logando no app <app> com o user <user> e senha <senha>
	Então loga no app

Exemplos:
| app											|	user					| senha			|
|	HML_BPS									|38209674005		|	abc123		|
##|	HML_SNA									|53456471866		|	abc123		|
