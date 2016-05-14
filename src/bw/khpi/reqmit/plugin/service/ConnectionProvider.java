package bw.khpi.reqmit.plugin.service;

public class ConnectionProvider {

	private static SenderService senderService;
	private static ListenerService listenerService;
	
	private ConnectionProvider(){
		
	}
	
	public static void setSenderService(SenderService senderService) {
		ConnectionProvider.senderService = senderService;
	}



	public static void setListenerService(ListenerService listenerService) {
		ConnectionProvider.listenerService = listenerService;
	}



	public static AbstractService getListener(){
		return listenerService;
	}
	
	public static AbstractService getSender(){
		return senderService;
	}

	public static void sendMessage(String message){
		 senderService.sendMessage(message);
	}
	
}
