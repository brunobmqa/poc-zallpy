package utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

import io.cucumber.java.Scenario;

public class Screenshot {

	public static void takeScreenshot(WebDriver navegador, String arquivo) {
		File screenshot = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(screenshot, new File(arquivo));
		} catch (Exception e) {
			System.out.println("-> Erro ao copiar arquivo para a pasta. \n" + e.getMessage());
		}

	}

	public static void captureFullPageScreenshot(WebDriver driver, Scenario scenario) {

		String status = scenario.isFailed() ? "FAIL" : "PASS";
		StringBuilder screenshotName = new StringBuilder(Generator.dataHoraPrintScreen()).append("_")
				.append(scenario.getName().replace(" ", "_")).append("_").append(status);

		try {
			Shutterbug.shootPage(driver, Capture.FULL_SCROLL, true).withName(screenshotName.toString())
					.save("src/test/resources/screenshots/");
		} catch (Exception ex) {
			System.out.println("-> Erro ao tentar tirar screenshot. " + ex.getMessage());
		}
	}
}
