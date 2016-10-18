import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor{
	
	private int porta;
	private List<PrintStream> clientes;
	
	public static void main(String[] args) throws IOException{
		/**
		 * Inicia o Servidor
		 */
		new Servidor(80).executa();
	}
	
	public Servidor(int porta){
		this.porta = porta;
		this.clientes = new ArrayList<PrintStream>();
	}
	
	public void executa() throws IOException{
		ServerSocket servidor = new ServerSocket(this.porta);
		System.out.println("Porta" + porta + "aberta");
	
		while(true){
			/**
			 * Aceita o cliente
			 */
			Socket cliente = servidor.accept();
			/**
			* Imprime o IP do cliente
			*/
			System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());
		
			/**
			 * Adiciona saída do cliente a lista
			 */
			PrintStream ps = new PrintStream(cliente.getOutputStream());
			this.clientes.add(ps);
			
			/**
			 * Cria tratador de cliente numa nova thread 
			 */
			TratadorDeMensagemDoCliente tc = new TratadorDeMensagemDoCliente(cliente.getInputStream(), this);
			new Thread(tc).start();
		}
	}
	
	public void distribuirMensagem(String mensagem){
		/**
		 * Envia mensagem para todos (global)
		 */
		for(PrintStream cliente : this.clientes){
			((PrintStream) clientes).println(mensagem);
		}
	}
}	

		/**
		* Ler todas as informações que o cliente enviar
		
		Scanner s = new Scanner(cliente.getInputStream());

		while(s.hasNextLine()){
			System.out.println(s.nextLine());
		}

		/**
		* Fechando a conexão
		
		s.close();
		cliente.close();
		servidor.close();
	}*/