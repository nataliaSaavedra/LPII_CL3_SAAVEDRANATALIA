package interfaces;

import model.Producto;

public interface IProductoDao {
	Producto buscarPorId(Integer idProd);
	Producto registrar(Producto producto);
	Producto actualizar(Producto producto);
	void eliminar(Integer idProd);
}
