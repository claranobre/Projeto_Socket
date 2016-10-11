import java.net.*;

public class Servidor{
	public static void main(String[] args) throws IOException{

		ServerSocket servidor = new ServerSocket(80);
		System.out.println("Porta 80 aberta");

		Socket cliente = servidor.accept();
		/**
		* Imprime o IP do cliente
		*/
		System.out.println("Nova conexão com o cliente" + cliente.getInetAdress().getHostAddress());

		/***
		* Ler todas as informações que o cliente enviar
		*/
		Scanner s = new Scanner(cliente.getInputStream());

		while(s.hasNextLine()){
			System.out.println(s.nextLine());
		}

		/**
		* Fechando a conexão
		*/
		s.close();
		cliente.close();
		servidor.close();
	}
}