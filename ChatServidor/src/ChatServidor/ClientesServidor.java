package ChatServidor;
	import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
	import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
	import java.util.Vector;

public class ClientesServidor extends Thread{
	
	private static Vector clientes; //CLIENTES
    // socket deste cliente
    private Socket conexao;
    // nome deste cliente
    private String apelido; //nomeCliente
    private String novoApelido;
    // lista que armazena nome de CLIENTES
    private static List ListaApelidos = new ArrayList(); //LISTA_DE_NOMES
    // construtor que recebe o socket deste cliente
    
    public void AdicionaApelido(){
    	ListaApelidos.add(apelido);
    	return;
    }
    
    public ClientesServidor(Socket socket) {
        this.conexao = socket;
    }
    
    public void run() {
    	
    	try{
    		BufferedReader entrada = new BufferedReader(new InputStreamReader(this.conexao.getInputStream())); 
    		PrintStream saida = new PrintStream(this.conexao.getOutputStream());
    		this.apelido = entrada.readLine();
    		System.out.println(this.apelido + "Conectado ao Servidor");
    		String mensagem = entrada.readLine();
    		while(true){
    			EnviaMensagem(saida, "Diz: ", mensagem);
    			mensagem = entrada.readLine();
    		}
    	}catch (Exception e) {
			// TODO: handle exception
		}
    }


	private void EnviaMensagem(PrintStream saida, String string, String mensagem) throws IOException {
		Enumeration e = clientes.elements();
		while (e.hasMoreElements()){
			PrintStream chat = (PrintStream)e.nextElement();
			
			if(chat != saida){
				chat.println(this.apelido + mensagem);
			}
		}
		
	}
	   
	    

		
}
