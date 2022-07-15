package ChatServidor;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.io.IOException;
import java.io.PrintStream;

public class Servidor {

	private static Scanner s;
	private static ServerSocket servidorSocket;
	Vector ListaApelidos = new Vector(); //CLIENTES
	
	
	public static void main(String[] args) throws IOException{
		int porta = 0, user  = 0;
		
		try{
			servidorSocket = new ServerSocket(porta);
			s = new Scanner(System.in);
		
		System.out.println("entre com o numero da porta:");
		
		porta = s.nextInt();
		while(true){
			Socket conexao = servidorSocket.accept();
			Thread thread = new ClientesServidor(conexao);
			
			PrintStream saida = new PrintStream(conexao.getOutputStream());
			saida.println("Conectado!");
			thread.start();
		}
		}catch (Exception e) {
			System.out.println("IOException: " + e);
		}
		
		
		}
}
		
	