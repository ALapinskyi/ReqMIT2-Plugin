package bw.khpi.reqmit.plugin.service;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class SenderService extends AbstractService {

	public SenderService() {
		super();
		try {
			out = new ObjectOutputStream(requestSocket.getOutputStream());
            out.flush();
		} catch (IOException ioException) {
			ioException.printStackTrace();
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
