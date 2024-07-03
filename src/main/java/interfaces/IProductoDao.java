package interfaces;

import java.util.List;

import model.Producto;

public interface IProductoDao {
	Producto buscarPorId(Integer idProd);
	void registrar(Producto producto);
	void actualizar(Producto producto);
	void eliminar(Producto producto);
	List<Producto> listarProductos();
}
