package steps;

import actions.ViaCEPActions;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import static org.junit.Assert.assertTrue;

public class ViaCEPSteps {

	ViaCEPActions viaCepActions = new ViaCEPActions();

	@Quando("^efetuo uma requisição para o (.*)$")
	public void quandoEfetuoRequisicaoParaOCep(String CEP) {
		assertTrue(viaCepActions.efetuoRequisicao(CEP));
	}

	@Então("^valido se o (.*) está correto$")
	public void entaoValidoSeLogradoutoEstaCorreto(String logradouro) {
		assertTrue(viaCepActions.validoLogradouro(logradouro));

	}

}
