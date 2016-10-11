import java.io.IOException;
import java.net.Socket;

public class Cliente {
	public static void main(String[] args) throws UnknownHostException, IOException{
		/**
		* Criando o Socket localmente na porta 80
		*/
		Socket socket = new Socket("127.0.0.1", 80);
		/**
		* Verifica conexão
		*/
		if(socket.isConnected()){
			/**
			* Imprime endereço de IP do servidor
			*/
			System.out.println("Conectado a " + socket.getInetAddress());
		}
		/**
		* Ler os dados do cliente, da entrada padrão(teclado)
		*/
		Scanner teclado = new Scanner(System.in);
		PrintStream saida = new PrintStream(cliente.getOutputStream());
		
		while(teclado.hasNextLine()){
			saida.println(teclado.NextLine());		
		}
		saida.close();
		teclado.close();
		cliente.close();
	}
}