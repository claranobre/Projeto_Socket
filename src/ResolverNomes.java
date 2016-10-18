import java.util.Scanner;

public class ResolverNomes{
	public static void main(String[] args) {
	String host;
	
	Scanner input = new Scanner(System.in);
	InetAddress address;
	System.out.println("Entre com o host: ");
	host = input.next();
		try{
		address = InetAddress.getByName(host);
		System.out.println("IP = " +address.toString());
		}
		catch(UnknownHostException ex){
			System.out.println("Host não encontrado");
		}
	}
}