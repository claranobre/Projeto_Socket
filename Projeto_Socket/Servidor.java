ServerSocket serverSocket = new ServerSocket(9876);
servidor.accept();
DataInputStream ent = new DataInputStream(
		sc.getInputStream())
	String recebido = ent.readUTF();
DataOutputStream sai = new DataOutputStream(
		sc.getOutputStream());
sai.writeUTF("mensagem");
serverSocket.close(req);
