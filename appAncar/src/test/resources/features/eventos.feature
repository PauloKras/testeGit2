# language: pt

Funcionalidade: Acesso a tela de eventos do app

@AcessarEventosBotãoOffSemOB
Esquema do Cenário: Acessar a tela de eventos pelo carrossel de botões sem logim e sem passar pelas telas de OnBoarding
	Dado um cliente acessando offline a tela de eventos sem onborading no app <app>
	E visualiza tela de eventos pelo carrossel de botões
	E seleciona primeiro evento
	Então visualiza os detalhes do evento

Exemplos:
| app											|	user					| senha			|
|	HML_BPS									|38209674005		|	abc123		|
##|	HML_SNA									|53456471866		|	abc123		|


@AcessarEventosBotãoOffComOB
Esquema do Cenário: Acessar a tela de eventos pelo carrossel de botões sem logim e passando pelas telas de OnBoarding
	Dado um cliente acessando offline a tela de eventos com onborading no app <app>
	E visualiza tela de eventos pelo botão da Bottom Bar
	E visualiza a lista de eventos
	Então visualiza os detalhes do evento

Exemplos:
| app											|	user					| senha			|
|	HML_BPS									|38209674005		|	abc123		|


@AcessarEventosBotãoOnSemOB
Esquema do Cenário: Acessar a tela de eventos pelo carrossel de botões com logim e sem passar pelas telas de OnBoarding
	Dado um cliente acessando online a tela de eventos sem onborading no app <app> com o user <user> e senha <senha>
	E visualiza tela de eventos pelo botão da Bottom Bar
	E visualiza a lista de eventos
	Então visualiza os detalhes do evento

Exemplos:
| app											|	user					| senha			|
|	HML_BPS									|38209674005		|	abc123		|


@AcessarEventosBotãoOnComOB
Esquema do Cenário: Acessar a tela de eventos pelo carrossel de botões com logim e passando pelas telas de OnBoarding
	Dado um cliente acessando online a tela de eventos com onborading no app <app> com o user <user> e senha <senha>
	E visualiza tela de eventos pelo botão da Bottom Bar
	E visualiza a lista de eventos
	Então visualiza os detalhes do evento

Exemplos:
| app											|	user					| senha			|
|	HML_BPS									|38209674005		|	abc123		|


	