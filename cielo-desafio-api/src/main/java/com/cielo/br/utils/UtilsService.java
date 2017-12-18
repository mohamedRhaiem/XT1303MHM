/**
 * @author mohamed
 * @creadted date 17 de dez de 2017 21:36:27
 */
package com.cielo.br.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;

@Controller
public class UtilsService {

	public JSONArray getMockLancamento() {
		JSONArray result = null;

		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(this.getClass().getResourceAsStream("/data/lancamento-conta-legado.json")));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			result = this.convertToObject(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	private JSONArray convertToObject(String dataAsString) {

		JSONParser parser = new JSONParser();
		JSONArray result = null;
		try {
			JSONObject jobj = (JSONObject) parser.parse(dataAsString);
			result = (JSONArray) jobj.get("listaControleLancamento");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
}
