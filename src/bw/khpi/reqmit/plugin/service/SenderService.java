package bw.khpi.reqmit.plugin.service;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;

public class SenderService extends AbstractService implements Runnable{

	public SenderService() {
		thread = new Thread(this, "Sender");
		thread.start();
	}

	@Override
	public void run() {
		try {
			do {
				try{
					requestSocket = new Socket("localhost", 2004);
				} catch(ConnectException e){
					//System.out.println("Connection refused");
				}
				if (requestSocket != null && requestSocket.getOutputStream() != null) {
					out = new ObjectOutputStream(requestSocket.getOutputStream());
					out.flush();
				}
			} while (requestSocket == null);
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} finally{
			thread.interrupt();
		}
	}

	@Override
	public void sendMessage(String msg) {
		try {
			out.writeObject(msg);
			out.flush();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

}
