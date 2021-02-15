package steps;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import actions.RegisterActions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.RegisterObjects;
import utils.Screenshot;
import utils.SetUpWeb;

public class RegisterSteps {

	WebDriver webDriver;
	RegisterActions registerActions;
	RegisterObjects registerObjects;

	public Scenario scenario;

	@Before("@First")
	public void setUpDriver() throws Exception {

		webDriver = SetUpWeb.setUp("chrome");
		// webDriver = SetUpWeb.setUp("firefox");
		// webDriver = SetUpWeb.setUp("edge");
		// webDriver = SetUpWeb.setUp("browserstack");
		registerActions = new RegisterActions(webDriver);
	}

	@Dado("^que estou na página de Registro$")
	public void dadoQueEstouNaPaginaDeRegistro() {
		registerActions = new RegisterActions(webDriver);
		assertTrue(registerActions.validaPaginaRegistro());
	}

	@E("^preencho o formulário$")
	public void ePreenchoOFormulario() {
		assertTrue(registerActions.preencheFormulario());
	}

	@Quando("^clico no botão Submit$")
	public void quandoClicoBotaoSubmit() {
		assertTrue(registerActions.clicaBotaoSubmit());
	}

	@Quando("^clico no botão Refresh$")
	public void quandoClicoBotaoRefresh() {
		assertTrue(registerActions.clicaBotaoRefresh());
	}

	@Então("^valido que o cadastro foi realizado$")
	public void entaoValidoQueCadastroFoiRealizado() {
		assertTrue(registerActions.validaCadastroRealizado());
	}

	@Before
	public void initScenario(Scenario scen) {
		scenario = scen;
	}

	@After(value = "@Print", order = 1)
	public void afterScenario() throws IOException {
		Screenshot.captureFullPageScreenshot(SetUpWeb.getNavegador(), scenario);
	}

	@After(value = "@Last", order = 0)
	public static void End() throws IOException {
		// SetUpWeb.getInstance();
		SetUpWeb.tearDown();
	}

}
