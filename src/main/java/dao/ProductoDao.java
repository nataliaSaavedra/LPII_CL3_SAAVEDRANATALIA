package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.IProductoDao;
import model.Producto;

public class ProductoDao implements IProductoDao {

	@Override
	public Producto buscarPorId(Integer idProd) {
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("PERSISTENCE");
		EntityManager em = fabr.createEntityManager();
		Producto producto = new Producto();
		try {
			producto = em.createQuery("Select P From Producto P Where P.idProducto = :idProd", Producto.class)
					.setParameter("idProd", idProd)
					.getSingleResult();
		} catch(Exception ex) { 
			ex.printStackTrace();
		}
		return producto;
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
	public void eliminar(Producto producto) {
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("PERSISTENCE");
	    EntityManager em = fabr.createEntityManager();
	    try {
	        em.getTransaction().begin();
	        Producto managedProducto = em.find(Producto.class, producto.getIdProducto());
	        if (managedProducto != null) {
	            em.remove(managedProducto);
	        }
	        em.getTransaction().commit();
	    } catch (Exception e) {
	        em.getTransaction().rollback();
	        e.printStackTrace();
	    } finally {
	        em.close();
	        fabr.close();
	    }
	}

	@Override
	public List<Producto> listarProductos() {
		EntityManagerFactory fabr = Persistence.createEntityManagerFactory("PERSISTENCE");
		EntityManager em = fabr.createEntityManager();
		List<Producto> productos = new ArrayList<Producto>();
		try {
			productos = em.createQuery("Select P From Producto P", Producto.class).getResultList();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		em.close();
		fabr.close();
		return productos;
	}

}
