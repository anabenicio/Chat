package ChatServidor;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class recebeMensagem implements Runnable{

	private InputStream cliente;
	
	private Scanner s;

	public String apelido;
	
	public recebeMensagem(InputStream cliente){
		this.cliente = cliente;
	}
	public void run() {
		try{
			while(true){

		s = new Scanner(this.cliente);
	
		while(s.hasNextLine()){
			System.out.println(s.nextLine());
			}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
