package br.com.claratersi.autoinvite.init;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import br.com.claratersi.autoinvite.invite.SlackInvite;
import br.com.claratersi.autoinvite.reader.TypeformReader;
import br.com.claratersi.autoinvite.task.Invite;
import br.com.claratersi.autoinvite.task.InviteScheduler;

@WebListener
public class AppContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		Configuration conf = new Configuration();
		
		FormProperties formProps = conf.loadFormProperties();
		TypeformReader reader = new TypeformReader(formProps);
		
		SlackProperties slackProperties = conf.loadSlackProperties();
		SlackInvite inviter = new SlackInvite(slackProperties);
		
		Invite invite = new Invite(reader, inviter);
		InviteScheduler scheduler = new InviteScheduler();
		scheduler.schedule(invite);		
	}

}
