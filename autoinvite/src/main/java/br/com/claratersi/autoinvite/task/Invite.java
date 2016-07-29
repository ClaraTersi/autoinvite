package br.com.claratersi.autoinvite.task;

import java.util.List;

import br.com.claratersi.autoinvite.invite.SlackInvite;
import br.com.claratersi.autoinvite.reader.FormResult;
import br.com.claratersi.autoinvite.reader.TypeformReader;

public class Invite implements Runnable {
	
	private TypeformReader reader;
	private SlackInvite inviter;
	
	public Invite(TypeformReader reader, SlackInvite inviter) {
		this.reader = reader;
		this.inviter = inviter;
	}
	
	public void run() {
		List<FormResult> results = reader.read();
		for (FormResult result : results) {
			inviter.invite(result);
		}
	}	

}
