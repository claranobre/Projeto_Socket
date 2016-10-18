import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {

	public static void main(String[] args) throws IOException{

		new Servidor(80).executa();
	}

	private int porta;
	private List<PrintStream> clientes;

	public Servidor(int porta) {
		this.porta = porta;
		this.clientes = new ArrayList<PrintStream>();
	}

	public void executa() throws IOException  {
		ServerSocket servidor = new ServerSocket(this.porta);
		System.out.println("Porta " + porta + " aberta!");
	
		while (true){

			/**
			* Aceita o Cliente
			*/
				
			Socket cliente = servidor.accept();
			System.out.println("Nova conexão com o cliente " + 
			cliente.getInetAddress().getHostAddress());

			/**
			* Adiciona saída do cliente à lista
			*/
			
			PrintStream ps = new PrintStream(cliente.getOutputStream());
			this.clientes.add(ps);

			/**
			* Cria tratador de cliente em uma nova Thread
			*/

			TratadorDeMensagemDoCliente tc = new TratadorDeMensagemDoCliente(cliente.getInputStream(), this);
			new Thread(tc).start();
		}
	}	

	public void distribuirMensagem(String msg){
		/**
		* Envia mensagem para todo mundo
		*/
		for (PrintStream cliente : this.clientes){
			cliente.println(msg);
		}
	}
}