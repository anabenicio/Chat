package ChatCliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class receberMensagem extends Thread {
	private InputStream servidor;
	private Socket socketServidor;
	
	private Scanner s;

	public receberMensagem(InputStream servidor){
		this.servidor = servidor;
		
	}
	
	public receberMensagem (Socket socket){
		this.socketServidor = socket;
	}
	 public void run() {
		 BufferedReader entrada = new BufferedReader(new InputStreamReader(servidor));
		 String msg;
		 
		
			 try { 
				 while(true){
				msg = entrada.readLine();
				 if(msg == null){
					 System.out.println("conexão encerrada");
					 System.out.println(0);
				 }
				 
				 System.out.println();
				 System.out.println(msg);
				 }
			 }
			 catch (IOException e) {
				System.out.println("erro 404");
				e.printStackTrace();
			}
			
		 // s = new Scanner(this.servidor);
		 
		// while(s.hasNextLine()){

			// System.out.println(s.nextLine());
			
			}
			 

	 }
