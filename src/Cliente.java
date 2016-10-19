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

	public static void main(String[] args) throws UnknownHostException, IOException{
	
		/**
		* Dispara o Cliente
		*/
		
		new Cliente("127.0.0.1" , 5000).executa();
	}

	public void executa() throws UnknownHostException, IOException {
		Socket cliente = new Socket(this.host, this.porta);
		System.out.println("Cliente se conectou ao servidor!");

		/**
		* Thread para ler os dados do cliente, da entrada padrão(teclado) e envia ao servidor
		*/
			
		RecebedorDeMensagemDoServidor r = new RecebedorDeMensagemDoServidor(cliente.getInputStream());
		new Thread(r).start();		 

		/**
		* Lê mensagens do teclado e manda para o Servidor
		*/

		Scanner teclado = new Scanner(System.in);
		PrintStream saida = new PrintStream(cliente.getOutputStream());
		
		while (teclado.hasNextLine()) {
			saida.println(teclado.nextLine());
		}

		saida.close();
		teclado.close();
		cliente.close();			
	}
}		