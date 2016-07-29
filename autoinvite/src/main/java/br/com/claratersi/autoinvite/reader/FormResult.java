package br.com.claratersi.autoinvite.reader;

public class FormResult {

	private String name;
	private String email;
		
	public FormResult(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
		
}
