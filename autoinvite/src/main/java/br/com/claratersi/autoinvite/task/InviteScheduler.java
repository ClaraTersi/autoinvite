package br.com.claratersi.autoinvite.task;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class InviteScheduler {
	
	public void schedule(Invite invite) {
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(invite, 0, 1800, TimeUnit.SECONDS);
	}

}
