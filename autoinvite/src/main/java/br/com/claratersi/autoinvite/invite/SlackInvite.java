package br.com.claratersi.autoinvite.invite;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import br.com.claratersi.autoinvite.init.SlackProperties;
import br.com.claratersi.autoinvite.reader.FormResult;

public class SlackInvite {
	
	private SlackProperties props;
	
	public SlackInvite(SlackProperties props) {
		this.props = props;
	}

	public void invite(FormResult result) {
		
		StringBuilder uri = new StringBuilder()
				.append("https://slack.com/api/users.admin.invite")
				.append("?token=").append(props.getToken())
				.append("&email=").append(result.getEmail());
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(uri.toString());
		target.request(MediaType.APPLICATION_JSON).get(String.class);
		
	}

}
