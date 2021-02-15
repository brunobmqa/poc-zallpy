#language: pt
Funcionalidade: Validar Funcionalidade de Consulta de CEP via API 

	Como um usuário
	Eu quero efetuar requisições via web service
	Para que eu possa verificar se a API está funcionando corretamente
		
	Cenário: Validar se é possível realizar consulta 
	Quando efetuo uma requisição para o <CEP>
	Então valido se o <Logradouro> está correto		
	
 Exemplos: 
      | CEP				  | Logradouro						|
      | 91520000 		|	Martins de Lima 			|
      | 90020100 		| Vigário José Inácio 	|
      | 90030130 		| Júlio de Castilhos 		|