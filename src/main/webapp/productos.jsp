<%@page import="dao.ProductoDao"%>
<%@page import="model.Producto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
    ProductoDao productoDao = new ProductoDao();

    String accion = (String) request.getAttribute("accion");
    if(accion == null) accion = "registrar";
    
    List<Producto> productos = (List<Producto>) request.getAttribute("productos");
    if(productos == null) productos = productoDao.listarProductos();
    
    Producto producto = (Producto) request.getAttribute("producto");
    if(producto == null) {
    	producto = new Producto();
        producto.setIdProducto(0);
        producto.setNomProd("");
        producto.setPreComp(0.0);
        producto.setPreVent(0.0);
        producto.setDescripcion("");
        producto.setEstado("Vigente");
    }
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body class="bg-success-subtle p-5">
    <div class="p-5 container col-6 border border-1 rounded bg-white">
        <h3 class="text-center fw-bold">Registrar Producto</h3>
        <hr>
        <form action="ProductoController" method="post">
            <input type="hidden" name="idProd" value="<%=producto.getIdProducto()%>">
            <input type="hidden" name="accion" value="<%=accion%>">
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="txtNomProd" name="nomProd" placeholder="Nombre" autocomplete="off" required value="<%=producto.getNomProd()%>">
                <label for="txtNomProd">Nombre</label>
            </div>
            <div class="form-floating mb-3">
                <input type="number" step="0.01" class="form-control" id="txtPreComp" name="preComp" placeholder="Precio Compra" required min="0.01"  value="<%=producto.getPreComp()%>">
                <label for="txtPreComp">Precio de Compra</label>
            </div>
            <div class="form-floating mb-3">
                <input type="number" step="0.01" class="form-control" id="txtPreVent" name="preVent" placeholder="Precio Venta" required min="0.01"  value="<%=producto.getPreVent()%>">
                <label for="txtPreVent">Precio de Venta</label>
            </div>
            <div class="form-floating mb-3">
                <select class="form-select" id="cboEstado" name="estado" aria-label="Floating label select example">
                    <option>Vigente</option>
                    <option>No Vigente</option>
                </select>
                <label for="cboEstado">Estado</label>
            </div>
            <div class="form-floating mb-3">
                <textarea class="form-control" style="height: 100px" id="txtDescripcion" name="descripcion" required><%=producto.getDescripcion() %></textarea>
                <label for="txtDescripcion">Descripción</label>
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-success">Registrar</button>
            </div>
        </form>
    </div>
    <div class="container mt-5">
        <h3 class="text-center text-primary">Datos Registrados en la BD</h3>
        <h5 class="text-center">Listado de Productos</h5>
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th class="text-center">Código</th>
                    <th class="text-center">Nombre</th>
                    <th class="text-center">Precio de Venta</th>
                    <th class="text-center">Precio de Compra</th>
                    <th class="text-center">Estado</th>
                    <th class="text-center">Descripción</th>
                    <th class="text-center" colspan="2">Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    if(productos != null)
                        for(Producto p: productos) {
                %>
                <tr>
                    <td class="text-center"><%=p.getIdProducto() %></td>
                    <td class="text-center"><%=p.getNomProd() %></td>
                    <td class="text-center"><%=p.getPreVent() %></td>
                    <td class="text-center"><%=p.getPreComp() %></td>
                    <td class="text-center"><%=p.getEstado() %></td>
                    <td class="text-center"><%=p.getDescripcion() %></td>
                    <td class="text-center">
                        <a class="btn btn-danger" href="ProductoController?accion=eliminar&idProd=<%=p.getIdProducto()%>">Eliminar</a>
                    </td>
                    <td class="text-center">
                        <a class="btn btn-primary" href="ProductoController?accion=actualizar&idProd=<%=p.getIdProducto()%>">Actualizar</a>
                    </td>
                </tr>
                <%
                        }
                %>
            </tbody>
        </table>
    </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</html>