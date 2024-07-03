package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.IUsuarioDao;
import model.Usuario;

public class UsuarioDao implements IUsuarioDao {

	@Override
	public Usuario Logueo(String username, String password) {
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("PERSISTENCE");
		EntityManager em = fabr.createEntityManager();
		Usuario usuario  = null;
		try {
			usuario = em.createQuery("Select U From Usuario U Where U.username = :username And U.password = :password", Usuario.class)
					.setParameter("username", username)
					.setParameter("password", password)
					.getSingleResult();
		} catch(Exception ex) {
			System.out.println("Usuario no encontrado");
		}
		em.close();
		fabr.close();
		return usuario;
	}

}
