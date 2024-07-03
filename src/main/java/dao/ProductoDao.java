package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.IProductoDao;
import model.Producto;

public class ProductoDao implements IProductoDao {

	@Override
	public Producto buscarPorId(Integer idProd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registrar(Producto producto) {
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("PERSISTENCE");
		EntityManager em = fabr.createEntityManager();
		em.getTransaction().begin();
		em.persist(producto);
		em.getTransaction().commit();
		em.close();
		fabr.close();
	}

	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
	}

	@Override
	public void eliminar(Integer idProd) {
		// TODO Auto-generated method stub
		
	}

}
