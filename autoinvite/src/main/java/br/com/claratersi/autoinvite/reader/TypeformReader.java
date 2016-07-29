package br.com.claratersi.autoinvite.reader;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import br.com.claratersi.autoinvite.init.FormProperties;

public class TypeformReader {
	
	private FormProperties formProps;
	
	public TypeformReader(FormProperties formProps) {
		this.formProps = formProps;
	}
	
	public List<FormResult> read() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(formProps.getTarget());
		String sr = target.request(MediaType.APPLICATION_JSON).get(String.class);
		
		List<FormResult> results = new ArrayList<>();
		
		JsonParser parser = new JsonParser();
		JsonObject o = parser.parse(sr).getAsJsonObject();
		JsonArray asJsonArray = o.get("responses").getAsJsonArray();
		for (JsonElement jsonElement : asJsonArray) {
			JsonObject jsonAnswers = jsonElement.getAsJsonObject().get("answers").getAsJsonObject();
			results.add(new FormResult(jsonAnswers.get("textfield_26356308").getAsString(), jsonAnswers.get("textfield_26351246").getAsString()));
		}
		
		return results;
	}

}
