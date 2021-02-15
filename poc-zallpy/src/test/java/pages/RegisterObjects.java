package pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import utils.Highlight;

public class RegisterObjects {

	WebDriver webDriver;

	@FindBy(xpath = "//h2[contains(text(), 'Register')]")
	WebElement weRegisterHeader;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement txtLastName;

	@FindBy(xpath = "//div[@class='form-group']//textarea")
	WebElement txtAddress;

	@FindBy(xpath = "//input[@type='email']")
	WebElement txtEmailAddress;

	@FindBy(xpath = "//input[@type='tel']")
	WebElement txtPhone;

	@FindBy(xpath = "//input[@value='Male']")
	WebElement rbMaleGender;

	@FindBy(xpath = "//input[@value='FeMale']")
	WebElement rbFeMaleGender;

	@FindBy
	WebElement cbHobbies;

	@FindBy(xpath = "//input[@type='checkbox']")
	List<WebElement> cbHobbiesList;

	@FindBy(id = "msdd")
	WebElement msLanguagesBox;

	@FindBy(xpath = "//div[@class='form-group']/div/multi-select/div/ul/li")
	List<WebElement> msLanguagesList;

	@FindBy(id = "Skills")
	WebElement selSkills;

	@FindBy(id = "countries")
	WebElement selCountry;

	@FindBy(id = "country")
	WebElement selSelectCountry;

	@FindBy(id = "yearbox")
	WebElement selBirthYear;

	@FindBy(xpath = "//select[@placeholder='Month']")
	WebElement selBirthMonth;

	@FindBy(id = "daybox")
	WebElement selBirthDay;

	@FindBy(id = "firstpassword")
	WebElement txtPassword;

	@FindBy(id = "secondpassword")
	WebElement txtConfirmPassword;

	@FindBy(id = "imagesrc")
	WebElement fileUploadPhoto;

	@FindBy(id = "submitbtn")
	WebElement btnSubmit;

	@FindBy(id = "Button1")
	WebElement btnRefresh;

	public RegisterObjects(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 20), this);
	}

	public WebElement validaTituloPagina() {
		Highlight.HighlightElement(webDriver, weRegisterHeader);
		return weRegisterHeader;
	}

	public String returnPageTitle() {
		return webDriver.getTitle();
	}

	public RegisterObjects preencheFormulario(String firstName, String lastName, String address, String email,
			String phone, String gender, String hobbies, String languages, String skill, String country,
			String selectCountry, String year, String month, String day, String password, String confirmPassword,
			String path) {
		preenchePrimeiroNome(firstName);
		preencheUltimoNome(lastName);
		preencheEndereco(address);
		preencheEmail(email);
		preencheTelefone(phone);
		preencheGenero(gender);
		preencheHobbies(hobbies);
		preencheIdiomas(languages);
		preencheSkills(skill);
		preenchePais(country);
		preencheSelecionaPais(selectCountry);
		preencheAnoNascimento(year);
		preencheMesNascimento(month);
		preencheDiaNascimento(day);
		preencheSenha(password);
		preencheConfirmaSenha(confirmPassword);
		preencheFoto(path);

		return this;
	}

	public void preenchePrimeiroNome(String firstName) {
		txtFirstName.sendKeys(firstName);
	}

	public void preencheUltimoNome(String lastName) {
		txtLastName.sendKeys(lastName);
	}

	public void preencheEndereco(String address) {
		txtAddress.sendKeys(address);
	}

	public void preencheEmail(String email) {
		txtEmailAddress.sendKeys(email);
	}

	public void preencheTelefone(String phone) {
		txtPhone.sendKeys(phone);
	}

	public void preencheGenero(String gender) {
		if (gender.toLowerCase().equals("male")) {
			rbMaleGender.click();
		} else {
			rbFeMaleGender.click();
		}
	}

	public void preencheHobbies(String hobbie) {
		for (int i = 0; i < cbHobbiesList.size(); i++) {
			if (cbHobbiesList.get(i).getAttribute("value").toLowerCase().equals(hobbie.toLowerCase())) {
				cbHobbiesList.get(i).click();
			}
		}
	}

	public void preencheIdiomas(String languages) {
		Random rd = new Random();

		msLanguagesBox.click();
		for (int i = 0; i < rd.nextInt(msLanguagesList.size()); i++) {
			System.out.println("Vou clicar em: " + msLanguagesList.get(i).getAttribute("innerText"));
			msLanguagesList.get(i).click();
		}
	}

	public void preencheSkills(String skill) {
		new Select(selSkills).selectByValue(skill);
	}

	public void preenchePais(String country) {
		new Select(selCountry).selectByValue(country);
	}

	public void preencheSelecionaPais(String selectedCountry) {
		new Select(selSelectCountry).selectByValue(selectedCountry);
	}

	public void preencheAnoNascimento(String anoNascimento) {
		new Select(selBirthYear).selectByValue(anoNascimento);
	}

	public void preencheMesNascimento(String mesNascimento) {
		new Select(selBirthMonth).selectByValue(mesNascimento);
	}

	public void preencheDiaNascimento(String diaNascimento) {
		new Select(selBirthDay).selectByValue(diaNascimento);
	}

	public void preencheSenha(String password) {
		txtPassword.sendKeys(password);
	}

	public void preencheConfirmaSenha(String confirmPassword) {
		txtConfirmPassword.sendKeys(confirmPassword);
	}

	public void preencheFoto(String path) {
		fileUploadPhoto.sendKeys(path);
	}

	public void clicaBotaoSubmit() {
		Highlight.HighlightElement(webDriver, btnSubmit);
		btnSubmit.click();
	}

	public void clicaBotaoRefresh() {
		Highlight.HighlightElement(webDriver, btnRefresh);
		btnRefresh.click();
	}

	public String validaCadastroRealizado() {
		// O botão de submit não realiza nenhuma ação, então apenas estou validando se
		// continua na mesma página.
		return webDriver.getTitle();
	}
}
