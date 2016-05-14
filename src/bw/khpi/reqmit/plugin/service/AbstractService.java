package bw.khpi.reqmit.plugin.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public abstract class AbstractService{

	public Socket requestSocket;
	public ObjectOutputStream out;
	public ObjectInputStream in;
	protected String message;
	protected Thread thread;
	
	public void closeConnection(){
		try{
            in.close();
            out.close();
            requestSocket.close();
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
	}
	
	public void sendMessage(String msg){
		
	}
	
	public void run(){
		
	}
}
