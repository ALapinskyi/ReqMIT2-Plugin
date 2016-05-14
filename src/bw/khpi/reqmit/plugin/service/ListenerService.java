package bw.khpi.reqmit.plugin.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;

public class ListenerService extends AbstractService implements Runnable{

	private ServerSocket providerSocket;

	public ListenerService() {
		thread = new Thread(this, "Listener");
		try {
			providerSocket = new ServerSocket(2014, 10);
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
		thread.start();

	}

	@Override
	public void run() {
		try {
			requestSocket = providerSocket.accept();
			in = new ObjectInputStream(requestSocket.getInputStream());
			do {
				try {
					message = (String) in.readObject();
					System.out.println("client>" + message);
					if (message.equals("bye"))
						sendMessage("bye");
				} catch (ClassNotFoundException e) {
					System.err.println("Data received in unknown format");
				}
			} while (!message.equals("bye"));

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally{
			closeConnection();
		}
	}
}
