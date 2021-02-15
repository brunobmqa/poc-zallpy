package utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SetUpWeb {
	// selenium drivers
	private static String chromeDriverPath = "src/test/resources/drivers/chromedriver.exe";
	private static String geckoDriverPath = "src/test/resources/drivers/geckodriver.exe";
	private static String edgeDriverPath = "src/test/resources/drivers/msedgedriver.exe";

	// URL init page
	private static String URL_AUTOMATION_TESTING_REGISTER = "http://demo.automationtesting.in/Register.html";

	// browserstack configs
	private static final String AUTOMATE_USERNAME = "brunobeckermorei1";
	private static final String AUTOMATE_ACCESS_KEY = "deLaQfgobVzw8y57zzgV";
	private static final String URLBrowserStack = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY
			+ "@hub-cloud.browserstack.com/wd/hub";

	private static WebDriver navegador;

	// create chrome instance
	public static WebDriver createChrome() {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		navegador = new ChromeDriver();
		navegador.get(URL_AUTOMATION_TESTING_REGISTER);
		navegador.manage().window().maximize();
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		return navegador;
	}

	// create firefox instance
	public static WebDriver createFirefox() {
		System.setProperty("webdriver.gecko.driver", geckoDriverPath);
		navegador = new FirefoxDriver();
		navegador.get(URL_AUTOMATION_TESTING_REGISTER);
		navegador.manage().window().maximize();
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		return navegador;
	}

	// create microsoft edge instance
	public static WebDriver createEdge() {
		System.setProperty("webdriver.edge.driver", edgeDriverPath);
		navegador = new EdgeDriver();
		navegador.get(URL_AUTOMATION_TESTING_REGISTER);
		navegador.manage().window().maximize();
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		return navegador;
	}
	
	public static WebDriver createBrowserStack() {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("os_version", "10");
		caps.setCapability("resolution", "1920x1080");
		caps.setCapability("browser", "IE");
		caps.setCapability("browser_version", "11.0");
		caps.setCapability("os", "Windows");
		caps.setCapability("name", "POC_Zallpy-[Java]"); // test name
		caps.setCapability("build", "Zallpy POC Build"); // CI/CD job or build name
		navegador = null;
		try {
			navegador = new RemoteWebDriver(new URL(URLBrowserStack), caps);
			navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			navegador.get(URL_AUTOMATION_TESTING_REGISTER);
		} catch (MalformedURLException e) {
			System.out.println("---> Problemas com a URL. \n" + e.getMessage());
		}

		return navegador;
	}

	public static WebDriver setUp(String navegadorEscolhido) throws Exception {

		if (navegadorEscolhido.toLowerCase().contains("firefox")) {
			return createFirefox();
		} else if (navegadorEscolhido.toLowerCase().contains("chrome")) {
			return createChrome();
		} else if (navegadorEscolhido.toLowerCase().contains("edge")) {
			return createEdge();
		} else if (navegadorEscolhido.toLowerCase().contains("browserstack")) {
			return createBrowserStack();
		} else {
			throw new Exception("Erro ao tentar instanciar navegador. \n ---> " + navegador);
		}
	}

	public static void tearDown() {
		if (navegador != null)
			navegador.quit();
	}

	public static WebDriver getNavegador() {
		return navegador;
	}

}
