import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

class TratadorDeMensagemDoCliente implements Runnable {

	private InputStream cliente;
	private Servidor servidor;

	public TratadorDeMensagemDoCliente(InputStream cliente, Servidor servidor) {
		this.cliente = cliente;
		this.servidor = servidor;
	}

	public void run() {
		
		/*
		* Quando chegar uma mensagem, distribui para todos
		*/
		
		Scanner s = new Scanner(this.cliente);
		while (s.hasNextLine()) {
			servidor.distribuirMensagem(s.nextLine());
		}
		s.close();
	}
}