<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
    String accion = (String) request.getAttribute("accion");
    if(accion == null) accion = "registrar";
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
            <input type="hidden" name="idProd" value="0">
            <input type="hidden" name="accion" value="<%=accion%>">
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="txtNomProd" name="nomProd" placeholder="Nombre" autocomplete="off" required>
                <label for="txtNomProd">Nombre</label>
            </div>
            <div class="form-floating mb-3">
                <input type="number" step="0.01" class="form-control" id="txtPreComp" name="preComp" placeholder="Precio Compra" required min="0.01">
                <label for="txtPreComp">Precio de Compra</label>
            </div>
            <div class="form-floating mb-3">
                <input type="number" class="form-control" id="txtPreVent" name="preVent" placeholder="Precio Venta" required min="0.01">
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
                <textarea class="form-control" style="height: 100px" id="txtDescripcion" name="descripcion" required></textarea>
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
                    <th colspan="2">Acciones</th>
                </tr>
            </thead>
            <tbody>
                
            </tbody>
        </table>
    </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</html>