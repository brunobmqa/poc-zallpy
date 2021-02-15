Feature: Register Page
  Como usuário quero realizar

  @First @Scenario
  Scenario: 01_Valida acesso ao portal da Nissan
    Given que acesso a página da "Nissan"
    When insiro o CPF "03184944930" no portal Nissan
    And insiro a senha "rci123" no portal Nissan
    And clico no botão Entrar no portal Nissan
    Then valido acesso a home do portal Nissan

  @Scenario
  Scenario: 02_Valida tag Dúvidas Frequentes
    Given que clico no menu Dúvidas Frequentes no portal Nissan
    Then valido o caminho Dúvidas Frequentes no portal Nissan
    And valido apresentação da página Dúvidas Frequentes no portal Nissan