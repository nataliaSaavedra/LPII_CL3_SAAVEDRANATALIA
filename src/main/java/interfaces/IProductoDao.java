package interfaces;

import model.Producto;

public interface IProductoDao {
	Producto buscarPorId(Integer idProd);
	void registrar(Producto producto);
	void actualizar(Producto producto);
	void eliminar(Integer idProd);
}
