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
	
	public void executa() throws UnknownHostException, IOException {
		try(Socket cliente = new Socket(this.host, this.porta); 
				Scanner teclado = new Scanner(System.in); 
				PrintStream saida = new PrintStream(cliente.getOutputStream())) {
			System.out.println("O cliente se conectou ao servidor!");
	
			/**
			 * Ler os dados do cliente, da entrada padrão(teclado) e envia ao servidor
			 */
			
			RecebedorDeMensagemDoServidor r = new RecebedorDeMensagemDoServidor(cliente.getInputStream());
			new Thread(r).start();
	
			while (teclado.hasNextLine()) {
				saida.println(teclado.nextLine());
			}
		}
	}
}