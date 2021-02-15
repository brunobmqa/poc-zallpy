package actions;

import java.io.File;

import org.openqa.selenium.WebDriver;

import pages.RegisterObjects;

public class RegisterActions {
	WebDriver webDriver;

	RegisterObjects registerObjects;

	public RegisterActions(WebDriver webDriver) {
		this.webDriver = webDriver;
		getImagePath();
	}

	public boolean validaPaginaRegistro() {
		registerObjects = new RegisterObjects(webDriver);
		try {
			return registerObjects.validaTituloPagina().isDisplayed();
		} catch (Exception e) {
			System.out.println("Erro ao tentar validar Página Registro. \n" + e.getMessage());
			return false;
		}

	}

	public boolean preencheFormulario() {
		try {

			registerObjects.preencheFormulario("Bruno", "Becker", "Rua Dois, 132", "bilubola@gmail.com", "5199785555",
					"Male", "Movies", "German", "Java", "Brazil", "India", "1989", "September", "28", "Ab123456",
					"Ab123456", getImagePath());
			return true;
		} catch (Exception e) {
			System.out.println("Erro ao tentar preencher formulário. \n" + e.getMessage());
			return false;
		}

	}

	public boolean clicaBotaoSubmit() {
		try {
			registerObjects.clicaBotaoSubmit();
			return true;
		} catch (Exception e) {
			System.out.println("Erro ao clicar no botão Submit.\n" + e.getMessage());
			return false;
		}
	}

	public boolean clicaBotaoRefresh() {
		try {
			registerObjects.clicaBotaoRefresh();
			return true;

		} catch (Exception e) {
			System.out.println("Erro ao clicar no botão Refresh.\n" + e.getMessage());
			return false;
		}
	}

	public boolean validaCadastroRealizado() {
		try {
			return registerObjects.validaCadastroRealizado().equals("Register");

		} catch (Exception e) {
			System.out.println("Erro ao validar se cadastro foi concluído.\n" + e.getMessage());
			return false;
		}
	}

	public String getImagePath() {
		File pasta = new File("src/test/resources/photos/");
		File[] arquivos = pasta.listFiles();
		String pathImage = "";

		for (File f : arquivos) {
			if (f.getName().contains("flap")) {
				pathImage = f.getAbsolutePath();
			}
		}
		return pathImage;
	}

}
