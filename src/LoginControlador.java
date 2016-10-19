public class LoginControlador{
	public String efetuaLogin(Cliente usuario, HttpSession session){
		if(new Usuario().existeUsuario(usuario)){
			session.setAttribute("Usuario Logado", usuario);
			return "menu";
		}
	}
}