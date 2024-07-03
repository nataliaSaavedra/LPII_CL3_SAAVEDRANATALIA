package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductoDao;
import model.Producto;

/**
 * Servlet implementation class ProductoController
 */
@WebServlet("/ProductoController")
public class ProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDao productoDao = new ProductoDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		switch(accion) {
		case "registrar": case "actualizar2":
			registrarProducto(request, response);
			break;
		case "actualizar":
			buscarProducto(request, response);
			break;
		case "eliminar":
			buscarProducto(request, response);
			break;
		default:
			goToProductos(request, response);
		}
	}
	
	private void buscarProducto(HttpServletRequest request, HttpServletResponse response) {
		Integer idProd = Integer.parseInt(request.getParameter("idProd"));
		Producto producto = productoDao.buscarPorId(idProd);
		String accion = request.getParameter("accion");
		switch(accion) {
		case "actualizar":
			actualizarProducto(request, response, idProd);
			break;
		case "eliminar":
			eliminarProducto(request, response, producto);
			break;
		}
	}
	
	private void actualizarProducto(HttpServletRequest request, HttpServletResponse response, Integer idProd) {
		Producto producto = productoDao.buscarPorId(idProd);
		request.setAttribute("producto", producto);
		request.setAttribute("accion", "actualizar2");
		goToProductos(request, response);
	}
	
	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response, Producto producto) {
		productoDao.eliminar(producto);
		goToProductos(request, response);
	}
	
	private void registrarProducto(HttpServletRequest request, HttpServletResponse response) {
		String accion = request.getParameter("accion");
		Integer idProd = 0;
		if(accion.equals("actualizar2"))
			idProd = Integer.parseInt(request.getParameter("idProd"));
		
		System.out.println(idProd);
		
		String nomProd = request.getParameter("nomProd");
		Double preComp = Double.parseDouble(request.getParameter("preComp"));
		Double preVent = Double.parseDouble(request.getParameter("preVent"));
		String estado = request.getParameter("estado");
		String descripcion = request.getParameter("descripcion");
		
		Producto producto = new Producto();
		producto.setIdProducto(idProd);
		producto.setNomProd(nomProd);
		producto.setPreComp(preComp);
		producto.setPreVent(preVent);
		producto.setEstado(estado);
		producto.setDescripcion(descripcion);
		if(accion.equals("actualizar2"))
			productoDao.actualizar(producto);
		else
			productoDao.registrar(producto);
		goToProductos(request, response);
	}
	
	private void goToProductos(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Producto> productos = productoDao.listarProductos();
			request.setAttribute("productos", productos);
			RequestDispatcher rd = request.getRequestDispatcher("productos.jsp");
			rd.forward(request, response);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("get");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("post");
	}

}
