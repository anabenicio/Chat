package ChatServidor;



import java.io.OutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class mandarMensagem extends Thread {
	private Scanner mensagem_digitada;

	public mandarMensagem(OutputStream saidamensagem){
		mensagem_digitada = new Scanner (System.in);
		saidamensagem = new PrintStream(saidamensagem);
		Date d = GregorianCalendar.getInstance().getTime();
		SimpleDateFormat format = new SimpleDateFormat();
		((PrintStream) saidamensagem).println("Seja Bem Vindo!!");
		while(mensagem_digitada.hasNextLine()){
			((PrintStream) saidamensagem).println("[Servidor]" + "[" + format.format(d) + "]" + " diz:" + mensagem_digitada.nextLine());
		}
		
	}


	




}




