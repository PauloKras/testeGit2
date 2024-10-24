# language: pt

Funcionalidade: Banco

	@CenarioInsert
	Esquema do Cenário: Cadastra veiculo
		Dado inclui veiculo nome <nome> tipo <tipo> categoria <categoria>

		Exemplos:
		| nome			| tipo					| categoria				|
		| Carro			| sw						|	urbano					|
		| carro			| sedan					|	urbano					|
		| caminhão	| truck					|	urbano					|
		| caminhão	| truck					|	offroad					|
		| caminhão	| Tombadeira		|	urbano					|
		| ônibus		| convencional	|	urbano					|
						
						
	@CenarioExcluir
	Esquema do Cenário: Excluir veiculo
		E busca veiculo <nome>	
		Dado exclui veiculo <nome> tipo <tipo> categoria <categoria>
		E busca veiculo <nome>	
		Exemplos:
		| nome			| tipo				| categoria				|
		| ônibus		| sw					|	urbano					|					
					
						
	@CenarioConsulta
	Esquema do Cenário: Consulta veiculo
		Dado busca veiculo <nome>	

		Exemplos:
		| nome			| tipo				| categoria				|
		| Carro			| sw					|	urbano					|
				
									