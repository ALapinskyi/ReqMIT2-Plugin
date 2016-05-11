package bw.khpi.reqmit.plugin.service;

import java.io.IOException;
import java.io.ObjectInputStream;

public class ListenerService extends AbstractService implements Runnable{

	public ListenerService(){
		super();
		try {
			in = new ObjectInputStream(requestSocket.getInputStream());
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(!message.equals("close")){
			try {
				message = (String)in.readObject();
	            System.out.println("server>" + message);
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
