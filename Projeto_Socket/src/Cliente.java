import java.net.*;
import java.io.IOException;
import java.io.PrintStream;
import java.net.UnknownHostException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	
	private String host;
	private int porta;
	
	public Cliente(String host, int porta){
		this.host = host;
		this.porta = porta;
	}	
		
	public void executa() throws UnknownException, IOException{
		
		/**
		* Criando o Socket
		*/
		
		Socket cliente = new Socket(this.host,this.porta);
		
		/**
		* Verifica conexão
		*/
		
		if(cliente.isConnected()){
			/**
			* Imprime endereço de IP do servidor
			*/
			System.out.println("Conectado a " + cliente.getInetAddress());
		}
		
		/**
		 * Thread para receber mensagens do servidor
		 */
		
		Recebedor r = new Recebedor(cliente.getInputStream());
		new Thread(r).start();
	}
		
		/**
		 * Ler os dados do cliente, da entrada padrão(teclado) e envia ao servidor
		 */
	
		Scanner teclado = new Scanner(System.in);
		PrintStream saida = new PrintStream(cliente.getOutputStream());
		
		while(teclado.hasNextLine()){
			saida.println(teclado.hasNextLine());		
		}
		
		saida.close();
		teclado.close();
		cliente.close();
}