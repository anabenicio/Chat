package ChatCliente;

import java.util.Date;  
import java.util.GregorianCalendar;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class enviarMensagem extends Thread{
	
String apelido;
private Scanner mensagem_digitada;

public enviarMensagem(OutputStream saida) throws IOException {
	mensagem_digitada = new Scanner (System.in);
	
	saida = new PrintStream(saida);
	
	Date d = GregorianCalendar.getInstance().getTime();
	
	SimpleDateFormat format = new SimpleDateFormat();
	
	System.out.println("entre com o seu apelido");
	
	apelido = mensagem_digitada.nextLine();
	
	while(true){
	
	while(apelido.length() > 8){
		System.out.println("Você digitou um apelido com mais de 8 caracteres, tente Novamente!");
		System.out.println("entre com o seu apelido");
		apelido = mensagem_digitada.nextLine();
	}
	while(mensagem_digitada.hasNextLine()){
		((PrintStream) saida).println("["+apelido + "]" + "[" + format.format(d) + "]" + " diz: " +mensagem_digitada.nextLine());
			}
	}

	//mensagem_digitada.close();
	//saida.close();
		}
	



		
}


