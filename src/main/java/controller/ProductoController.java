package controller;

import java.io.IOException;

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
		case "registrar":
			registrarProducto(request, response);
			break;
		}
	}
	
	private void registrarProducto(HttpServletRequest request, HttpServletResponse response) {
		String nomProd = request.getParameter("nomProd");
		Double preComp = Double.parseDouble(request.getParameter("preComp"));
		Double preVent = Double.parseDouble(request.getParameter("preVent"));
		String estado = request.getParameter("estado");
		String descripcion = request.getParameter("descripcion");
		
		Producto producto = new Producto();
		producto.setNomProd(nomProd);
		producto.setPreComp(preComp);
		producto.setPreVent(preVent);
		producto.setEstado(estado);
		producto.setDescripcion(descripcion);
		System.out.println(nomProd);
		System.out.println(preComp);
		System.out.println(preVent);
		System.out.println(estado);
		System.out.println(descripcion);
		productoDao.registrar(producto);
		goToProductos(request, response);
	}
	
	private void goToProductos(HttpServletRequest request, HttpServletResponse response) {
		try {
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
