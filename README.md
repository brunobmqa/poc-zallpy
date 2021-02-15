# poc-zallpy
POC Zallpy
Projeto criado para teste de QA - Zallpy

#### Clonando/Buildando o projeto ####

- Clonar o projeto e importar com o Eclipse;
- Buildar o projeto (Botão direito sobre o projeto -> Build Project)
- Garantir que as dependências do Maven estão disponíveis (Botão direito sobre o projeto -> Maven -> Update project)

#### Executando as Funcionalidades ####
- src/test/resources/features -> Botão direito sobre o arquivo .feature -> Run as -> Cucumber Feature
- src/test/java/steps/RegisterSteps.java -> Primeiro método com a anotação @Before instancia os drivers, pode ser alterado para execução
- Coloquei uma instância no Browserstack, rodando com Internet Explorer, para utilizar basta descomentar o códico mencionado acima e executar o arquivo .feature.

### Browserstack ###
- https://automate.browserstack.com/
- Login: beeneoox@gmail.com
- Senha: Ab102030
- Após executar o arquivo .feature no Eclipse, a execução irá aparecer na página.
- Após conclusão dos steps, é gerado um vídeo como evidência da execução.

Qualquer dúvida estou à disposição.
