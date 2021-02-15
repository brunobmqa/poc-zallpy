package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Highlight {

	private static JavascriptExecutor jsExecutor;

	public static void HighlightElement(WebDriver navegador, WebElement element) {
		jsExecutor = (JavascriptExecutor) navegador;
		try {
			// new Point(0, 0);
			if (element != null) {
				element.getLocation();
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
				jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
						"outline: 4px solid #00FF00;");
			} else {
				throw new Exception("Erro ao scrollar até o elemento! Elemento é NULL.");
			}
		} catch (Exception ex) {
			System.out.println("-> Erro no método de Highlight. \n" + ex.getMessage());
		}

	}
}
