package actions;

import org.json.JSONException;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ViaCEPActions {

	String logradouro;
	int statusCode;

	public boolean efetuoRequisicao(String cep) {

		StringBuilder URL = new StringBuilder("https://viacep.com.br/ws/").append(cep).append("/json/");

		Response response = RestAssured.get(URL.toString());
		this.statusCode = response.getStatusCode();

		try {
			JSONObject json = new JSONObject(response.body().asPrettyString());
			this.logradouro = json.getString("logradouro");
			return true;

		} catch (JSONException e) {
			System.out.println("Erro ao ler JSON. \n" + e.getMessage());
			return false;
		}

	}

	public boolean validoLogradouro(String log) {
		return this.logradouro.toLowerCase().contains(log.toLowerCase()) && statusCode == 200;

	}

}
