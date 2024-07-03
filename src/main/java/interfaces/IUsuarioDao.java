package interfaces;

import model.Usuario;

public interface IUsuarioDao {
	public Usuario Logueo(String username, String password);
}
