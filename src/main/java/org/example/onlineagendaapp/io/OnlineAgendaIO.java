package org.example.onlineagendaapp.io;

import org.example.onlineagendaapp.model.OnlineAgenda;

public interface OnlineAgendaIO {
	
	public OnlineAgenda getOnlineAgenda();
	public void saveOnlineAgenda(OnlineAgenda onlineAgenda);

}
