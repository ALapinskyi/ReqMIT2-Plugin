package bw.khpi.reqmit.plugin.service;

public class ConnectionProvider {

	private static SenderService senderService = new SenderService();
	private static ListenerService listenerService;
	
	public ConnectionProvider(SenderService senderService, ListenerService listenerService){
		this.senderService = senderService;
		//this.listenerService = listenerService;
		//this.listenerService.run();
	}
	
	public ConnectionProvider(){
		
	}
	
	public AbstractService getSender(){
		return senderService;
	}

	public void sendMessage(String message){
		 senderService.sendMessage(message);
	}
	
	
}
