package br.com.claratersi.autoinvite.init;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
	
	public FormProperties loadFormProperties() {
		
		Properties props = new Properties();
		InputStream stream = getClass().getClassLoader().getResourceAsStream("form.properties");
		
		try {
			props.load(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FormProperties formProperties = new FormProperties(
				props.getProperty("api.address"), 
				props.getProperty("api.key"), 
				props.getProperty("form.uid"));
		
		if(!props.getProperty("results.completed").isEmpty()) {
			formProperties.setResultsCompleted(Boolean.valueOf(props.getProperty("results.completed")));
		}
		if(!props.getProperty("results.since").isEmpty()) {
			formProperties.setResultsSince(Long.valueOf(props.getProperty("results.since")));
		}
		if(!props.getProperty("results.limit").isEmpty()) {
			formProperties.setResultsLimit(Integer.valueOf(props.getProperty("results.limit")));
		}
		if(!props.getProperty("results.orderby").isEmpty()) {
			formProperties.setResultsOrderBy(props.getProperty("results.orderby"));
		}
		if(!props.getProperty("results.sortby").isEmpty()) {
			formProperties.setResultsSortBy(props.getProperty("results.sortby"));
		}		
		
		return formProperties;
	}
	
	public SlackProperties loadSlackProperties() {
		
		Properties props = new Properties();
		InputStream stream = getClass().getClassLoader().getResourceAsStream("slack.properties");
		
		try {
			props.load(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SlackProperties slackProperties = new SlackProperties(props.getProperty("token"));
		
		return slackProperties;
	}
	
}
