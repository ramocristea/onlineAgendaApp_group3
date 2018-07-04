package org.example.onlineAgendaApp.io;

import org.example.onlineAgendaApp.model.OnlineAgenda;

public interface OnlineAgendaIO {
	
	public OnlineAgenda getOnlineAgenda();
	public void saveOnlineAgenda(OnlineAgenda onlineAgenda);

}
