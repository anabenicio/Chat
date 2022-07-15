
package ChatCliente;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
public class Cliente {
	

	private static Scanner s;

	public static void main(String[] args) throws IOException {
	
		Socket socket = null;
		
		PrintStream saida = null;
		
		int porta = 0;
		
		s = new Scanner(System.in);
		
		String ip = null;
		
		System.out.println("Entre com o ip");
		
		ip = s.nextLine();
		
		System.out.println("entre com o numero da porta: ");
		
		porta = s.nextInt();
		
		
		socket = new Socket(ip,porta);
		
			
		
		
		while(true){
			
			saida = new PrintStream(socket.getOutputStream());
		
			Scanner mensagem_digitada = new Scanner(socket.getInputStream());
			
			
			
			receberMensagem receber = new receberMensagem(socket.getInputStream());
		
			new Thread(receber).start();
		
			enviarMensagem mandarMensagem = new enviarMensagem(saida);
			
			new Thread(mandarMensagem).start();
		
			Thread thread = new receberMensagem(socket);
			thread.start();
		}
		
		
			
			
	

	}
	
}
