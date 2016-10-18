import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

class TratadorDeMensagemDoCliente implements Runnable {

	private Socket cliente;
	private Servidor servidor;

	public TratadorDeMensagemDoCliente(Socket cliente, Servidor servidor) {
		this.cliente = cliente;
		this.servidor = servidor;
	}

	public void run() {
		try(Scanner s = new Scanner(((Socket) this.cliente).getInputStream())) {
			while (s.hasNextLine()) {
				servidor.distribuirMensagem(cliente, s.nextLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}