#language: pt
Funcionalidade: POC Zallpy
  Como um usuário
	Eu quero acessar a página de Cadastro
	Para que eu possa verificar se a funcionalidade de cadastro funciona corretamente.  

	@First @Print @Last
  Cenário: Verificar se é possível realizar novo cadastro
	Dado que estou na página de Registro
	E preencho o formulário
	Quando clico no botão Submit
	Então valido que o cadastro foi realizado