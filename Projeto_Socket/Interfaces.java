try{
	Enumeration<NetworkInterface> interfaceList
		= NetworkInterface.getNetworkInterfaces();
	if(interfaceList == null){
		System.out.println("Nenhuma interface encontrada!");
	}
	else{
		while (interfaceList.hasMoreElements()) {
			NetworkInterface iface =
				interfaceList.nextElement();
			System.out.println("Inteface "+
					iface.getName()+": ");
			Enumeration<InetAddress> addrList =
				iface.getInetAddresses();
	if(!addrList.hasMoreElements()){
		System.out.println("Inteface sem endereço!");
	}
	while (addrList.hasMoreElements()) {
		InetAddress address = addrList.nextElement();
		System.out.print("\tAddress "
				+ ((address instanceof Inet4Address ? "(v4)" :
						(address instanceof Inet6Address ? "(v6)" : "(?)"))));
		System.out.println(": " + address.getHostAddress());
	}
		}
	}
}catch(SocketException se){
	System.out.println("Erro ao buscar interfaces "
			+se.getMessage());
}
